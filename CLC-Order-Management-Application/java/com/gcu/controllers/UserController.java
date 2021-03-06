package com.gcu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.dao.UserDao;

import Model.User;

import java.util.List;

@Controller
public class UserController 
{
	String message = "Welcome to the Order Management Application,";
	User registeredUser = new User();
	MainController main = new MainController();
	
	@Autowired
	UserDao user_dao;
	
	@Autowired
	@Qualifier("userValidator")
	private Validator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder)
	{
		binder.setValidator(validator);
	}
	
	@RequestMapping(value = "/helloworld", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user")@Validated User user, BindingResult bindingRS)
	{
		if(bindingRS.hasErrors())
		{
			return "register";
		}
		user_dao.save(user);
		registeredUser = user;
		main.setLoggedUser(user);
		return "login";
	}
	
	@RequestMapping(value="/displayHome")
	public ModelAndView homePage(@ModelAttribute("user")User user)
	{
		ModelAndView mv = new ModelAndView("login");
		if(authenticate(user))
		{
			mv = new ModelAndView("helloworld");
			mv.addObject("user", main.getLoggeduser());
			mv.addObject("message", message);
			return mv;
		}
		return mv;
	}
	
	public boolean authenticate(User incUser)
	{
		List<User> userList = user_dao.authenticateUser();
		for(User currUser : userList)
		{
			if(incUser.getUsername().equals(currUser.getUsername()) && incUser.getPassword().equals(currUser.getPassword()))
			{
				System.out.println("SUCCESSFUL MATCH!");
				main.setLoggedStatus(true);
				return true;
			}
		}
		return false;
	}
}

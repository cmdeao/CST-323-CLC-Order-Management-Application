package com.gcu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Model.User;
import Model.Order;
import com.gcu.dao.UserDao;
import com.gcu.dao.OrderDao;

import java.util.List;

@Controller
public class MainController {
	String message = "Welcome to the Order Management Application,";
	User registeredUser = new User();

	@Autowired
	UserDao user_dao;

	@Autowired
	OrderDao order_dao;

	@Autowired
	@Qualifier("userValidator")
	private Validator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder)
	{
		binder.setValidator(validator);
	}
	
	@RequestMapping("/hello")
	public ModelAndView showMessage(@RequestParam(value = "name", required = false, defaultValue = "World") String name)
	{
		System.out.println("in controller");
		
		ModelAndView mv = new ModelAndView("register");
		mv.addObject("message", message);
		mv.addObject("name", name);
		return mv;
	}
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public ModelAndView displayLogin()
	{
		return new ModelAndView("register","user", new User());
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
		return "login";
	}
	
	@RequestMapping(value="/displayHome")
	public ModelAndView homePage(@ModelAttribute("user")User user)
	{
		ModelAndView mv = new ModelAndView("login");
		if(checkLogin(user.getUsername(),user.getPassword()))
		{
			mv = new ModelAndView("helloworld");
			System.out.println("SUCCESSFUl LOGIN");
			mv.addObject("user", registeredUser);
			mv.addObject("message",message);
			return mv;
		}
		System.out.println("FAILED LOGIN");
		return mv;
	}
	
	public boolean checkLogin(String incUser, String incPass)
	{
		if(registeredUser.getUsername().equals(incUser) && registeredUser.getPassword().equals(incPass))
		{
			return true;
		}
		return false;
	}
}
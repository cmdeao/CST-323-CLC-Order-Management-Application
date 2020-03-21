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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import Model.User;

import java.util.List;

@Controller
public class UserController 
{
	String message = "Welcome to the Order Management Application,";
	User registeredUser = new User();
	MainController main = new MainController();
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
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
		logger.debug("Entered UserController");
		if(bindingRS.hasErrors())
		{
			logger.warn("Registration has missing information input! Timestamp: " + sdf.format(timestamp));
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
			logger.debug("Entered main page. Timestamp: " + sdf.format(timestamp));
			return mv;
		}
		return mv;
	}
	
	public boolean authenticate(User incUser)
	{
		List<User> userList = user_dao.authenticateUser();
		String nameOfMethod = new Throwable().getStackTrace()[0].getMethodName();
		for(User currUser : userList)
		{
			if(incUser.getUsername().equals(currUser.getUsername()) && incUser.getPassword().equals(currUser.getPassword()))
			{
				System.out.println("SUCCESSFUL MATCH!");
				logger.debug("Successfully logged into application! Timestamp: " + sdf.format(timestamp));
				return true;
			}
		}
		logger.warn("Failed login attempt! Timestamp: " + sdf.format(timestamp) + " Within: " + nameOfMethod);
		return false;
	}
}

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gcu.dao.OrderDao;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class MainController 
{
	String message = "Welcome to the Order Management Application,";
	User loggedUser = new User();
	ModelAndView mv;
	
	Logger logger = LoggerFactory.getLogger(MainController.class);
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	@Autowired
	UserDao user_dao;

	@Autowired
	OrderDao order_dao;
	
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
		System.out.println("THIS IS A SYSTEM TEST BEFORE LOGGER");
		logger.info("Entered MainController. Timestamp: " + sdf.format(timestamp));
		return new ModelAndView("register","user", new User());
	}
	
	@RequestMapping(value="/homePage")
	public ModelAndView displayHome()
	{
		mv = new ModelAndView("helloworld");
		mv.addObject("user", loggedUser);
		mv.addObject("message", message);
		logger.debug("Entered MainController. Timestamp: " + sdf.format(timestamp));
		return mv;
	}
	
	public void setLoggedUser(User incUser)
	{
		this.loggedUser = incUser;
	}
	
	public User getLoggeduser()
	{
		return loggedUser;
	}
}
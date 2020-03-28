package com.gcu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Model.User;
import Model.Login;

import com.gcu.dao.UserDao;
import com.gcu.dao.OrderDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * MainController class. 
 * @author Cameron Deao & John Harrison
 *
 */
@Controller
public class MainController 
{
	//Global variables to be used within this Java Class.
	private static final String message = "Welcome to the Order Management Application!";
	private static final String loginMessage = "Please Login to Continue to Application.";
	ModelAndView mv;
	Logger logger = LoggerFactory.getLogger(MainController.class);
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	//Autowiring both DAO's that will be utilized.
	@Autowired
	UserDao user_dao;

	@Autowired
	OrderDao order_dao;

	/**
	 * showMessage() - Initial test method within the application. 
	 * @param name
	 * @return
	 */
	@RequestMapping("/hello")
	public ModelAndView showMessage(@RequestParam(value = "name", required = false, defaultValue = "World") String name)
	{
		System.out.println("in controller");
		ModelAndView mv = new ModelAndView("register");
		mv.addObject("message", message);
		mv.addObject("name", name);
		return mv;
	}
	
	/**
	 * displayLogin() - Directing the user to the registration page. 
	 * @return
	 */
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public ModelAndView displayLogin()
	{
		System.out.println("THIS IS A SYSTEM TEST BEFORE LOGGER");
		logger.info("Entered MainController. Timestamp: " + sdf.format(timestamp));
		return new ModelAndView("register","user", new User());
	}
	
	/**
	 * displayHome() - Method used within all JSP pages to direct the user to the home page. 
	 * @return
	 */
	@RequestMapping(value="/homePage")
	public ModelAndView displayHome()
	{
		mv = new ModelAndView("helloworld");
		mv.addObject("message", message);
		logger.debug("Entered MainController. Timestamp: " + sdf.format(timestamp));
		return mv;
	}
	
	//
	/**
	 * showcaseLogin() - Alternative login page direct method within index.jsp 
	 * @return
	 */
	@RequestMapping(value="/altLogin", method = RequestMethod.GET)
	public ModelAndView showcaseLogin()
	{
		ModelAndView mv = new ModelAndView("altLogin", "login", new Login());
		mv.addObject("message", loginMessage);
		return mv;
	}
}
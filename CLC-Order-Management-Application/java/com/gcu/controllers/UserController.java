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

/**
 * UserController Class
 * @author Cameron Deao & John Harrison
 *
 */
@Controller
public class UserController 
{
	//Global variables to be used within this Java Class.
	private static final String message = "Welcome to the Order Management Application,";
	//User registeredUser = new User();
	//MainController main = new MainController();
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	//Autowiring UserDAO
	@Autowired
	UserDao user_dao;
	
	//Autowiring UserValidator.
	@Autowired
	@Qualifier("userValidator")
	private Validator validator;
	
	//Establishing validator.
	@InitBinder
	private void initBinder(WebDataBinder binder)
	{		
		binder.setValidator(validator);
	}
	
	/**
	 * addUser() - POST method called upon registration form submission.
	 * 
	 * @param user
	 * @param bindingRS
	 * @return
	 */
	@RequestMapping(value = "/helloworld", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user")@Validated User user, BindingResult bindingRS)
	{
		logger.debug("Entered UserController");
		//Exception handling.
		if(bindingRS.hasErrors())
		{
			logger.warn("Registration has missing information input! Timestamp: " + sdf.format(timestamp));
			return "register";
		}
		//Calling the UserDAO save method and passing the new user.
		user_dao.save(user);
		//registeredUser = user;
		return "login";
	}
	
	/**
	 * homePage() - Home display method after initial login to application. 
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/displayHome")
	public ModelAndView homePage(@ModelAttribute("user")User user)
	{
		ModelAndView mv = new ModelAndView("login");
		//If-Statement calls authenticate and passes user submitted information.
		if(authenticate(user))
		{
			//Returns updated ModelAndView if successful.
			mv = new ModelAndView("helloworld");
			mv.addObject("message", message);
			logger.debug("Entered main page. Timestamp: " + sdf.format(timestamp));
			return mv;
		}
		return mv;
	}
	
	/**
	 * authenticate() - Authenticate method for initial login to application.
	 * 
	 * @param incUser
	 * @return
	 */
	public boolean authenticate(User incUser)
	{
		//Establishing the list of registered users.
		List<User> userList = user_dao.authenticateUser();
		String nameOfMethod = new Throwable().getStackTrace()[0].getMethodName();
		//Iterating through the list of users.
		for(User currUser : userList)
		{
			//If-Statement checking the current iteration against the passed login information.
			if(incUser.getUsername().equals(currUser.getUsername()) && incUser.getPassword().equals(currUser.getPassword()))
			{
				System.out.println("SUCCESSFUL MATCH!");
				logger.debug("Successfully logged into application! Timestamp: " + sdf.format(timestamp));
				//Returning a true boolean if a match is found.
				return true;
			}
		}
		logger.warn("Failed login attempt! Timestamp: " + sdf.format(timestamp) + " Within: " + nameOfMethod);
		//Returning a false boolean if no match is found.
		return false;
	}
}

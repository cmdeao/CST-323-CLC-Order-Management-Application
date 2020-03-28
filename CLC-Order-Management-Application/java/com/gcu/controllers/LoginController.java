package com.gcu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.dao.UserDao;
import com.gcu.validators.LoginValidator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import Model.Login;
import Model.User;

import java.util.List;

/**
 * Updated LoginController class.
 * @author Cameron Deao & John Harrison
 *
 */
@Controller
public class LoginController 
{
	/**
	 *Global variables to be used within this Java Class. 
	 */
	private static final String  message = "Welcome to the Order Management Application!";
	private static final String failedLoginMessage = "Invalid Login Attempt! Try again.";
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	@Autowired
	UserDao user_dao;

	@Autowired
	private LoginValidator userVal;
	
	/**
	 * checkLogin() - Method used with login form submission.
	 * 
	 * @param login
	 * @param bindingRS
	 * @return
	 */
	@RequestMapping(value="/checkLogin")
	public ModelAndView checkLogin(@ModelAttribute("login")Login login, BindingResult bindingRS)
	{
		//Exception handling for form submission.
		userVal.validate(login, bindingRS);
		//Establishing initial return page in the event of error or failed login.
		ModelAndView mv = new ModelAndView("altLogin");
		if(bindingRS.hasErrors())
		{
			logger.warn("Login has missing information input! Timestamp: " + sdf.format(timestamp));
			return mv;
		}
		//If-Statement calls loginAttempt with submitted information.
		if(loginAttempt(login))
		{
			//If successful adjusting the return page.
			mv = new ModelAndView("helloworld");
			mv.addObject("message", message);
			logger.debug("Entered main page. Timestamp: " + sdf.format(timestamp));
			return mv;
		}
		//Returning a failed login attempt with updated message on JSP.
		mv.addObject("message", failedLoginMessage);
		return mv;
	}
	
	/**
	 * loginAttempt() - Checks login credentials. 
	 * 
	 * @param incLogin
	 * @return
	 */
	public boolean loginAttempt(Login incLogin)
	{
		//Establishing the list of registered users.
		List<User> userList = user_dao.authenticateUser();
		String nameOfMethod = new Throwable().getStackTrace()[0].getMethodName();
		//Iterating through the list of users.
		for(User currUser : userList)
		{
			//If-Statement checking the current iteration against the passed login information.
			if(incLogin.getUsername().equals(currUser.getUsername()) && incLogin.getPassword().equals(currUser.getPassword()))
			{
				System.out.println("SUCCESS LOGIN!");
				//Returning a true boolean if a match is found.
				return true;
			}
		}
		logger.warn("Failed login attempt! Timestamp: " + sdf.format(timestamp) + " Within: " + nameOfMethod);
		//Returning a false boolean if no match is found.
		return false;
	}
}
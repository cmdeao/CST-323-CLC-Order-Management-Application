package com.gcu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Model.User;

@Controller
public class MainController {
	String message = "Welcome to the Order Management Application,";
	User registeredUser = new User();
	
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
	
	@RequestMapping(value="/helloworld", method = RequestMethod.POST)
	public ModelAndView showcaseMain(@ModelAttribute("user")User user, BindingResult binding, Model model)
	{
		registeredUser = user;
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("message", message);
		mv.addObject("firstName", user.getFirstName());
		return mv;
	}
	
	@RequestMapping(value="/displayHome")
	public ModelAndView homePage(@ModelAttribute("user")User user)
	{
		ModelAndView mv = new ModelAndView("register");
		if(checkLogin(user.getUsername(),user.getPassword()))
		{
			mv = new ModelAndView("helloworld");
			System.out.println("SUCCESSFUl LOGIN");
			mv.addObject("firstName",registeredUser.getFirstName());
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
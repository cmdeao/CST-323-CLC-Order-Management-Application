package com.gcu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import Model.User;
import Model.Order;

import com.gcu.validators.OrderValidator;
import com.gcu.dao.OrderDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import java.util.List;

/**
 * OrderController class.
 * @author Cameron Deao & John Harrison
 *
 */
@Controller
public class OrderController
{
	//Autowiring the Order DAO.
    @Autowired
    OrderDao order_dao;
    
    //Global variables to be used within this Java Class.
    Logger logger = LoggerFactory.getLogger(OrderController.class);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    
    //Autowiring the Order Validator for exception handling.
    @Autowired
    private OrderValidator orderVal;

    /**
     * placeOrder() - Directing the user to the placeOrder.jsp. 
     * @param user
     * @param m
     * @return
     */
    @RequestMapping(value = "/placeOrder", method = RequestMethod.GET)
    public String placeOrder(@ModelAttribute("user") User user, Model m)
    {
    	//Creating a new Order model.
        m.addAttribute("order", new Order());
        m.addAttribute("user", user);
        logger.debug("Entered OrderController");
        return "placeOrder";
    }

    /**
     * placeOrder() - Submit method when placing an order. 
     * @param order
     * @param model
     * @param bindingRS
     * @return
     */
    @RequestMapping(value = "/placeOrder", method = RequestMethod.POST)
    public String placeOrder(@ModelAttribute("order") Order order, Model model, BindingResult bindingRS)
    {
    	//Exception handling for form submission.
    	orderVal.validate(order, bindingRS);
    	if(bindingRS.hasErrors())
    	{
    		logger.warn("Order has missing information input! Timestamp: " + sdf.format(timestamp));
    		return "placeOrder";
    	}
    	//Calling OrderDAO's save method. Redirecting the user to viewOrders.jsp.
    	else
    	{
	        order_dao.save(order);
	        logger.debug("Added order into Database. Timestamp: " + sdf.format(timestamp));
	        return "redirect:/viewOrders";
    	}
    }

    /**
     * viewOrders() - Method to display viewOrders.jsp 
     * @param model
     * @return
     */
    @RequestMapping(value = "/viewOrders")
    public String viewOrders(Model model)
    {
    	//Establishing the list of existing orders within the database. 
        List<Order> list = order_dao.getOrders();
        //Adding the list to a model.
        model.addAttribute("list", list);
        String nameOfMethod = new Throwable().getStackTrace()[0].getMethodName();
        //Exception handling. Logging if the list is empty.
        if(list == null || list.isEmpty())
        {
        	logger.error("An error occurred with the order list, within method " + nameOfMethod, list);
        }
        else
        {
        	logger.debug("Displayed orders list");
        }
        return "viewOrders";
    }
}

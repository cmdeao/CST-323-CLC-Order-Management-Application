package com.gcu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import Model.User;
import Model.Order;
import com.gcu.dao.UserDao;
import com.gcu.dao.OrderDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import java.util.List;

@Controller
public class OrderController
{
    @Autowired
    OrderDao order_dao;
    
    Logger logger = LoggerFactory.getLogger(OrderController.class);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    
//    @Autowired
//    @Qualifier("orderValidator")
//    private Validator validator;
//
//    @InitBinder
//    private void initBinder(WebDataBinder binder)
//    {
//        binder.setValidator(validator);
//    }

    @RequestMapping(value = "/placeOrder", method = RequestMethod.GET)
    public String placeOrder(@ModelAttribute("user") User user, Model m)
    {
        m.addAttribute("order", new Order());
        m.addAttribute("user", user);
        logger.debug("Entered OrderController");
        return "placeOrder";
    }

    @RequestMapping(value = "/placeOrder", method = RequestMethod.POST)
    public String placeOrder(@ModelAttribute("order") Order order, Model model)
    {
        order_dao.save(order);
        logger.debug("Added order into Database. Timestamp: " + sdf.format(timestamp));
        return "redirect:/viewOrders";
    }

    @RequestMapping(value = "/viewOrders")
    public String viewOrders(Model model)
    {
        List<Order> list = order_dao.getOrders();
        model.addAttribute("list", list);
        String nameOfMethod = new Throwable().getStackTrace()[0].getMethodName();
        
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

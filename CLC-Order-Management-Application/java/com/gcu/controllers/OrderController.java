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

import java.util.List;

@Controller
public class OrderController
{
    @Autowired
    OrderDao order_dao;

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
        return "placeOrder";
    }

    @RequestMapping(value = "/placeOrder", method = RequestMethod.POST)
    public String placeOrder(@ModelAttribute("order") Order order, Model model)
    {
        order_dao.save(order);
        return "redirect:/viewOrders";
    }

    @RequestMapping(value = "/viewOrders")
    public String viewOrders(Model model)
    {
        List<Order> list = order_dao.getOrders();
        model.addAttribute("list", list);
        return "viewOrders";
    }

}

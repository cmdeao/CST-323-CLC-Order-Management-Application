package com.gcu.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import Model.Order;

public class OrderValidator implements Validator
{

    @Override
    public boolean supports(Class<?> valid)
    {
        return Order.class.isAssignableFrom(valid);
    }

    @Override
    public void validate(Object o, Errors error)
    {
        ValidationUtils.rejectIfEmptyOrWhitespace(error, "item", "required.item",
            "Please enter a item!");
        ValidationUtils.rejectIfEmptyOrWhitespace(error, "total", "required.total",
                "Please enter a total!");
        ValidationUtils.rejectIfEmptyOrWhitespace(error, "card_last_four", "required.card_last_four",
                "Please enter the last four digits of the card you are using!");
        ValidationUtils.rejectIfEmptyOrWhitespace(error, "description", "required.description",
                "Please enter a description!");
        ValidationUtils.rejectIfEmptyOrWhitespace(error, "status", "required.status",
                "Please select a status a item!");
    }
}

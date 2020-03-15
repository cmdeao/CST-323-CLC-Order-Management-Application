package com.gcu.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import Model.User;

public class LoginValidator implements Validator {
	
	public boolean supports(Class<?> valid) {
		
		return User.class.isAssignableFrom(valid);
	}

	public void validate(Object arg0, Errors error) 
	{
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "username", "required.firstName", 
				"Please enter a username!");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "password", "required.lastName", 
				"Please enter a password!");
	}
}

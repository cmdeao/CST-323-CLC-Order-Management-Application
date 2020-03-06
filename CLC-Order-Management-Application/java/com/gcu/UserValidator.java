package com.gcu;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import Model.User;

public class UserValidator implements Validator {
	
	public boolean supports(Class<?> valid) {
		
		return User.class.isAssignableFrom(valid);
	}

	public void validate(Object arg0, Errors error) 
	{
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "firstName", "required.firstName", 
				"Please enter a first name!");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "lastName", "required.lastName", 
				"Please enter a last name!");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "emailAddress", "required.emailAddress", 
				"Please enter a email address!");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "phoneNumber", "required.phoneNumber", 
				"Please enter a phone number!");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "username", "required.username", 
				"Please enter a username!");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "password", "required.password", 
				"Please enter a password!");
	}
}

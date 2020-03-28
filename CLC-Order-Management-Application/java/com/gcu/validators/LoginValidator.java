package com.gcu.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import Model.User;

/**
 * LoginValidator class.
 * @author Cameron Deao & John Harrison
 *
 */
public class LoginValidator implements Validator {
	
	/**
	 * supports()
	 */
	public boolean supports(Class<?> valid) {
		
		return User.class.isAssignableFrom(valid);
	}

	/**
	 * validate() - validates submitted data.
	 */
	public void validate(Object arg0, Errors error) 
	{
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "username", "required.firstName", 
				"Please enter a username!");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "password", "required.lastName", 
				"Please enter a password!");
	}
}

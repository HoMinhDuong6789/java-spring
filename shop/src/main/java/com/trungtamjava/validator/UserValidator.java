package com.trungtamjava.validator;

import org.springframework.context.annotation.Bean;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.trungtamjava.model.User;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		User user = (User) target;
		
		if(user.getName()== null || user.getName().length()==0) {
			errors.rejectValue("name", "field.required");
			
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password","field.required");
		if(user.getPassword().length()<6 && user.getPassword().length()>12) {
			errors.rejectValue("password", "password.invalid");
		}
	}
	
	
}

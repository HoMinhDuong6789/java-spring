package com.trungtamjava.validator;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.trungtamjava.model.UserDTO;

@Component
public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		UserDTO user = (UserDTO) target;
		
		if(user.getName()== null || user.getName().length()==0) {
			errors.rejectValue("name", "field.required");
			
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone","field.required");
		if(user.getPhone().length()<6 && user.getPhone().length()>12) {
			errors.rejectValue("phone", "phone.invalid");
		}
	}
	
	
}

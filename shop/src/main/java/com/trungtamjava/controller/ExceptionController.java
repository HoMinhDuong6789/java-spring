package com.trungtamjava.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = { NoHandlerFoundException.class})
	public String exceptionHandler(Exception exception) {
		//exception.printStackTrace();
		System.err.println(exception);
		return "404";
	}
	
	@ExceptionHandler(value = { Exception.class})
	public String exceptionALl(Exception exception) {
		//exception.printStackTrace();
		System.err.println(exception);
		return "error";
	}
}

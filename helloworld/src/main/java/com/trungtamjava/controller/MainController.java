package com.trungtamjava.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@Autowired
	org.springframework.core.env.Environment environment;
	
	@GetMapping(value = "/")
	public String home(HttpServletRequest request) {
		//request.setAttribute("msg", "Hello Spring Boot");
		//request.setAttribute("msg", messageSource.getMessage("my.name", null, null));
		request.setAttribute("msg", environment.getProperty("message"));
		return "index";
	}
}

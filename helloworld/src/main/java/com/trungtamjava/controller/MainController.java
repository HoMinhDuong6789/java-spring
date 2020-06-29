package com.trungtamjava.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping(value = "/")
	public String home(HttpServletRequest request) {
		request.setAttribute("msg", "Hello Spring Boot");
		return "index";
	}
}

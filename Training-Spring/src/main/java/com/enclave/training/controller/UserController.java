package com.enclave.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@GetMapping(value = "/")
	public ModelAndView start() {
		ModelAndView modelAndView = new ModelAndView("layout");
		modelAndView.addObject("title", "Login");
		modelAndView.addObject("view","login");
		return modelAndView;
	}
}

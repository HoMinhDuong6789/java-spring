package com.trungtamjava.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/say-hello")
	public ModelAndView sayHello(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		request.setAttribute("msg", "J4team");
		return new ModelAndView("hello");
	}
}

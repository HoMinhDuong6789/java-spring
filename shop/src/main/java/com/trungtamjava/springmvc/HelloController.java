package com.trungtamjava.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	/*
	 * Request Param
	 * localhost:8080/shop/say-hello?user=spring-mvc
	 */
	
	@RequestMapping("/say-hello")
	public ModelAndView sayHello(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			@RequestParam(name = "user", required = true) String username,
			@RequestHeader(name = "Accept", required = false) String contentType) {
		request.setAttribute("msg", username + " " + contentType);
		return new ModelAndView("hello");
	}

	/*
	 * Path Variable
	 * localhost:8080/shop/hello/spring-mvc/2
	 */
	@RequestMapping("/hello{name}/{id}")
	public String hello(HttpServletRequest request, @PathVariable(name = "name") String name,
			@PathVariable(name = "id") int useId) {
		request.setAttribute("msg", name);
		return "hello";
	}
}

package com.trungtamjava.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.trungtamjava.model.Person;

@Controller
public class HelloController {

	@Autowired
	@Qualifier("person2")
	private Person person;

	@RequestMapping("/hello")
	public String sayHello(ModelMap map) {
		//map.addAttribute("msg", "Trung Tam Java");
		map.addAttribute("person", person);
		return "hello";
	}
	@RequestMapping(value = {"/say-hello"})
	public ModelAndView sayHello1(HttpServletRequest request) {
		request.setAttribute("person", person);
		return new ModelAndView("hello");
	}
}

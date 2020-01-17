package com.trungtamjava.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trungtamjava.model.Person;

public class HelloController {
	@Autowired
	@Qualifier("person2")
	private Person	person;
	
	@RequestMapping("/hello")
	public String sayHello(ModelMap map) {
		//map.addAttribute("msg", "Trung Tam JAVA");
		map.addAttribute("person", person);
		return "Wellcome";
	}
}

package com.trungtamjava.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	@RequestMapping("/wellcome")
	public String sayHello(ModelMap map) {
		map.addAttribute("msg", "Wellcome Spring 4 MVC");
		return "wellcome";
	}
}

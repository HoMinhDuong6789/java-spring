package com.trungtamjava.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.trungtamjava.model.Person;
import com.trungtamjava.model.User;

@Controller
public class HelloController {

	@Autowired
	@Qualifier("person2")
	private Person person;

	@RequestMapping("/hello")
	public String sayHello(HttpServletRequest request) {
		request.setAttribute("person", person);
		return "hello";// new ModelAndView("hello");
	}

	/*
	 * Request Param localhost:8080/shop/say-hello?user=spring-mvc
	 */
	@RequestMapping("/say-hello")
	public ModelAndView sayHello(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			@RequestParam(name = "user", required = true) String username,
			@RequestHeader(name = "Accept", required = false) String contentType) {
		Person person= new Person(username, 2);
		request.setAttribute("person", person);
		return new ModelAndView("hello");
	}

	/*
	 * Path Variable localhost:8080/shop/hello/spring-mvc/2
	 */
	@RequestMapping("/hello{name}/{id}")
	public String hello(HttpServletRequest request, @PathVariable(name = "name") String name,
			@PathVariable(name = "id") int useId) {
		request.setAttribute("msg", name);
		return "hello";
	}

	/*
	 * form addUser
	 * 
	 */
	@RequestMapping(value="/adduser", method = RequestMethod.GET)
	public String addUser(HttpServletRequest request) {
		User user = new User("j4Team");
		request.setAttribute("user", user);
		return "addUser";
	}

	@RequestMapping(value ="/adduser", method = RequestMethod.POST)
	public String addUser(HttpServletRequest request, @ModelAttribute("user") User user) {
		// user = new User("j4Team");
		request.setAttribute("user", user);
		return "viewUser";
	}
}

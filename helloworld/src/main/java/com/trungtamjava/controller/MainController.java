package com.trungtamjava.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trungtamjava.model.Employee;

@Controller
public class MainController {

	public static List<Employee> employees = new ArrayList<Employee>();

	@Autowired
	org.springframework.core.env.Environment environment;

	@GetMapping(value = "/")
	public String home(HttpServletRequest request) {
		// request.setAttribute("msg", "Hello Spring Boot");
		// request.setAttribute("msg", messageSource.getMessage("my.name", null, null));
		employees.addAll(Arrays.asList(new Employee("1", "Nguyen Van A", 22), new Employee("2", "Nguyen Van B", 20),
				new Employee("3", "Nguyen Van C", 21), new Employee("4", "Nguyen Van D", 19),
				new Employee("5", "Nguyen Van E", 23)));
		request.setAttribute("msg", environment.getProperty("message"));
		return "index";
	}

	@GetMapping(value = "/employees")
	public String employee(HttpServletRequest request) {
		request.setAttribute("employees", employees);
		return "employees";
	}

	@PostMapping(value = "/employee")
	public String addemployee(HttpServletRequest request, @RequestParam(name = "name") String name,
			@RequestParam(name = "age", required = true) int age) {
		employees.add(new Employee("" + (employees.size() + 1), name, age));
		return "redirect:/employees";
	}
}

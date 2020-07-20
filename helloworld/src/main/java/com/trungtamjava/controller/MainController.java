package com.trungtamjava.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.trungtamjava.model.EmployeeDTO;
import com.trungtamjava.service.EmployeeService;

@Controller
public class MainController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	org.springframework.core.env.Environment environment;

	@GetMapping(value = "/")
	public String home(HttpServletRequest request) {
		request.setAttribute("msg", environment.getProperty("message"));
		return "index";
	}

	@GetMapping(value = "/employees")
	public String getAllEmployees(HttpServletRequest request, Model model) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		request.setAttribute("msg", environment.getProperty("message") + userDetails.getUsername());

		List<EmployeeDTO> employees = employeeService.getAllEmployees();
		request.setAttribute("employees", employees);
		model.addAttribute("employee", new EmployeeDTO(10, "Model", 23));
		return "employees";
	}

	@PostMapping(value = "/employee")
	public String addEmployee(HttpServletRequest request, @ModelAttribute(name = "employee") EmployeeDTO employee) {
		employee.setPhones(Arrays.asList("098766555", "098883223"));
		employeeService.addEmployee(employee);
		return "redirect:/employees";
	}
}

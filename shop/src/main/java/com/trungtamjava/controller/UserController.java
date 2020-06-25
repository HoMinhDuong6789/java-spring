package com.trungtamjava.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.trungtamjava.model.User;
import com.trungtamjava.service.UserService;
import com.trungtamjava.validator.UserValidator;

@Controller
public class UserController {

	@Autowired
	UserValidator userValidator;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/list-user", method = RequestMethod.GET)
	public String getAllUser(HttpServletRequest request) {
		List<User> users= userService.getAllUsers();
		request.setAttribute("users", users);
		
		return "user/listUser";
	}
	

	@RequestMapping(value = "/user-detail/{userId}", method = RequestMethod.GET)
	public String viewUser(HttpServletRequest request, @PathVariable(value = "userId") int userId) {
		List<User> users= userService.getAllUsers();
		request.setAttribute("user", userService.getUserById(userId));
		return "user/viewUser";
	}
	
	@RequestMapping(value = "/user-insert", method = RequestMethod.GET)
	public String addUser(HttpServletRequest request) {
		request.setAttribute("user",new User());
		return "user/addUser";
	}
	
	@RequestMapping(value = "/user-insert", method = RequestMethod.POST)
	public String addUser(HttpServletRequest request, @ModelAttribute("user") User user, BindingResult bindingResult) {
		userValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {// bien dung de kiem tra co loi hay ko, ==true thi co loi
			return "user/addUser";
		}
		userService.addUser(user);
		request.setAttribute("user", user);
		return "redirect:list-user";
	}
}

package com.trungtamjava.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trungtamjava.model.UserDTO;
import com.trungtamjava.service.UserService;
import com.trungtamjava.validator.UserValidator;

@Controller
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	UserValidator userValidator;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/list-user", method = RequestMethod.GET)
	public String getAllUser(HttpServletRequest request) {
		List<UserDTO> users= userService.getAllUsers();
		request.setAttribute("users", users);
		logger.info("User Information");
		return "user/listUser";
	}
	

	@RequestMapping(value = "/user-detail/{userId}", method = RequestMethod.GET)
	public String viewUser(HttpServletRequest request, @PathVariable(name = "userId") int userId) {
		//List<User> users= userService.getAllUsers();
		request.setAttribute("user", userService.getUserById(userId));
		return "user/viewUser";
	}
	
	@RequestMapping(value = "/user-insert", method = RequestMethod.GET)
	public String addUser(HttpServletRequest request) {
		request.setAttribute("user",new UserDTO());
		return "user/addUser";
	}
	
	@RequestMapping(value = "/user-insert", method = RequestMethod.POST)
	public String addUser(HttpServletRequest request, @ModelAttribute("user") UserDTO user, BindingResult bindingResult) {
		userValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {// bien dung de kiem tra co loi hay ko, ==true thi co loi
			return "user/addUser";
		}
		userService.addUser(user);
		request.setAttribute("user", user);
		return "redirect:list-user";
	}
	
	@RequestMapping(value = "/user-delete/{userId}", method = RequestMethod.GET)
	public String deleteUser(HttpServletRequest request,
			@PathVariable(name = "userId") int userId) {
		userService.deleteUser(userId);
		return "redirect:/list-user";
	}
	
	@RequestMapping(value = "/user-edit/{userId}", method = RequestMethod.GET)
	public String editUser(HttpServletRequest request,
			@PathVariable(name = "userId") int userId) {
		request.setAttribute("user", userService.getUserById(userId));
		return "user/editUser";
	}
	
	@RequestMapping(value = "/user-edit", method = RequestMethod.POST)
	public String editUser(HttpServletRequest request, @ModelAttribute("user") UserDTO user, BindingResult bindingResult) {
		userValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {// bien dung de kiem tra co loi hay ko, ==true thi co loi
			return "user/editUser";
		}
		userService.updateUser(user);
		return "redirect:list-user";
	}
}

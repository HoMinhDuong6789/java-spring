package com.trungtamjava.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.trungtamjava.model.UserDTO;
import com.trungtamjava.service.UserService;

@RestController
public class RestUserController {

	@Autowired
	UserService userService;
	
	// RestAPI

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<UserDTO> listUser(HttpServletRequest request) {  // chuyeern ddoir mot list, thanh dangj json or xml tuy theo yeu caum convert tuw server ve json/xml
		List<UserDTO> users = userService.getAllUsers();
		request.setAttribute("users", users);
		return users;
	}

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public UserDTO detailUser(HttpServletRequest request, @PathVariable(name = "userId") int userId) {
		// List<User> users= userService.getAllUsers();
		request.setAttribute("user", userService.getUserById(userId));
		return userService.getUserById(userId);
	}

	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addUser(@RequestBody UserDTO user) { //@RequestBody: convert json -> thanh cac doi tuong DTO
		userService.addUser(user);
	}
}

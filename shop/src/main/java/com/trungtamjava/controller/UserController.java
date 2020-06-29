package com.trungtamjava.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
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
@RequestMapping("/admin")
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	UserValidator userValidator;

	@Autowired
	UserService userService;

	@Autowired
	MailSender mailSender;

	@RequestMapping(value = "/list-user", method = RequestMethod.GET)
	public String getAllUser(HttpServletRequest request, HttpSession session) {
		List<UserDTO> users = userService.getAllUsers();
		request.setAttribute("users", users);
		session.setAttribute("users", users);
		// logger.info("User Information");
		return "listUser";
	}

	@RequestMapping(value = "/user-detail/{userId}", method = RequestMethod.GET)
	public String viewUser(HttpServletRequest request, @PathVariable(name = "userId") int userId) {
		// List<User> users= userService.getAllUsers();
		request.setAttribute("user", userService.getUserById(userId));
		return "viewUser";
	}

	@RequestMapping(value = "/user-insert", method = RequestMethod.GET)
	public String addUser(HttpServletRequest request) {
		request.setAttribute("user", new UserDTO());
		return "addUser";
	}

	@RequestMapping(value = "/user-insert", method = RequestMethod.POST)
	public String addUser(HttpServletRequest request, @ModelAttribute("user") UserDTO user,
			BindingResult bindingResult) {
		userValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {// bien dung de kiem tra co loi hay ko, ==true thi co loi
			return "addUser";
		}
		userService.addUser(user);
		request.setAttribute("user", user);
		return "redirect:list-user";
	}

	@RequestMapping(value = "/user-delete/{userId}", method = RequestMethod.GET)
	public String deleteUser(HttpServletRequest request, @PathVariable(name = "userId") int userId) {
		userService.deleteUser(userId);
		return "redirect:/list-user";
	}

	@RequestMapping(value = "/user-edit/{userId}", method = RequestMethod.GET)
	public String editUser(HttpServletRequest request, @PathVariable(name = "userId") int userId) {
		request.setAttribute("user", userService.getUserById(userId));
		return "editUser";
	}

	@RequestMapping(value = "/user-edit", method = RequestMethod.POST)
	public String editUser(HttpServletRequest request, @ModelAttribute("user") UserDTO user,
			BindingResult bindingResult) {
		userValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {// bien dung de kiem tra co loi hay ko, ==true thi co loi
			return "editUser";
		}

		//sendEmail("minhans29@gmail.com", "minhans29@gmail.com", "test", "this is email for test");
		userService.updateUser(user);
		return "redirect:list-user";
	}

	public void sendEmail(String from, String to, String subject, String content) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(from);
		mailMessage.setTo(to);
		mailMessage.setSubject(subject);
		mailMessage.setText(content);
		mailSender.send(mailMessage);
	}

}

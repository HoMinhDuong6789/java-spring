package com.enclave.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enclave.training.dao.UserDAO;
import com.enclave.training.enity.User;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	public User findUser(String username) {
		return userDAO.findUser(username);
	}
}

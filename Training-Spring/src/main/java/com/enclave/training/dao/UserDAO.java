package com.enclave.training.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.enclave.training.enity.User;

@Repository
@Transactional
public class UserDAO {

	@Autowired
	EntityManager entityManager;

	public User findUser(String username) {
		return entityManager.find(User.class, username);
	}
}

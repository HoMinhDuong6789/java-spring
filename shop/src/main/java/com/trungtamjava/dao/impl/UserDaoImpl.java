package com.trungtamjava.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trungtamjava.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	UserDao userDao;
}

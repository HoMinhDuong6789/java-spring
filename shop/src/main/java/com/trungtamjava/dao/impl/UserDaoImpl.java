package com.trungtamjava.dao.impl;

import java.nio.channels.SeekableByteChannel;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trungtamjava.dao.UserDao;
import com.trungtamjava.entity.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addUser(User user) {
	sessionFactory.getCurrentSession().save(user);
		
	}

	@Override
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().merge(user);
		
	}

	@Override
	public void deleteUser(int id) {
		sessionFactory.getCurrentSession().delete(getUserById(id));
	}

	@Override
	public User getUserById(int id) {
		return  (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	@Override
	public List<User> getAllUsers() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		return criteria.list();
	}



}

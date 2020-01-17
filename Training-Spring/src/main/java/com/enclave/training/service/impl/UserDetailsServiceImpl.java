package com.enclave.training.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.enclave.training.dao.UserDAO;
import com.enclave.training.enity.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDAO.findUser(username);

		if (user == null) {
			System.err.println("User " + username + " was not found in the database");
			throw new UsernameNotFoundException("User " + username + " was not found in the database");
		}

		String role = "ADMIN";
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		GrantedAuthority authority = new SimpleGrantedAuthority(role);
		grantList.add(authority);

		UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(), grantList);
		return userDetails;
	}
}

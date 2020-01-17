package com.example.ex1;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ProductDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	public boolean save(Product product) {
		try {
			entityManager.persist(product);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}

package com.trungtamjava.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trungtamjava.dao.ProductDao;
import com.trungtamjava.entity.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addProduct(Product product) {
		sessionFactory.getCurrentSession().save(product);
	}

	@Override
	public void updateProduct(Product product) {
		sessionFactory.getCurrentSession().merge(product);

	}

	@Override
	public void deleteProduct(int id) {
		sessionFactory.getCurrentSession().delete(getProductById(id));
	}

	@Override
	public Product getProductById(int id) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
	}

	@Override
	public List<Product> getAllProducts() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
		return criteria.list();
	}
}

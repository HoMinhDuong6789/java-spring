package com.example.ex1;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
@Transactional
public class ProductService {
	@Autowired
	private ProductRespository repo;
	
	public List<Product> listAll(){
		return repo.findAll();
	}
	public void save(Product product) {
		repo.save(product);
	}
	public Product get(int id) {
		return repo.findById(id).get();
		
	}
	private Object findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public void delete(int id) {
		repo.deleteById(id);
	}
}

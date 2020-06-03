package com.laptrinhjavaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.dao.impl.CategoryDAO;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.service.ICategoryService;

public class CategoryService implements ICategoryService {
	
	/*
	private ICategoryDAO categoryDAO;
	public CategoryService() {
		// TODO Auto-generated constructor stub
		categoryDAO = new CategoryDAO();
	}
	@Inject nafy thay the co toan bo dong code tren
	*/
	@Inject
	private ICategoryDAO categoryDao;

	@Override
	public List<CategoryModel> findAll() {
		return categoryDao.findAll();
	}
}

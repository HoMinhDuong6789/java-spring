package com.trungtamjava.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trungtamjava.dao.ProductDao;
import com.trungtamjava.entity.Product;
import com.trungtamjava.model.ProductDTO;
import com.trungtamjava.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;

	@Override
	public void addProduct(ProductDTO productDTO) {
		Product product = new Product();
		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPrice());
		product.setImage_url(productDTO.getImage_url());
		productDao.addProduct(product);
	}

	@Override
	public void updateProduct(ProductDTO productDTO) {
		Product product = new Product();
		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPrice());
		productDao.updateProduct(product);

	}

	@Override
	public void deleteProduct(int id) {
		Product product = productDao.getProductById(id);
		if (product != null) {
			productDao.deleteProduct(id);
		}
	}

	@Override
	public ProductDTO getProductById(int id) {
		Product product = new Product();
		product = productDao.getProductById(id);
		ProductDTO productDTO = new ProductDTO();
		if (product != null) {
			productDTO.setId(product.getId());
			productDTO.setName(product.getName());
			productDTO.setPrice(product.getPrice());
			productDTO.setImage_url(product.getImage_url());
		}

		return productDTO;
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		List<Product> products = productDao.getAllProducts();
		List<ProductDTO> productDTOs = new ArrayList<>();
		for (Product product : products) {
			ProductDTO productDTO = new ProductDTO(product.getName(), product.getPrice());
			productDTO.setId(product.getId());
			productDTOs.add(productDTO);
		}
		return productDTOs;
	}
}

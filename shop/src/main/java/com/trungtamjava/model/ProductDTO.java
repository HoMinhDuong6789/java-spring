package com.trungtamjava.model;

import org.springframework.web.multipart.MultipartFile;

public class ProductDTO {
	private int id;
	private String name;
	private double price;
	private String image_url;
	private MultipartFile file;

	public ProductDTO() {

	}

	public ProductDTO(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}

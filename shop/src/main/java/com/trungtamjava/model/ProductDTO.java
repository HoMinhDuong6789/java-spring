package com.trungtamjava.model;

public class ProductDTO {
	private int id;
	private String name;
	private double price;

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

	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}

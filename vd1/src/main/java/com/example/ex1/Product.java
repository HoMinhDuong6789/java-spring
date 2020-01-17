package com.example.ex1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The Class Product.
 */
@Entity
public class Product {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/** The name. */
	private String name;

	/** The brand. */
	private String brand;

	/** The madein. */
	private String madein;

	/** The price. */
	private float price;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the brand.
	 *
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Sets the brand.
	 *
	 * @param brand the new brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Gets the madein.
	 *
	 * @return the madein
	 */
	public String getMadein() {
		return madein;
	}

	/**
	 * Sets the madein.
	 *
	 * @param madein the new madein
	 */
	public void setMadein(String madein) {
		this.madein = madein;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(float price) {
		this.price = price;
	}

}

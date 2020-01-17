package com.enclave.training.enity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class User.
 */
@Entity
@Table(name = "tbl_user")
public class User {

	/** The username. */
	@Id
	private String username;
	
	/** The password. */
	private String password;
	
	/** The logo. */
	private String logo;
	
	/** The created at. */
	private Date created_at;
	
	/** The updated at. */
	private Date updated_at;

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the logo.
	 *
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * Sets the logo.
	 *
	 * @param logo the new logo
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}

	/**
	 * Gets the created at.
	 *
	 * @return the created at
	 */
	public Date getCreated_at() {
		return created_at;
	}

	/**
	 * Sets the created at.
	 *
	 * @param created_at the new created at
	 */
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	/**
	 * Gets the updated at.
	 *
	 * @return the updated at
	 */
	public Date getUpdated_at() {
		return updated_at;
	}

	/**
	 * Sets the updated at.
	 *
	 * @param updated_at the new updated at
	 */
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

}

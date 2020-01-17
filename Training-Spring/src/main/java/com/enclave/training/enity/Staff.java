package com.enclave.training.enity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Staff.
 */
@Entity
@Table(name = "tbl_staff")
public class Staff {
	
	/** The staff id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int staffId;
	
	/** The name. */
	private String name;
	
	/** The role. */
	private String role;
	
	/** The tel. */
	private String tel;
	
	/** The gender. */
	private int gender;
	
	/** The created at. */
	private Date created_at;
	
	/** The updated at. */
	private Date updated_at;
	
	/**
	 * Gets the staff id.
	 *
	 * @return the staff id
	 */
	public int getStaffId() {
		return staffId;
	}
	
	/**
	 * Sets the staff id.
	 *
	 * @param staffId the new staff id
	 */
	public void setStaffId(int staffId) {
		this.staffId = staffId;
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
	 * Gets the role.
	 *
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	
	/**
	 * Sets the role.
	 *
	 * @param role the new role
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	/**
	 * Gets the tel.
	 *
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}
	
	/**
	 * Sets the tel.
	 *
	 * @param tel the new tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public int getGender() {
		return gender;
	}
	
	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(int gender) {
		this.gender = gender;
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

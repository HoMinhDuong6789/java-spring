package com.enclave.training.enity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Role.
 */
@Entity
@Table(name = "mst_role")
public class Role {
	
	/** The role id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleId;
	
	/** The position. */
	private String position;
	
	/** The created at. */
	private Date created_at;
	
	/** The updated at. */
	private Date updated_at;

	/**
	 * Gets the role id.
	 *
	 * @return the role id
	 */
	public int getRoleId() {
		return roleId;
	}

	/**
	 * Sets the role id.
	 *
	 * @param roleId the new role id
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * Sets the position.
	 *
	 * @param position the new position
	 */
	public void setPosition(String position) {
		this.position = position;
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

package com.trungtamjava.service;

import java.util.List;

import com.trungtamjava.model.EmployeeDTO;

public interface EmployeeService {
	/*
	 * convert dữ liệu từ DTO về Entity
	 * DTO: đối tượng sử dụng trên tầng View và controller
	 */

	
	public List<EmployeeDTO> getAllEmployees();
	public void addEmployee(EmployeeDTO employee);
	public void deleleEmployee(int id);
	public void updateEmployee(EmployeeDTO employee);
}

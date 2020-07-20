package com.trungtamjava.dao;

import java.util.List;

import com.trungtamjava.entity.Employee;

public interface EmployeeDao {
	
	public List<com.trungtamjava.entity.Employee> getAllEmployees();

	public void addEmployee(com.trungtamjava.entity.Employee employee);

	public void deleteEmployee(com.trungtamjava.entity.Employee employee);

	public void updateEmployee(com.trungtamjava.entity.Employee employee);
	
	public Employee getEmployeeById(int id);
}

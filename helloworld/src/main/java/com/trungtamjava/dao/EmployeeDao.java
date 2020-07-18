package com.trungtamjava.dao;

import java.util.List;

import com.trungtamjava.model.Employee;

public interface EmployeeDao {
	public List<Employee> getAllEmployees();
	public void addEmployee(Employee employee);
}

package com.trungtamjava.service;

import java.util.List;

import com.trungtamjava.model.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployees();
	public void addEmployee(Employee employee);
}

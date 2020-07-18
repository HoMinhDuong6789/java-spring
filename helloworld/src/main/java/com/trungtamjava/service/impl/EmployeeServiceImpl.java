package com.trungtamjava.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trungtamjava.dao.EmployeeDao;
import com.trungtamjava.model.Employee;
import com.trungtamjava.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
		
	}

}

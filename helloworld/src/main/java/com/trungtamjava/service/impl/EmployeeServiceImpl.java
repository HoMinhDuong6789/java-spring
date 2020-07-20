package com.trungtamjava.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.trungtamjava.dao.EmployeeDao;
import com.trungtamjava.model.EmployeeDTO;
import com.trungtamjava.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<EmployeeDTO> listEmployeeDTO = new ArrayList<EmployeeDTO>();
		List<com.trungtamjava.entity.Employee> employees = employeeDao.getAllEmployees();
		for (com.trungtamjava.entity.Employee employee : employees) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setId(employee.getId());
			employeeDTO.setName(employee.getName());
			employeeDTO.setAge(employee.getAge());
			listEmployeeDTO.add(employeeDTO);
		}
		return listEmployeeDTO;
	}

	@Override
	public void addEmployee(EmployeeDTO employeeDTO) {
		com.trungtamjava.entity.Employee employee = new com.trungtamjava.entity.Employee();
		employee.setId(employeeDTO.getId());
		employee.setName(employeeDTO.getName());
		employee.setAge(employeeDTO.getAge());
		employeeDao.addEmployee(employee);
	}

	@Override
	public void deleleEmployee(int id) {
		com.trungtamjava.entity.Employee employee = employeeDao.getEmployeeById(id);
		if(employee!=null) {
			employeeDao.deleteEmployee(employee);
		}
		
	}

	@Override
	public void updateEmployee(EmployeeDTO employeeDTO) {
		com.trungtamjava.entity.Employee employee = employeeDao.getEmployeeById(employeeDTO.getId());
		if(employee!=null) {
			employee.setName(employeeDTO.getName());
			employee.setAge(employeeDTO.getAge());
			employeeDao.updateEmployee(employee);
		}
	}

}

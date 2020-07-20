package com.trungtamjava.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trungtamjava.dao.EmployeeDao;
import com.trungtamjava.entity.Employee;

@Transactional
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<com.trungtamjava.entity.Employee> getAllEmployees() {
		String jql = "SELECT e FROM Employee e";
		return entityManager.createQuery(jql, Employee.class).getResultList();
	}

	@Override
	public void addEmployee(Employee employee) {
		entityManager.persist(employee);

	}

	@Override
	public void deleteEmployee(Employee employee) {
		entityManager.remove(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		entityManager.merge(employee);
	}

	@Override
	public Employee getEmployeeById(int id) {
		return entityManager.find(Employee.class, id);
	}

}

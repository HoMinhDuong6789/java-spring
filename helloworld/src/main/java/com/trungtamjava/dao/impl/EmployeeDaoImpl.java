package com.trungtamjava.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trungtamjava.dao.EmployeeDao;
import com.trungtamjava.model.Employee;

@Transactional
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Employee> getAllEmployees() {
		String sql = "SELECT * FROM employee";
		return jdbcTemplate.query(sql, new RowMapper<Employee>() {
			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee = new Employee();
				employee.setId(rs.getInt("id"));
				employee.setName(rs.getString("name"));
				employee.setAge(rs.getInt("age"));
				return employee;
			}
		});
	}

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO employee (name,age) VALUES ('"+employee.getName()+"',"+employee.getAge()+")";
				//"INSERT INTO employee (name,age) VALUES (?, ?)"; ???
		jdbcTemplate.execute(sql);
	}

}

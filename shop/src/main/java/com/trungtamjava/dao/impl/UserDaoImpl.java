package com.trungtamjava.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trungtamjava.dao.UserDao;
import com.trungtamjava.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void addUser(User user) {
		String sql = "INSERT INTO user (tenkh, sdt) VALUE (?,?)";
		jdbcTemplate.update(sql, user.getName(), user.getPhone());
	}

	@Override
	public void updateUser(User user) {
		String sql = "UPDATE user SET tenkh=?, sdt=? WHERE id=?";
		jdbcTemplate.update(sql, user.getName(), user.getPhone(), user.getId());
	}

	@Override
	public void deleteUser(int id) {
		String sql = "DELETE FROM user WHERE id=?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public User getUserById(int id) {
		String sql = "SELECT * FROM user WHERE id=?";
		return jdbcTemplate.queryForObject(sql,new Object[]{id} , new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNumber) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("tenkh"));
				user.setPhone(rs.getString("sdt"));
				return user;
			}
		});
	}

	@Override
	public List<User> getAllUsers() {
		String sql = "SELECT * FROM user ";
		return jdbcTemplate.query(sql, new Object[] {} , new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNumber) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("tenkh"));
				user.setPhone(rs.getString("sdt"));
				return user;
			}
		});
	}
}

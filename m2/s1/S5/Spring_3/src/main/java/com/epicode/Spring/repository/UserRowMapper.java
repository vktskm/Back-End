package com.epicode.Spring.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.epicode.Spring.model.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User u = new User();
		u.setId(rs.getLong("id"));
		u.setName(rs.getString("name"));
		u.setLastname(rs.getString("lastname"));
		u.setCity(rs.getString("city"));
		u.setAge(rs.getInt("age"));
		u.setEmail(rs.getString("email"));
		u.setPassword(rs.getString("password"));
		
		return u;
	}

}

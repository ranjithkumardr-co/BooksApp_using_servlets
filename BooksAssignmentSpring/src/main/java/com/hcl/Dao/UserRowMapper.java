package com.hcl.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.hcl.beans.Users;

public class UserRowMapper implements RowMapper<Users>{
	
	


	@Override
	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Users u=new Users();
		u.setUserid(rs.getInt(1));
		u.setUsername(rs.getString(2));
		u.setEmail(rs.getString(3));
		u.setPassword(rs.getString(4));
		return u;
	
	}

}

package com.hcl.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hcl.beans.Books;

public class BooksLikedRow implements RowMapper<Books> {

	@Override
	public Books mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Books book=new Books();
		book.setBookid(rs.getInt(1));
		book.setBookurl(rs.getString(2));
		book.setBookname(rs.getString(3));
		book.setCategory(rs.getString(4));
		book.setAuthorname(rs.getString(5));
		return book;
	}

}

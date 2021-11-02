package com.hcl.springtest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.hcl.beans.Books;
import com.hcl.beans.Users;


@Configuration
public class AppConfig {

	@Bean
	@Scope(value = "prototype")
	public Users getuser() {

		return new Users();
	}


	
	@Bean
	@Scope(value = "prototype")
	public Books getBooks() {
		return new Books();
	}



	@Bean
	public DriverManagerDataSource ds() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/ranjith");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}

	@Bean
	public JdbcTemplate template()

	{
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(ds());

		return template;
	}

}
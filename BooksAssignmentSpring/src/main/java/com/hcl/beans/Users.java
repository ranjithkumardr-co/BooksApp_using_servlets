package com.hcl.beans;

public class Users {
	
	private Integer userid;
	private String Username;
	private String Email;
	private String password;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getEmail() {
		return Email;
	}
	@Override
	public String toString() {
		return "Users [userid=" + userid + ", Username=" + Username + ", Email=" + Email + ", password=" + password
				+ "]";
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}

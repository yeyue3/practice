package com.yl.domian;

import java.util.ArrayList;

import com.yl.util.SqlHelper;

public class Users {
	int id = -1;
	String username;
	String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNameById(String id){
		String sql = "select username from users where id=?";
		String[] parameters = {id}; 
		ArrayList al = SqlHelper.executeQuery2(sql, parameters);
		Object[] obj = (Object[]) al.get(0);
		return (String)obj[0];
	}
	
	int grade = -1;
	String password;
}

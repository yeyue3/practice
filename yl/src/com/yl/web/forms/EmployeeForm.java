package com.yl.web.forms;

import org.apache.struts.action.ActionForm;

public class EmployeeForm extends ActionForm {
	private Integer id;
	private String name;
	private String email;
	private java.util.Date heirdate;
	private Float salary;
	private String pwd;
	private Integer grade;
	private String department;
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public java.util.Date getHeirdate() {
		return heirdate;
	}
	public void setHeirdate(java.util.Date heirdate) {
		this.heirdate = heirdate;
	}
	public Float getSalary() {
		return salary;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	
	
}

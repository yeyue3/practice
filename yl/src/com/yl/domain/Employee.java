package com.yl.domain;

import java.util.Date;

public class Employee {
	private Integer id;
	private String name;
	private String email;
	private java.util.Date heirdate;
	private Float salary;
	private String pwd;
	private Integer grade;
	
	private Department department;
	
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
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

	public Employee(){
		
	}
	
	
	public Employee(String email, Integer grade, Date heirdate, String name,
			String pwd, Float salary) {
		super();
		this.email = email;
		this.grade = grade;
		this.heirdate = heirdate;
		this.name = name;
		this.pwd = pwd;
		this.salary = salary;
	}

	public java.util.Date getHeirdate() {
		return heirdate;
	}

	public void setHeirdate(java.util.Date heirdate) {
		this.heirdate = heirdate;
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
	
	public Float getSalary() {
		return salary;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	
	
}

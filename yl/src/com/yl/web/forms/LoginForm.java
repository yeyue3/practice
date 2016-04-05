package com.yl.web.forms;

import org.apache.struts.action.ActionForm;

public class LoginForm extends ActionForm {
	private Integer id;
	private String pwd;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}

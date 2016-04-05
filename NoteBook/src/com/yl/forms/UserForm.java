package com.yl.forms;

import org.apache.struts.action.ActionForm;

public class UserForm extends ActionForm{
	private int userid;
	private String pwd;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}

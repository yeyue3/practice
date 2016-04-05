package com.yl.forms;

import org.apache.struts.action.ActionForm;


public class MassageForm extends ActionForm{
	private String getterName;
	private String content;
	public String getGetterName() {
		return getterName;
	}
	public void setGetterName(String getterName) {
		this.getterName = getterName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	

	
	
}

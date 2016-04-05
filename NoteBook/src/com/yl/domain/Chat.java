package com.yl.domain;

import java.util.Date;

public class Chat {
	private Integer id;
	private User sender;
	private User getter;
	private String content;
	private Date transtime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	public User getGetter() {
		return getter;
	}
	public void setGetter(User getter) {
		this.getter = getter;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTranstime() {
		return transtime;
	}
	public void setTranstime(Date transtime) {
		this.transtime = transtime;
	}
	
	
}

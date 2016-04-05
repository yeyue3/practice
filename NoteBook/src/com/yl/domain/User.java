package com.yl.domain;

import java.util.Set;

public class User {
	private int userid;
	private String username;
	private String userpwd;
	
	private Set<Chat> sendChat;
	private Set<Chat> getChat;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String pwd) {
		this.userpwd = pwd;
	}
	public Set<Chat> getSendChat() {
		return sendChat;
	}
	public void setSendChat(Set<Chat> sendChat) {
		this.sendChat = sendChat;
	}
	public Set<Chat> getGetChat() {
		return getChat;
	}
	public void setGetChat(Set<Chat> getChat) {
		this.getChat = getChat;
	}
	
	
}

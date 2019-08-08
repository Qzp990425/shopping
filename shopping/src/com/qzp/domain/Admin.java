package com.qzp.domain;

public class Admin {
	private int id;
	private String account;
	private String password;
	
	public Admin(){
		this.id = -1;
		this.account = "";
		this.password = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

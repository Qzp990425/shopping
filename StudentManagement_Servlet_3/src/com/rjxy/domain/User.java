package com.rjxy.domain;

public class User {
	private String id;
	private String username;
	private String emali;
	private int grade;
	private String password;
	
	public User() {}
	public User(String id,String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public User(String id, String username, String emali, int grade) {
		super();
		this.id = id;
		this.username = username;
		this.emali = emali;
		this.grade = grade;
	}
	
	public User(String id, String username, String emali, int grade, String password) {
		super();
		this.id = id;
		this.username = username;
		this.emali = emali;
		this.grade = grade;
		this.password = password;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmali() {
		return emali;
	}


	public void setEmali(String emali) {
		this.emali = emali;
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
	
	
	
}

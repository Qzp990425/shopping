package com.qzp.domain;

public class User {
	//自增长id
	private int id;	  
	//用户的真实姓名  用于日后校验
	private String name; 
	//用户名
	private String username;  
	//密码
	private String password;   
	//头像
	private String headImage;  
	//支付情况
	private Double spend;
	public User() {
		this.id = Integer.MAX_VALUE;
		this.username = "";
		this.password = "";
		this.headImage = "";
		this.spend = 0.0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	public Double getSpend() {
		return spend;
	}

	public void setSpend(Double spend) {
		this.spend = spend;
	}
	
	
}

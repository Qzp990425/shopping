package com.qzp.domain;

import java.sql.Date;

public class Order {
	private int id;
	private Date date;  //订单时间
	private int userId;	//用户的id号
	private double total;	//总价钱
	
	public Order() {
		this.id = -1;
		this.userId = -1;
		this.total = 0.0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
}

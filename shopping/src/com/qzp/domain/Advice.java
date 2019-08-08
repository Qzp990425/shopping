package com.qzp.domain;

import java.sql.Date;

public class Advice {
	private int id;
	private int userid;//用户id号
	private Date date;  //存入日期
	private String title; //标题 
	private String neirong; //内容
	
	public Advice() {
		this.id = -1;
		this.userid = -1;
		this.title = "";
		this.neirong = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNeirong() {
		return neirong;
	}

	public void setNeirong(String neirong) {
		this.neirong = neirong;
	}
	
	
}

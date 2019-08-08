package com.qzp.domain;

public class Book {
	private int id;
	private String link; //表示该图书的介绍
	private String name; //书名
	private String kind; //书的种类
	private String status;  //书的出售状态(0,1) 0为正常  1为打折
	private int num;  //书的数量
	private String img;  //书的图片路径
	private double price; //书的价钱
	private double nowPirce;
	
	public Book() {
		this.id = -1;
		this.link = " ";
		this.name = "";
		this.kind = "";
		this.status = "0";
		this.num = 0;
		this.img = "";
		this.price = 0.0f;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getNowPirce() {
		return nowPirce;
	}

	public void setNowPirce(double nowPirce) {
		this.nowPirce = nowPirce;
	}
	
	
}

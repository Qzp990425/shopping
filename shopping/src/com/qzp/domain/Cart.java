package com.qzp.domain;

//这里是购物车表
public class Cart {
	private int id;
	private int bookId;  //设置买的书的id
	private int userId; //这里为用户的id
	private String bookName; //这里为买的书的名字
	private String bookImg; //设置书的图片
	private int buyNum;	//购买数量
	private int num;  //剩余的本数
	private double price;   //书的价钱
	
	public Cart(){
		this.id = -1;
		this.userId = -1;
		this.bookName = "";
		this.bookImg = "";
		this.buyNum = -1;
		this.num = -1;
		this.price = -1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBuyNum() {
		return buyNum;
	}

	public void setBuyNum(int buyNum) {
		this.buyNum = buyNum;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBookImg() {
		return bookImg;
	}

	public void setBookImg(String bookImg) {
		this.bookImg = bookImg;
	}
	
	
}

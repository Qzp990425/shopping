package com.qzp.domain;

//表示收藏列表bean
public class Like {
	private int id;
	private int userId;
	private int bookId;
	
	public Like() {
		this.id = -1;
		this.userId = -1;
		this.bookId = -1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	
}

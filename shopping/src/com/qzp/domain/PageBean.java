package com.qzp.domain;

import java.util.ArrayList;

public class PageBean {
	private int pageNow; //要去第几页
	private int pageCount; //共有多少页
	private int pageSize;  //每页几条数据
	private int rowCount;  //共有多少条记录
	
	private ArrayList<Book> al = new ArrayList();  //表示显示的信息
	
	public PageBean() {
		this.pageNow = 0; 
		this.pageCount = 0; //共有多少页
		this.pageSize = 0;  //每页几条数据
		this.rowCount = 0;  //共有多少条记录
		
	}
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public ArrayList<Book> getAl() {
		return al;
	}
	public void setAl(ArrayList<Book> al) {
		this.al = al;
	}
	
	
}

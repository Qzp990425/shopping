package com.qzp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import com.qzp.domain.Book;
import com.qzp.domain.PageBean;
import com.qzp.utils.DBUtil;
import com.qzp.utils.SqlHelper;

//这里是一些与书有关的方法
public class BookService {
	//查找正常出售的书籍
	public ArrayList<Book> getNormalBook() {
		String sql = "select * from book where status = ?";
		String[] parameters = {"0"};
		ArrayList<Object> al = SqlHelper.executeQuery(sql, parameters);
		ArrayList<Book> bookAl = new ArrayList<Book>();
		for(int i = 0; i<al.size() ; i++){
			Object[] object = (Object[]) al.get(i);
			Book book = setBook(object);			
			bookAl.add(book);
		}
		return bookAl;
	}
	
	//查找正在折扣的书籍
	public ArrayList<Book> getSaleBook() {
		String sql = "select * from book where status = ?";
		String[] parameters = {"1"};
		ArrayList<Object> al = SqlHelper.executeQuery(sql, parameters);
		ArrayList<Book> bookAl = new ArrayList<Book>();
		for(int i = 0; i<al.size() ; i++){
			Object[] object = (Object[]) al.get(i);
			Book book = setBook(object);
			bookAl.add(book);
		}
		return bookAl;
	}
	
	//查找一本指定的书籍(通过id)
	public Book getBook(String id) {
		Book book = new Book();
		String sql = "select * from book where id = ?";
		String[] parameters = {id};
		ArrayList<Object> al = SqlHelper.executeQuery(sql, parameters);
		Object[] object = (Object[]) al.get(0);
		book = setBook(object);
		return book;
	}
	
	//查找一本指定的书籍(通过名字)
	public Book getBook1(String name) {
		System.out.println(name);
		Book book = new Book();
		String sql = "select * from book where name = ?";
		String[] parameters = {name};
		ArrayList<Object> al = SqlHelper.executeQuery(sql, parameters);
		if(al.size()==0){
			return null;
		}
		Object[] object = (Object[]) al.get(0);
		book = setBook(object);
		return book;
	}
	
	//查找同类型书籍
	public ArrayList<Book> getSameKindBook(String kind) {
		String sql = "select * from book where kind = ?";
		String[] parameters = {kind};
		ArrayList<Object> al = SqlHelper.executeQuery(sql, parameters);
		ArrayList<Book> bookAl = new ArrayList<Book>();
		for(int i = 0; i<al.size() ; i++){
			Object[] object = (Object[]) al.get(i);
			Book book1 = setBook(object);
			bookAl.add(book1);
		}
		return bookAl;
	}

	//查找喜欢书籍(同类型)
	public ArrayList<Book> getSameBook(Book book) {
		String sql = "select * from book where kind = ? and id != ? ";
		String[] parameters = {book.getKind(),Integer.toString(book.getId())};
		ArrayList<Object> al = SqlHelper.executeQuery(sql, parameters);
		ArrayList<Book> bookAl = new ArrayList<Book>();
		for(int i = 0; i<al.size() ; i++){
			Object[] object = (Object[]) al.get(i);
			Book book1 = setBook(object);
			bookAl.add(book1);
		}
		return bookAl;
	}
	
	//购买后对书进行更新
	public void updateBook(Book book,String buynum) {
		String sql = "update book set num = ? where id = ?";
		String id = Integer.toString(book.getId());
		String num = Integer.toString(book.getNum()-Integer.valueOf(buynum));
		String[] parameters = {num,id};
		SqlHelper.executeUpdate(sql, parameters);
	}
	
	//得到所有的书
	public ArrayList<Book> getAllBook() {
		String sql = "select * from book where 1 = ?";
		String[] parameters = {"1"};
		ArrayList<Object> al = SqlHelper.executeQuery(sql, parameters);
		ArrayList<Book> bookAl = new ArrayList<Book>();
		for(int i = 0; i<al.size() ; i++){
			Object[] object = (Object[]) al.get(i);
			Book book = setBook(object);			
			bookAl.add(book);
		}
		return bookAl;
	}
	
	//删除一本书
	public void deleteBook(String id) {
		String sql = "delete from book where id = ?";
		String[] parameters = {id};
		SqlHelper.executeUpdate(sql, parameters);
	}
	
	//添加一本书
	public void addBook(Book book) {
		String sql = "insert into book(link,name,kind,status,num,img,price,nowprice) values(?,?,?,?,?,?,?,?)";
		String[] parameters = {book.getLink(),book.getName(),book.getKind(),book.getStatus(),Integer.toString(book.getNum()),book.getImg(),Double.toString(book.getPrice()),Double.toString(book.getNowPirce())};
		SqlHelper.executeUpdate(sql, parameters);
	}
	
	//更新一本书
	public void updateBook(Book book) {
		String sql = "update book set link=?,name=?,kind=?,status=?,num=?,img=?,price=?,nowprice=? where id = ?";
		String[] parameters = {book.getLink(),book.getName(),book.getKind(),book.getStatus(),Integer.toString(book.getNum()),book.getImg(),Double.toString(book.getPrice()),Double.toString(book.getNowPirce()),Integer.toString(book.getId())};
		SqlHelper.executeUpdate(sql, parameters);
	}
	//完成分页
	public ArrayList<Book> getPageBook(PageBean pageBean) {
		int start = (pageBean.getPageNow()-1)*pageBean.getPageSize();
		String sql = "select * from book limit ?,?";
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement pres = conn.prepareStatement(sql);
			pres.setInt(1, start);
			pres.setInt(2, pageBean.getPageSize());
			ResultSet res = pres.executeQuery();
			ArrayList<Book> booklist = new ArrayList<Book>();
			while(res.next()) {
				Book book = new Book();
				book.setId(res.getInt("id"));
				book.setLink(res.getString("link"));
				book.setName(res.getString("name"));
				book.setKind(res.getString("kind"));
				book.setStatus(res.getString("status"));
				book.setNum(res.getInt("num"));
				book.setImg(res.getString("img"));
				book.setPrice(res.getDouble("price"));
				book.setNowPirce(res.getDouble("nowprice"));
				booklist.add(book);
			}
			res.close();
			pres.close();
			conn.close();
			return booklist;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	//帮助设置书的属性
	public Book setBook(Object[] object) {
		Book book = new Book();
		book.setId(Integer.valueOf(object[0].toString()));
		book.setLink(object[1].toString());
		book.setName(object[2].toString());
		book.setKind(object[3].toString());
		book.setStatus(object[4].toString());
		book.setNum(Integer.valueOf(object[5].toString()));
		book.setImg(object[6].toString());
		book.setPrice(Double.valueOf(object[7].toString()));
		book.setNowPirce(Double.valueOf(object[8].toString()));
		return book;
	}
}

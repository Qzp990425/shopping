package com.qzp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import com.qzp.domain.Book;
import com.qzp.domain.Cart;
import com.qzp.domain.User;
import com.qzp.utils.DBUtil;
import com.qzp.utils.SqlHelper;

//处理与购物车书籍有关的一些业务
//先使用hashmap进行存储  然后最后进行更新
public class MyCartService {
	private Connection conn = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;		
	
	
	//用于添加一本书
	public void addBook(User user,Book book) {
		//先判断这个人有没有买过这个书
		String sql = "select * from cart where userid = ? and bookname = ?";
		String[] parameters = {Integer.toString(user.getId()),book.getName()};
		ArrayList<Object> al = SqlHelper.executeQuery(sql, parameters);
		if(al.size() == 0) {	
			try {
				//说明用户是第一次添加 进行插入
				sql = "insert into cart(userid,bookid,bookname,bookImg,buynum,num,price) values(?,?,?,?,?,?,?) ";
				conn = DBUtil.getConnection();		
				pst = conn.prepareStatement(sql);
				pst.setInt(1, user.getId());
				pst.setInt(2, book.getId());
				pst.setString(3, book.getName());
				pst.setString(4, book.getImg());
				pst.setInt(5, 1);
				pst.setInt(6, book.getNum());
				pst.setDouble(7, book.getPrice());
				pst.executeUpdate();
				DBUtil.close(rs, pst, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(rs, pst, conn);
			}							
		} else {
			try {
				//说明用户是第一次添加 进行插入
				sql = "update cart set num = ? where userid = ? and bookname = ?";
				conn = DBUtil.getConnection();		
				pst = conn.prepareStatement(sql);
				pst.setInt(1, book.getNum());
				pst.setInt(2, user.getId());
				pst.setString(3, book.getName());
				pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(rs, pst, conn);
			}		
		}
	}
	
	//更新一下购物车
	public void updateCart(Cart cart,User user) {
		String sql = "update cart set buynum = ? where userid = ? and bookid = ?";
		try {
			conn = DBUtil.getConnection();		
			pst = conn.prepareStatement(sql);
			pst.setInt(1, cart.getBuyNum());
			pst.setInt(2, user.getId());
			pst.setInt(3, cart.getBookId());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pst, conn);
		}		
	}
	
	//删除购物车中的指定书籍
	public void deleteBook(User user,String bookId) {
		String sql = "delete from cart where userid = ? and bookid = ?";
		String id = Integer.toString(user.getId());
		String[] parameters = {id,bookId};
		SqlHelper.executeUpdate(sql, parameters);
	}
	
	public void submitCart(User user,String total) {
		String sql = "insert into orderlist(date,userid,total) values(?,?,?)";
		//当前系统时间
		java.util.Date date = new java.util.Date();
		java.sql.Date sql_date = new java.sql.Date(date.getTime());
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setDate(1, sql_date);
			pst.setInt(2, user.getId());
			pst.setDouble(3, Double.valueOf(total));
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pst, conn);
		}
	}
	
	//清空购物车
	public void deleteCart(User user) {
		String sql = "delete from cart where userid = ?";
		String[] parameters = {Integer.toString(user.getId())};
		SqlHelper.executeUpdate(sql, parameters);
	}
	
	//更新user  将购物情况写入
	public User updateUser(User user,String total) {
		double double_total = Double.valueOf(total);
		user.setSpend(user.getSpend()+double_total);
		String sql = "update user set spend = ? where id = ?";
		String[] parameters = {Double.toString(user.getSpend()),Integer.toString(user.getId())};
		SqlHelper.executeUpdate(sql, parameters);		
		return user;
	}
	
	//用来得到当前用户的所有购物车商品
	public ArrayList<Cart> getCart(User user) {
		String sql = "select * from cart where userid = ?";
		String[] parameters = {Integer.toString(user.getId())};
		ArrayList<Object> al = SqlHelper.executeQuery(sql, parameters);
		ArrayList<Cart> al_cart = new ArrayList<Cart>();
		for(int i=0; i<al.size(); i++) {
			Cart cart = new Cart();
			Object[] objects = (Object[]) al.get(i);
			cart.setId(Integer.valueOf(objects[0].toString()));
			cart.setBookId(Integer.valueOf(objects[1].toString()));
			cart.setUserId(user.getId());
			cart.setBookName(objects[3].toString());
			cart.setBookImg(objects[4].toString());
			cart.setBuyNum(Integer.valueOf(objects[5].toString()));
			cart.setNum(Integer.valueOf(objects[6].toString()));
			cart.setPrice(Double.valueOf(objects[7].toString()));
			al_cart.add(cart);
		}
		return al_cart;
	}
}

package com.qzp.service;

import java.util.ArrayList;

import com.qzp.domain.Book;
import com.qzp.domain.Cart;
import com.qzp.domain.Like;
import com.qzp.utils.SqlHelper;

//处理喜欢收藏里的一些事务逻辑
public class LikeService {
	
	//用于往收藏中加入商品
	public void addLike(int userId,String bookId) {
		String userId_String = Integer.toString(userId);
		String[] parameters = {userId_String,bookId};
		String sql = "select * from collect where userid = ? and bookid = ?";
		ArrayList<Object> al = SqlHelper.executeQuery(sql, parameters);
		//判断是否已经添加过
		if(al.size() == 0) { 
			sql = "insert into collect(userid,bookid) values (?,?)";
			SqlHelper.executeUpdate(sql, parameters);
		}
	}
	//移除商品
	public void deleteLike(int userId,String bookId) {
		String userId_String = Integer.toString(userId);
		String[] parameters = {userId_String,bookId};
		String sql = "delete from collect where userid = ? and bookid = ?";
		SqlHelper.executeUpdate(sql, parameters);
	}
	
	public ArrayList<Book> getLike(int userId) {
		String userId_String = Integer.toString(userId);
		String sql = "select bookid from collect where userid = ?";
		String[] parameters = {userId_String};
		BookService bookService = new BookService();
		ArrayList<Object> objects = SqlHelper.executeQuery(sql, parameters);    //获取查询对象
		ArrayList<Like> al = new ArrayList<Like>();   //将查询对象封装到Like集合  用于收集bookid
		ArrayList<Book> bookal = new ArrayList<Book>();  //获取收藏的书的集合
		for(int i = 0; i < objects.size() ; i++) {
			Object[] object = (Object[]) objects.get(i);
			Like like = new Like();
			like.setBookId(Integer.valueOf(object[0].toString()));
			al.add(like);
		}
		for (int i = 0; i < al.size(); i++) {
			int id = al.get(i).getBookId();
			Book book = bookService.getBook(Integer.toString(id));
			bookal.add(book);
		}
		return bookal;
	}
}

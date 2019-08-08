package com.rjxy.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import com.rjxy.domain.User;
import com.rjxy.tools.SqlHelper;

public class UserService {
	public static boolean checkLogin(User user){
		String id = user.getId();
		String password = user.getPassword();
  
		try {
			String sql = "select * from users where id=? and password=?";
			String[] parameters = {id,password}; 
			ResultSet resultSet = SqlHelper.executeQuery(sql, parameters);
			if(resultSet.next()){
				return true;
			}
			else{
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			}
		return false; 
	}
	
	public static int getPageCount(){
		ResultSet resultSet = null;	
		//实现分页显示		
		int pageSize = 2;  //表示一页有几条数据
		String sql_count = "select count(*) from users";
		resultSet = SqlHelper.executeQuery(sql_count, null);	
		try {
			resultSet.next();
			int rowCount = resultSet.getInt(1);
			int pageCount = (rowCount-1) / pageSize + 1;  //表示共有多少页
			return pageCount;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;		
	}
		
	public static ArrayList pageSelect(int pageNow_a){	
		ResultSet resultSet = null;
		ArrayList<User> al = new ArrayList<User>();
		int pageSize = 2;  //表示一页有几条数据
		try {
			int pageNow = pageNow_a;
			String sql_mes = "select * from users limit "+ (pageSize*(pageNow-1)) + "," + pageSize;
			resultSet = SqlHelper.executeQuery(sql_mes, null);
			while(resultSet.next()){
				 User user = new User();
				 user.setId(resultSet.getString(1));
				 user.setUsername(resultSet.getString(2));
				 user.setEmali(resultSet.getString(3));
				 user.setGrade(resultSet.getInt(4));
				 al.add(user);
			}
			return al;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean delete(String id){
		String sql = "delete  from users where id="+id;
		System.out.println(sql);
		SqlHelper.executeUpdate(sql, null);
		return true;
	}
	public static boolean update(User user){	
		String sql = "update users set username=?,email=?,grade=?,password=? where id=?";
		String[] parameters = {user.getUsername(),user.getEmali(),Integer.toString(user.getGrade()),user.getPassword(),user.getId()};
		SqlHelper.executeUpdate(sql, parameters);
		return true;
	}
	public static boolean insert(User user){	
		String sql = "insert into users values(?,?,?,?,?) ";
		String[] parameters = {user.getId(),user.getUsername(),user.getEmali(),Integer.toString(user.getGrade()),user.getPassword(),};
		SqlHelper.executeUpdate(sql, parameters);
		return true;
	}
	public static User getUser(String id){
		String sql = "select * from users where id = " + id;
		ResultSet resultSet = SqlHelper.executeQuery(sql, null);
		User user = new User();
		try {
			while(resultSet.next()){
				user.setId(resultSet.getString(1));
				user.setUsername(resultSet.getString(2));
				user.setEmali(resultSet.getString(3));
				user.setGrade(resultSet.getInt(4));
				user.setPassword(resultSet.getString(5));
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

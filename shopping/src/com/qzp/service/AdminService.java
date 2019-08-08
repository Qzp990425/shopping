package com.qzp.service;

import java.util.ArrayList;

import com.qzp.domain.User;
import com.qzp.utils.SqlHelper;

public class AdminService {
	
	//得到所有的user对象
	public ArrayList<User> getUser(){
		String sql = "select * from user where 1 = ?";
		String[] parameters = {"1"};
		ArrayList al = SqlHelper.executeQuery(sql, parameters);
		ArrayList<User> userlist = new ArrayList<>();
		for(int i=0 ; i<al.size() ; i++) {
			Object[] objects = (Object[]) al.get(i);
			User user = new User();
			user.setId(Integer.valueOf(objects[0].toString()));
			user.setUsername(objects[1].toString());
			user.setPassword(objects[2].toString());
			user.setName(objects[3].toString());
			user.setHeadImage(objects[4].toString());
			user.setSpend(Double.valueOf(objects[5].toString()));
			userlist.add(user);
		}
		return userlist;
	}
	
	public void deleteUser(String id){
		String sql = "delete from user where id = ?";
		String[] parameters = {id};
		SqlHelper.executeUpdate(sql, parameters);
	}
}

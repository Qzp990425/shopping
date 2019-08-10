package com.qzp.service;

import java.util.ArrayList;

import com.qzp.domain.User;
import com.qzp.utils.SqlHelper;

//这里是与用户注册有关的一些处理方法
public class RegisterService {
	
	//此方法用于检测用户是否已经存在   true表示存在  false表示不存在
	public boolean checkRepeat(User user) {
		String sql = "select * from user where username = ?";
		String[] parameters = {user.getUsername()};
		ArrayList al = SqlHelper.executeQuery(sql, parameters);   //将查询的结果返回到ArrayList中
		if(al.size()!=0) {
			return true;
		} else {
			return false;
		}

	}
	
	public void addUser(User user) {
		String sql = "insert into user(username,password,name,headImage) values(?,?,?,?)";
		String[] parameters = {user.getUsername(),user.getPassword(),user.getName(),user.getHeadImage()};
		SqlHelper.executeUpdate(sql, parameters);
	}
}

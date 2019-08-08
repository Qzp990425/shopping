package com.qzp.service;

import java.util.ArrayList;

import com.qzp.domain.Admin;
import com.qzp.domain.User;
import com.qzp.utils.SqlHelper;

public class LoginService {
	//检查输入信息是否正确
	public boolean haveUser(User user) {
		String sql = "select * from user where username = ? and password = ?";
		String[] parameters = {user.getUsername(),user.getPassword()};
		ArrayList al = SqlHelper.executeQuery(sql, parameters);   //将查询的结果返回到ArrayList中
		if(al.size()!=0) {
			return true;
		} else {
			return false;
		}
	}
	
	//将登录的User信息保存完成
	public User getUser(User user) {
		String sql = "select * from user where username = ?";
		String[] parameters = {user.getUsername()};
		ArrayList al = SqlHelper.executeQuery(sql, parameters);
		Object[] objects = (Object[]) al.get(0);
		user.setId(Integer.valueOf(objects[0].toString()));
		user.setName(objects[3].toString());
		user.setHeadImage(objects[4].toString());
		user.setSpend(Double.valueOf(objects[5].toString()));
		return user;
	}
	
	public boolean haveAdmin(Admin admin) {
		String sql = "select * from admin where account = ? and password = ?";
		String[] parameters = {admin.getAccount(),admin.getPassword()};
		ArrayList al = SqlHelper.executeQuery(sql, parameters);   //将查询的结果返回到ArrayList中
		if(al.size()!=0) {
			return true;
		} else {
			return false;
		}
	}
	
	//将登录的管理员信息保存完成
	public Admin getAdmin(Admin admin) {
		String sql = "select * from admin where account = ?";
		String[] parameters = {admin.getAccount()};
		ArrayList al = SqlHelper.executeQuery(sql, parameters);
		Object[] objects = (Object[]) al.get(0);
		admin.setId(Integer.valueOf(objects[0].toString()));
		admin.setAccount(objects[1].toString());
		admin.setPassword(objects[2].toString());
		return admin;
	}
}

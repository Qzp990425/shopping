package com.qzp.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServlet;

import com.qzp.domain.User;
import com.qzp.utils.SqlHelper;

//有关更改密码的服务
public class ChangePassService extends HttpServlet{
	//检查是否有用户名或者真实姓名
	public boolean haveUser(User user) {
		String sql = "select * from user where username = ? and name = ?";
		String[] parameters = {user.getUsername(),user.getName()};
		ArrayList al = SqlHelper.executeQuery(sql, parameters);   //将查询的结果返回到ArrayList中
		if(al.size()!=0) {
			return true;
		} else {
			return false;
		}
	}
	
	//改密码
	public void changePass(User user) {
		String sql = "update user set password = ? where username = ?";
		String[] parameters = {user.getPassword(),user.getUsername()};
		SqlHelper.executeUpdate(sql, parameters);
	}
}

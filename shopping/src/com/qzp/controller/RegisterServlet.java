package com.qzp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qzp.domain.User;
import com.qzp.service.RegisterService;

//用于处理与注册相关的逻辑
public class RegisterServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		User user = new User();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String headImage = request.getParameter("headImage");
		String mess = "";   //反馈给用户信息
		if("".equals(username)||"".equals(password)||"".equals(name)||"".equals(headImage)) { //注册的时候内容不能为空
			mess = "内容不能为空";	
			System.out.println(mess);
		}else{
			RegisterService registerService = new RegisterService();
			user.setUsername(username);
			user.setPassword(password);
			user.setName(name);
			user.setHeadImage(headImage);	
			//注册的时候判断是否已经存在用户
			if(registerService.checkRepeat(user)) {
				mess = "用户已经存在";
				System.out.println(mess);
			}else {
				registerService.addUser(user);
				mess = "注册成功";
				System.out.println(user.getUsername()+mess);
			}
		}
		request.setAttribute("mess",mess);
		request.getRequestDispatcher("/register.jsp").forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}

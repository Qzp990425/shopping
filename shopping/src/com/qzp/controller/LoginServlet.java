package com.qzp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qzp.domain.User;
import com.qzp.service.LoginService;

//这部分用于处理与登录有关的逻辑
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String mess = "";
		if("".equals(username)||"".equals(password)) {
			mess = "输入的信息不能为空";
			request.setAttribute("mess", mess);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} else {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			LoginService loginService =  new LoginService();
			if(!loginService.haveUser(user)) {
				mess = "输入的账号或密码错误";
				request.setAttribute("mess", mess);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			} else {
				user = loginService.getUser(user);
				System.out.println(user.getUsername()+"已经登录");
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("/WEB-INF/jsp/myMess.jsp").forward(request, response);
			}
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}
}

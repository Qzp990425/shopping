package com.qzp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qzp.domain.Admin;
import com.qzp.domain.User;
import com.qzp.service.LoginService;

public class AdminLoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String mess = "";
		if("".equals(account)||"".equals(password)) {
			mess = "输入的信息不能为空";
			request.setAttribute("mess", mess);
			request.getRequestDispatcher("/WEB-INF/jsp/adminLogin.jsp").forward(request, response);
		} else {
			Admin admin = new Admin();
			admin.setAccount(account);
			admin.setPassword(password);
			LoginService loginService =  new LoginService();
			if(!loginService.haveAdmin(admin)) {
				mess = "输入的账号或密码错误";
				request.setAttribute("mess", mess);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			} else {
				admin = loginService.getAdmin(admin);
				request.getSession().setAttribute("admin", admin);
				request.getRequestDispatcher("/WEB-INF/jsp/admin.jsp").forward(request, response);
			}
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}
}

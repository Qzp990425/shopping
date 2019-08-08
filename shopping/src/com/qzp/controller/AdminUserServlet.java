package com.qzp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qzp.domain.User;
import com.qzp.service.AdminService;

public class AdminUserServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String userid = request.getParameter("userid");
		AdminService adminService = new AdminService();
		adminService.deleteUser(userid);
		ArrayList<User> userlist = adminService.getUser();
		request.setAttribute("userlist", userlist);
		request.getRequestDispatcher("/WEB-INF/jsp/adminUser.jsp").forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}
}


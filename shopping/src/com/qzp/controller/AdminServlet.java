package com.qzp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qzp.domain.Advice;
import com.qzp.domain.User;
import com.qzp.service.AdminService;
import com.qzp.service.AdviceService;

//管理员跳转的一些逻辑
public class AdminServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String type = request.getParameter("type");
		if("user".equals(type)) {
			AdminService adminService = new AdminService();
			ArrayList<User> userlist = adminService.getUser();
			request.setAttribute("userlist", userlist);
			request.getRequestDispatcher("/WEB-INF/jsp/adminUser.jsp").forward(request, response);
			return;
		} else if("hall".equals(type)) {
			request.getRequestDispatcher("/WEB-INF/jsp/adminHall.jsp").forward(request, response);
			return;
		} else if("advice".equals(type)) {
			AdviceService adviceService = new AdviceService();
			ArrayList<Advice> adviceList = adviceService.getAdvice();
			request.setAttribute("adviceList", adviceList);
			request.getRequestDispatcher("/WEB-INF/jsp/lookAdvice.jsp").forward(request, response);
			return;
		}	
		request.getRequestDispatcher("/WEB-INF/jsp/admin.jsp").forward(request, response);
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}
}


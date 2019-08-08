package com.rjxy.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.rjxy.domain.User;
import com.rjxy.service.UserService;

public class StudentCheckLogin extends HttpServlet{
	
	public void doPost(HttpServletRequest req,HttpServletResponse res){
		res.setContentType("text/html;charset=utf-8");
		User user = new User(req.getParameter("id"),req.getParameter("password"));
		try {
			if(UserService.checkLogin(user)){
					req.getRequestDispatcher("/Main").forward(req, res);
			}else{
				res.sendRedirect("/StudentManagement_Servlet_3/StudentLogin");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();		
		}
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res){
		this.doPost(req, res);
	}
}

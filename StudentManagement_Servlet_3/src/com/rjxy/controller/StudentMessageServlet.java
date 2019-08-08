package com.rjxy.controller;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rjxy.domain.User;
import com.rjxy.service.UserService;


public class StudentMessageServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			if("delete".equals(request.getParameter("type"))){
				if(UserService.delete(request.getParameter("id"))){
					request.getRequestDispatcher("/Ok").forward(request, response);
				}else{
					request.getRequestDispatcher("/Wrong").forward(request, response);
				}
			}else if("update".equals(request.getParameter("type"))){
				User user = new User();
				user.setId(request.getParameter("id"));
				user.setUsername((request.getParameter("username")));
				user.setEmali(request.getParameter("email"));
				user.setGrade(Integer.valueOf(request.getParameter("grade")));
				user.setPassword(request.getParameter("password"));
				if(UserService.update(user)){
					request.getRequestDispatcher("/Ok").forward(request, response);
				}else{
					request.getRequestDispatcher("/Wrong").forward(request, response);
				}
			}else if("insert".equals(request.getParameter("type"))){
				User user = new User();
				user.setId(request.getParameter("id"));
				user.setUsername((request.getParameter("username")));
				user.setEmali(request.getParameter("email"));
				user.setGrade(Integer.valueOf(request.getParameter("grade")));
				user.setPassword(request.getParameter("password"));
				if(UserService.insert(user)){
					request.getRequestDispatcher("/Ok").forward(request, response);
				}else{
					request.getRequestDispatcher("/Wrong").forward(request, response);
				}
			}else if("select".equals(request.getParameter("type"))){
				String id = request.getParameter("id");
				User user = UserService.getUser(id);
				System.out.println(id);
				if(user.getId()!=null){
					request.setAttribute("user", user);
					request.getRequestDispatcher("/StudentFind").forward(request, response);
				}else{
					request.setAttribute("error", "查无此人");
					request.getRequestDispatcher("/StudentFind").forward(request, response);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response){
		doPost(request, response);
	}
}

package com.rjxy.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Wrong extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println(request.getParameter("type")+"操作失败");
			out.println("<a href='/StudentManagement_Servlet_3/Main'>返回主界面</a>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response){
		this.doPost(request, response);
	}
}
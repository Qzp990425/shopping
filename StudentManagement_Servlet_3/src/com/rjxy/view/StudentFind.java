package com.rjxy.view;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rjxy.domain.User;
import com.rjxy.service.UserService;
import com.rjxy.tools.SqlHelper;


public class StudentFind extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/html;charset=utf-8");

		try {
			PrintWriter out = response.getWriter();
			out.println("<h1>查询用户</h1>");
			out.println("<hr />");
			out.println("<form action='/StudentManagement_Servlet_3/StudentMessageServlet?type=select' method='post'>");
			out.println("请输入你要查询的id号:<input type='text'  name='id'></td></tr>");
			out.println("</table>");
			out.println("</br><input type='submit' value='查询'>");
			out.println("</form>");
			out.println("</br><a href='/StudentManagement_Servlet_3/Main'>返回主界面</a>");
			if(request.getAttribute("user")!=null){
				User user = (User) request.getAttribute("user");
				out.println("<table bordercolor='pink' border=2px width=500px cellspacing=0><tr><th></th><th></th></tr>");
				out.println("<tr><td>id</td><td><input type='text' readonly value="+user.getId()+"></td></tr>");
				out.println("<tr><td>username</td><td><input type='text' readonly value="+user.getUsername()+"></td></tr>");
				out.println("<tr><td>Email</td><td><input type='text' readonly  value="+user.getEmali()+"></td></tr>");
				out.println("<tr><td>grade</td><td><input type='text' readonly value="+user.getGrade()+"></td></tr>");
				out.println("<tr><td>password</td><td><input type='text' readonly value="+user.getPassword()+"></td></tr>");
				out.println("</table>");
			}else if(request.getAttribute("error")!=null){
				out.println("<h1>"+request.getAttribute("error")+"</h1>");
			}else{
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
				
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response){
		this.doPost(request, response);
	}
}

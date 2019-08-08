package com.rjxy.view;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rjxy.domain.User;
import com.rjxy.service.UserService;
import com.rjxy.tools.SqlHelper;


public class StudentAdd extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/html;charset=utf-8");

		try {
			PrintWriter out = response.getWriter();
			User user = UserService.getUser(request.getParameter("id"));
			out.println("<h1>添加用户</h1>");
			out.println("<hr />");
			out.println("<form action='/StudentManagement_Servlet_3/StudentMessageServlet?type=insert' method='post'>");
			out.println("<table bordercolor='pink' border=2px width=500px cellspacing=0><tr><th></th><th></th></tr>");
			out.println("<tr><td>id</td><td><input type='text'  name='id'></td></tr>");
			out.println("<tr><td>username</td><td><input type='text' name='username'></td></tr>");
			out.println("<tr><td>Email</td><td><input type='text' name='email' ></td></tr>");
			out.println("<tr><td>grade</td><td><input type='text' name='grade' ></td></tr>");
			out.println("<tr><td>password</td><td><input type='text' name='password'></td></tr>");
			out.println("</table>");
			out.println("</br><input type='submit' value='添加'>");
			out.println("</form>");
			out.println("</br><a href='/StudentManagement_Servlet_3/Main'>返回主界面</a>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
				
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response){
		this.doPost(request, response);
	}
}

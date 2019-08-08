package com.rjxy.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

public class StudentLogin extends HttpServlet{
	
	public void doPost(HttpServletRequest req,HttpServletResponse res){
		res.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter out = res.getWriter();   //此处为PrintWriter
			out.println("<form action='/StudentManagement_Servlet_3/StudentCheckLogin' method='post'>");
			out.println("用户名<input type='text' name='id'>");
			out.println("密	码<input type='password' name='password'>");
			out.println("<input type='submit' value='提交'>");
			out.println("</form></br>");
			HttpSession session = req.getSession();
			if(session.getAttribute("error")!=null){
				out.println("<font color='red'>"+session.getAttribute("error")+"</font>");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res){
		this.doPost(req, res);
	}
}

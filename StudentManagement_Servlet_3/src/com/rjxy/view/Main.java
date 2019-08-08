package com.rjxy.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.rjxy.service.CookieService;

public class Main extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res){
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		Cookie cookie = CookieService.getCookie(req, res);
		try {
			out = res.getWriter();
			String id = req.getParameter("id");
			out.println("<h1>主界面</h1>");
			if(cookie!=null){
				out.println("上一次登录时间是"+cookie.getValue());
			}else{
				out.println("你是第一次登录");
			}
			CookieService.checkLogin(req, res);
			out.println("<hr />");
			out.println("<a href='/StudentManagement_Servlet_3/StudentManage'>用户信息</a><br>");
			out.println("<a href='/StudentManagement_Servlet_3/StudentAdd'>添加用户</a><br>");
			out.println("<a href='/StudentManagement_Servlet_3/StudentFind'>查询用户</a><br>");
			out.println("<a href='/StudentManagement_Servlet_3/StudentLogin'>返回登陆界面</a><br>");
			//out.println("<a href='/FirstEasyServlet/MyImportServlet'>盗链他</a><br>");
			out.println("<hr />");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (Exception e2) {
				// TODO: handle exception
			} finally {
				out = null;
			}
		}
		
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res){
		this.doPost(req, res);
	}
}

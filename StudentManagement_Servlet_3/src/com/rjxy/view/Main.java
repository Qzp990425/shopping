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
			out.println("<h1>������</h1>");
			if(cookie!=null){
				out.println("��һ�ε�¼ʱ����"+cookie.getValue());
			}else{
				out.println("���ǵ�һ�ε�¼");
			}
			CookieService.checkLogin(req, res);
			out.println("<hr />");
			out.println("<a href='/StudentManagement_Servlet_3/StudentManage'>�û���Ϣ</a><br>");
			out.println("<a href='/StudentManagement_Servlet_3/StudentAdd'>����û�</a><br>");
			out.println("<a href='/StudentManagement_Servlet_3/StudentFind'>��ѯ�û�</a><br>");
			out.println("<a href='/StudentManagement_Servlet_3/StudentLogin'>���ص�½����</a><br>");
			//out.println("<a href='/FirstEasyServlet/MyImportServlet'>������</a><br>");
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

package com.rjxy.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

public class CookieService extends HttpServlet{

	public static Cookie getCookie(HttpServletRequest req,HttpServletResponse resp){	
		try {
			resp.setContentType("text/html;charset=utf-8");
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Cookie[] cookies = req.getCookies();
		boolean a = false;
		if(cookies!=null){
			for(Cookie cookie:cookies){
				if(cookie.getName().equals("lastName")){
					a=true;
					cookie.setValue(new java.util.Date().toString());
					cookie.setMaxAge(3600*24);
					resp.addCookie(cookie);
					return cookie;
				}
			}
		}
		if(!a){
			Cookie cookie = new Cookie("lastName", new java.util.Date().toString());
			cookie.setMaxAge(3600*24);
			resp.addCookie(cookie);
			a=true;
			return null;
		}
		return null;
	}
	
	public static void checkLogin(HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("id");
		if(id==null){
			try {
				response.setContentType("text/html;charset=utf-8");
				request.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				HttpSession session = request.getSession();
				session.setAttribute("error", "«Îµ«¬º”√’À∫≈√‹¬Î∑√Œ ");
				request.getRequestDispatcher("/StudentLogin").forward(request, response);
				return;
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			
		}
	}
}

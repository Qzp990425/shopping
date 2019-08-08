package com.qzp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qzp.domain.Advice;
import com.qzp.domain.User;
import com.qzp.service.AdviceService;

public class AdviceServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String type = request.getParameter("type");
		if("post".equals(type)) {
			User user = (User) request.getSession().getAttribute("user");
			AdviceService adviceService = new AdviceService();
			String title = request.getParameter("title");
			String neirong = request.getParameter("neirong");
			Advice advice = new Advice();
			advice.setUserid(user.getId());
			advice.setTitle(title);
			advice.setNeirong(neirong);
			adviceService.addAdvice(advice);
			String mess = "感谢您，提交成功";
			request.setAttribute("mess", mess);
		}
		request.getRequestDispatcher("/WEB-INF/jsp/advice.jsp").forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}
}
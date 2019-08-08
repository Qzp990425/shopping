package com.qzp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qzp.domain.Book;
import com.qzp.domain.User;
import com.qzp.service.BookService;
import com.qzp.service.LikeService;

//与收藏有关的业务逻辑
public class LikeServlet  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		LikeService likeService = new LikeService();
		String operator = request.getParameter("operator");
		String id = request.getParameter("id");
		User user = (User) request.getSession().getAttribute("user");
		if("add".equals(operator)) {			
			likeService.addLike(user.getId(),id);
		} else if("delete".equals(operator)) {
			likeService.deleteLike(user.getId(),id);
		}
		ArrayList<Book> bookal = likeService.getLike(user.getId());
		request.setAttribute("likeBookList", bookal);
		request.getRequestDispatcher("/WEB-INF/jsp/like.jsp").forward(request, response);
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}
}


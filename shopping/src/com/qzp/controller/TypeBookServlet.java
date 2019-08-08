package com.qzp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qzp.domain.Book;
import com.qzp.service.BookService;

public class TypeBookServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String kind = new String(request.getParameter("kind").getBytes("iso-8859-1"),"utf-8");
		BookService bookService = new BookService();
		ArrayList<Book> bookal= bookService.getSameKindBook(kind);
		request.setAttribute("typeBookList", bookal);
		request.setAttribute("kind", kind);
		request.getRequestDispatcher("/WEB-INF/jsp/typeBook.jsp").forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}

package com.qzp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qzp.domain.Book;
import com.qzp.service.BookService;

//帮助实现一些web-inf中的跳转,以及一些数据的准备
//例如 个人信息=>购物商城    个人信息<=购物商城   购物商城=>商品详情
public class HelpGo extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String type = request.getParameter("type");
		BookService bookService = new BookService();	
		if("goHall".equals(type)) {
			//帮助跳转到商城界面		
			ArrayList<Book> normalBookList = bookService.getNormalBook();   //获取到正常出售的书籍
			ArrayList<Book> saleBookList = bookService.getSaleBook();	//获取到打折出售的书籍
			request.setAttribute("normalBookList", normalBookList);
			request.setAttribute("saleBookList", saleBookList);
			request.getRequestDispatcher("/WEB-INF/jsp/Hall.jsp").forward(request, response);
		} else if("gomyMess".equals(type)) {
			//帮助跳转到个人信息界面
			request.getRequestDispatcher("/WEB-INF/jsp/myMess.jsp").forward(request, response);
		} else if("goMore".equals(type)) {
			//用于id查找制定书籍  从而实现具体详情页跳转
			String id = request.getParameter("id");
			Book book = bookService.getBook(id);
			ArrayList<Book> sameBookList = bookService.getSameBook(book);
			request.setAttribute("book", book);
			request.setAttribute("sameBookList", sameBookList);
			//用于跳转到具体的商品信息页面
			request.getRequestDispatcher("/WEB-INF/jsp/book.jsp").forward(request, response);
		} else {
			//用于使用查询制定书籍
			String name = request.getParameter("bookname");
			Book book = bookService.getBook1(name);
			ArrayList<Book> sameBookList = new ArrayList<Book>();
			if(book!=null){
				sameBookList = bookService.getSameBook(book);
			}
			request.setAttribute("book", book);
			request.setAttribute("sameBookList", sameBookList);
			//用于跳转到具体的商品信息页面
			request.getRequestDispatcher("/WEB-INF/jsp/book.jsp").forward(request, response);
		}
 		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}
}
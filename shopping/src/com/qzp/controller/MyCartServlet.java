package com.qzp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.qzp.domain.Book;
import com.qzp.domain.Cart;
import com.qzp.domain.User;
import com.qzp.service.BookService;
import com.qzp.service.LoginService;
import com.qzp.service.MyCartService;

public class MyCartServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String operator = request.getParameter("operator"); //获取操作
		User user = (User) request.getSession().getAttribute("user");
		MyCartService myCartService = new MyCartService();
		BookService bookService = new BookService();
		ArrayList<Cart> cartlist = new ArrayList<>();  //用于存储获得的购物车
		
		if("add".equals(operator)) {  		//用于添加书及
			String id = request.getParameter("id");  //获取对应的书的id号
			Book book = bookService.getBook(id);
			myCartService.addBook(user,book);
			
		} else if("update".equals(operator)) {   //用于更新购物车书籍数量
			String[] bookId = request.getParameterValues("bookId");
			String[] buynum = request.getParameterValues("buynum");
			for(int i = 0; i<bookId.length ; i++) {
				Cart cart = new Cart();  //设置刚才得到的对象
				cart.setBookId(Integer.valueOf(bookId[i]));
				cart.setBuyNum(Integer.valueOf(buynum[i]));
				myCartService.updateCart(cart,user);
			}
		} else if("delete".equals(operator)) { //用于删除制定的书籍
			String bookId = request.getParameter("bookid");
			myCartService.deleteBook(user,bookId);
		} else if("submit".equals(operator)) { //用于提交订单
			String total = request.getParameter("total");
			//提交订单
			myCartService.submitCart(user,total);
			cartlist = myCartService.getCart(user);
			//更新书的数量以及剩余数量
			String[] bookId = request.getParameterValues("bookId");
			String[] buynum = request.getParameterValues("buynum");
			for(int i = 0; i<bookId.length ; i++) {
				Book book = bookService.getBook(bookId[i]);
				//更新书的数量
				bookService.updateBook(book,buynum[i]);					
			}		
			cartlist = myCartService.getCart(user);
			request.setAttribute("cart", cartlist);
			//清空购物车	
			myCartService.deleteCart(user);		
			//更新用户消费情况  
			User user_new = myCartService.updateUser(user,total);
			request.getSession().setAttribute("user", user_new);
			request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);
			return;
		}
		cartlist = myCartService.getCart(user);
		request.setAttribute("cart", cartlist);
		request.getRequestDispatcher("/WEB-INF/jsp/myCart.jsp").forward(request, response);
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}
}

package com.qzp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qzp.domain.Book;
import com.qzp.domain.PageBean;
import com.qzp.service.BookService;


public class AdminBookServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String type = request.getParameter("type");
		BookService bookService = new BookService();
		if("insert".equals(type)) {
			//添加
			if(request.getParameter("name")!=null) {
				Book book = new Book();
				book.setImg(request.getParameter("img"));
				book.setKind(request.getParameter("kind"));
				book.setLink(request.getParameter("link"));
				book.setName(request.getParameter("name"));
				book.setNum(Integer.valueOf(request.getParameter("num")));
				book.setNowPirce(Double.valueOf(request.getParameter("nowprice")));
				book.setPrice(Double.valueOf(request.getParameter("price")));
				book.setStatus(request.getParameter("status"));
				bookService.addBook(book);
				String mess = "添加成功";
				request.setAttribute("mess", mess);
			}
			request.getRequestDispatcher("/WEB-INF/jsp/adminAddBook.jsp").forward(request, response);
			return;
		} else if("update".equals(type)) {		
			//修改
			if(request.getParameter("name")!=null){
				Book book = new Book();
				book.setId(Integer.valueOf(request.getParameter("id")));
				book.setImg(request.getParameter("img"));
				book.setKind(request.getParameter("kind"));
				book.setLink(request.getParameter("link"));
				book.setName(request.getParameter("name"));
				book.setNum(Integer.valueOf(request.getParameter("num")));
				book.setNowPirce(Double.valueOf(request.getParameter("nowprice")));
				book.setPrice(Double.valueOf(request.getParameter("price")));
				book.setStatus(request.getParameter("status"));
				bookService.updateBook(book);
				String mess = "更新成功";
				request.setAttribute("mess", mess);
			}
			String id = request.getParameter("id");
			Book book = bookService.getBook(id);
			request.setAttribute("book", book);
			request.getRequestDispatcher("/WEB-INF/jsp/adminUpdateBook.jsp").forward(request, response);
			return;
		} else if("delete".equals(type)){
			//删除
			String id = request.getParameter("id");
			bookService.deleteBook(id);
		}
		/* -----------------------------切换成分页
		 * ArrayList<Book> bookal = bookService.getAllBook();
		 * -------------------------------------*/
		PageBean pageBean = new PageBean();
		ArrayList<Book> bookal = new ArrayList<Book>();
		if(request.getParameter("pageNow")==null) {
			pageBean.setPageNow(1);
			pageBean.setRowCount(bookService.getAllBook().size());
			pageBean.setPageSize(3);
			pageBean.setPageCount((pageBean.getRowCount()-1)/pageBean.getPageSize()+1);
			bookal = bookService.getPageBook(pageBean); 
		} else {
			pageBean.setPageNow(Integer.valueOf(request.getParameter("pageNow")));
			pageBean.setRowCount(bookService.getAllBook().size());
			pageBean.setPageSize(3);
			pageBean.setPageCount((pageBean.getRowCount()-1)/pageBean.getPageSize()+1);
			bookal = bookService.getPageBook(pageBean); 
		}
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("booklist", bookal);
		request.getRequestDispatcher("/WEB-INF/jsp/adminBook.jsp").forward(request, response);
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}
}

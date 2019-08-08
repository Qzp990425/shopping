package com.qzp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qzp.domain.User;
import com.qzp.service.ChangePassService;

//用于处理与更改密码相关的逻辑
public class ChangePassServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String new_password = request.getParameter("password");
		String name = request.getParameter("name");
		String mess = "";
		//判断提交信息是否为空
		if("".equals(username)||"".equals(new_password)||"".equals(name)) {
			mess = "信息不能为空";
		} else {
			User user = new User();
			user.setUsername(username);
			user.setPassword(new_password);
			user.setName(name);
			ChangePassService changePassService = new ChangePassService();
			if(!changePassService.haveUser(user)) {
				mess = "输入的信息有误";
			} else {
				changePassService.changePass(user);
				mess = "修改成功";
			}
		}
		request.setAttribute("mess", mess);
		request.getRequestDispatcher("/changePass.jsp").forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}
}

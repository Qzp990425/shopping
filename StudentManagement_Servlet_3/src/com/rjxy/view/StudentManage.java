package com.rjxy.view;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rjxy.domain.User;
import com.rjxy.service.UserService;


public class StudentManage extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/html;charset=utf-8");

		try {
			PrintWriter out = response.getWriter();
			int pageNow = 1;
			if(request.getParameter("pageNow")!=null){
				pageNow = Integer.valueOf(request.getParameter("pageNow"));
			}
			//此处嵌入javaScript
			out.println("<script type='text/javascript' language='javascript' >");
			out.println("function toPage(){ var pageNow = document.getElementById('page').value;"
					+ "window.location = '/StudentManagement_Servlet_3/StudentManage?pageNow='+pageNow;}");
			out.println("</script>");
			
			out.println("<h1>用户管理</h1>");
			out.println("<hr />");
			
			int pageCount = UserService.getPageCount();
			out.println(pageNow);
			ArrayList<User> user = UserService.pageSelect(pageNow);
			out.println(user.size());
			out.println("<table bordercolor='pink' border=2px width=500px cellspacing=0><tr><th>id</th><th>username</th><th>email</th><th>grade</th><th>修改</th><th>删除</th></tr>");
			for(User u:user){
				out.println("<tr><td>"+u.getId()+"</td><td>"+u.getUsername()+"</td><td>"+u.getEmali()+"</td><td>"+u.getGrade()+"</td>"
						+ "<td><a href='/StudentManagement_Servlet_3/UpdateStudentView?id="+u.getId()+"'>修改</a></td>"
								+ "<td><a href='/StudentManagement_Servlet_3/StudentMessageServlet?id="+u.getId()+"&type=delete'>删除</a></td></tr>");
			}
			out.println("</table>");
			if(pageNow!=1){
				out.println("<a href='/StudentManagement_Servlet_3/StudentManage?pageNow="+(pageNow-1)+"'>上一页</a>");
			}
			for(int i = 1;i <=pageCount;i++){
				out.println("<a href='/StudentManagement_Servlet_3/StudentManage?pageNow="+i+"'><"+i+"></a>");
			}
			if(pageNow!=pageCount){
				out.println("<a href='/StudentManagement_Servlet_3/StudentManage?pageNow="+(pageNow+1)+"'>下一页</a>");
			}
			out.println("<br> 请说明你要跳转到哪一页:<input type='text' id='page'>  <input type='button' value='转向' onClick='toPage()'>");
			out.println("</br><a href='/StudentManagement_Servlet_3/Main'>返回主界面</a>");
			out.println("<hr />");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
				
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response){
		this.doPost(request, response);
	}
}

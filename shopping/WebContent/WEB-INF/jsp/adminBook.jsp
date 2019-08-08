<%@page import="java.util.ArrayList"%>
<%@page import="com.qzp.domain.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html  lang="zh-cn">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="css/comm.css">
	<link rel="stylesheet" href="css/myCart.css">
	<title>购物车</title>
	<link rel="stylesheet" href="jsplib/css/bootstrap.min.css">
</head>
<body>
	<!-- 头部 -->					
		<div id="sp-header-top">
			<!-- 最上部分 -->
			<div class="container">
				<div class="top-bar clearfix">
					<ul>
						<li class="active">
								<%
									Admin admin = (Admin)session.getAttribute("admin");
								%>
								<%= admin.getAccount()%>
						</li>
					</ul>
				</div>
			</div>	
		</div>
		<!-- 中间部分横线 -->
		<div id="sp-herder-mid"></div>
		<div class="container">
			 <div class="table-responsive m-t">
			 	<form id="cartform" action="#" method="post">
					<table class="table invoice-table">
						<thead>
							<tr>
								<th>ID号</th>
								<th>商品</th>
								<th>种类</th>
								<th>剩余数量</th>
								<th>当前状态</th>								
								<th>原价</th>
								<th>现价</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<% 	
								ArrayList<Book> bookal =(ArrayList<Book>) request.getAttribute("booklist");
								for(int i = 0 ; i<bookal.size()  ; i++) {
									Book book = bookal.get(i);
							%>
							<tr>
								<td><%=book.getId() %></td>
								<td>
									<div>
										<input type="hidden" name="bookId" value=<%= book.getId() %>>
										<img src=<%= book.getImg() %> style="width:100px"><strong><%= book.getName() %></strong>
									</div>
								</td>
								<td><%=book.getKind() %></td>
								<td><%=book.getNum() %></td>
								<td><%
										if("0".equals(book.getStatus())){
											out.println("不打折");
										}
										else{
											out.println("打折");
										}
									%>
								</td>
								<td><%= book.getPrice() %></td>
								<td><%= book.getNowPirce() %></td>								
								<td class="clearfix"><a  class="btn btn-primary" href='/shopping/AdminBookServlet?type=delete&id=<%=book.getId() %>'>删除商品</a><br>
								<a class="btn btn-primary" href='/shopping/AdminBookServlet?type=update&id=<%=book.getId() %>'>修改商品</a></td>
							</tr>
							<%	
								}
							%>
							
							<% PageBean pageBean = (PageBean)request.getAttribute("pageBean");%>
							<tr class="text-center">
								<td colspan="8">
								<%
									if(pageBean.getPageNow()-1 > 0){
								%>
								<a href="/shopping/AdminBookServlet?pageNow=<%=pageBean.getPageNow()-1 %>">上一页</a>
									<% 
									}
										for(int i=1; i<=pageBean.getPageCount() ; i++) {				
											if(pageBean.getPageNow()==i){
									%>	
											<a class="text-danger" href="/shopping/AdminBookServlet?pageNow=<%=i %>"><%=i %></a>
									<%		
											} else {
									%>
											<a href="/shopping/AdminBookServlet?pageNow=<%=i %>"><%=i %></a>
									<% 			
											}
										}
									%>
								<%
									if(pageBean.getPageNow()+1 <= pageBean.getPageCount()){
								%>
								<a href="/shopping/AdminBookServlet?pageNow=<%=pageBean.getPageNow()+1 %>">下一页</a>
								<%
									}
								%>
								</td>
							</tr>
							<tr >
								<td colspan="8"><a href="/shopping/AdminBookServlet?type=insert">添加商品.......</a></td>
							</tr>
							<tr>
								<td></td><td></td><td></td><td></td><td></td><td></td><td></td>
								<td><a href="/shopping/AdminServlet" class="btn btn-primary">返回主界面</a></td>
							</tr>										
						</tbody>
					</table>
				</form>
			</div>
		</div>
		<!-- 底部 -->
		<footer id="sp-footer">
			<div class="text text-center p-4 text-primary">
				<p>制作于2019/8/3的一个神奇网页</p>
				<p>Copyright © 2015.Company name All rights reserved.</p>
			</div>
		</footer>
</body>
	<script src="jsplib/js/jquery-3.4.1.min.js"></script>
    <script src="jsplib/js/popper.min.js"></script>
    <script src="jsplib/js/bootstrap.min.js" ></script>
    <script src="js/myCart.js" ></script> 
</html>
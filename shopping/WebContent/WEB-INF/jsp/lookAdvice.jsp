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
	<link rel="stylesheet" href="css/lookAdvice.css">
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
		
		<div class="text-center mt-3 mb-3"  >
				<h2><strong>用户意见</strong></h2>
				<img src="img/star.png" />
		</div>
		
		<div class="container clearfix">
			 <div class="table-responsive m-t">
				<table>
					<tr><th>id</th><th>用户id</th><th>发送时间</th><th>标题</th><th>内容</th></tr>				
				<% ArrayList<Advice> adviceList = (ArrayList<Advice>)request.getAttribute("adviceList"); 
					for(int i=0;i<adviceList.size();i++) {
						Advice advice = adviceList.get(i);
				%>
					<tr><td><%= advice.getId() %></td><td><%= advice.getUserid() %></td><td><%= advice.getDate() %></td><td><%= advice.getTitle() %></td><td><%= advice.getNeirong() %></td></tr>
				<%
					}
				%>
				</table>
			</div>
			<a href="/shopping/AdminServlet" class="btn btn-primary mb-4 mt-4" style="float:right">返回主界面</a>	
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
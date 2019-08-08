<%@page import="com.qzp.domain.*,java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html lang="zh-cn">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="css/comm.css">
	<link rel="stylesheet" href="css/adminUser.css">
	<title>管理用户</title>   
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
									ArrayList<User> userlist = (ArrayList<User>)request.getAttribute("userlist");
								%>
								<%= admin.getAccount() %>
						</li>   
					</ul>
				</div>
			</div>	
		</div>
		<!-- 中间部分横线 -->
		<div id="sp-herder-mid"></div>
		
		<div class="text-center mt-3 mb-3"  >
				<h2><strong>管理用户</strong></h2>
				<img src="img/star.png" />
		</div>
		
		<!-- 用户部分 -->
		<div class="main">
			<div class="container text-center clearfix">
				<table class="infor table table-hover ">
					<tr><th>id</th><th>用户名</th><th>真实姓名</th><th>头像</th><th>花销</th><th>操作</th></tr>
					<%
					for(int i = 0; i < userlist.size() ; i++) {
						User user = userlist.get(i);
					%>
						<tr>
							<td><%=user.getId() %></td>
							<td><%=user.getUsername()%></td>
							<td><%=user.getName()%></td>
							<td><%=user.getHeadImage()%></td>
							<td><%=user.getSpend()%></td>
							<td><a href="/shopping/AdminUserServlet?userid=<%=user.getId() %>">封停用户</a></td>
						</tr>
					<%
					}
					%>
				</table>	
				<a href="/shopping/AdminServlet" class="btn btn-primary mb-4 mt-4" style="float:right">返回主界面</a>						
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
</html>
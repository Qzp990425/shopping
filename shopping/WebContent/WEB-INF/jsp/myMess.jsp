<%@ page import="com.qzp.domain.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 
个人信息首页:主要用来显示个人信息,以及一直以来的消费情况。					
 -->
<html  lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="jsplib/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/comm.css">
	<link rel="stylesheet" href="css/myMess.css">
</head>
<body>
	<%
		User user = (User)session.getAttribute("user");
	%>
	<div class="container-fluid" id="sp-main">
		<div class="row align-items-center">  
			<!-- 登录框 -->
			<div class="offset-1 col-xs-10 offset-sm-2 col-sm-8 offset-md-3 col-md-6 offset-lg-4 col-lg-4 rounded-lg" id="sp-index">
				<div class="text-center mt-3">
					<h2><strong>个人信息</strong></h2>
					<img src="img/star.png" />
				</div>
				<div class="mb-4 mt-4 text-center">
					<p>头像：<%=user.getHeadImage()%><p>
				</div>
				<div class="mb-4 mt-4 text-center">
					<p>用户名：<%=user.getUsername() %><p>
				</div>				
				<div class="mb-4 mt-4 text-center">
					<p>消费情况：&yen;<%=user.getSpend()%><p>
				</div>
				<!-- 底部两个超链接 -->
				<div id="sp-useradmin">
					<div><button id="Goshopping" class="row justify-content-end no-gutters btn btn-primary">开始购物</button></div>
				</div>
			</div>
		</div>
	</div>
</body>
	<script src="jsplib/js/jquery-3.4.1.min.js"></script>
    <script src="jsplib/js/popper.min.js"></script>
    <script src="jsplib/js/bootstrap.min.js" ></script>
	<script src="js/myMess.js"></script>
</html>
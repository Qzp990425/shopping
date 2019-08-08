<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 登录首页 -->
<html lang="zh-cn">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" href="jsplib/css/bootstrap.min.css">
		<link rel="stylesheet" href="css/comm.css">
		<link rel="stylesheet" href="css/admin.css">
		<title>管理员登录界面</title>   
	</head>
	<body>
		<div class="container-fluid" id="sp-main">
			<div class="row align-items-center">  
				<!-- 登录框 -->
				<div class="offset-1 col-xs-10 offset-sm-2 col-sm-8 offset-md-3 col-md-6 offset-lg-4 col-lg-4 rounded-lg" id="sp-index">
					<div class="text-center mt-3">
						<h2 class="text-danger"><strong>选择操作</strong></h2>
						<img src="img/star.png" />
					</div>
					<div class="text-center mybtn-group">
						<a href="/shopping/AdminServlet?type=user" class="btn btn-primary" >用户管理</a><br>
						<a href="/shopping/AdminServlet?type=hall" class="btn btn-primary" >商场管理</a><br>
						<a href="/shopping/AdminServlet?type=advice" class="btn btn-primary"  >建议管理</a>
					</div>
				</div>
			</div>
		</div>
	</body>
    <script src="jsplib/js/jquery-3.4.1.min.js"></script>
    <script src="jsplib/js/popper.min.js"></script>
    <script src="jsplib/js/bootstrap.min.js" ></script>  
</html>
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
		<link rel="stylesheet" href="css/login.css">
		<title>管理员登录界面</title>   
	</head>
	<body>
		<div class="container-fluid" id="sp-main">
			<div class="row align-items-center">  
				<!-- 登录框 -->
				<div class="offset-1 col-xs-10 offset-sm-2 col-sm-8 offset-md-3 col-md-6 offset-lg-4 col-lg-4 rounded-lg" id="sp-index">
					<div class="text-center mt-3">
						<h2 class="text-danger"><strong>管理员登录</strong></h2>
						<img src="img/star.png" />
					</div>
					<form action="/shopping/AdminLoginServlet" method="post">
						<!-- 用户名 -->
						<div class="input-group mb-2 mt-3">
							<div class="input-group-prepend">
								<span class="input-group-text" id="basic-addon1">用户名</span>
							</div>
							<input type="text" name="account" id="account" class="form-control" placeholder="account" aria-label="account" aria-describedby="basic-addon1">
						</div>
						<!-- 密码 -->
						<div class="input-group mb-2 mt-4">
							<div class="input-group-prepend">
								<span class="input-group-text" id="basic-addon1">密&nbsp;&nbsp;&nbsp;码</span>
							</div>
							<input id="password" name="password" type="password" class="form-control" placeholder="password" aria-label="password" aria-describedby="basic-addon1">
						</div>	
						<!-- 按钮 -->
						<div class="row justify-content-between mt-4 no-gutters" id="botton-class">
							 <div class="col-8 text-danger" id="mess">
      							<% 
      								/* 用于获取验证信息 */
      								String mess = (String)request.getAttribute("mess");
      								if(mess!=null){
      									out.println(mess);
      								}
      							%>
    						</div>
							<div class="col-2.5">
								<button id="login" type="submit" class="btn btn-primary">登录</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>
    <script src="jsplib/js/jquery-3.4.1.min.js"></script>
    <script src="jsplib/js/popper.min.js"></script>
    <script src="jsplib/js/bootstrap.min.js" ></script>  
</html>
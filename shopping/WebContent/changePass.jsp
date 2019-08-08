<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 重置密码首页 -->
<html lang="zh-cn">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" href="jsplib/css/bootstrap.min.css">
		<link rel="stylesheet" href="css/comm.css">
		<link rel="stylesheet" href="css/changePass.css">
		<title>重置密码界面</title>   
	</head>
	<body>
		<div class="container-fluid" id="sp-main">
			<div class="row align-items-center">  
				<!-- 重置密码框 -->
				<div class="offset-1 col-xs-10 offset-sm-2 col-sm-8 offset-md-3 col-md-6 offset-lg-4 col-lg-4 rounded-lg" id="sp-change">
					<div class="text-center mt-3">
						<h2><strong>重置密码</strong></h2>
						<img src="img/star.png" />
					</div>
					<form action="/shopping/ChangePassServlet" method="post">
						<!-- 用户名 -->
						<div class="input-group mb-2 mt-3">
							<div class="input-group-prepend">
								<span class="input-group-text" id="basic-addon1">用户名</span>
							</div>
							<input type="text" id="username" name="username" class="form-control" placeholder="username" aria-label="username" aria-describedby="basic-addon1">
						</div>
						<!-- 新密码 -->
						<div class="input-group mb-2 mt-4">
							<div class="input-group-prepend">
								<span class="input-group-text" id="basic-addon1">新密码</span>
							</div>
							<input id="password" type="password" name="password" class="form-control" placeholder="password" aria-label="password" aria-describedby="basic-addon1">
						</div>	
						<!-- 校验真实姓名 -->
						<div class="input-group mb-2 mt-4">
							<div class="input-group-prepend">
								<span class="input-group-text" id="basitextc-addon1">真实姓名</span>
							</div>
							<input id="name" type="text" name="name" class="form-control" placeholder="真实姓名" aria-label="name" aria-describedby="basic-addon1">
						</div>	
						<div class="row justify-content-between mt-4 no-gutters" id="botton-class">
							 <div class="col-5  text-danger" id="mess">
      							<% 
      								/* 用于获取验证信息 */
      								String mess = (String)request.getAttribute("mess");
      								if(mess!=null){
      									out.println(mess);
      								}
      							%>
    						</div>
							<div class="col-2.5">
								<button type="submit" class="btn btn-primary">提交重置</button>
							</div>
						</div>
					</form>
					<!-- 底部两个超链接 -->
					<div id="sp-useradmin">
						<div class="row justify-content-end no-gutters"><a href="/shopping/login.jsp">返回登录页面</a></div>
						<div class="row justify-content-end no-gutters"><a href="/shopping/register.jsp">注册页面</a></div>
					</div>
				</div>
			</div>
		</div>
	</body>
    <script src="jsplib/js/jquery-3.4.1.min.js"></script>
    <script src="jsplib/js/popper.min.js"></script>
    <script src="jsplib/js/bootstrap.min.js" ></script> 
</html>

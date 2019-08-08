<%@ page import="com.qzp.domain.*,java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" href="css/comm.css">
		<link rel="stylesheet" href="css/Hall.css">
		<link rel="stylesheet" href="jsplib/css/bootstrap.min.css">
		<title>添加书</title>   
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
		
		<div class="text-center mt-3 mb-3">
				<h2><strong>修改书籍</strong></h2>
				<img src="img/star.png" />
		</div>
		<!-- 主要部分 -->
		<div class="container clearfix" style="border-top:2px solid #e0e0e0">
			
			<%
				Book book = (Book)request.getAttribute("book");
			%>
		<form action="/shopping/AdminBookServlet" method="post">
			<input type="hidden" value="update" name="type">
			<input type="hidden" value=<%=book.getId()%> name="id">
		  <div class="form-row">
			<div class="form-group col-md-6">
			  <label for="inputName">书名</label>
			  <input class="form-control" type="text" placeholder="书名" name="name" value=<%=book.getName() %> >
			</div>
			<div class="form-group col-md-6">
			 <label for="inputName">书图片(形式:img/xxx.jpg)</label>
			 <input class="form-control" type="text" placeholder="图片名称" name="img" value=<%=book.getImg() %>>
			</div>
		  </div>
		  <div class="form-row">
		  	<div class="form-group col-md-12">
			  <label for="inputName">书的链接</label>
			  <input class="form-control" type="text"  name="link" value=<%=book.getLink() %>>
			</div>
		  </div>
		  <div class="form-row">
			  <div class="form-group col-md-6">
				  <label for="type">书的类型</label>	
				  <input type="hidden" value=<%=book.getKind() %> id="Kind">
				  <select class="form-control" name="kind" id="selectKind">
				  	<option value="抒情">抒情</option>
				  	<option value="鸡汤">鸡汤</option>
				  	<option value="散文">散文</option>
				  	<option value="小说">小说</option>
				  </select>
			  </div>
			  <div class="form-group col-md-6">
					<label for="type">库存</label>	
					<input class="form-control" type="text" placeholder="库存" name="num" value=<%=book.getNum() %>>
			</div>
		</div>
		  <div class="form-row">
			<div class="form-group col-xs-12 col-md-4 ">
			  <label for="inputName">状态</label>
			   <input type="hidden" value=<%=book.getStatus()  %> id="Status">
				<select class="form-control" name="status" id="selectStatus">
					<option value="0">正常</option>
					<option value="1">打折</option>		
				</select>
			</div>
			<div class="form-group col-xs-6 col-md-4" >
				  <label for="price">原价</label>
				  <input class="form-control" type="text" placeholder="原价" name="price" value=<%=book.getPrice() %>>
			</div>
			<div class="form-group col-xs-6 col-md-4">
				 <label for="price">现价</label>
				<input class="form-control" type="text" placeholder="现价" name="nowprice" value=<%=book.getNowPirce() %>>
			</div>
		  </div>
		  <button type="submit" class="btn btn-primary" style="float:right;">更新</button>
		</form>
		<a href="/shopping/AdminServlet" class="btn btn-primary mr-2" style="float:right">返回主界面</a>	
		 <% if(request.getAttribute("mess")!=null){
		  
		  %> <p class="text-danger" style="float:right;display:block"><%=request.getAttribute("mess") %></p>
		  <%
		   }
		  %>
	</div>
		
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
    <script src="js/adminUpdateBook.js" ></script>
</html>
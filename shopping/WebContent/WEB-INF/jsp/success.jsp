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
							<a href="/shopping/HelpGo?type=gomyMess">  <!-- 这里显示个人信息  同时超链接到个人信息界面-->
								<%
									User user = (User)session.getAttribute("user");
								%>
								<%= user.getUsername() %>
							</a>
						</li>
					</ul>
				</div>
			</div>	
		</div>
		<!-- 中间部分横线 -->
		<div id="sp-herder-mid"></div>
		<!-- 下半部分 -->
		<div id="sp-header-foot">
			<div class="container">
				<nav class="navbar navbar-expand-lg navbar-light">
					<a class="navbar-brand" href="/shopping/HelpGo?type=goHall">   
						<img src="img/bootstrap-solid.svg" width="30" height="30" class="d-inline-block align-top" alt="">
							<span class="text-primary">那么多书</span>
					</a>
					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#sp-list" aria-controls="sp-list" aria-expanded="false" aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>

					<div class="collapse navbar-collapse" id="sp-list">
						<ul class="navbar-nav mr-auto">
							<li class="nav-item active">
								<a class="nav-link mr-1" href="/shopping/HelpGo?type=goHall">主页<span class="sr-only">(current)</span></a>   <!--连接到主页-->
							</li>
							<li class="nav-item dropdown">
								<a class="nav-link dropdown-toggle mr-1" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								书籍分类
								</a>   
								<div class="dropdown-menu" aria-labelledby="navbarDropdown">
									<a class="dropdown-item" href="/shopping/TypeBookServlet?kind=散文">散文</a>
									<a class="dropdown-item" href="/shopping/TypeBookServlet?kind=小说">小说</a>
									<a class="dropdown-item" href="/shopping/TypeBookServlet?kind=育儿">育儿</a>
									<a class="dropdown-item" href="/shopping/TypeBookServlet?kind=鸡汤">鸡汤</a>
								</div>
							</li>
							<li class="nav-item">
								<a class="nav-link mr-1" href="#">入驻卖书</a>
							</li>
							<li class="nav-item">
								<a class="nav-link mr-1" href="/shopping/AdviceServlet">给我们提建议</a>
							</li>
						</ul>	
					</div>
					<form action="/shopping/HelpGo" method="post" class="form-inline my-2 my-lg-0 d-none d-sm-none d-md-none d-lg-flex">
						<div class="input-group">
							<input name="bookname" type="text" class="form-control" placeholder="输入你想查找的书籍" aria-label="输入你想查找的书籍" aria-describedby="basic-addon2">
							<div class="input-group-append">
							<button class="btn btn-outline-secondary" type="submit">查找</button>
							</div>
						</div>
						<a class="active-icon" href="/shopping/LikeServlet">💗</a>
						<a class="active-icon c1" href="/shopping/MyCartServlet"></a> <!--连接到购物车-->
					</form>
				</nav>
			</div>
		</div>
		
		<!-- 购物清单 -->
		<div class="container">
			 <div class="table-responsive m-t">
			 	<form action="/shopping/MyCartServlet" method="post">
			 		<h2 class="text-center mb-4">支付完成  您的订单如下</h2>
					<table class="table invoice-table">
						<thead>
							<tr>
								<th>商品</th>
								<th>购买数量</th>
								<th>单价</th>
								<th>总价</th>
							</tr>
						</thead>
						<tbody>
							<% 	
								ArrayList<Cart> cartlist = (ArrayList<Cart>)request.getAttribute("cart");
								Double total = 0.0;
								for(int i = 0 ; i<cartlist.size()  ; i++) {
									Cart cart = cartlist.get(i);
							%>
							<tr>
								<td>
									<div>
										<input type="hidden" name="bookId" value=<%= cart.getBookId() %>>
										<img src=<%= cart.getBookImg() %> style="width:100px"><strong><%= cart.getBookName() %></strong>
									</div>
								</td>
								<td>
									<%= cart.getBuyNum()%>
								</td>
								<td><%= cart.getPrice() %></td>
								<td><%= cart.getBuyNum()*cart.getPrice() %></td>								
							</tr>
							<%	
								total += cart.getBuyNum()*cart.getPrice() ;
								}
							%>
							<tr>
								<td><strong>总计</strong></td><td></td><td></td>
								<td>&yen;<%=total %></td>
							</tr>
							<tr>
								<td></td><td></td><td></td>
								<td><a class="btn btn-primary" href="/shopping/HelpGo?type=goHall">返回主页</a></td>
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
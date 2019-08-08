<%@page import="java.util.ArrayList"%>
<%@ page import="com.qzp.domain.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
	同一类型书籍	
 -->
<html  lang="zh-cn">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="css/comm.css">
	<link rel="stylesheet" href="css/Hall.css">
	<title>商城</title>   
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
					<a class="navbar-brand" href="/shopping/HelpGo?type=goHall">   <!--连接到主页-->
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
		<!-- 轮播图 显示热门商品 -->
		<section id="sp_carousel" class="carousel slide" data-ride="carousel">
			  <ol class="carousel-indicators">
				<li data-target="#sp_carousel" data-slide-to="0" class="active"></li>
				<li data-target="#sp_carousel" data-slide-to="1"></li>
				<li data-target="#sp_carousel" data-slide-to="2"></li>
			  </ol>
			  <div class="carousel-inner">
				<div class="carousel-item active" data-sm-img="img/sm-1.jpg" data-lg-img="img/bg-1.jpg"></div>
				<div class="carousel-item" data-sm-img="img/sm-2.jpg" data-lg-img="img/bg-2.jpg"></div>
				<div class="carousel-item" data-sm-img="img/sm-3.jpg" data-lg-img="img/bg-3.jpg"></div>
			  </div>
			  <a class="carousel-control-prev" href="#sp_carousel" role="button" data-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			  </a>
			  <a class="carousel-control-next" href="#sp_carousel" role="button" data-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			  </a>
		</section>
		
		<!-- 正常书籍专区 -->
		<section id="sp-normalBook">
			<!-- 标题 -->
			<div class="text-center mt-3 mb-3">
				<h2><strong><%=request.getAttribute("kind") %>专区</strong></h2>
				<img src="img/star.png" />
			</div>
			<% 
				ArrayList<Book> typeBookList = (ArrayList<Book>)request.getAttribute("typeBookList");
			%>
			<div class="container">
				<div class="row">
					<%
						for(int i = 0; i < typeBookList.size() ; i++) {
							Book book = typeBookList.get(i);
					%>
					<div class="col-xs-12 col-sm-6 col-lg-3">
						<div class="card align-items-center  bg-light p-2">
							<div class="mb-1">
								<a href=<%= book.getLink() %> target="_blank"><img src=<%= book.getImg() %> alt="" class="card-img-top media-boject rounded img-thumbnail" /></a>			
							</div>
							<div class="card-body">
								<h5 class="card-title text-center"><a href=<%= book.getLink() %> target="_blank"><%= book.getName() %></a></h5>
								<p class="card-text text-center"><%= book.getPrice() %>元</p>
								<a class="active-icon" href="/shopping/LikeServlet?operator=add&id=<%=book.getId() %>">💗&nbsp;</a> <!--收藏-->
								<a href="/shopping/HelpGo?type=goMore&id=<%=book.getId() %>" class="btn btn-primary">查看详情</a>
							</div>
						</div>
					</div>
					<%
						}
					%>
				</div>
			</div>
		</section>
	
		
		<!-- 其他购物网站 -->
		<div class="sp-other d-none d-md-none d-lg-block">
			<!-- 标题 -->
			<div class="text-center mt-5 mb-5">
				<h2><strong>其他购物网址</strong></h2>
				<img src="img/star.png" />
			</div>
			<!-- 其他网站 -->
			<div class="container mb-5">
				<!-- 主轴伸缩对齐  侧轴两侧居中 -->
				<div class="row d-flex justify-content-around align-items-center">
					<a href=""><img src="img/logo1.jpg" width="200" alt=""></a>
					<a href=""><img src="img/logo2.jpg" width="100" alt=""></a>
					<a href=""><img src="img/logo3.jpg" width="200" alt=""></a>
					<a href=""><img src="img/logo4.jpg" width="100" alt=""></a>
					<a href=""><img src="img/logo5.jpg" width="100" alt=""></a>
					<a href=""><img src="img/logo6.jpg" width="100" alt=""></a>    <!-- 此处链接到自己的一个小网页 -->
				</div>
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
    <script src="js/Hall.js"></script>
</html>
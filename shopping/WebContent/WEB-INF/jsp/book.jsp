<%@page import="java.util.ArrayList"%>
<%@page import="com.qzp.domain.*"%>
<%@ page errorPage="Error.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 具体书籍 -->
<html  lang="zh-cn">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="css/comm.css">
	<link rel="stylesheet" href="css/book.css">
	<link rel="stylesheet" href="jsplib/css/bootstrap.min.css">
	<title>书</title>
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
							<input type="text" class="form-control" placeholder="输入你想查找的书籍" aria-label="输入你想查找的书籍" aria-describedby="basic-addon2">
							<div class="input-group-append">
							<button class="btn btn-outline-secondary" type="button">查找</button>
							</div>
						</div>
						<a class="active-icon" href="/shopping/LikeServlet">💗</a>
						<a class="active-icon c1" href="/shopping/MyCartServlet"></a> <!--连接到购物车-->
					</form>
				</nav>
			</div>
		</div>
		
		<!-- 书的详情 -->
		<div class="book">
			<!-- 得到刚才查询的书籍 -->
			<% 
				Book book =	(Book) request.getAttribute("book");
			%>
			<div class="container">
				<div class="media">
					<img class="mr-3" src=<%= book.getImg() %> alt="Generic placeholder image">
					<div class="media-body">
						<h5 class="mt-0 ">书名：<%=book.getName() %></h5>
						<h5 class="mt-0 ">单价：<%=book.getNowPirce() %></h5>
						<h5 class="mt-0 ">剩余数量：<%=book.getNum() %></h5>
						<a href="/shopping/MyCartServlet?operator=add&id=<%=book.getId() %>" class="btn btn-primary mb-2">加入购物车</a>
					</div>
				</div>
			</div>
		</div>
		
		<!-- 其他书籍推荐 -->
		<section id="sp-saleBook">
			<!-- 标题 -->
			<div class="text-center mt-3 mb-3">
				<h2><strong>猜你喜欢</strong></h2>
				<img src="img/star.png" />
			</div>
			<div class="container">
				<div class="row">
					<!-- 得到喜欢的书籍集合 -->
					<%
						ArrayList<Book> al = (ArrayList<Book>)request.getAttribute("sameBookList");
						for(int i=0; i<al.size(); i++) {
							book = al.get(i);
					%>
					<div class="col-xs-12 col-sm-6 col-lg-3">
						<div class="card align-items-center  bg-light p-2">
							<div class="mb-1">
								<a href=<%= book.getLink() %> target="_blank"><img src=<%= book.getImg() %> alt="" class="card-img-top media-boject rounded img-thumbnail" /></a>			
							</div>
							<div class="card-body text-center">
								<h5 class="card-title text-center"><a href=<%= book.getLink() %> target="_blank"><%= book.getName() %></a></h5>
								<!-- //判断是否为特价书籍 -->
								<% if("0".equals(book.getStatus())){ %>
								<p class="card-text text-center"><%= book.getNowPirce() %>元</p>
								<% } else { %>
								<p class="card-text text-center"><del><%= book.getPrice() %>元</del><i class="text-danger"> &nbsp;&nbsp;&nbsp;<%= book.getNowPirce() %>元</i></p>	
								<% } %>
								<a class="active-icon" href="/shopping/?type=add&id=<%=book.getId() %>">💗&nbsp;</a> <!--收藏-->
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
		
		<!-- 底部 -->
		<footer id="sp-footer">
			<div class="text text-center p-4 text-primary">
				<p>制作于2019/8/3的一个神奇网页</p>
				<p>Copyright © 2015.Company name All rights reserved.</p>
			</div>
		</footer>
	</body>
    <script src="./jsplib/js/jquery-3.4.1.min.js"></script>
    <script src="./jsplib/js/popper.min.js"></script>
    <script src="./jsplib/js/bootstrap.min.js" ></script> 
</body>
</html>
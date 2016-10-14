<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script src="<%=basePath%>resource/jquery/jquery.min.js"></script>
<link href="<%=basePath%>resource/css/bootstrap.min.css"
	rel="stylesheet">
<script src="<%=basePath%>resource/js/bootstrap.min.js"></script>
<script src="<%=basePath%>resource/ie10-viewport-bug-workaround.js"></script>
<link href="<%=basePath%>resource/css/signin.css" rel="stylesheet">

</head>

<body>

	<div class="container">
		<div class="col-md-12 column">
			<nav class="navbar navbar-default" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span><span
						class="icon-bar"></span><span class="icon-bar"></span><span
						class="icon-bar"></span>
				</button>
				<strong><a class="navbar-brand"
					href="<%=basePath%>manager/chooseAgentAdmit.jsp">鲸艺教育</a></strong>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">登录<strong class="caret"></strong></a>
						<ul class="dropdown-menu">
							<li><a href="<%=basePath%>manager/login.jsp">管理员登录</a></li>
							<li><a href="#">代理商登录</a></li>
						</ul></li>
					<li><a href="<%=basePath%>agent/debug.jsp">代理商</a></li>
				</ul>

			</div>

			</nav>

		</div>
		<form class="form-signin" role="form">
			<h2 class="form-signin-heading">Please sign in</h2>
			<input class="form-control" placeholder="账号名" required=""
				autofocus="" type="text"> <input class="form-control"
				placeholder="密码" required="" type="password">
			<div class="checkbox">
				<label> <input value="remember-me" type="checkbox">
					记住我
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
		</form>

	</div>


</body>
</html>



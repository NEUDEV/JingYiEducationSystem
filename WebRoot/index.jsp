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
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span><span
							class="icon-bar"></span><span class="icon-bar"></span><span
							class="icon-bar"></span>
					</button>
					<strong><a class="navbar-brand" href="#">鲸艺教育</a></strong>
				</div>

				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">Link</a></li>
						<li><a href="#">Link</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li class="divider"></li>
								<li><a href="#">Separated link</a></li>
								<li class="divider"></li>
								<li><a href="#">One more separated link</a></li>
							</ul></li>
					</ul>
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input class="form-control" type="text" />
						</div>
						<button type="submit" class="btn btn-default">Submit</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#">Link</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li class="divider"></li>
								<li><a href="#">Separated link</a></li>
							</ul></li>
					</ul>
				</div>

				</nav>
				<div class="row clearfix">
					<div class="col-md-2 column">
						<div class="panel-group" id="panel-699072">
							<div class="panel panel-default">
								<div class="panel-heading">
									<a class="panel-title collapsed" data-toggle="collapse"
										data-parent="#panel-699072" href="#panel-element-16476">我的佣金</a>
								</div>
								<div id="panel-element-16476" class="panel-collapse collapse">
									<div class="panel-body">我的佣金</div>
									<div class="panel-body">结算记录</div>
								</div>
							</div>

							<div class="panel panel-default">
								<div class="panel-heading">
									<a class="panel-title" data-toggle="collapse"
										data-parent="#panel-699072" href="#panel-element-724199">我的业绩</a>
								</div>
								<div id="panel-element-724199" class="panel-collapse in">
									<div class="panel-body">业绩订单</div>
									<div class="panel-body">班长订单</div>
									<div class="panel-body">业绩汇总</div>
									<div class="panel-body">我的工单</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<a class="panel-title" data-toggle="collapse"
										data-parent="#panel-699072" href="#panel-element-724200">我的学员</a>
								</div>
								<div id="panel-element-724200" class="panel-collapse in">
									<div class="panel-body">我的学员</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<a class="panel-title" data-toggle="collapse"
										data-parent="#panel-699072" href="#panel-element-724201">我的团队</a>
								</div>
								<div id="panel-element-724201" class="panel-collapse in">
									<div class="panel-body">我的推广员</div>
								</div>
							</div>

							<div class="panel panel-default">
								<div class="panel-heading">
									<a class="panel-title collapsed" data-toggle="collapse"
										data-parent="#panel-699072" href="#panel-element-16477">我的账户</a>
								</div>
								<div id="panel-element-16477" class="panel-collapse collapse">
									<div class="panel-body">个人信息</div>
									<div class="panel-body">银行信息</div>
									<div class="panel-body">手机验证</div>
									<div class="panel-body">修改密码</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-10 column">
						<nav class="navbar navbar-default navbar-static-top"
							role="navigation">
						<div class="collapse navbar-collapse"
							id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav">
								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown">学员UID<strong class="caret"></strong></a>
									<ul class="dropdown-menu">
										<li><a href="#">学员UID</a></li>
										<li><a href="#">用户名</a></li>
										<li><a href="#">真实姓名</a></li>
										<li><a href="#">手机号</a></li>
										<li><a href="#">QQ</a></li>
										<li><a href="#">邮箱</a></li>
									</ul></li>
							</ul>
							<form class="navbar-form navbar-left" role="search">
								<div class="form-group">
									<input class="form-control" type="text" />
								</div>
								<button type="submit" class="btn btn-default">Submit</button>
							</form>
						</div>

						</nav>
						<table class="table">
							<thead>
								<tr>
									<th>UID</th>
									<th>用户名</th>
									<th>姓名</th>
									<th>手机号</th>
									<th>QQ</th>
									<th>邮箱</th>
									<th>注册时间</th>
									<th>最后登录时间</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>TB - Monthly</td>
									<td>01/04/2012</td>
									<td>Default</td>
								</tr>
								<tr class="success">
									<td>1</td>
									<td>TB - Monthly</td>
									<td>01/04/2012</td>
									<td>Approved</td>
								</tr>
								<tr class="error">
									<td>2</td>
									<td>TB - Monthly</td>
									<td>02/04/2012</td>
									<td>Declined</td>
								</tr>
								<tr class="warning">
									<td>3</td>
									<td>TB - Monthly</td>
									<td>03/04/2012</td>
									<td>Pending</td>
								</tr>
								<tr class="info">
									<td>4</td>
									<td>TB - Monthly</td>
									<td>04/04/2012</td>
									<td>Call in to confirm</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

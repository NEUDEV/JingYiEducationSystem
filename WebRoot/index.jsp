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
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<div class="navbar">
					<div class="navbar-inner">
						<div class="container-fluid">
							<a class="btn btn-navbar"
								data-target=".navbar-responsive-collapse" data-toggle="collapse"></a>
							<a class="brand" href="#">鲸艺教育</a>
							<div class="nav-collapse collapse navbar-responsive-collapse">
								<ul class="nav">
									<li><a href="#">链接</a></li>
									<li><a href="#">链接</a></li>
									<li class="dropdown"><a class="dropdown-toggle"
										data-toggle="dropdown" href="#">下拉菜单</a>
										<ul class="dropdown-menu">
											<li><a href="#">下拉导航1</a></li>
											<li><a href="#">下拉导航2</a></li>
											<li><a href="#">其他</a></li>
											<li class="divider"></li>
											<li class="nav-header">标签</li>
											<li><a href="#">链接1</a></li>
											<li><a href="#">链接2</a></li>
										</ul></li>
								</ul>
								<ul class="nav pull-right">
									<li><a href="#">右边链接</a></li>
									<li class="divider-vertical"></li>
									<li class="dropdown"><a class="dropdown-toggle"
										data-toggle="dropdown" href="#">下拉菜单</a>
										<ul class="dropdown-menu">
											<li><a href="#">下拉导航1</a></li>
											<li><a href="#">下拉导航2</a></li>
											<li><a href="#">其他</a></li>
											<li class="divider"></li>
											<li><a href="#">链接3</a></li>
										</ul></li>
								</ul>
							</div>

						</div>
					</div>

				</div>
				<div class="row-fluid">
					<div class="span3">
						<div class="accordion" id="accordion-624141">
							<div class="accordion-group">
								<div class="accordion-heading">
									<a class="accordion-toggle" data-parent="#accordion-624141"
										data-toggle="collapse" href="#accordion-element-220884">我的佣金</a>
								</div>
								<div class="accordion-body in collapse"
									id="accordion-element-220884">
									<div class="accordion-inner">我的佣金</div>
								</div>
							</div>
							<div class="accordion-group">
								<div class="accordion-heading">
									<a class="accordion-toggle collapsed"
										data-parent="#accordion-624141" data-toggle="collapse"
										href="#accordion-element-339731">我的业绩</a>
								</div>
								<div class="accordion-body collapse"
									id="accordion-element-339731">
									<div class="accordion-inner">业绩订单</div>
								</div>
							</div>
						</div>
					</div>
					<div class="span9">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>序号</th>
									<th>UID</th>
									<th>用户名</th>
									<th>姓名</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>TB - Monthly</td>
									<td>01/04/2012</td>
									<td>Defa</td>
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

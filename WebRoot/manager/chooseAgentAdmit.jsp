<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/index.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>开设代理商账户</title>
</head>

<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-2 column">
				<div class="sidebar-nav">
					<div class="panel-group" id="panel-659100">
						<div class="panel panel-default">
							<div class="panel-heading">
								<a class="panel-title" data-toggle="collapse"
									data-parent="#panel-659100" href="#panel-element-24469">代理商管理</a>
							</div>
							<div id="panel-element-24469" class="panel-collapse collapse in">
								<div class="panel-body">
									<a href="<%=basePath%>manager/chooseAgentAdmit.jsp">登记代理商</a>
								</div>
								<div class="panel-body">
									<a href="<%=basePath%>manager/agentRegister.jsp">开设代理商账户</a>
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<a class="panel-title" data-toggle="collapse"
									data-parent="#panel-659100" href="#panel-element-936974">报表</a>
							</div>
							<div id="panel-element-936974" class="panel-collapse collapse">
								<div class="panel-body">
									<a href="#">查看系统报表</a>
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<a class="panel-title" data-toggle="collapse"
									data-parent="#panel-659100" href="#panel-element-936975">学员管理</a>
							</div>
							<div id="panel-element-936975" class="panel-collapse collapse">
								<div class="panel-body">
									<a href="#">划分学员</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-10 column">
				<ul class="breadcrumb">
					<li><a href="<%=basePath%>/index.jsp">主页</a></li>
					<li class="active">选择代理商</li>
					<li><a href="#">登记代理商信息</a></li>
					<li><a href="#">登记成功</a></li>
				</ul>
				<nav class="navbar navbar-default navbar-static-top"
					role="navigation">
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<form class="navbar-form navbar-left" role="search"
						action="AgentStudentsAction.action" method="post">
						<select name="searchtype" class="form-control">
							<option>账户名</option>
							<option>姓名</option>
							<option>手机号</option>
						</select>
						<div class="form-group">
							<input class="form-control" name="searchvalue" type="text" />
						</div>
						<button type="submit" class="btn btn-default">查找</button>
					</form>
				</div>
				</nav>
				<table class="table">
					<thead>
						<tr>
							<th>账户名</th>
							<th>姓名</th>
							<th>手机号</th>
							<th>QQ</th>
							<th>邮箱</th>
						</tr>
					</thead>
					<tbody>
					
					</tbody>
				</table>

			</div>
		</div>
</body>
</html>



<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../../managerMemu.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>开设班主任账户</title>
</head>

<body>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<ul class="breadcrumb">
			<li><a href="<%=basePath%>index.jsp">主页</a></li>
			<li class="active">选择班主任</li>
			<li><a href="#">选择超级班主任</a></li>
			<li><a href="#">划分成功</a></li>
		</ul>
		<nav class="navbar navbar-default navbar-static-top" role="navigation">
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<form class="navbar-form navbar-left" role="search"
				action="<%=basePath%>Manager/ManagerAgentManage_searchCommonAgents.action"
				method="post">
				<select name="searchType" class="form-control">
					<option>账户名</option>
					<option>姓名</option>
					<option>手机号</option>
					<option>QQ</option>
				</select>
				<div class="form-group">
					<input class="form-control" name="searchValue" type="text" />
				</div>
				<button type="submit" class="btn btn-default">查找</button>
			</form>
		</div>
		</nav>

		<a>请选择班主任：</a>
		<form
			action="<%=basePath%>Manager/ManagerAgentManage_displaySuperAgents.action"
			method="post" id="selectCommonAgentForm">
			<table class="table table table-bordered">
				<thead>
					<tr>
						<th>序号</th>
						<th>账户名</th>
						<th>姓名</th>
						<th>手机号</th>
						<th>QQ</th>
						<th>班主任类别</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${request.agentList}" var="agent">
						<tr>
							<td>${i=i+1}</td>
							<td>${agent.aname}</td>
							<td>${agent.name}</td>
							<td>${agent.phone}</td>
							<td>${agent.qq}</td>
							<td>${agent.role}</td>
							<td><label><input name="check" type="checkbox"
									value="${agent.uid}" /></label></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
		<input type="button" class="btn btn-default " value="选择完成"
			onclick="document.getElementById('selectCommonAgentForm').submit();"
			style="margin-right;" /><br>
	</div>
</body>
</html>



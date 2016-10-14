<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../managerMemu.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>划分学员</title>
</head>

<body>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<ul class="breadcrumb">
			<li><a href="<%=basePath%>/index.jsp">主页</a></li>
			<li class="active">选择鲸艺代理商学员</li>
			<li><a href="#">划分</a></li>
			<li><a href="#">划分成功</a></li>
		</ul>
		
		<nav class="navbar navbar-default navbar-static-top" role="navigation">
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<form class="navbar-form navbar-left" role="search"
				action="<%=basePath%>Manager/ManagerAgentManage_searchAgent.action"
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
		<table class="table table table-bordered">
			<thead>
				<tr>
					<th>UID</th>
					<th>姓名</th>
					<th>手机号</th>
					<th>QQ</th>
					<th>微信号</th>
					<th>选择</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${request.studentList}" var="agent">
					<tr>
						<td>${student.uid}</td>
						<td>${student.name}</td>
						<td>${student.phone}</td>
						<td>${student.qq}</td>
						<td>${student.weixin}</td>
						<td><input name="check" type="checkbox" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>



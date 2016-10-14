<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.JES.model.Student"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="./agentMemu.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>
<body>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<nav class="navbar navbar-default navbar-static-top" role="navigation">
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<form class="navbar-form navbar-left" role="search"
				action="AgentStudentsAction.action" method="post">
				<select name="searchtype" class="form-control">
					<option>学员UID</option>
					<option>用户名</option>
					<option>真实姓名</option>
					<option>手机号</option>
					<option>QQ</option>
					<option>邮箱</option>
				</select>
				<div class="form-group">
					<input class="form-control" name="searchvalue" type="text" />
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
					<th>状态</th>
				</tr>
			</thead>
			<tbody>
				<%
					List<Student> list = (List<Student>) request
							.getAttribute("mystudent");
					if (list != null) {
						for (int i = 0; i < list.size(); i++) {
				%>
				<tr>
					<td><%=list.get(i).getUid()%></td>
					<td><%=list.get(i).getUname()%></td>
					<td><%=list.get(i).getName()%></td>
					<td><%=list.get(i).getPhone()%></td>
					<td><%=list.get(i).getQq()%></td>
					<td><%=list.get(i).getEmail()%></td>
					<td><%=list.get(i).getSign()%></td>
				</tr>
				<%
					}
						session.putValue("mystudent", null);
					}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>

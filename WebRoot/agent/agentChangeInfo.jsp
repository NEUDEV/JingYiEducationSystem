<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="./agentMemu.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>开设代理商账户</title>
</head>

<body>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<ul class="breadcrumb">
			<li><a href="<%=basePath%>/index.jsp">主页</a></li>
			<li class="active">修改个人信息</li>
		</ul>

		<form
			action="<%=basePath%>Manager/AgentLoginAndInfo_changeAgentInfo.action"
			id="form" method="post">
			<table class="table table table-bordered">
				<thead>
					<tr>
						<th>字段</th>
						<th>目前值</th>
						<th>修改值</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>账号名</td>
						<td>${agent.aname}</td>
						<td><input class="form-control" id="aname" type="text"
							name="aname" /></td>
					</tr>
					<tr>
						<td>姓名</td>
						<td>${agent.name}</td>
						<td><input class="form-control" id="name" type="text"
							name="name" /></td>
					</tr>
					<tr>

						<td>QQ</td>
						<td>${agent.qq}</td>
						<td><input class="form-control" id="qq" type="number"
							name="qq" /></td>
					</tr>
					<tr>
						<td>手机号</td>
						<td>${agent.phone}</td>
						<td><input class="form-control" id="phone" type="number"
							name="phone" /></td>
					</tr>
					<tr>
						<td>身份证号</td>
						<td>${agent.idcard}</td>
						<td><input class="form-control" id="idcard" type="text"
							name="idcard" /></td>
					</tr>
					<tr>
						<td>银行卡号</td>
						<td>${agent.account}</td>
						<td><input class="form-control" id="account" type="number"
							name="account" /></td>
					</tr>
					<tr>
						<td>所属银行</td>
						<td>${agent.bank}</td>
						<td><input class="form-control" id="bank" type="text"
							name="bank" /></td>
					</tr>
				</tbody>
			</table>

			<button type="submit" class="btn btn-default">提交</button>
		</form>
	</div>
</body>
</html>


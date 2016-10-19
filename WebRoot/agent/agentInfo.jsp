<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="./agentMemu.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>开设代理商账户</title>
<link href="<%=basePath%>resource/css/signin.css" rel="stylesheet">
</head>

<body>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<ul class="breadcrumb">
			<li><a href="<%=basePath%>/index.jsp">主页</a></li>
			<li class="active">查看个人信息</li>
			<li><a href="#">修改个人信息</a></li>
		</ul>
		<dl>
			<dt>我的个人信息：</dt>
			</br>
			<dd>账号： ${agent.aname}</dd>
			<dd>姓名： ${agent.name}</dd>
			<dd>QQ： ${agent.qq}</dd>
			<dd>手机号： ${agent.phone}</dd>
			<dd>身份证号： ${agent.idcard}</dd>
			<dd>班主任类别： ${agent.role}</dd>
		</dl>
		<a class="btn btn-default"
			href="<%=basePath%>Agent/AgentLoginAndInfo_getAgentInfo.action"
			role="button">修改个人信息</a>
	</div>
</body>
</html>


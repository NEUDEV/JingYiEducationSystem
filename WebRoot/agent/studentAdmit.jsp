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
		<form action="AgentAddStudentsAction" id="form" method="post">
			<div class="form-group">
				<label for="uid">学员UID</label> <label id="errms"
					style="color:#FF0000;display:none">(该学员已被录入)</label> <input
					class="form-control" id="uidin" type="text" name="uidin" />
			</div>
			<div class="form-group">
				<label for="aname">账户名</label><input class="form-control" id="aname"
					type="text" name="uname" />
			</div>
			<div class="form-group">
				<label for="name">姓名</label><input class="form-control" id="name"
					type="text" name="name" />
			</div>
			<div class="form-group">
				<label for="qq">qq</label><input class="form-control" id="qq"
					type="text" name="qq" />
			</div>
			<div class="form-group">
				<label for="phone">电话</label> <input class="form-control" id="phone"
					type="text" name="phone" />
			</div>
			<div class="form-group">
				<label for="email">邮箱</label><input class="form-control" id="email"
					type="email" name="email" />
			</div>
			<button type="submit" class="btn btn-default" id="button">提交</button>
		</form>
	</div>
</body>
</html>

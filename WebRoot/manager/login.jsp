<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/index.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>信用卡激活</title>
</head>

<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<form class="form-horizontal" role="form"
					action="<%=basePath%>Manager/MangaerLogin_login.action"
					method="post">
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">账户名</label>
						<div class="col-sm-10">
							<input class="form-control" id="inputEmail3" type="text" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-10">
							<input class="form-control" id="inputPassword3" type="password" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<div class="checkbox">
								<label><input type="checkbox" />记住密码</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">登录</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>

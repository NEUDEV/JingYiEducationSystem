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
			<div class="col-md-3 column">
				<div class="sidebar-nav">
					<div class="panel-group" id="panel-659100">
						<div class="panel panel-default">
							<div class="panel-heading">
								<a class="panel-title" data-toggle="collapse"
									data-parent="#panel-659100" href="#panel-element-24469">代理商管理</a>
							</div>
							<div id="panel-element-24469" class="panel-collapse collapse in">
								<div class="panel-body">
									<a href="#">登记代理商</a>
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
			<div class="col-md-9 column">
				<form action="<%=basePath%>Manager/ManagerAgentRegister_register.action"
					id="form" method="post">
					<div class="form-group">
						<label for="aname">账户名</label><input class="form-control"
							id="aname" type="text" name="aname" />
					</div>
					<div class="form-group">
						<label for="name">姓名</label><input class="form-control" id="name"
							type="text" name="name" />
					</div>
					<div class="form-group">
						<label for="qq">qq</label><input class="form-control" id="qq"
							type="number" name="qq" />
					</div>
					<div class="form-group">
						<label for="phone">电话</label><input class="form-control"
							id="phone" type="number" name="phone" size="11"/>
					</div>
					<div class="form-group">
						<label for="email">邮箱</label><input class="form-control"
							id="email" type="email" name="email" />
					</div>
					<div class="form-group">
						<label for="Password">登录密码:</label> <input class="form-control"
							id="chPassword" type="password" name="password" />
					</div>
					<div class="form-group">
						<label for="confirmPassword">密码确认:</label> <input
							class="form-control" id="confirmPassword" type="password"
							name="confirmPassword" />
					</div>
					<div class="form-group">
						<label for="role">选择代理商级别:</label> <select name="selectRole"
							class="form-control">
							<option>1级代理商</option>
							<option>2级代理商</option>
						</select>
					</div>
					<div class="col-md-12 column">${request.info}</div>
					<button type="submit" class="btn btn-default">提交</button>
				</form>
			</div>
		</div>
</body>
</html>



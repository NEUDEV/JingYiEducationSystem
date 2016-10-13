<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/index.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>管理员菜单</title>
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
									<a href="<%=basePath%>Manager/ManagerAgentManage_display.action">代理商管理</a>
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
			<div class="col-md-10 column"></div>
		</div>
	</div>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.JES.model.Student" %>
<%@ include file="/index.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="row clearfix">
					<div class="col-md-2 column">
						<div class="panel-group" id="panel-699072">
							<div class="panel panel-default">
								<div class="panel-heading">
									<a class="panel-title collapsed" data-toggle="collapse"
										data-parent="#panel-699072" href="#panel-element-16476">我的佣金</a>
								</div>
								<div id="panel-element-16476" class="panel-collapse collapse">
									<div class="panel-body">我的佣金</div>
									<div class="panel-body">结算记录</div>
								</div>
							</div>

							<div class="panel panel-default">
								<div class="panel-heading">
									<a class="panel-title" data-toggle="collapse"
										data-parent="#panel-699072" href="#panel-element-724199">我的业绩</a>
								</div>
								<div id="panel-element-724199" class="panel-collapse in">
									<div class="panel-body">
										<a href="#">业绩订单</a>
									</div>
									<div class="panel-body">班长订单</div>
									<div class="panel-body">业绩汇总</div>
									<div class="panel-body">我的工单</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<a class="panel-title" data-toggle="collapse"
										data-parent="#panel-699072" href="#panel-element-724200">我的学员</a>
								</div>
								<div id="panel-element-724200" class="panel-collapse in">
									<div class="panel-body">我的学员</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<a class="panel-title" data-toggle="collapse"
										data-parent="#panel-699072" href="#panel-element-724201">我的团队</a>
								</div>
								<div id="panel-element-724201" class="panel-collapse in">
									<div class="panel-body">我的推广员</div>
								</div>
							</div>

							<div class="panel panel-default">
								<div class="panel-heading">
									<a class="panel-title collapsed" data-toggle="collapse"
										data-parent="#panel-699072" href="#panel-element-16477">我的账户</a>
								</div>
								<div id="panel-element-16477" class="panel-collapse collapse">
									<div class="panel-body">个人信息</div>
									<div class="panel-body">银行信息</div>
									<div class="panel-body">手机验证</div>
									<div class="panel-body">修改密码</div>
								</div>
							</div>
						</div>
					</div>
					
					<div class="col-md-10 column">
						<form action="AgentAddStudentsAction.action"
					id="form" method="post">
					<div class="form-group">
						<label for="uid">学员UID</label><input class="form-control"
							id="uid" type="text" name="uid" />
					</div>
					<div class="form-group">
						<label for="aname">账户名</label><input class="form-control"
							id="aname" type="text" name="uname" />
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
						<label for="phone">电话</label><input class="form-control"
							id="phone" type="text" name="phone" />
					</div>
					<div class="form-group">
						<label for="email">邮箱</label><input class="form-control"
							id="email" type="email" name="email" />
					</div>
					<button type="submit" class="btn btn-default">提交</button>
				</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

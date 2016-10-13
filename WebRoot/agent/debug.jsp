<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
									<div class="panel-body"><a href="#">业绩订单</a></div>
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
						<nav class="navbar navbar-default navbar-static-top"
							role="navigation">
						<div class="collapse navbar-collapse"
							id="bs-example-navbar-collapse-1">
							<form class="navbar-form navbar-left" role="search">
								<select name="selectCd" class="form-control">
									<option>学员UID</option>
									<option>用户名</option>
									<option>真实姓名</option>
									<option>手机号</option>
									<option>QQ</option>
									<option>邮箱</option>
								</select>
								<div class="form-group">
									<input class="form-control" type="text" />
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
									<th>注册时间</th>
									<th>最后登录时间</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>TB - Monthly</td>
									<td>01/04/2012</td>
									<td>Default</td>
								</tr>
								<tr class="success">
									<td>1</td>
									<td>TB - Monthly</td>
									<td>01/04/2012</td>
									<td>Approved</td>
								</tr>
								<tr class="error">
									<td>2</td>
									<td>TB - Monthly</td>
									<td>02/04/2012</td>
									<td>Declined</td>
								</tr>
								<tr class="warning">
									<td>3</td>
									<td>TB - Monthly</td>
									<td>03/04/2012</td>
									<td>Pending</td>
								</tr>
								<tr class="info">
									<td>4</td>
									<td>TB - Monthly</td>
									<td>04/04/2012</td>
									<td>Call in to confirm</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

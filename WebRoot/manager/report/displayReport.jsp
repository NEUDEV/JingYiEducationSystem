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
			<li class="active">查看系统报表</li>
		</ul>
		<table class="table table table-bordered">
			<thead>
				<tr>
					<th>报表</th>
					<th>新增非正式学员</th>
					<th>板式学员</th>
					<th>字体学员</th>
					<th>品牌学员</th>
					<th>全科班学员</th>
					<th>插画学员</th>
					<th>电商学员</th>
					<th>终身学员</th>
					<th>转化率</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>合计</td>
					<td>${report.informalstu}人</td>
					<td>${report.platestu}人</td>
					<td>${report.typefacestu}人</td>
					<td>${report.brandstu}人</td>
					<td>${report.fullstu}人</td>
					<td>${report.illustration}人</td>
					<td>${report.onlinestu}人</td>
					<td>${report.lifetimestu}人</td>
					<td>${report.transrate}</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>



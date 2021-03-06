<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../managerMemu.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>删除课程</title>
</head>

<body>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<ul class="breadcrumb">
			<li><a href="<%=basePath%>/index.jsp">主页</a></li>
			<li class="<%=basePath%>Manager/ManagerCourseManage_displayCourse.action">课程管理</li>
			<li class="active">课程删除成功</li>
		</ul>
		
		<dl>
			<dt>
				<font size="4">课程信息：</font>
			</dt>
			</br>
			<dd>
				<font size="3">课程名：${course.cname}</font>
			</dd>
			<br>
			<dd>
				<font size="3">开课时间： ${course.starttime.toString().substring(0,10)}</font>
			</dd>
			<br>
			<dd>
				<font size="3">结课时间：${course.endtime.toString().substring(0,10)}</font>
			</dd>
			<br>
			<dd>
				<font size="3">参考价格： ${course.referencebill}元</font>
			</dd>
			<br>
		</dl>

		<a class="btn btn-default"
			href="<%=basePath%>Manager/ManagerCourseManage_displayCourse.action">返回</a>
	</div>
</body>
</html>



<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../managerMemu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>课程管理</title>
<script type="text/javascript">
	$(function() {
		$("#commit").click(function() {
			if ($("#cname").val() == "") {
				alert("账户不能为空");
			} else if ($("#starttime").val() == "") {
				alert("开课 不能为空");
			} else if ($("#endtime").val() == "") {
				alert("结课时间不能为空");
			} else if ($("#referencebill").val() == "") {
				alert("参考价格不能为空");
			} else {
				$('form').submit();
			}
		});
	});
</script>
</head>

<body>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<ul class="breadcrumb">
			<li><a href="<%=basePath%>/index.jsp">主页</a></li>
			<li class="active">添加课程</li>
			<li class="#">课程添加成功</li>
		</ul>

		<form
			action="<%=basePath%>Manager/ManagerCourseManage_addCourse.action"
			id="form" method="post">
			<div class="form-group">
				<label for="cname">课程名：</label><input class="form-control"
					id="cname" type="text" name="cname" value="" />
			</div>
			<div class="form-group">
				<label for="starttime">开课时间：</label><input class="form-control"
					id="starttime" type="date" name="starttime" />
			</div>
			<div class="form-group">
				<label for="endtime">结课时间：</label>
				
				<input class="form-control"
					id="endtime" type="date" name="endtime" size="11" />
			</div>
			<div class="form-group">
				<label for="referencebill">参考价格：</label><input class="form-control"
					id="referencebill" type="number" name="referencebill" size="11" />
			</div>
			<div class="col-md-12 column">${request.info}</div>
			<input type="button" class="btn btn-default" value="提交" id="commit">
		</form>
	</div>
</body>
</html>



<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../managerMemu.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>课程管理</title>
<link href="<%=basePath%>resource/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet" media="screen">
<script type="text/javascript"
	src="<%=basePath%>resource/js/bootstrap-datetimepicker.js"
	charset="UTF-8"></script>
<script type="text/javascript"
	src="<%=basePath%>resource/js/locales/bootstrap-datetimepicker.fr.js"
	charset="UTF-8"></script>
<script type="text/javascript">
	$(function() {
		$("#commit").click(function() {
			if ($("#cname").val() == "") {
				alert("账户不能为空");
			} else if ($("#starttime").val() == "") {
				alert("开课时间不能为空");
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
				<label for="starttime">开课时间：</label>

				<div class="controls input-append date form_date form-group"
					data-date="" data-date-format="yyyy-mm-dd">
					<input size="16" type="text" value="" readonly class="form-control"
						name="starttime" id="starttime"> <span class="add-on"><i
						class="icon-remove"></i></span> <span class="add-on"><i
						class="icon-th"></i></span>
				</div>
			</div>
			<div class="form-group">
				<label for="endtime">结课时间：</label>
				<div class="controls input-append date form_date form-group"
					data-date="" data-date-format="yyyy-mm-dd">
					<input size="16" type="text" value="" readonly class="form-control"
						id="endtime" name="endtime"> <span class="add-on"><i
						class="icon-remove"></i></span> <span class="add-on"><i
						class="icon-th"></i></span>
				</div>
			</div>
			<div class="form-group">
				<label for="referencebill">参考价格：</label><input class="form-control"
					id="referencebill" type="number" name="referencebill" size="11" />
			</div>
			<div class="col-md-12 column">${request.info}</div>
			<input type="button" class="btn btn-default" value="提交" id="commit">
		</form>


		<br />
		<script type="text/javascript">
			$('.form_date').datetimepicker({
				language : 'fr',
				weekStart : 1,
				todayBtn : 1,
				autoclose : 1,
				todayHighlight : 1,
				startView : 2,
				minView : 2,
				forceParse : 0
			});
		</script>
</body>
</html>



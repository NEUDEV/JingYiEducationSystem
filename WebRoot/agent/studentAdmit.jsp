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
		<form action="AgentUpStudentAction" id="form" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="name">姓名</label><input class="form-control" id="name"
					type="text" name="name" />
			</div>
			<div class="form-group">
				<label for="qq">QQ</label><input class="form-control" id="qq"
					type="text" name="qq" />
			</div>
			<div class="form-group">
				<label for="weixin">微信</label> <input class="form-control" id="weixin"
					type="text" name="weixin" />
			</div>
			<div class="form-group">
				<label for="phone">电话</label> <input class="form-control" id="phone"
					type="text" name="phone" />
			</div>
			<div class="form-group">
				<label for="class_">课程</label> <input class="form-control" id="class_"
					type="text" name="class_" />
			</div>
			<div class="form-group">
				<input type="file" name="file" >  
				<input type="reset" class="btn1" value="取消">
			</div>
			<button type="submit" class="btn btn-default" id="button">提交</button>
		</form>
	</div>
</body>
</html>

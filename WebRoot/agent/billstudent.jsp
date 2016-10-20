<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.JES.model.Student"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="./agentMemu.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="jquery/JS/jquery-2.1.1.min.js"></script>  
<script type="text/javascript">  
     function clickFunctino() {  
            //alert($("#xm").val());             
            $.ajax({  
                type: "post",  
                url: "cheakqq.action",    
                dataType:"json",  
                success: function(data){    
                    //alert(data);  
                    //var obj = $.parseJSON(json);  //使用这个方法解析字符串json result  
                    if(data.result=="true"){
                    	  $("#qq").val("");
                    	  $("#qq").innerHTML="qq号已存在";
                    	  }
                    else if(data.result=="false"){
                    	  $("#qq").innerHTML="ok";
                    	  }
                },  
                error: function(data){  
                    alert("验证QQ号失败");  
                 return false;  
                }  
                });      
     };
     
     
     function cheackblock(){
     	var name=$("#name").val();
     	var qq=$("#qq").val();
     	var s=document.form.file.value;
     	//alert(name+qq+s);
     	if(name!=""&&qq!=""&&s!=""){
     		alert("不空");
        	document.getElementById("form").submit();
        }else{
     	if(name==""){
     		$("#name").innerHTML="name";
     		document.getElementById("name").focus();
     		return false; 
     	}
     	else $("#name").innerHTML="";
     	if(qq==""){
     		$("#qq").innerHTML="QQ";
     		document.getElementById("qq").focus();
     		return false;
     	}
     	else $("#qq").innerHTML="";
     	if(s==""){
                alert("请选择一张图片");
                document.getElementById("file").focus();
                return false;
            }
         }
     }
     
     function course(){
		$.ajax({
			type : "post",
			url : "GetCourseAction.action",
			data: "",
			datatype: "json",
			success : function(json) {
			var order = $.parseJSON(json.jsonResult);
				var result = "";
				if (order == null) {
					return;
				}
				result += "<label for='class_'>报名科目</label>";
				result += "<select name='class_' class='form-control'>";
				for (var i = 0; i < order.length; i++) {
					result += "<option>" + order[i].cname + "</option>";
				}
				result+="</select>";
				$("#courseshow").html(result);
				$("#courseshow").innerHTML="123";
			},
			error : function(text) {
				alert("erro");
			}
		});
     }
</script>  
</head>
<body onload="course()">
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<form action="AgentBillAction" name="form" id="form" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="stuid">学号*</label><input class="form-control" id="stuid"
					type="text" name="stuid" disabled=true value=<%=request.getParameter("stuid") %>></input>
			</div>
			<div class="form-group">
				<label for="name">姓名*</label><input class="form-control" id="name"
					type="text" name="name" disabled=true value=<%=request.getParameter("name") %>></input>
			</div>
			<div class="form-group">
				<label for="phone">电话</label> <input class="form-control" id="phone"
					type="text" name="phone" value=<%=request.getParameter("phone") %>></input>
			</div>
			<div class="form-group">
				<label for="qq">QQ*</label><input class="form-control" id="qq"
					type="text" name="qq" disabled=true value=<%=request.getParameter("qq") %>></input>
					
			</div>
			<div><label id="qqms"></label></div>
			<div class="form-group">
				<label for="weixin">微信</label> <input class="form-control" id="weixin"
					type="text" name="weixin" value=<%=request.getParameter("qq") %>></input>
			</div>
			<div class="form-group">
				<label for="sign">状态</label> <select name="sign" class="form-control">
					<option>正式学员</option>
					<option>非正式学员</option>
				</select>
			</div>
			<div class="form-group" id="courseshow">
				<!-- <label for="class_">报名科目</label> 
				<select name="class_" class="form-control">
					<option>科目A</option>
					<option>科目B</option>
				</select> -->
			</div>
			<div class="form-group">
				<label for="bill">学费</label> <input class="form-control" id="bill"
					type="text" name="bill" />
			</div>
			<div class="form-group">
				<label for="mark">转化指数</label> 
				<div><input type="radio" checked="checked" name="mark" value="1" />1星<br /></div>
				<div><input type="radio"  name="mark" value="2" />2星<br /></div>
				<div><input type="radio"  name="mark" value="3" />3星<br /></div>
				<div><input type="radio"  name="mark" value="4" />4星<br /></div>
				<div><input type="radio"  name="mark" value="5" />5星<br /></div>
			</div>
			<button type="submit" class="btn btn-default" id="submit" onclick="cheackblock()">提交</button>
		</form>
	</div>
</body>
</html>

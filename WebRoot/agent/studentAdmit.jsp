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
            var params = $("#qq").val();           
            $.ajax({  
                type: "post",  
                url: "cheakqq.action",  
                data: {'qq':params},  
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
</script>  
</head>
<body>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<form action="AgentUpStudentAction" name="form" id="form" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="name">姓名*</label><input class="form-control" id="name"
					type="text" name="name" />
			</div>
			<div class="form-group">
				<label for="qq">QQ*</label><input class="form-control" id="qq"
					type="text" name="qq" onblur="clickFunctino()"/>
					
			</div>
			<div><label id="qqms"></label></div>
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
				<label for="class_">上传截图*</label>
				<input type="file" name="file" id="file">  
				<input type="reset" class="btn1" value="取消">
			</div>
			<button type="submit" class="btn btn-default" id="submit" onclick="cheackblock()">提交</button>
		</form>
	</div>
</body>
</html>

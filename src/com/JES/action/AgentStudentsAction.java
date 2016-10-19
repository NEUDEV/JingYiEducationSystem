package com.JES.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.JES.model.Student;
import com.JES.service.AgentService;

import forchange.JsonUtil;

@SuppressWarnings("serial")
public class AgentStudentsAction extends SuperAction{
	private String searchtype;
	private String searchvalue;
	private AgentService agentservice;
	private String jsonResult;
	
	public String getJsonResult() {
		return jsonResult;
	}
	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}
	public String getSearchtype() {
		return searchtype;
	}
	public void setSearchtype(String searchtype) {
		this.searchtype = searchtype;
	}
	public String getSearchvalue() {
		return searchvalue;
	}
	public void setSearchvalue(String searchvalue) {
		this.searchvalue = searchvalue;
	}
	public AgentService getAgentservice() {
		return agentservice;
	}
	public void setAgentservice(AgentService agentservice) {
		this.agentservice = agentservice;
	}
	
	public String Mystudents(){
		try{
		List<Student> studentList = new ArrayList<Student>();
		//studentList=agentservice.searchStudents(searchtype, searchvalue);
		studentList=agentservice.showAllStudents();
		/*if(studentList!=null){
			request.setAttribute("mystudent", studentList);
			return "show";
		}
		return "noshow";*/
		
		/*10.17*/
		
		jsonResult = JsonUtil.listToJson(studentList);  
		System.out.println();
        //申明返回的结果，不然页面上不能显示  
            ServletActionContext.getResponse().setContentType("text/xml");  
        }catch(Exception e){    
            e.fillInStackTrace();  
        }  
        return SUCCESS;
		 
		/*int totalRows = studentList.size();
		StringBuffer sb = new StringBuffer();
		sb.append("{\"totalCount\":\""+totalRows+"\",");  
        sb.append("\"jsonRoot\":[");
        for (int i=0;i<studentList.size();i++) {  
            Student student = (Student)studentList.get(i);  
            sb.append("{\"uid\":\""+ student.getUid());  
            sb.append("\",");    
            sb.append("\"stuid\":\""+ student.getStuid());  
            sb.append("\",");    
            sb.append("\"name\":\""+ student.getName());  
            sb.append("\",");    
            sb.append("\"phone\":\""+ student.getPhone());  
            sb.append("\",");  
            sb.append("\"weixin\":\""+ student.getWeixin());  
            sb.append("\",");  
            sb.append("\"sfrom\":\""+ student.getSfrom());  
            sb.append("\"");  
            sb.append("\"sign\":\""+ student.getSign());  
            sb.append("\"");
            sb.append("\"intime\":\""+ student.getIntime());  
            sb.append("\"");
            sb.append("\"class_\":\""+ student.getClass());  
            sb.append("\"");
            sb.append("\"mark\":\""+ student.getMark());  
            sb.append("\"");
            sb.append("},");  
        }
        sb.deleteCharAt(sb.lastIndexOf(","));  // 删去最后一个逗号  
        sb.append("]}");
        HttpServletResponse response = ServletActionContext.getResponse();           
        try {
        	response.setContentType("text/plain"); 
			response.getWriter().print(sb);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	
	
}

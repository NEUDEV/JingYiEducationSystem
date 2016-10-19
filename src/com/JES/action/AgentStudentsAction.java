package com.JES.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.JES.json.JsonUtil;
import com.JES.model.Student;
import com.JES.service.AgentService;

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
		studentList=agentservice.searchStudents(searchtype,searchvalue);
		jsonResult = JsonUtil.listToJson(studentList);  
		System.out.println();
            ServletActionContext.getResponse().setContentType("text/xml");  
        }catch(Exception e){    
            e.fillInStackTrace();  
        }  
        return SUCCESS;
	}
	
	
	
}

package com.JES.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.JES.json.JsonUtil;
import com.JES.model.Report;
import com.JES.model.Student;
import com.JES.service.AgentService;

public class MyCpReportAction extends SuperAction{
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
	
	public String MyCps(){
		try{
		List<Report> reportList = new ArrayList<Report>();
		//String mid = session.getAttribute("agentID").toString();
		String aid="1";
		reportList=agentservice.MyCpReports(searchtype,searchvalue,aid);
		jsonResult = JsonUtil.listToJson(reportList); 
		System.out.println(jsonResult);
        ServletActionContext.getResponse().setContentType("text/xml");  
        }catch(Exception e){    
            e.fillInStackTrace();  
        }  
        return SUCCESS;
	}
}

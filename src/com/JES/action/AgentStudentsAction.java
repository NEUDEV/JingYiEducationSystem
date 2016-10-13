package com.JES.action;

import java.util.ArrayList;
import java.util.List;

import com.JES.model.Student;
import com.JES.service.AgentService;

@SuppressWarnings("serial")
public class AgentStudentsAction extends SuperAction{
	private String searchtype;
	private String searchvalue;
	private AgentService agentservice;
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
	
	@SuppressWarnings("unused")
	public String Mystudents(){
		List<Student> listofstudents = new ArrayList<Student>();
		listofstudents.addAll(agentservice.searchStudents(searchtype, searchvalue));
		if(listofstudents!=null){
			request.setAttribute("mystudent", listofstudents);
			return "show";
		}
		return "noshow";
	}
}

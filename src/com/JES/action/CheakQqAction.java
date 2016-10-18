package com.JES.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.JES.service.AgentService;

public class CheakQqAction {
	private String qq;
	private String result;
	private AgentService agentservice;
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public AgentService getAgentservice() {
		return agentservice;
	}
	public void setAgentservice(AgentService agentservice) {
		this.agentservice = agentservice;
	}
	
	public String execute() throws Exception {
	    HttpServletRequest request = ServletActionContext.getRequest();
	    //获取ajax传过来的数据直接使用前台的属性名即可获取。
	    if(agentservice.cheakQq(qq)){
	      //返回给ajax的数据
	      this.result = "true";
	    }else{
	      this.result = "false";
	    }
	    return "success";
	  }
}

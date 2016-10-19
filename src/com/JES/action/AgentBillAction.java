package com.JES.action;

import com.JES.model.Student;
import com.JES.service.AgentService;

@SuppressWarnings("serial")
public class AgentBillAction extends SuperAction{
	private String qq;
	private String phone;
	private String weixin;
	private String sign;
	private Integer bill;
	private Integer mark;
	private String class_;
	
	
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getClass_() {
		return class_;
	}
	public void setClass_(String class_) {
		this.class_ = class_;
	}

	private AgentService agentservice;
	
	public AgentService getAgentservice() {
		return agentservice;
	}
	public void setAgentservice(AgentService agentservice) {
		this.agentservice = agentservice;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWeixin() {
		return weixin;
	}
	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public Integer getBill() {
		return bill;
	}
	public void setBill(Integer bill) {
		this.bill = bill;
	}
	public Integer getMark() {
		return mark;
	}
	public void setMark(Integer mark) {
		this.mark = mark;
	}
	
	public String billup(){
		System.out.println(qq);
		agentservice.billUp(phone,weixin,sign,bill,mark,class_);
		return SUCCESS;
	}
}

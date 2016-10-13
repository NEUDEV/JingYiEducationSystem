package com.JES.action;

import javax.swing.JOptionPane;

import org.hibernate.validator.constraints.Email;

import com.JES.dao.StudentDAO;
import com.JES.model.Student;
import com.JES.service.AgentService;

public class AgentAddStuAction extends SuperAction{
	private String uid;
	private String uname;
	private String name;
	private String phone;
	private String qq;
	private String email;
	private AgentService agentservice;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public AgentService getAgentservice() {
		return agentservice;
	}
	public void setAgentservice(AgentService agentservice) {
		this.agentservice = agentservice;
	}
	
	public String AddStudent(){
		Student student=new Student();
		//String mid=(String)session.getAttribute("");
		student.setUid(uid);
		student.setUname(uname);
		student.setName(name);
		student.setPhone(phone);
		student.setQq(qq);
		student.setEmail(email);
		//student.setMid(mid);
		student.setMid("我");
		student.setSign("未审核");
		if(agentservice.addStudent(student)){
		JOptionPane.showMessageDialog(null, "成功录入！","提示",  JOptionPane.WARNING_MESSAGE);
		return "haveadd";
		}
		else {
		JOptionPane.showMessageDialog(null, "录入失败,可能该学员已经被录入！","提示",  JOptionPane.WARNING_MESSAGE);
		return "haveadd";
		}
	}
}

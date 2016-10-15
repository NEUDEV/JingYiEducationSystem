package com.JES.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.struts2.ServletActionContext;

import com.JES.model.Agentupstudent;
import com.JES.service.AgentService;
import com.opensymphony.xwork2.ActionSupport;

public class AgentUpStudentAction extends ActionSupport{
	
	private File file;
	private String qq;
    private String name;
    private String weixin;
    private String phone;
    private String class_;
	private String fileFileName;
	private String fileContentType;
	
	
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWeixin() {
		return weixin;
	}
	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getClass_() {
		return class_;
	}
	public void setClass_(String class_) {
		this.class_ = class_;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	
	public String execute() throws Exception{
	File uploadFile=new File(ServletActionContext.getServletContext().getRealPath("uploadFile"));
	if(!uploadFile.exists()){  
        uploadFile.mkdir(); //创建该目录  
    	}
	FileInputStream input=new FileInputStream(file);
	Agentupstudent upstudent=new Agentupstudent();
	AgentService agentService=new AgentService();
	upstudent.setClass_(class_);
	upstudent.setName(name);
	upstudent.setPhone(phone);
	upstudent.setPhone(phone);
	upstudent.setQq(qq);
	upstudent.setWeixin(weixin);
	agentService.upPhoto(input, (int) file.length(), upstudent);
	return "success";
	}
}

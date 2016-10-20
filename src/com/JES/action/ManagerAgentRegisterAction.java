package com.JES.action;

import java.util.UUID;

import com.JES.model.Agent;
import com.JES.model.Report;
import com.JES.service.ManagerService;
import com.opensymphony.xwork2.ModelDriven;

public class ManagerAgentRegisterAction extends SuperAction implements
		ModelDriven<Agent> {

	private static final long serialVersionUID = 1L;
	private Agent agent;
	private ManagerService managerService;

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

	public String register() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}
		
		String confirmPassword = request.getParameter("confirmPassword");
		String role = request.getParameter("selectRole");
		agent.setUid("");
		
		if (managerService.isExistAgent(agent)) {
			request.setAttribute("info", "�������˺��Ѵ��ڣ�");
			return "regesterFail";
		} else if (!agent.getPassword().equals(confirmPassword)) {
			request.setAttribute("info", "�������벻һ�£�");
			return "regesterFail";
		} 
		
		if ("������".equals(role)) {
			agent.setRole("������");
		} else if ("����������".equals(role)) {
			agent.setRole("����������");
		}
		
		String reportId=UUID.randomUUID().toString();
		agent.setReportId(reportId);
		managerService.agentRegister(agent);
		
		Report report = new Report(0);
		report.setReportid(reportId);
		managerService.getReportDAO().save(report);
		
		return "regesterSuccess";
	}
	
	@Override
	public Agent getModel() {

		if (agent == null) {
			agent = new Agent();
		}

		return agent;
	}

}

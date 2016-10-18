package com.JES.action;

import com.JES.model.Agent;
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
		
		// TODO ��agent.manager����ΪString���͡�
//		agent.setMannager(session.getAttribute("managerId"));
		managerService.agentRegister(agent);
		
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

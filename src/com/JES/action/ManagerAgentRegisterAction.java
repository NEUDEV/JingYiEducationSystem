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
		System.out.println(role);
		
//		if (managerService.isExistAgent(agent)) {
//			request.setAttribute("info", "�������˺��Ѵ��ڣ�");
//			return "regesterFail";
//		} else if (!agent.getPassword().equals(confirmPassword)) {
//			request.setAttribute("info", "�������벻һ�£�");
//			return "regesterFail";
//		} 
		
		if ("1��������".equals(role)) {
			agent.setRole("1");
		} else if ("2��������".equals(role)) {
			agent.setRole("2");
		}
		
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

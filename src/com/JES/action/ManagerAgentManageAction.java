package com.JES.action;

import org.hibernate.hql.internal.ast.tree.DisplayableNode;

import com.JES.model.Agent;
import com.JES.service.ManagerService;
import com.opensymphony.xwork2.ModelDriven;

public class ManagerAgentManageAction extends SuperAction implements
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

	/**
	 * 显示所有代理商。
	 * 
	 * @return
	 */
	public String display() {
		request.setAttribute("agentList", managerService.getAgents());
		return "display";
	}

	public String searchAgent() {
		request .setAttribute("agentList", managerService.search(request.getParameter("searchType"), request.getParameter("searchValue")));
		
		return "display";
	}

	@Override
	public Agent getModel() {

		if (agent == null) {
			agent = new Agent();
		}

		return agent;
	}

}

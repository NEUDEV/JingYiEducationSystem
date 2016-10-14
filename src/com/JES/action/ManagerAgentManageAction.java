package com.JES.action;

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
		return "agentsDisplay";
	}
	
	/**
	 * 查询代理商。
	 * @return
	 */
	public String searchAgent() {
		request .setAttribute("agentList", managerService.search(request.getParameter("searchType"), request.getParameter("searchValue")));
		return "agentsDisplay";
	}
	
	public String toChange() {
		String uid = request.getParameter("uid");
		session.setAttribute("uid", uid);
		
		return "toChange";
	}
	
	public String toDelete() {
		String uid = request.getParameter("uid");
		session.setAttribute("uid", uid);
		session.setAttribute("agent", managerService.getAgentByID(uid));
		request.setAttribute("agent", managerService.getAgentByID(uid));
		return "toDelete";
	}
	
	public String delete() {
		managerService.deleteAgent((Agent)session.getAttribute("agent"));
		return "agentDeleteSuccess";
	}
	
	public String change() {
		agent.setUid(request.getParameter("uid"));
		
		if (managerService.isExistAgent(agent)) {
			request.setAttribute("info", "账号已存在。");
			return "agentChangeFaild";
		}
		
		String role = request.getParameter("selectRole");
		if ("鲸艺代理商".equals(role)) {
			agent.setRole("鲸艺代理商");
		} else if ("1级代理商".equals(role)) {
			agent.setRole("1级代理商");
		} else if ("2级代理商".equals(role)) {
			agent.setRole("2级代理商");
		}
		
		request.setAttribute("agent", agent);
		managerService.changeAgent(agent);
		return "agentChangeSuccess";
	}

	@Override
	public Agent getModel() {

		if (agent == null) {
			agent = new Agent();
		}

		return agent;
	}

}

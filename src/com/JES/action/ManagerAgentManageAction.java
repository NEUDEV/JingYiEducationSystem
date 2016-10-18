package com.JES.action;

import com.JES.model.Agent;
import com.JES.service.ManagerService;
import com.opensymphony.xwork2.ModelDriven;

import freemarker.core.ReturnInstruction.Return;

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
	 * 
	 * @return
	 */
	public String searchAgent() {
		request.setAttribute("agentList", managerService.searchAgent(
				request.getParameter("searchType"),
				request.getParameter("searchValue")));
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
		session.setAttribute("agent", managerService.getAgentDAO().findById(uid));
		request.setAttribute("agent", managerService.getAgentDAO().findById(uid));
		return "toDelete";
	}

	public String delete() {
		managerService.getAgentDAO().delete(
				((Agent) session.getAttribute("agent")));
		return "agentDeleteSuccess";
	}

	public String change() {
		agent.setUid(request.getParameter("uid"));

		if (managerService.isExistAgent(agent)) {
			request.setAttribute("info", "账号已存在。");
			return "agentChangeFaild";
		}

		String role = request.getParameter("selectRole");
		if ("班主任".equals(role)) {
			agent.setRole("班主任");
		} else if ("超级班主任".equals(role)) {
			agent.setRole("超级班主任");
		}

		request.setAttribute("agent", agent);
		managerService.changeAgent(agent);
		return "agentChangeSuccess";
	}
	
	/**
	 * 查找班主任。
	 * @return
	 */
	public String searchCommonAgents() {
		request.setAttribute("agentList", managerService.searchCommonAgent(request.getParameter("searchType"),
				request.getParameter("searchValue")));
		request.setAttribute("i", 0);
		return "returnCommonAgent";
	}
	
	/**
	 * 显示所有班主任。
	 * @return
	 */
	public String displayCommonAgents() {
		request.setAttribute("agentList", managerService.getAgentDAO().findByRole("班主任"));
		request.setAttribute("i", 0);
		return "returnCommonAgent";
	}
	
	/**
	 * 查找班主任。
	 * @return
	 */
	public String searchSuperAgents() {
		request.setAttribute("agentList", managerService.searchSuperAgent(request.getParameter("searchType"),
				request.getParameter("searchValue")));
		request.setAttribute("i", 0);
		return "returnCommonAgent";
	}
	
	/**
	 * 显示所有超级班主任。
	 * @return
	 */
	public String displaySuperAgents() {
		session.setAttribute("checkCommonAgents",
				request.getParameterValues("check"));
		
		request.setAttribute("agentList", managerService.getAgentDAO().findByRole("超级班主任"));
		request.setAttribute("i", 0);
		return "returnCommonAgent";
	}
	
	/**
	 * 划分班主任。
	 * @return
	 */
	public String divideAgent() {
		return "divideAgentSuccess";
	}

	@Override
	public Agent getModel() {

		if (agent == null) {
			agent = new Agent();
		}

		return agent;
	}

}

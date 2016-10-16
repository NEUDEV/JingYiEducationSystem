package com.JES.action;

import com.JES.model.Agent;
import com.JES.service.AgentService;
import com.opensymphony.xwork2.ModelDriven;

public class AgentLoginAndInfoAction extends SuperAction implements
		ModelDriven<Agent> {

	private Agent agent;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AgentService agentservice;

	public AgentService getAgentservice() {
		return agentservice;
	}

	public void setAgentservice(AgentService agentservice) {
		this.agentservice = agentservice;
	}

	/**
	 * 管理员登陆。
	 * 
	 * @return
	 */
	public String login() {
		if (agentservice.isLoginSuccess(agent)) {
			session.setAttribute("agentID", ((Agent) agentservice.getAgentDAO()
					.findByAname(agent.getAname()).get(0)).getUid());
			return "agentLoginSuccess";
		}

		request.setAttribute("info", "用户名或密码错误！");
		return "agentLoginFailed";
	}

	public String changePassword() {
		agent.setUid(session.getAttribute("agentID").toString());
		String chPassword = request.getParameter("chPassword");
		String confirmPassword = request.getParameter("confirmPassword");

		if (!agent.getPassword().equals(
				agentservice.getAgentDAO().findById(agent.getUid())
						.getPassword())) {
			request.setAttribute("info", "原密码不正确");
		} else if (!chPassword.equals(confirmPassword)) {
			request.setAttribute("info", "两次密码不一致，请重新输入！");

		} else {
			agent = agentservice.getAgentDAO().findById(agent.getUid());
			agent.setPassword(chPassword);
			agentservice.getAgentDAO().merge(agent);
			return "changePasswordSuccess";
		}

		return "changePasswordFailed";

	}

	@Override
	public Agent getModel() {
		if (agent == null) {
			agent = new Agent();
		}

		return agent;
	}

}

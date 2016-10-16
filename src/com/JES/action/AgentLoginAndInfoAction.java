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

	/**
	 * 获取Agent信息。
	 * 
	 * @return
	 */
	public String getAgentInfo() {
		agent = agentservice.getAgentDAO().findById(
				session.getAttribute("agentID").toString());
		session.setAttribute("agent", agent);
		request.setAttribute("agent", agent);
		return "returnAgentInfo";
	}

	/**
	 * 更改代理商信息。
	 * @return
	 */
	public String changeAgentInfo() {
		Agent oldAgent = (Agent) session.getAttribute("agent");

		if (!"".equals(agent.getAname())) {
			oldAgent.setAname(agent.getAname());
		}

		if (!"".equals(agent.getName())) {
			oldAgent.setName(agent.getName());
		}

		if (!"".equals(agent.getQq())) {
			oldAgent.setQq(agent.getQq());
		}

		if (!"".equals(agent.getPhone())) {
			oldAgent.setPhone(agent.getPhone());
		}

		if (!"".equals(agent.getAccount())) {
			oldAgent.setAccount(agent.getAccount());
		}

		if (!"".equals(agent.getIdcard())) {
			oldAgent.setIdcard(agent.getIdcard());
		}

		if (!"".equals(agent.getBank())) {
			oldAgent.setBank(agent.getBank());
		}
		
		agentservice.getAgentDAO().merge(oldAgent);
		
		return "changeAgentInfo";
	}

	@Override
	public Agent getModel() {
		if (agent == null) {
			agent = new Agent();
		}

		return agent;
	}

}

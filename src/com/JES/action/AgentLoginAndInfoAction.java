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
	 * ����Ա��½��
	 * 
	 * @return
	 */
	public String login() {
		if (agentservice.isLoginSuccess(agent)) {
			session.setAttribute("agentID", ((Agent) agentservice.getAgentDAO()
					.findByAname(agent.getAname()).get(0)).getUid());
			return "agentLoginSuccess";
		}

		request.setAttribute("info", "�û������������");
		return "agentLoginFailed";
	}

	public String changePassword() {
		agent.setUid(session.getAttribute("agentID").toString());
		String chPassword = request.getParameter("chPassword");
		String confirmPassword = request.getParameter("confirmPassword");

		if (!agent.getPassword().equals(
				agentservice.getAgentDAO().findById(agent.getUid())
						.getPassword())) {
			request.setAttribute("info", "ԭ���벻��ȷ");
		} else if (!chPassword.equals(confirmPassword)) {
			request.setAttribute("info", "�������벻һ�£����������룡");

		} else {
			agent = agentservice.getAgentDAO().findById(agent.getUid());
			agent.setPassword(chPassword);
			agentservice.getAgentDAO().merge(agent);
			return "changePasswordSuccess";
		}

		return "changePasswordFailed";

	}

	/**
	 * ��ȡAgent��Ϣ��
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
	 * ���Ĵ�������Ϣ��
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

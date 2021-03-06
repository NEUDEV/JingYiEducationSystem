package com.JES.action;

import java.util.ArrayList;
import java.util.UUID;

import com.JES.model.Agent;
import com.JES.model.Report;
import com.JES.model.Student;
import com.JES.service.ManagerService;
import com.opensymphony.xwork2.ModelDriven;

import freemarker.core.ReturnInstruction.Return;

/**
 * 管理员管理班主任类。
 * @author 刘鑫伟
 *
 */
public class ManagerAgentManageAction extends SuperAction implements
		ModelDriven<Agent> {

	private static final long serialVersionUID = 1L;
	private Agent agent;
	private ManagerService managerService;
	private String result;

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * 班主任注册。
	 * @return
	 */
	public String register() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

		result = managerService.agentRegister(agent,
				request.getParameter("confirmPassword"));
		System.out.println(result);
		return "agentReigster";
	}

	/**
	 * 查询班主任。
	 * 
	 * @return
	 */
	public String searchAgent() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

		request.setAttribute("agentList", managerService.searchAgent(
				request.getParameter("searchType"),
				request.getParameter("searchValue")));
		return "agentsDisplay";
	}

	/**
	 * 修改班主任预处理。
	 * 
	 * @return
	 */
	public String toChange() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

		String uid = request.getParameter("uid");
		session.setAttribute("uid", uid);

		return "toChange";
	}

	/**
	 * 查看班主任。
	 * 
	 * @return
	 */
	public String toDisplay() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

		String uid = request.getParameter("uid");
		request.setAttribute("agent", managerService.getAgentDAO()
				.findById(uid));
		return "toDisplay";
	}

	/**
	 * 删除班主任预处理。
	 * 
	 * @return
	 */
	public String toDelete() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

		String uid = request.getParameter("uid");
		session.setAttribute("uid", uid);
		session.setAttribute("agent", managerService.getAgentDAO()
				.findById(uid));
		request.setAttribute("agent", managerService.getAgentDAO()
				.findById(uid));
		return "toDelete";
	}

	/**
	 * 显示所有班主任。
	 * 
	 * @return
	 */
	public String display() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

		request.setAttribute("agentList", managerService.getAgents());
		return "agentsDisplay";
	}
	
	/**
	 * 班主任删除。
	 * @return
	 */
	public String delete() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

		managerService.deleteAgent((Agent) session.getAttribute("agent"));
		return "agentDeleteSuccess";
	}

	/**
	 * 班主任修改信息。
	 * @return
	 */
	public String change() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

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
	 * 修改密码。
	 * 
	 * @return
	 */
	public String changePassword() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

		String chPassword = request.getParameter("chPassword");
		String confirmPassword = request.getParameter("confirmPassword");
		if (!chPassword.equals(confirmPassword)) {
			request.setAttribute("info", "两次密码不一致，请重新输入！");

		} else {
			agent = managerService.getAgentDAO().findById(agent.getUid());
			agent.setPassword(chPassword);
			managerService.getAgentDAO().merge(agent);
			return toDisplay();
		}

		return "changePasswordFailed";
	}

	/**
	 * 查找班主任。
	 * 
	 * @return
	 */
	public String searchCommonAgents() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

		request.setAttribute(
				"agentList",
				managerService.searchCommonAgent(
						request.getParameter("searchType"),
						request.getParameter("searchValue")));
		request.setAttribute("i", 0);
		return "returnCommonAgent";
	}

	/**
	 * 显示所有班主任。
	 * 
	 * @return
	 */
	public String displayCommonAgents() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

		request.setAttribute("agentList", managerService.getAgentDAO()
				.findByRole("班主任"));
		request.setAttribute("i", 0);
		return "returnCommonAgent";
	}

	/**
	 * 查找班主任。
	 * 
	 * @return
	 */
	public String searchSuperAgents() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

		request.setAttribute(
				"agentList",
				managerService.searchSuperAgent(
						request.getParameter("searchType"),
						request.getParameter("searchValue")));
		request.setAttribute("i", 0);
		return "returnSuperAgent";
	}

	/**
	 * 显示所有超级班主任。
	 * 
	 * @return
	 */
	public String displaySuperAgents() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

		session.setAttribute("checkCommonAgents",
				request.getParameterValues("check"));

		request.setAttribute("agentList", managerService.getAgentDAO()
				.findByRole("超级班主任"));
		request.setAttribute("i", 0);
		return "returnSuperAgent";
	}

	/**
	 * 划分班主任。
	 * 
	 * @return
	 */
	public String divideAgent() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

		String superAgentID = request.getParameter("radio");
		String[] checkStudents = (String[]) session
				.getAttribute("checkCommonAgents");
		ArrayList<Agent> agentList = new ArrayList<Agent>();

		for (String uid : checkStudents) {
			agent = managerService.getAgentDAO().findById(uid);
			agent.setMannager(superAgentID);
			managerService.getAgentDAO().merge(agent);
			agentList.add(agent);
		}

		request.setAttribute("superAgent", managerService.getAgentDAO()
				.findById(superAgentID));
		request.setAttribute("agentList", agentList);
		request.setAttribute("i", 0);
		return "divideAgentSuccess";
	}

	/**
	 * 显示班主任下属学员。
	 * 
	 * @return
	 */
	public String displayStudentByAgent() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

		request.setAttribute("studentList", (ArrayList<Student>) managerService
				.getStudentDAO().findByMid(agent.getUid()));
		return "displayStudentByAgentSuccess";
	}

	@Override
	public Agent getModel() {

		if (agent == null) {
			agent = new Agent();
		}

		return agent;
	}

}

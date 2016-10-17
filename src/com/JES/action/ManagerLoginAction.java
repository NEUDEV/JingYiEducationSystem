package com.JES.action;

import com.JES.model.Manager;
import com.JES.service.ManagerService;
import com.opensymphony.xwork2.ModelDriven;

public class ManagerLoginAction extends SuperAction implements
		ModelDriven<Manager> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Manager manager;
	private ManagerService managerService;

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

	/**
	 * 管理员登陆。
	 * 
	 * @return
	 */
	public String login() {
		if (managerService.isLoginSuccess(manager)) {
			session.setAttribute(
					"managerId",
					((Manager) managerService.getManagerDAO()
							.findByMname(manager.getMname()).get(0)).getUid());
			return "managerLoginSuccess";
		}

		request.setAttribute("info", "用户名或密码错误！");
		return "managerLoginFailed";
	}

	@Override
	public Manager getModel() {

		if (manager == null) {
			manager = new Manager();
		}

		return manager;
	}

}

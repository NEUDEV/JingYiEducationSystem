package com.JES.action;

import com.JES.model.Manager;
import com.opensymphony.xwork2.ModelDriven;

public class ManagerLoginAction extends SuperAction implements
		ModelDriven<Manager> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Manager manager;

	public String login() {
		if (manager.getMname().equals("1") && manager.getPassword().equals("2")) {
			return "managerLoginSuccess";
		} 
		
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

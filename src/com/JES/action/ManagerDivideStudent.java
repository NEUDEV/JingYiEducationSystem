package com.JES.action;

import com.JES.model.Manager;
import com.JES.service.ManagerService;
import com.opensymphony.xwork2.ModelDriven;

public class ManagerDivideStudent extends SuperAction implements
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
	
	public String display() {
		request.setAttribute("studentList", managerService.getJingyiStudents());
		
		return "studentsDisplay";
	}

	@Override
	public Manager getModel() {

		if (manager == null) {
			manager = new Manager();
		}

		return manager;
	}
}

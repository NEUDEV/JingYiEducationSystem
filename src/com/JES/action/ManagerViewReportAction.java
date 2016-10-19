package com.JES.action;

import com.JES.service.ManagerService;

public class ManagerViewReportAction extends SuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ManagerService managerService;

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

	public String displayReport() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}
		
		request.setAttribute("report", managerService.dealWithReport(session
				.getAttribute("managerId").toString()));

		return "displayReport";
	}

}

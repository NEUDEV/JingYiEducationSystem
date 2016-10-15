package com.JES.action;

import com.JES.model.Student;
import com.JES.service.ManagerService;
import com.opensymphony.xwork2.ModelDriven;

public class ManagerDivideStudentAction extends SuperAction implements
		ModelDriven<Student> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Student student;
	private ManagerService managerService;

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

	public String display() {
		request.setAttribute("studentList", managerService.getJingyiStudents());

		return "studentsDisplay";
	}

	/**
	 * 查询鲸艺学员。
	 * 
	 * @return
	 */
	public String searchStudent() {
		request.setAttribute("studentList", managerService.searchJingyiStudent(
				request.getParameter("searchType"),
				request.getParameter("searchValue")));
		return "studentsDisplay";
	}

	/**
	 * 获取鲸艺学员。
	 * @return
	 */
	public String selectJingyiStudent() {
		session.setAttribute("JingYiStudents",
				request.getParameterValues("check"));
		request.setAttribute("firstLevelAgents", managerService.searchAgent("代理商类别", "1级代理商"));
		return "firstLevelAgentDisplay";
	}
	
	public String searchFirstLevelAgent() {
		request.setAttribute("firstLevelAgents", managerService.searchFirstLevelAgents(
				request.getParameter("searchType"),
				request.getParameter("searchValue")));
		
		return "firstLevelAgentDisplay";
	}
	
	public String divideJingyiToFirstLevelAgent() {
		String firstLevelAgent = request.getParameter("radio");
		String[] JingYiStudents = (String[])session.getAttribute("JingYiStudents");
		
		for (String uid : JingYiStudents) {
			student = managerService.findStudentByID(uid);
			student.setMid(firstLevelAgent);
			student.setMsign("1级代理商");
			managerService.updateStudent(student);
		}
		
		return "divideStudentSuccess";
	}

	@Override
	public Student getModel() {

		if (student == null) {
			student = new Student();
		}

		return student;
	}
}

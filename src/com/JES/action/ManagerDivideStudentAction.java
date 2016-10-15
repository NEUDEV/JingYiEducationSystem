package com.JES.action;

import com.JES.dao.StudentDAO;
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
	private StudentDAO studentDAO;

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
	
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
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
		request.setAttribute("firstLevelAgents", managerService.search("代理商类别", "一级代理商"));
		return "firstLevelAgentDisplay";
	}
	
	public String divideJingyiToFirstLevelAgent() {
		String firstLevelAgent = request.getParameter("radio");
		String[] JingYiStudents = (String[])session.getAttribute("JingYiStudents");
		
		for (String uid : JingYiStudents) {
			student = studentDAO.findById(uid);
			student.setMid(firstLevelAgent);
			student.setMsign("一级代理商");
			studentDAO.merge(student);
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

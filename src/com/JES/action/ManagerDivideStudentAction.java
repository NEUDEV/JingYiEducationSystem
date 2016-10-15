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
	 * ��ѯ����ѧԱ��
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
	 * ��ȡ����ѧԱ��
	 * @return
	 */
	public String selectJingyiStudent() {
		session.setAttribute("JingYiStudents",
				request.getParameterValues("check"));
		request.setAttribute("firstLevelAgents", managerService.search("���������", "һ��������"));
		return "firstLevelAgentDisplay";
	}
	
	public String divideJingyiToFirstLevelAgent() {
		String firstLevelAgent = request.getParameter("radio");
		String[] JingYiStudents = (String[])session.getAttribute("JingYiStudents");
		
		for (String uid : JingYiStudents) {
			student = studentDAO.findById(uid);
			student.setMid(firstLevelAgent);
			student.setMsign("һ��������");
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

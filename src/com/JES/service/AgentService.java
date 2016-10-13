package com.JES.service;


import java.util.ArrayList;
import java.util.List;

import com.JES.dao.AgentDAO;
import com.JES.dao.StudentDAO;
import com.JES.model.Student;

public class AgentService {
	private AgentDAO agentdao;
	private StudentDAO StudentDAO;

	public AgentDAO getAgentdao() {
		return agentdao;
	}

	public void setAgentdao(AgentDAO agentdao) {
		this.agentdao = agentdao;
	}
	
	public StudentDAO getStudentdao() {
		return StudentDAO;
	}

	public void setStudentdao(StudentDAO StudentDAO) {
		this.StudentDAO = StudentDAO;
	}

	public List<Student> searchStudents(String type,String value){
//		List<Student> listofstudent = new ArrayList<Student>();
//		if((listofstudent=StudentDAO.searchStudent(type,value))!=null) 
//			return listofstudent;
		return null;
	}
}

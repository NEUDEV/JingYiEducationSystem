package com.JES.service;


import java.util.ArrayList;
import java.util.List;

import com.JES.dao.Agentdao;
import com.JES.dao.Studentdao;
import com.JES.model.Student;

public class AgentService {
	private Agentdao agentdao;
	private Studentdao studentdao;

	public Agentdao getAgentdao() {
		return agentdao;
	}

	public void setAgentdao(Agentdao agentdao) {
		this.agentdao = agentdao;
	}
	
	public Studentdao getStudentdao() {
		return studentdao;
	}

	public void setStudentdao(Studentdao studentdao) {
		this.studentdao = studentdao;
	}

	public List<Student> searchStudents(String type,String value){
		List<Student> listofstudent = new ArrayList<Student>();
		if((listofstudent=studentdao.searchStudent(type,value))!=null) 
			return listofstudent;
		return null;
	}
}

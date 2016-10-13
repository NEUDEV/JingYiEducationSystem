package com.JES.service;

import java.util.ArrayList;
import java.util.List;

import com.JES.dao.AgentDAO;
import com.JES.dao.StudentDAO;
import com.JES.model.Student;

public class AgentService {
	private AgentDAO agentdao;
	private StudentDAO studentDAO;

	public AgentDAO getAgentdao() {
		return agentdao;
	}

	public void setAgentdao(AgentDAO agentdao) {
		this.agentdao = agentdao;
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@SuppressWarnings("unchecked")
	public List<Student> searchStudents(String type, String value) {
		List<Student> slist = new ArrayList<Student>();
		switch (type) {
		case "ѧԱUID":Student student=studentDAO.findById(value);
			if(student!=null) slist.add(student);
			return slist;
		case "�û���":
			return (List<Student>) studentDAO.findByUname(value);
		case "��ʵ����":
			return (List<Student>) studentDAO.findByName(value);
		case "�ֻ���":
			return (List<Student>) studentDAO.findByPhone(value);
		case "QQ":
			return (List<Student>) studentDAO.findByQq(value);
		case "����":
			return (List<Student>) studentDAO.findByEmail(value);
		}
		return null;
	}

	public boolean addStudent(Student student) {
		Student stu = studentDAO.findById(student.getUid());
		if (stu == null) {
			studentDAO.save(student);
			return true;
		} else
			return false;
	}
}

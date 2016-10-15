package com.JES.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.JES.dao.AgentDAO;
import com.JES.dao.AgentNoteDAO;
import com.JES.dao.AgentupstudentDAO;
import com.JES.dao.StudentDAO;
import com.JES.model.AgentNote;
import com.JES.model.Agentupstudent;
import com.JES.model.Student;

import debug.AgentserviceImpl;

public class AgentService implements AgentserviceImpl{
	private AgentDAO agentDAO;
	private AgentupstudentDAO agentupstudentDAO;
	private StudentDAO studentDAO;
	private AgentNoteDAO agentnoteDAO;
	
	
	public AgentNoteDAO getAgentnoteDAO() {
		return agentnoteDAO;
	}

	public void setAgentnoteDAO(AgentNoteDAO agentnoteDAO) {
		this.agentnoteDAO = agentnoteDAO;
	}

	public AgentDAO getAgentDAO() {
		return agentDAO;
	}

	public void setAgentDAO(AgentDAO agentDAO) {
		this.agentDAO = agentDAO;
	}

	public AgentupstudentDAO getAgentupstudentDAO() {
		return agentupstudentDAO;
	}

	public void setAgentupstudentDAO(AgentupstudentDAO agentupstudentDAO) {
		this.agentupstudentDAO = agentupstudentDAO;
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
		case "学员UID":Student student=studentDAO.findById(value);
			if(student!=null) slist.add(student);
			return slist;
		case "真实姓名":
			return (List<Student>) studentDAO.findByName(value);
		case "手机号":
			return (List<Student>) studentDAO.findByPhone(value);
		case "QQ":
			return (List<Student>) studentDAO.findByQq(value);
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
	
	public boolean upPhoto(FileInputStream input,Integer length,Agentupstudent upstudent){
		byte[] bFile = new byte[length];
		try {
			input.read(bFile);
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		upstudent.setPhoto(bFile);
		agentupstudentDAO.save(upstudent);
		return true;
	}

	public boolean agentNote(String note){
		AgentNote agentnote=new AgentNote();
		Date nDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sDate = sdf.format(nDate);
		String noteid = UUID.randomUUID().toString();
		agentnote.setNote(note);
		agentnote.setNotetime(sDate);
		agentnote.setAgentid("代理商");
		agentnote.setNoteid(noteid);
		agentnoteDAO.save(agentnote);
		return true;
	}
}

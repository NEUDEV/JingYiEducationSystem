package com.JES.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.JES.dao.AgentDAO;
import com.JES.dao.AgentNoteDAO;
import com.JES.dao.AgentupstudentDAO;
import com.JES.dao.StudentDAO;
import com.JES.model.Agent;
import com.JES.model.AgentNote;
import com.JES.model.Agentupstudent;
import com.JES.model.Manager;
import com.JES.model.Student;


public class AgentService {
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
		case "学号":
			return (List<Student>) studentDAO.findByStuid(value);
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
	
	public boolean upPhoto(FileInputStream input,Integer length,
			Agentupstudent upstudent,Student student){
		byte[] bFile = new byte[length];
		try {
			input.read(bFile);
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date intime = new Date();
		student.setIntime(intime);
		student.setMark(1);   //设置转化指数
		student.setMid("001"); //设置代理商ID
		student.setMsign("001");
		student.setSfrom("群聊");
		student.setSign("未审核");
		upstudent.setPhoto(bFile);
		agentupstudentDAO.save(upstudent);
		studentDAO.save(student);
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
		agentnote.setAgentid("代理商");//getSession
		agentnote.setNoteid(noteid);
		agentnoteDAO.save(agentnote);
		return true;
	}
	
	public void shoeView(String qq){
		HttpServletResponse response = null;
        ServletOutputStream out = null;
        Agentupstudent agentupstudent=new Agentupstudent();
        try {
            response = ServletActionContext.getResponse();
            response.setContentType("multipart/form-data");
            out = response.getOutputStream();
            agentupstudent = agentupstudentDAO.findById(qq);
            out.write(agentupstudent.getPhoto()); //换成你自己的图片byte[] 数据就行.
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
	}

	public boolean isLoginSuccess(Agent agent) {
		List resultList = agentDAO.findByAname(agent.getAname());

		if (resultList.size() != 0) {
			Agent result = (Agent) resultList.get(0);

			if (agent.getAname().equals(result.getAname())
					&& agent.getPassword().equals(result.getPassword())) {
				return true;
			}
		}

		return false;
	}
	
}

package com.JES.service;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

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

/*	public Student searchStudents(String type,String value){
		switch(type){
		case "�û�UID":;break;
		case "�û���":;break;
		case "��ʵ����":;break;
		case "�ֻ���":;break;
		case "QQ":;break;
		case "����":;break;
		}
	}*/
}

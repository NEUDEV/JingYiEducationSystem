package com.JES.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.JES.dao.AgentDAO;
import com.JES.dao.ManagerDAO;
import com.JES.dao.StudentDAO;
import com.JES.model.Agent;
import com.JES.model.Manager;
import com.JES.model.Student;

public class ManagerService {
	private ManagerDAO managerDAO;
	private AgentDAO agentDAO;
	private StudentDAO studentDAO;

	public ManagerDAO getManagerDAO() {
		return managerDAO;
	}

	public void setManagerDAO(ManagerDAO managerDAO) {
		this.managerDAO = managerDAO;
	}

	public AgentDAO getAgentDAO() {
		return agentDAO;
	}

	public void setAgentDAO(AgentDAO agentDAO) {
		this.agentDAO = agentDAO;
	}
	
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	/**
	 * �Ƿ��½�ɹ���
	 * 
	 * @param manager
	 *            ����Ա����
	 * @return �Ƿ��½�ɹ���
	 */
	public boolean isLoginSuccess(Manager manager) {
		List resultList = managerDAO.findByMname(manager.getMname());

		if (resultList.size() != 0) {
			Manager result = (Manager) resultList.get(0);

			if (manager.getMname().equals(result.getMname())
					&& manager.getPassword().equals(result.getPassword())) {
				return true;
			}
		}

		return false;
	}

	/**
	 * �Ƿ���ڴ����̡�
	 * 
	 * @param agent
	 *            �����̶���
	 * @return
	 */
	public boolean isExistAgent(Agent agent) {
		List results = agentDAO.findByAname(agent.getAname());

		if (results.size() != 0) {
			
			Agent a = (Agent)results.get(0);
			if (agent.getUid().equals(a.getUid())) {
				return false;
			}
			
			return true;
		}

		return false;
	}

	/**
	 * ������ע�ᡣ
	 * 
	 * @param agent
	 */
	public void agentRegister(Agent agent) {
		String uid = UUID.randomUUID().toString();
		agent.setUid(uid);
		agentDAO.save(agent);
	}

	public ArrayList<Agent> getAgents() {
		return (ArrayList<Agent>) agentDAO.findAll();
	}
	
	public ArrayList<Student> getJingyiStudents() {
		ArrayList<Student> students = new ArrayList<Student>();
		
//		students = (ArrayList<Student>) studentDAO.
		
		return students;
	}

	public ArrayList<Agent> search(String searchType, String searchValue) {
		
		if ("�˻���".equals(searchType)) {
			return (ArrayList<Agent>)agentDAO.findByAname(searchValue);
		} else if ("����".equals(searchType)) {
			return (ArrayList<Agent>)agentDAO.findByName(searchValue);
		} else if ("�ֻ���".equals(searchType)) {
			return (ArrayList<Agent>)agentDAO.findByPhone(searchValue);
		} else if ("QQ".equals(searchType)) {
			return (ArrayList<Agent>)agentDAO.findByQq(searchValue);
		}
		
		return new ArrayList<Agent>();
	}
	
	public Agent getAgentByID(String uid) {
		return agentDAO.findById(uid);
	}
	
	public void deleteAgent(Agent agent) {
		agentDAO.delete(agent);
	}
	
	public void changeAgent(Agent agent) {
		agentDAO.merge(agent);
	}

}

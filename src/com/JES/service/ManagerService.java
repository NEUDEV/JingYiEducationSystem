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
	 * 是否登陆成功。
	 * 
	 * @param manager
	 *            管理员对象。
	 * @return 是否登陆成功。
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
	 * 是否存在代理商。
	 * 
	 * @param agent
	 *            代理商对象。
	 * @return
	 */
	public boolean isExistAgent(Agent agent) {
		List results = agentDAO.findByAname(agent.getAname());

		if (results.size() != 0) {

			Agent a = (Agent) results.get(0);
			if (agent.getUid().equals(a.getUid())) {
				return false;
			}

			return true;
		}

		return false;
	}

	/**
	 * 代理商注册。
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

		students = (ArrayList<Student>) studentDAO.findByMsign("鲸艺代理商");

		return students;
	}

	/**
	 * 查找代理商。
	 * @param searchType
	 * @param searchValue
	 * @return
	 */
	public ArrayList<Agent> searchAgent(String searchType, String searchValue) {

		if ("账户名".equals(searchType)) {
			return (ArrayList<Agent>) agentDAO.findByAname(searchValue);
		} else if ("姓名".equals(searchType)) {
			return (ArrayList<Agent>) agentDAO.findByName(searchValue);
		} else if ("手机号".equals(searchType)) {
			return (ArrayList<Agent>) agentDAO.findByPhone(searchValue);
		} else if ("QQ".equals(searchType)) {
			return (ArrayList<Agent>) agentDAO.findByQq(searchValue);
		} else if ("代理商类别".equals(searchType)) {
			return (ArrayList<Agent>) agentDAO.findByRole(searchValue);
		}

		return new ArrayList<Agent>();
	}
	
	/**
	 * 查找一级代理商。
	 * @param searchType
	 * @param searchValue
	 * @return
	 */
	public ArrayList<Agent> searchFirstLevelAgents(String searchType, String searchValue) {
		if ("账户名".equals(searchType)) {
			return (ArrayList<Agent>) agentDAO.findFirstLevelAgentsByAname(searchValue);
		} else if ("姓名".equals(searchType)) {
			return (ArrayList<Agent>) agentDAO.findFirstLevelAgentsByName(searchValue);
		} else if ("手机号".equals(searchType)) {
			return (ArrayList<Agent>) agentDAO.findFirstLevelAgentsByPhone(searchValue);
		} else if ("QQ".equals(searchType)) {
			return (ArrayList<Agent>) agentDAO.findFirstLevelAgentsByQq(searchValue);
		} 

		return new ArrayList<Agent>();
	}

	public ArrayList<Student> searchJingyiStudent(String searchType, String searchValue) {
		if ("UID".equals(searchType)) {
			ArrayList<Student> students = new ArrayList<Student>();
			Student student = studentDAO.findById(searchValue);
			if ((student != null) && "鲸艺代理商".equals(student.getMsign())) {
				students.add(student);
			}
			return students;
		} else if ("姓名".equals(searchType)) {
			return (ArrayList<Student>) studentDAO.findJingYiByName(searchValue);
		} else if ("手机号".equals(searchType)) {
			return (ArrayList<Student>) studentDAO.findJingYiByPhone(searchValue);
		} else if ("QQ".equals(searchType)) {
			return (ArrayList<Student>) studentDAO.findJingYiByQq(searchValue);
		}

		return new ArrayList<Student>();
	}
	
	public Student findStudentByID(String id) {
		return studentDAO.findById(id);
	}
	
	public void updateStudent(Student student) {
		studentDAO.merge(student);
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

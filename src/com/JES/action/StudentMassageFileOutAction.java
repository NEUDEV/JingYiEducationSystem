package com.JES.action;

import com.JES.service.AgentService;

public class StudentMassageFileOutAction {
	private AgentService agentservice;

	public AgentService getAgentservice() {
		return agentservice;
	}

	public void setAgentservice(AgentService agentservice) {
		this.agentservice = agentservice;
	}
	public String massageout()
    {
        try {
        	agentservice.studentmsout();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("导出数据有误");
        }
        return null;
    }
     
}

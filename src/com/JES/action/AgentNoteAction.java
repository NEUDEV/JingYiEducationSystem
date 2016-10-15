package com.JES.action;

import java.util.Date;

import com.JES.service.AgentService;

public class AgentNoteAction {
	private String note;
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String agentnote(){
		AgentService agentservice=new AgentService();
		agentservice.agentNote(note);
		return "success";
	}
}

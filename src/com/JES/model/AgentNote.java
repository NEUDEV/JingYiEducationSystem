package com.JES.model;

import java.util.Date;

/**
 * AgentNote entity. @author MyEclipse Persistence Tools
 */

public class AgentNote implements java.io.Serializable {

	// Fields

	private String noteid;
	private Date notetime;
	private String note;
	private Date warntime;
	private String agentid;

	// Constructors

	/** default constructor */
	public AgentNote() {
	}

	/** minimal constructor */
	public AgentNote(String noteid) {
		this.noteid = noteid;
	}

	/** full constructor */
	public AgentNote(String noteid, Date notetime, String note, Date warntime,
			String agentid) {
		this.noteid = noteid;
		this.notetime = notetime;
		this.note = note;
		this.warntime = warntime;
		this.agentid = agentid;
	}

	// Property accessors

	public String getNoteid() {
		return this.noteid;
	}

	public void setNoteid(String noteid) {
		this.noteid = noteid;
	}

	public Date getNotetime() {
		return this.notetime;
	}

	public void setNotetime(Date notetime) {
		this.notetime = notetime;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getWarntime() {
		return this.warntime;
	}

	public void setWarntime(Date warntime) {
		this.warntime = warntime;
	}

	public String getAgentid() {
		return this.agentid;
	}

	public void setAgentid(String agentid) {
		this.agentid = agentid;
	}

}
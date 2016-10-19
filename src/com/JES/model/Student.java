package com.JES.model;

import java.util.Date;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private String uid;
	private String msign;
	private String name;
	private String phone;
	private String qq;
	private String weixin;
	private String mid;
	private String sign;
	private String stuid;
	private String sfrom;
	private Integer mark;
	private String intime;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(String uid) {
		this.uid = uid;
	}

	/** full constructor */
	public Student(String uid, String msign, String name, String phone,
			String qq, String weixin, String mid, String sign, String stuid,
			String sfrom, Integer mark, String intime) {
		this.uid = uid;
		this.msign = msign;
		this.name = name;
		this.phone = phone;
		this.qq = qq;
		this.weixin = weixin;
		this.mid = mid;
		this.sign = sign;
		this.stuid = stuid;
		this.sfrom = sfrom;
		this.mark = mark;
		this.intime = intime;
	}

	// Property accessors

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		if(uid==null) this.uid="";
		else this.uid = uid;
	}

	public String getMsign() {
		return this.msign;
	}

	public void setMsign(String msign) {
		if(msign==null) this.msign="";
		else this.msign = msign;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		if(name==null) this.name="";
		else this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		if(phone==null) this.phone="";
		else this.phone = phone;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		if(qq==null) this.qq="";
		else this.qq = qq;
	}

	public String getWeixin() {
		return this.weixin;
	}

	public void setWeixin(String weixin) {
		if(weixin==null) this.weixin="";
		else this.weixin = weixin;
	}

	public String getMid() {
		return this.mid;
	}

	public void setMid(String mid) {
		if(mid==null) this.mid="";
		else this.mid = mid;
	}

	public String getSign() {
		return this.sign;
	}

	public void setSign(String sign) {
		if(sign==null) this.sign="";
		else this.sign = sign;
	}

	public String getStuid() {
		return this.stuid;
	}

	public void setStuid(String stuid) {
		if(stuid==null) this.stuid="";
		else this.stuid = stuid;
	}

	public String getSfrom() {
		return this.sfrom;
	}

	public void setSfrom(String sfrom) {
		if(sfrom==null) this.sfrom="";
		else this.sfrom = sfrom;
	}

	public Integer getMark() {
		return this.mark;
	}

	public void setMark(Integer mark) {
		if(mark==null) this.mark=1;
		else this.mark = mark;
	}

	public String getIntime() {
		return this.intime;
	}

	public void setIntime(String intime) {
		if(intime==null) this.intime="";
		else this.intime = intime;
	}

}
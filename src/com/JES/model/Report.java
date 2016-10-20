package com.JES.model;

/**
 * Report entity. @author MyEclipse Persistence Tools
 */

public class Report implements java.io.Serializable {

	// Fields

	private String reportid;
	private Integer informalstu;
	private Integer platestu;
	private Integer typefacestu;
	private Integer brandstu;
	private Integer fullstu;
	private Integer illustration;
	private Integer onlinestu;
	private Integer lifetimestu;
	private Double transrate;
	private String role;
	private Integer allinnum;
	private Double allbills;

	// Constructors

	/** default constructor */
	public Report() {
	}

	/** minimal constructor */
	public Report(String reportid) {
		this.reportid = reportid;
	}

	/** full constructor */
	public Report(String reportid, Integer informalstu, Integer platestu,
			Integer typefacestu, Integer brandstu, Integer fullstu,
			Integer illustration, Integer onlinestu, Integer lifetimestu,
			Double transrate, String role, Integer allinnum, Double allbills) {
		this.reportid = reportid;
		this.informalstu = informalstu;
		this.platestu = platestu;
		this.typefacestu = typefacestu;
		this.brandstu = brandstu;
		this.fullstu = fullstu;
		this.illustration = illustration;
		this.onlinestu = onlinestu;
		this.lifetimestu = lifetimestu;
		this.transrate = transrate;
		this.role = role;
		this.allinnum = allinnum;
		this.allbills = allbills;
	}

	// Property accessors

	public String getReportid() {
		return this.reportid;
	}

	public void setReportid(String reportid) {
		this.reportid = reportid;
	}

	public Integer getInformalstu() {
		return this.informalstu;
	}

	public void setInformalstu(Integer informalstu) {
		this.informalstu = informalstu;
	}

	public Integer getPlatestu() {
		return this.platestu;
	}

	public void setPlatestu(Integer platestu) {
		this.platestu = platestu;
	}

	public Integer getTypefacestu() {
		return this.typefacestu;
	}

	public void setTypefacestu(Integer typefacestu) {
		this.typefacestu = typefacestu;
	}

	public Integer getBrandstu() {
		return this.brandstu;
	}

	public void setBrandstu(Integer brandstu) {
		this.brandstu = brandstu;
	}

	public Integer getFullstu() {
		return this.fullstu;
	}

	public void setFullstu(Integer fullstu) {
		this.fullstu = fullstu;
	}

	public Integer getIllustration() {
		return this.illustration;
	}

	public void setIllustration(Integer illustration) {
		this.illustration = illustration;
	}

	public Integer getOnlinestu() {
		return this.onlinestu;
	}

	public void setOnlinestu(Integer onlinestu) {
		this.onlinestu = onlinestu;
	}

	public Integer getLifetimestu() {
		return this.lifetimestu;
	}

	public void setLifetimestu(Integer lifetimestu) {
		this.lifetimestu = lifetimestu;
	}

	public Double getTransrate() {
		return this.transrate;
	}

	public void setTransrate(Double transrate) {
		this.transrate = transrate;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getAllinnum() {
		return this.allinnum;
	}

	public void setAllinnum(Integer allinnum) {
		this.allinnum = allinnum;
	}

	public Double getAllbills() {
		return this.allbills;
	}

	public void setAllbills(Double allbills) {
		this.allbills = allbills;
	}

}
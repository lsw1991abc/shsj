package com.lssrc.cms.entity;


public class Job {
    private String jId;

    private String jTitle;

    private String jOrganizer;

    private String jBelong;

    private String jType;

    private Integer jNumber;

    private Integer jNumberReady;

    private Integer jNumberLimit;

    private String jWorkPlace;

    private String jWorkTime;

    private String jSalary;

    private String jSalaryType;

    private String jContact;

    private String jAuditionTime;

    private String jDatetimeEnd;

    private String jAuditionPlace;

    private String jDatetimeBuild;

    private Integer isdeled;

    private String jContent;
    
    private String jBuilder;

    public String getjId() {
        return jId;
    }

    public void setjId(String jId) {
        this.jId = jId == null ? null : jId.trim();
    }

    public String getjTitle() {
        return jTitle;
    }

    public void setjTitle(String jTitle) {
        this.jTitle = jTitle == null ? null : jTitle.trim();
    }

    public String getjOrganizer() {
        return jOrganizer;
    }

    public void setjOrganizer(String jOrganizer) {
        this.jOrganizer = jOrganizer == null ? null : jOrganizer.trim();
    }

    public String getjBelong() {
        return jBelong;
    }

    public void setjBelong(String jBelong) {
        this.jBelong = jBelong == null ? null : jBelong.trim();
    }

    public String getjType() {
        return jType;
    }

    public void setjType(String jType) {
        this.jType = jType == null ? null : jType.trim();
    }

    public Integer getjNumber() {
        return jNumber;
    }

    public void setjNumber(Integer jNumber) {
        this.jNumber = jNumber;
    }

    public Integer getjNumberReady() {
        return jNumberReady;
    }

    public void setjNumberReady(Integer jNumberReady) {
        this.jNumberReady = jNumberReady;
    }

    public Integer getjNumberLimit() {
        return jNumberLimit;
    }

    public void setjNumberLimit(Integer jNumberLimit) {
        this.jNumberLimit = jNumberLimit;
    }

    public String getjWorkPlace() {
        return jWorkPlace;
    }

    public void setjWorkPlace(String jWorkPlace) {
        this.jWorkPlace = jWorkPlace == null ? null : jWorkPlace.trim();
    }

    public String getjWorkTime() {
        return jWorkTime;
    }

    public void setjWorkTime(String jWorkTime) {
        this.jWorkTime = jWorkTime == null ? null : jWorkTime.trim();
    }

    public String getjSalary() {
        return jSalary;
    }

    public void setjSalary(String jSalary) {
        this.jSalary = jSalary == null ? null : jSalary.trim();
    }

    public String getjSalaryType() {
        return jSalaryType;
    }

    public void setjSalaryType(String jSalaryType) {
        this.jSalaryType = jSalaryType == null ? null : jSalaryType.trim();
    }

    public String getjContact() {
        return jContact;
    }

    public void setjContact(String jContact) {
        this.jContact = jContact == null ? null : jContact.trim();
    }

    public String getjAuditionTime() {
        return jAuditionTime;
    }

    public void setjAuditionTime(String jAuditionTime) {
        this.jAuditionTime = jAuditionTime == null ? null : jAuditionTime.trim();
    }

    public String getjDatetimeEnd() {
        return jDatetimeEnd;
    }

    public void setjDatetimeEnd(String jDatetimeEnd) {
        this.jDatetimeEnd = jDatetimeEnd;
    }

    public String getjAuditionPlace() {
        return jAuditionPlace;
    }

    public void setjAuditionPlace(String jAuditionPlace) {
        this.jAuditionPlace = jAuditionPlace == null ? null : jAuditionPlace.trim();
    }

    public String getjDatetimeBuild() {
        return jDatetimeBuild;
    }

    public void setjDatetimeBuild(String jDatetimeBuild) {
        this.jDatetimeBuild = jDatetimeBuild;
    }

    public Integer getIsdeled() {
        return isdeled;
    }

    public void setIsdeled(Integer isdeled) {
        this.isdeled = isdeled;
    }

    public String getjContent() {
        return jContent;
    }

    public void setjContent(String jContent) {
        this.jContent = jContent == null ? null : jContent.trim();
    }

	public String getjBuilder() {
		return jBuilder;
	}

	public void setjBuilder(String jBuilder) {
		this.jBuilder = jBuilder;
	}
}
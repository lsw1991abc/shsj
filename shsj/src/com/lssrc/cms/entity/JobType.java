package com.lssrc.cms.entity;

public class JobType {
    private String jtId;

    private String jtName;

    public String getJtId() {
        return jtId;
    }

    public void setJtId(String jtId) {
        this.jtId = jtId == null ? null : jtId.trim();
    }

    public String getJtName() {
        return jtName;
    }

    public void setJtName(String jtName) {
        this.jtName = jtName == null ? null : jtName.trim();
    }
}
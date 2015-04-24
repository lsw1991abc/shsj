package com.lssrc.cms.entity;

public class JobBelong {
    private String jbId;

    private String jbName;

    public String getJbId() {
        return jbId;
    }

    public void setJbId(String jbId) {
        this.jbId = jbId == null ? null : jbId.trim();
    }

    public String getJbName() {
        return jbName;
    }

    public void setJbName(String jbName) {
        this.jbName = jbName == null ? null : jbName.trim();
    }
}
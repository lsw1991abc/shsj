package com.lssrc.cms.entity;

public class ActivitStatu {
    private Integer asId;

    private String asName;

    public Integer getAsId() {
        return asId;
    }

    public void setAsId(Integer asId) {
        this.asId = asId;
    }

    public String getAsName() {
        return asName;
    }

    public void setAsName(String asName) {
        this.asName = asName == null ? null : asName.trim();
    }
}
package com.lssrc.cms.entity;

public class Link {
    private String lId;

    private String lName;

    private Integer lSort;

    private String lParent;

    private Integer lType;

    private String lTarget;

    private String lUrl;

    public String getlId() {
        return lId;
    }

    public void setlId(String lId) {
        this.lId = lId == null ? null : lId.trim();
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName == null ? null : lName.trim();
    }

    public Integer getlSort() {
        return lSort;
    }

    public void setlSort(Integer lSort) {
        this.lSort = lSort;
    }

    public String getlParent() {
        return lParent;
    }

    public void setlParent(String lParent) {
        this.lParent = lParent == null ? null : lParent.trim();
    }

    public Integer getlType() {
        return lType;
    }

    public void setlType(Integer lType) {
        this.lType = lType;
    }

    public String getlTarget() {
        return lTarget;
    }

    public void setlTarget(String lTarget) {
        this.lTarget = lTarget == null ? null : lTarget.trim();
    }

    public String getlUrl() {
        return lUrl;
    }

    public void setlUrl(String lUrl) {
        this.lUrl = lUrl == null ? null : lUrl.trim();
    }
}
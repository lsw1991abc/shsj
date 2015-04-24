package com.lssrc.cms.entity;


public class Notice {
    private String nId;

    private String nTitle;

    private String nBuilder;

    private String nDatetimeBuild;

    private Integer nType;

    private Integer isdeled;

    private String nDesc;

    public String getnId() {
        return nId;
    }

    public void setnId(String nId) {
        this.nId = nId == null ? null : nId.trim();
    }

    public String getnTitle() {
        return nTitle;
    }

    public void setnTitle(String nTitle) {
        this.nTitle = nTitle == null ? null : nTitle.trim();
    }

    public String getnBuilder() {
        return nBuilder;
    }

    public void setnBuilder(String nBuilder) {
        this.nBuilder = nBuilder == null ? null : nBuilder.trim();
    }

    public String getnDatetimeBuild() {
        return nDatetimeBuild;
    }

    public void setnDatetimeBuild(String nDatetimeBuild) {
        this.nDatetimeBuild = nDatetimeBuild;
    }

    public Integer getnType() {
        return nType;
    }

    public void setnType(Integer nType) {
        this.nType = nType;
    }

    public Integer getIsdeled() {
        return isdeled;
    }

    public void setIsdeled(Integer isdeled) {
        this.isdeled = isdeled;
    }

    public String getnDesc() {
        return nDesc;
    }

    public void setnDesc(String nDesc) {
        this.nDesc = nDesc == null ? null : nDesc.trim();
    }
}
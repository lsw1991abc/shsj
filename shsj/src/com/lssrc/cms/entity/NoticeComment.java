package com.lssrc.cms.entity;

public class NoticeComment {
    private String ncId;

    private String nId;

    private String ncBuilder;

    private String ncDatetime;

    private String ncContent;

    public String getNcId() {
        return ncId;
    }

    public void setNcId(String ncId) {
        this.ncId = ncId == null ? null : ncId.trim();
    }

    public String getnId() {
        return nId;
    }

    public void setnId(String nId) {
        this.nId = nId == null ? null : nId.trim();
    }

    public String getNcBuilder() {
        return ncBuilder;
    }

    public void setNcBuilder(String ncBuilder) {
        this.ncBuilder = ncBuilder == null ? null : ncBuilder.trim();
    }

    public String getNcDatetime() {
        return ncDatetime;
    }

    public void setNcDatetime(String ncDatetime) {
        this.ncDatetime = ncDatetime == null ? null : ncDatetime.trim();
    }

    public String getNcContent() {
        return ncContent;
    }

    public void setNcContent(String ncContent) {
        this.ncContent = ncContent == null ? null : ncContent.trim();
    }
}
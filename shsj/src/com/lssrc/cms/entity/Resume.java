package com.lssrc.cms.entity;


public class Resume {
    private String rId;

    private String rName;

    private String rSex;

    private Integer rAge;

    private String rCollege;

    private String rMajor;

    private String rEntrance;

    private Double rHeight;

    private Double rWeight;

    private String rDatetimeUpdate;

    private String rQq;

    private String rPhoneno;

    private String rEmail;

    private String rPic;

    private Integer rHot;

    private Integer rShow;

    private String uId;
    
    private String rProfile;

    private String rExperience;

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId == null ? null : rId.trim();
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName == null ? null : rName.trim();
    }

    public String getrSex() {
        return rSex;
    }

    public void setrSex(String rSex) {
        this.rSex = rSex == null ? null : rSex.trim();
    }

    public Integer getrAge() {
        return rAge;
    }

    public void setrAge(Integer rAge) {
        this.rAge = rAge;
    }

    public String getrCollege() {
        return rCollege;
    }

    public void setrCollege(String rCollege) {
        this.rCollege = rCollege == null ? null : rCollege.trim();
    }

    public String getrMajor() {
        return rMajor;
    }

    public void setrMajor(String rMajor) {
        this.rMajor = rMajor == null ? null : rMajor.trim();
    }

    public String getrEntrance() {
        return rEntrance;
    }

    public void setrEntrance(String rEntrance) {
        this.rEntrance = rEntrance == null ? null : rEntrance.trim();
    }

    public Double getrHeight() {
        return rHeight;
    }

    public void setrHeight(Double rHeight) {
        this.rHeight = rHeight;
    }

    public Double getrWeight() {
        return rWeight;
    }

    public void setrWeight(Double rWeight) {
        this.rWeight = rWeight;
    }

    public String getrDatetimeUpdate() {
        return rDatetimeUpdate;
    }

    public void setrDatetimeUpdate(String rDatetimeUpdate) {
        this.rDatetimeUpdate = rDatetimeUpdate;
    }

    public String getrQq() {
        return rQq;
    }

    public void setrQq(String rQq) {
        this.rQq = rQq == null ? null : rQq.trim();
    }

    public String getrPhoneno() {
        return rPhoneno;
    }

    public void setrPhoneno(String rPhoneno) {
        this.rPhoneno = rPhoneno == null ? null : rPhoneno.trim();
    }

    public String getrEmail() {
        return rEmail;
    }

    public void setrEmail(String rEmail) {
        this.rEmail = rEmail == null ? null : rEmail.trim();
    }

    public String getrPic() {
        return rPic;
    }

    public void setrPic(String rPic) {
        this.rPic = rPic == null ? null : rPic.trim();
    }

    public Integer getrHot() {
        return rHot;
    }

    public void setrHot(Integer rHot) {
        this.rHot = rHot;
    }

    public Integer getrShow() {
        return rShow;
    }

    public void setrShow(Integer rShow) {
        this.rShow = rShow;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId == null ? null : uId.trim();
    }
    
    public String getrProfile() {
        return rProfile;
    }

    public void setrProfile(String rProfile) {
        this.rProfile = rProfile == null ? null : rProfile.trim();
    }

    public String getrExperience() {
        return rExperience;
    }

    public void setrExperience(String rExperience) {
        this.rExperience = rExperience == null ? null : rExperience.trim();
    }
    
}
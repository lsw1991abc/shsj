package com.lssrc.cms.entity;


public class Activit {
    private String aId;

    private String aTitle;

    private String aOrganizer;

    private String aPlotter;

    private Integer aNumber;

    private String aDatetimeStart;

    private String aDatetimeEnd;

    private Integer aStatu;

    private String aDatetimeBuild;

    private String aBuilder;

    private Integer aHot;

    private Integer isdeled;
    
    private String aDesc;

    private String aPic;

    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId == null ? null : aId.trim();
    }

    public String getaTitle() {
        return aTitle;
    }

    public void setaTitle(String aTitle) {
        this.aTitle = aTitle == null ? null : aTitle.trim();
    }

    public String getaOrganizer() {
        return aOrganizer;
    }

    public void setaOrganizer(String aOrganizer) {
        this.aOrganizer = aOrganizer == null ? null : aOrganizer.trim();
    }

    public String getaPlotter() {
        return aPlotter;
    }

    public void setaPlotter(String aPlotter) {
        this.aPlotter = aPlotter == null ? null : aPlotter.trim();
    }

    public Integer getaNumber() {
        return aNumber;
    }

    public void setaNumber(Integer aNumber) {
        this.aNumber = aNumber;
    }

    public String getaDatetimeStart() {
        return aDatetimeStart;
    }

    public void setaDatetimeStart(String aDatetimeStart) {
        this.aDatetimeStart = aDatetimeStart;
    }

    public String getaDatetimeEnd() {
        return aDatetimeEnd;
    }

    public void setaDatetimeEnd(String aDatetimeEnd) {
        this.aDatetimeEnd = aDatetimeEnd;
    }

    public Integer getaStatu() {
        return aStatu;
    }

    public void setaStatu(Integer aStatu) {
        this.aStatu = aStatu;
    }

    public String getaDatetimeBuild() {
        return aDatetimeBuild;
    }

    public void setaDatetimeBuild(String aDatetimeBuild) {
        this.aDatetimeBuild = aDatetimeBuild;
    }

    public String getaBuilder() {
        return aBuilder;
    }

    public void setaBuilder(String aBuilder) {
        this.aBuilder = aBuilder == null ? null : aBuilder.trim();
    }

    public Integer getaHot() {
        return aHot;
    }

    public void setaHot(Integer aHot) {
        this.aHot = aHot;
    }

    public Integer getIsdeled() {
        return isdeled;
    }

    public void setIsdeled(Integer isdeled) {
        this.isdeled = isdeled;
    }
    
    public String getaDesc() {
        return aDesc;
    }

    public void setaDesc(String aDesc) {
        this.aDesc = aDesc == null ? null : aDesc.trim();
    }

    public String getaPic() {
        return aPic;
    }

    public void setaPic(String aPic) {
        this.aPic = aPic == null ? null : aPic.trim();
    }
}
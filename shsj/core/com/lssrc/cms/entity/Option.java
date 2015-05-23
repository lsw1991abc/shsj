package com.lssrc.cms.entity;

public class Option {
    private String id;

    private String oKey;
    
    private String oName;

    private String oValue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getoKey() {
        return oKey;
    }

    public void setoKey(String oKey) {
        this.oKey = oKey == null ? null : oKey.trim();
    }

	public String getoName() {
		return oName;
	}

	public void setoName(String oName) {
		this.oName = oName;
	}

	public String getoValue() {
        return oValue;
    }

    public void setoValue(String oValue) {
        this.oValue = oValue == null ? null : oValue.trim();
    }
}
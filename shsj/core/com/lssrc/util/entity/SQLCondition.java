/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月18日
 */
package com.lssrc.util.entity;

/**
 * @author Carl_Li
 *
 */
public class SQLCondition {

	private String colName;
	
	private String condition;
	
	private String value;

	/**
	 * @param colName
	 * @param condition
	 * @param value
	 */
	public SQLCondition(String colName, String condition, String value) {
		super();
		this.colName = colName;
		this.condition = condition;
		this.value = value;
	}

	/**
	 * @return the colName
	 */
	public String getColName() {
		return colName;
	}

	/**
	 * @param colName the colName to set
	 */
	public void setColName(String colName) {
		this.colName = colName;
	}

	/**
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * @param condition the condition to set
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
}

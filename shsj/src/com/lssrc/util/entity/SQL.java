/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月18日
 */
package com.lssrc.util.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Carl_Li
 *
 */
public class SQL {

	private String sql;
	
	private List<Object> values = new ArrayList<Object>();

	/**
	 * 
	 */
	public SQL() {
		super();
	}

	/**
	 * @param sql
	 * @param values
	 */
	public SQL(String sql, List<Object> values) {
		super();
		this.sql = sql;
		this.values = values;
	}

	/**
	 * @return the sql
	 */
	public String getSql() {
		return sql;
	}

	/**
	 * @param sql the sql to set
	 */
	public void setSql(String sql) {
		this.sql = sql;
	}

	/**
	 * @return the values
	 */
	public List<Object> getValues() {
		return values;
	}

	/**
	 * @param values the values to set
	 */
	public void setValues(List<Object> values) {
		this.values = values;
	}
	
}

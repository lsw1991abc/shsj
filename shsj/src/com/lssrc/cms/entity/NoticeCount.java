/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2015年4月18日
 */
package com.lssrc.cms.entity;

/**
 * @author Carl_Li
 *
 */
public class NoticeCount {

	private String ncId;
	private String nId;
	private String ncDatetime;
	
	/**
	 * 
	 */
	public NoticeCount() {
		super();
	}
	
	/**
	 * @param ncId
	 * @param id
	 * @param ncDatetime
	 */
	public NoticeCount(String ncId, String nId, String ncDatetime) {
		super();
		this.ncId = ncId;
		this.nId = nId;
		this.ncDatetime = ncDatetime;
	}

	/**
	 * @return the ncId
	 */
	public String getNcId() {
		return ncId;
	}
	/**
	 * @param ncId the ncId to set
	 */
	public void setNcId(String ncId) {
		this.ncId = ncId;
	}
	/**
	 * @return the id
	 */
	public String getNid() {
		return nId;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String nId) {
		this.nId = nId;
	}
	/**
	 * @return the ncDatetime
	 */
	public String getNcDatetime() {
		return ncDatetime;
	}
	/**
	 * @param ncDatetime the ncDatetime to set
	 */
	public void setNcDatetime(String ncDatetime) {
		this.ncDatetime = ncDatetime;
	}
}

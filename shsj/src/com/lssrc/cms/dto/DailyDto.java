/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月18日
 */
package com.lssrc.cms.dto;

import java.util.Map;

/**
 * @author Carl_Li
 *
 */
public class DailyDto {
	
	private Map<String, Object> daily;
	
	private int dailyCount;
	
	/**
	 * 
	 */
	public DailyDto() {
		super();
	}

	/**
	 * @param daily
	 * @param dailyInfo
	 */
	public DailyDto(Map<String, Object> daily, int dailyCount) {
		super();
		this.daily = daily;
		this.dailyCount = dailyCount;
	}

	/**
	 * @return the daily
	 */
	public Map<String, Object> getDaily() {
		return daily;
	}

	/**
	 * @param daily the daily to set
	 */
	public void setDaily(Map<String, Object> daily) {
		this.daily = daily;
	}

	/**
	 * @return the dailyCount
	 */
	public int getDailyCount() {
		return dailyCount;
	}

	/**
	 * @param dailyCount the dailyCount to set
	 */
	public void setDailyCount(int dailyCount) {
		this.dailyCount = dailyCount;
	}
	
}

/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月18日
 */
package com.lssrc.shsj.dto;

import java.util.List;
import java.util.Map;

/**
 * @author Carl_Li
 *
 */
public class DailyListDto {
	
	private Map<String, Integer> navigator;
	
	private List<Map<String, Object>> dailies;

	/**
	 * 
	 */
	public DailyListDto() {
		super();
	}

	/**
	 * @param navigator
	 * @param dailies
	 */
	public DailyListDto(Map<String, Integer> navigator,
			List<Map<String, Object>> dailies) {
		super();
		this.navigator = navigator;
		this.dailies = dailies;
	}

	/**
	 * @return the navigator
	 */
	public Map<String, Integer> getNavigator() {
		return navigator;
	}

	/**
	 * @param navigator the navigator to set
	 */
	public void setNavigator(Map<String, Integer> navigator) {
		this.navigator = navigator;                           
	}                                                         

	/**
	 * @return the dailies
	 */
	public List<Map<String, Object>> getDailies() {
		return dailies;
	}

	/**
	 * @param dailies the dailies to set
	 */
	public void setDailies(List<Map<String, Object>> dailies) {
		this.dailies = dailies;
	}
	
}

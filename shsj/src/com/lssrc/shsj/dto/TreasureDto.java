/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月22日
 */
package com.lssrc.shsj.dto;

import java.util.Map;

/**
 * @author Carl_Li
 *
 */
public class TreasureDto {

	private Map<String, Object> treasure;
	
	private int treasureCount;

	/**
	 * 
	 */
	public TreasureDto() {
		super();
	}

	/**
	 * @param treasure
	 * @param treasureCount
	 */
	public TreasureDto(Map<String, Object> treasure, int treasureCount) {
		super();
		this.treasure = treasure;
		this.treasureCount = treasureCount;
	}

	/**
	 * @return the treasure
	 */
	public Map<String, Object> getTreasure() {
		return treasure;
	}

	/**
	 * @param treasure the treasure to set
	 */
	public void setTreasure(Map<String, Object> treasure) {
		this.treasure = treasure;
	}

	/**
	 * @return the treasureCount
	 */
	public int getTreasureCount() {
		return treasureCount;
	}

	/**
	 * @param treasureCount the treasureCount to set
	 */
	public void setTreasureCount(int treasureCount) {
		this.treasureCount = treasureCount;
	}
	
}

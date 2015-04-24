/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2015年4月21日
 */
package com.lssrc.cms.dto;

import com.lssrc.cms.entity.Activit;
import com.lssrc.cms.entity.ActivitStatu;

/**
 * @author Carl_Li
 *
 */
public class ActivitDto {
	
	private String aId;
	private Activit activit;
	private ActivitStatu statu;
	
	/**
	 * 
	 */
	public ActivitDto() {
		super();
	}
	
	/**
	 * @return the aId
	 */
	public String getaId() {
		return aId;
	}
	
	/**
	 * @param aId the aId to set
	 */
	public void setaId(String aId) {
		this.aId = aId;
	}
	
	/**
	 * @return the activit
	 */
	public Activit getActivit() {
		return activit;
	}
	
	/**
	 * @param activit the activit to set
	 */
	public void setActivit(Activit activit) {
		this.activit = activit;
	}
	
	/**
	 * @return the statu
	 */
	public ActivitStatu getStatu() {
		return statu;
	}
	
	/**
	 * @param statu the statu to set
	 */
	public void setStatu(ActivitStatu statu) {
		this.statu = statu;
	}
	
}

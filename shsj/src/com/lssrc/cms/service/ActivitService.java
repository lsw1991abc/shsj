/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月10日
 */
package com.lssrc.cms.service;

import java.util.List;
import java.util.Map;

import com.lssrc.cms.dto.ActivitDto;
import com.lssrc.cms.entity.Activit;
import com.lssrc.cms.entity.ActivitStatu;
import com.lssrc.util.Navigator;

/**
 * @author Carl_Li
 *
 */
public interface ActivitService {
	
	/**
	 * @param id
	 * @return
	 */
	public ActivitDto getById(String id);

	/**
	 * @param pageNo
	 * @param pageSize
	 * @param navigator 
	 * @return 
	 */
	public List<Activit> getByPage(Navigator navigator);
	
	/**
	 * @param i
	 * @return
	 */
	public List<Activit> getByTop(int top);

	/**
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Navigator getNavigator(int pageNo, int pageSize);

	/**
	 * @param title
	 * @param organizer
	 * @param plotter
	 * @param number
	 * @param statu
	 * @param dateTimeStart
	 * @param dateTimeEnd
	 * @param content
	 * @param userId
	 * @return
	 */
	public int save(Activit activit);
	
	/**
	 * @param id
	 * @param title
	 * @param organizer
	 * @param plotter
	 * @param number
	 * @param statu
	 * @param dateTimeStart
	 * @param dateTimeEnd
	 * @param content
	 * @param imgPath
	 * @param userId
	 * @return
	 */
	public int update(Activit activit);

	/**
	 * @param id
	 * @return
	 */
	public int delete(String id);

	/**
	 * @return
	 */
	public List<ActivitStatu> getStatus();

}

/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月10日
 */
package com.lssrc.shsj.service;

import java.util.List;
import java.util.Map;

/**
 * @author Carl_Li
 *
 */
public interface ActivitService {
	
	public Map<String, Object> getById(String id);

	/**
	 * @param pageNo
	 * @param pageSize
	 * @param navigator 
	 * @return 
	 */
	public List<Map<String, Object>> getByPage(Map<String, Integer> navigator);

	/**
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Map<String, Integer> getNavigator(int pageNo, int pageSize);

	/**
	 * @param i
	 * @return
	 */
	public List<Map<String, Object>> getByTop(int top);

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
	public int save(String title, String organizer, String plotter,
			String number, String statu, String dateTimeStart,
			String dateTimeEnd, String content, String imgPath, String userId);

	/**
	 * @param id
	 * @return
	 */
	public int delete(String id);

	public List<Map<String, Object>> getStatus();

}

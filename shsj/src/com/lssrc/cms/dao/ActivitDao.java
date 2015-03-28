/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月11日
 */
package com.lssrc.cms.dao;

import java.util.List;
import java.util.Map;

/**
 * @author Carl_Li
 *
 */
public interface ActivitDao {

	/**
	 * @return
	 */
	public int queryCount();

	/**
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<Map<String, Object>> queryByPage(int start, int pageSize);

	/**
	 * @param id
	 * @return
	 */
	public Map<String, Object> queryById(String id);

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
	public int save(String title, String organizer, String plotter, String number,
			String statu, String dateTimeStart, String dateTimeEnd,
			String content, String imgPath, String userId);

	/**
	 * @param id
	 * @return
	 */
	public int delete(String id);

	public List<Map<String, Object>> queryStatus();

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
	public int update(String id, String title, String organizer,
			String plotter, String number, String statu, String dateTimeStart,
			String dateTimeEnd, String content, String imgPath, String userId);

}

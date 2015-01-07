/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月11日
 */
package com.lssrc.shsj.dao;

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
	int queryCount();

	/**
	 * @param start
	 * @param pageSize
	 * @return
	 */
	List<Map<String, Object>> queryByPage(int start, int pageSize);

	/**
	 * @param id
	 * @return
	 */
	Map<String, Object> queryById(String id);

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
	int save(String title, String organizer, String plotter, String number,
			String statu, String dateTimeStart, String dateTimeEnd,
			String content, String userId);

	/**
	 * @param id
	 * @return
	 */
	int delete(String id);

}

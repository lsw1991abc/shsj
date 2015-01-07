/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月13日
 */
package com.lssrc.shsj.service;

import java.util.List;
import java.util.Map;

/**
 * @author Carl_Li
 *
 */
public interface JobService {

	/**
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	Map<String, Integer> getNavigator(int pageNo, int pageSize, String type);

	/**
	 * @param id
	 * @return
	 */
	Map<String, Object> getById(String id);

	/**
	 * @param navigator
	 * @return
	 */
	List<Map<String, Object>> getByPage(Map<String, Integer> navigator, String type);

	/**
	 * @param i
	 * @param string
	 * @return
	 */
	List<Map<String, Object>> getByTop(int top, String type);

	/**
	 * @param organnizer
	 * @param title
	 * @param type
	 * @param place
	 * @param salary
	 * @param datetimeWork
	 * @param number
	 * @param numberLimit
	 * @param contact
	 * @param datetimeStart
	 * @param datetimeEnd
	 * @param auditionPlace
	 * @param content
	 * @param userId
	 * @return
	 */
	int save(String organnizer, String title, String type, String place,
			String salary, String datetimeWork, String number,
			String numberLimit, String contact, String datetimeStart,
			String datetimeEnd, String auditionPlace, String content, String belong,
			String userId);

	/**
	 * @param id
	 * @return
	 */
	int delete(String id);

}

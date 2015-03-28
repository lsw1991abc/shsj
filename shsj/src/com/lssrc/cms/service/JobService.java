/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月13日
 */
package com.lssrc.cms.service;

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
	public Map<String, Integer> getNavigator(int pageNo, int pageSize, String type);

	/**
	 * @param id
	 * @return
	 */
	public Map<String, Object> getById(String id);

	/**
	 * @param navigator
	 * @return
	 */
	public List<Map<String, Object>> getByPage(Map<String, Integer> navigator, String type);

	/**
	 * @param i
	 * @param string
	 * @return
	 */
	public List<Map<String, Object>> getByTop(int top, String type);

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
	public int save(String organnizer, String title, String type, String place,
			String salary, String datetimeWork, int number,
			int numberLimit, String contact, String datetimeStart,
			String datetimeEnd, String auditionPlace, String content, String belong,
			String userId);

	/**
	 * @param id
	 * @return
	 */
	public int delete(String id);

	public List<Map<String, Object>>  getBelong();

}

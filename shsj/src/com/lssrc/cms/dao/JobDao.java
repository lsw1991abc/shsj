/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月13日
 */
package com.lssrc.cms.dao;

import java.util.List;
import java.util.Map;

/**
 * @author Carl_Li
 *
 */
public interface JobDao {

	/**
	 * @param i
	 * @param pageSize
	 * @return
	 */
	public List<Map<String, Object>> queryByPage(int start, int pageSize, String type);

	/**
	 * @param id
	 * @return
	 */
	public Map<String, Object> queryById(String id);

	/**
	 * @return
	 */
	public int queryCount(String type);

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

	public List<Map<String, Object>> queryBelong();

}

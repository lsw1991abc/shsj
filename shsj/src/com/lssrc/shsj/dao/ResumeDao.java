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
public interface ResumeDao {

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
	 * @param userId
	 * @return
	 */
	Map<String, Object> queryByUserId(String userId);

	/**
	 * @param resume
	 * @return
	 */
	int update(Map<String, Object> resume);

	/**
	 * @param resume
	 * @return
	 */
	int save(Map<String, Object> resume);

}

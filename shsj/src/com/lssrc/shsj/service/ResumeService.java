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
public interface ResumeService {

	/**
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	Map<String, Integer> getNavigator(int pageNo, int pageSize);

	/**
	 * @param id
	 * @return
	 */
	Map<String, Object> getById(String id);

	/**
	 * @param navigator
	 * @return
	 */
	List<Map<String, Object>> getByPage(Map<String, Integer> navigator);

	/**
	 * @param string
	 * @return
	 */
	Map<String, Object> getByUserId(String userId);

	/**
	 * @param resume
	 * @return
	 */
	int update(Map<String, Object> resume);
	
}

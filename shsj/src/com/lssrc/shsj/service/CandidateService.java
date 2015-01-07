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
public interface CandidateService {

	/**
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	Map<String, Integer> getNavigator(int pageNo, int pageSize);

	/**
	 * @param navigator
	 * @return
	 */
	List<Map<String, Object>> getByPage(Map<String, Integer> navigator);

	/**
	 * @param id
	 * @return
	 */
	Map<String, Object> getById(String id);

}

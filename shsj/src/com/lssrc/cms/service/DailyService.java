/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月14日
 */
package com.lssrc.cms.service;

import java.util.List;
import java.util.Map;

import com.lssrc.cms.dto.DailyDto;

/**
 * @author Carl_Li
 *
 */
public interface DailyService {

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
	DailyDto getById(String id);

	/**
	 * @param i
	 * @return
	 */
	List<Map<String, Object>> getByTop(int top);

	/**
	 * @param pageNo
	 * @param pageSize
	 * @param object
	 * @return
	 */
	Map<String, Integer> getNavigatorByUser(int pageNo, int pageSize, String userId);

	/**
	 * @param navigator
	 * @param userId
	 * @return
	 */
	List<Map<String, Object>> getByPageByUser(Map<String, Integer> navigator, String userId);

	/**
	 * @param id
	 * @param title
	 * @param content
	 * @return
	 */
	int update(String id, String title, String content);

	/**
	 * @param title
	 * @param content
	 * @param content2 
	 * @return
	 */
	int save(String userId, String title, String content);

	/**
	 * @param id
	 * @return
	 */
	int delete(String id);

}

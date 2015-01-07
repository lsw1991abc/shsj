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
public interface NoticeService {

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

	/**
	 * @param i
	 * @return
	 */
	List<Map<String, Object>> getByTop(int top);

	/**
	 * @param title
	 * @param content
	 * @param object
	 * @return
	 */
	int save(String title, String content, String userId);

	/**
	 * @param id
	 * @return
	 */
	int delete(String id);

}

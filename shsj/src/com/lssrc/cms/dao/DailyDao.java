/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月14日
 */
package com.lssrc.cms.dao;

import java.util.List;
import java.util.Map;

import com.lssrc.util.entity.SQLCondition;

/**
 * @author Carl_Li
 *
 */
public interface DailyDao {

	int queryCount(String userId);

	List<Map<String, Object>> queryByPage(int start, int pageSize, List<SQLCondition> conditions);

	Map<String, Object> queryById(String id);

	/**
	 * @param id
	 * @param title
	 * @param content
	 * @return
	 */
	int update(String id, String title, String content);

	/**
	 * @param userId
	 * @param title
	 * @param content
	 * @return
	 */
	int save(String userId, String title, String content);

	/**
	 * @param id
	 * @return
	 */
	int delete(String id);

}

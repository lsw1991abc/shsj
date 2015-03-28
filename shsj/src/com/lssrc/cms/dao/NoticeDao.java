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
public interface NoticeDao {
	
	public static int NOTICE = 1;
	public static int TREASURE = 2;

	/**
	 * @param type
	 * @return
	 */
	int queryCount(int type);

	/**
	 * @param start
	 * @param pageSize
	 * @param type
	 * @return
	 */
	List<Map<String, Object>> queryByPage(int start, int pageSize, int type);

	/**
	 * @param id
	 * @return
	 */
	Map<String, Object> queryById(String id);

	/**
	 * @param title
	 * @param content
	 * @param userId
	 * @param type
	 * @return
	 */
	int save(String title, String content, String userId, int type);

	/**
	 * @param id
	 * @return
	 */
	int delete(String id);

}

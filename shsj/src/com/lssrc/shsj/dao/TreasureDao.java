/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月14日
 */
package com.lssrc.shsj.dao;

import java.util.List;
import java.util.Map;

/**
 * @author Carl_Li
 *
 */
public interface TreasureDao {

	/**
	 * @return
	 */
	int queryCount();

	/**
	 * @param i
	 * @param pageSize
	 * @return
	 */
	List<Map<String, Object>> queryByPage(int start, int pageSize);

	/**
	 * @param id
	 * @return
	 */
	Map<String, Object> queryById(String id);

}

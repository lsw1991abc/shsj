/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月9日
 */
package com.lssrc.shsj.dao;

import java.util.Map;

/**
 * @author Carl_Li
 *
 */
public interface UserDao {

	/**
	 * @param username
	 * @return
	 */
	Map<String, Object> queryByUsername(String username);
	
	/**
	 * 
	 * @param username
	 * @return
	 */
	int queryCountByUsername(String username);

	/**
	 * @param contations
	 * @return
	 */
	int save(Map<String, String> contations);

	/**
	 * @param id
	 * @return
	 */
	Map<String, Object> queryById(String id);

	/**
	 * @param user
	 * @return
	 */
	int update(Map<String, Object> user);

	/**
	 * @param user
	 * @return
	 */
	int changePasswd(Map<String, Object> user);

}

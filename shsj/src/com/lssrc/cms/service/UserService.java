/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月9日
 */
package com.lssrc.cms.service;

import java.util.List;
import java.util.Map;

/**
 * @author Carl_Li
 *
 */
public interface UserService {

	/**
	 * @param username
	 * @return
	 */
	Map<String, Object> getByUsername(String username);

	/**
	 * @param id
	 * @return
	 */
	Map<String, Object> getById(String id);

	/**
	 * 
	 * @param navigator
	 * @return
	 */
	List<Map<String, Object>> getByPage(Map<String, Integer> navigator, int issys);
	
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param issys
	 * @return
	 */
	Map<String, Integer> getNavigator(int pageNo, int pageSize, int issys);

	/**
	 * @param username
	 * @return
	 */
	boolean isNotExist(String username);

	/**
	 * @param contations
	 * @return
	 */
	boolean save(Map<String, String> contations);

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

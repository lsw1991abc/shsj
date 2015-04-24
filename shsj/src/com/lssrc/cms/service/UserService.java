/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月9日
 */
package com.lssrc.cms.service;

import java.util.List;

import com.lssrc.cms.entity.User;
import com.lssrc.util.Navigator;

/**
 * @author Carl_Li
 *
 */
public interface UserService {

	/**
	 * @param id
	 * @return
	 */
	public User getById(String id);

	/**
	 * 
	 * @param navigator
	 * @return
	 */
	public List<User> getByPage(Navigator navigator, int issys);
	
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param issys
	 * @return
	 */
	public Navigator getNavigator(int pageNo, int pageSize, int issys);

	/**
	 * @param username
	 * @return
	 */
	public boolean isNotExist(String username);

	/**
	 * @param user
	 * @return
	 */
	public boolean save(User user);

	/**
	 * @param user
	 * @return
	 */
	public int update(User user);

	/**
	 * @param user
	 * @return
	 */
	public int changePasswd(User user);

	/**
	 * @param user
	 * @return
	 */
	public int changeRole(User user);
	
	/**
	 * 
	 * @param account
	 * @return
	 */
	public User getByAccount(String account);
}

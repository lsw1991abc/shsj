/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月9日
 */
package com.lssrc.shsj.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;

import com.lssrc.shsj.dao.UserDao;
import com.lssrc.shsj.service.UserService;

/**
 * @author Carl_Li
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	/* (non-Javadoc)
	 * @see com.lssrc.shsj.service.UserService#getByUsername(java.lang.String)
	 */
	@Override
	public Map<String, Object> getByUsername(String username) {
		try {
			return userDao.queryByUsername(username);
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.lssrc.shsj.service.UserService#getById(java.lang.String)
	 */
	@Override
	public Map<String, Object> getById(String id) {
		return userDao.queryById(id);
	}

	/* (non-Javadoc)
	 * @see com.lssrc.shsj.service.UserService#getByPage(Map)
	 */
	@Override
	public List<Map<String, String>> getByPage(Map<String, Integer> navigator) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lssrc.shsj.service.UserService#getNavigator(int, int)
	 */
	@Override
	public Map<String, Integer> getNavigator(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lssrc.shsj.service.UserService#isNotExist(java.lang.String)
	 */
	@Override
	public boolean isNotExist(String username) {
		if (userDao.queryCountByUsername(username) == 0) {
			return true;
		} else {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.lssrc.shsj.service.UserService#save(java.util.Map)
	 */
	@Override
	public boolean save(Map<String, String> contations) {
		if (userDao.save(contations) == 1) {
			return true;
		} else {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.lssrc.shsj.service.UserService#update(java.util.Map)
	 */
	@Override
	public int update(Map<String, Object> user) {
		return userDao.update(user);
	}

	/* (non-Javadoc)
	 * @see com.lssrc.shsj.service.UserService#changePasswd(java.util.Map)
	 */
	@Override
	public int changePasswd(Map<String, Object> user) {
		return userDao.changePasswd(user);
	}

}

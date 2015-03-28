/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月9日
 */
package com.lssrc.cms.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;

import com.lssrc.cms.dao.UserDao;
import com.lssrc.cms.service.UserService;
import com.lssrc.util.PageFormater;

/**
 * @author Carl_Li
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public Map<String, Object> getByUsername(String username) {
		try {
			return userDao.queryByUsername(username);
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}

	@Override
	public Map<String, Object> getById(String id) {
		return userDao.queryById(id);
	}

	@Override
	public List<Map<String, Object>> getByPage(Map<String, Integer> navigator, int issys) {
		int pageNo = navigator.get("nowPageNo");
		int pageSize = navigator.get("pageSize");
		return userDao.queryByPage((pageNo - 1) * pageSize, pageSize, issys);
	}

	@Override
	public Map<String, Integer> getNavigator(int pageNo, int pageSize, int issys) {
		int count = userDao.queryCountByIssys(issys);
		return PageFormater.getFormatPageNav(pageNo, count, pageSize);
	}

	@Override
	public boolean isNotExist(String username) {
		if (userDao.queryCountByUsername(username) == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean save(Map<String, String> contations) {
		if (userDao.save(contations) == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int update(Map<String, Object> user) {
		return userDao.update(user);
	}

	@Override
	public int changePasswd(Map<String, Object> user) {
		return userDao.changePasswd(user);
	}

	@Override
	public int changeRole(String id, int issys) {
		return userDao.changeRole(id, issys);
	}

}

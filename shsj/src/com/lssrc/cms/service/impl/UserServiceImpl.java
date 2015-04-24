/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月9日
 */
package com.lssrc.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lssrc.cms.dao.UserMapper;
import com.lssrc.cms.entity.User;
import com.lssrc.cms.service.UserService;
import com.lssrc.util.Navigator;

/**
 * @author Carl_Li
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	
	@Override
	public User getByAccount(String account) {
		return userMapper.selectByAccount(account);
	}

	@Override
	public User getById(String id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> getByPage(Navigator navigator, int issys) {
		int pageNo = navigator.getNowPage();
		int pageSize = navigator.getPageSize();
		return userMapper.queryByPage((pageNo - 1) * pageSize, pageSize, issys);
	}

	@Override
	public Navigator getNavigator(int pageNo, int pageSize, int issys) {
		int count = userMapper.queryCountByIssys(issys);
		return Navigator.formatPageNavigator(pageNo, count, pageSize);
	}

	@Override
	public boolean isNotExist(String username) {
		if (userMapper.queryCountByUsername(username) == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean save(User user) {
		if (userMapper.insert(user) == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int update(User user) {
		return userMapper.updateByPrimaryKey(user);
	}

	@Override
	public int changePasswd(User user) {
		return userMapper.updateByPrimaryKey(user);
	}

	@Override
	public int changeRole(User user) {
		return userMapper.updateByPrimaryKey(user);
	}

}

/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月11日
 */
package com.lssrc.shsj.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;

import com.lssrc.shsj.dao.ActivitDao;
import com.lssrc.shsj.service.ActivitService;
import com.lssrc.util.PageFormater;

/**
 * @author Carl_Li
 *
 */
@Service("activitService")
public class ActivitServiceImpl implements ActivitService {

	@Autowired
	private ActivitDao activitDao;

	@Override
	public Map<String, Object> getById(String id) {
		try {
			return activitDao.queryById(id);
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Map<String, Object>> getByPage(Map<String, Integer> navigator) {
		int pageNo = navigator.get("nowPageNo");
		int pageSize = navigator.get("pageSize");
		return activitDao.queryByPage((pageNo - 1) * pageSize, pageSize);
	}

	@Override
	public Map<String, Integer> getNavigator(int pageNo, int pageSize) {
		int count = activitDao.queryCount();
		return PageFormater.getFormatPageNav(pageNo, count, pageSize);
	}

	@Override
	public List<Map<String, Object>> getByTop(int top) {
		return activitDao.queryByPage(0, top);
	}

	@Override
	public int save(String title, String organizer, String plotter,
			String number, String statu, String dateTimeStart,
			String dateTimeEnd, String content, String userId) {
		return activitDao.save(title, organizer, plotter,
				number, statu, dateTimeStart,
				dateTimeEnd, content, userId);
	}

	/* (non-Javadoc)
	 * @see com.lssrc.shsj.service.ActivitService#delete(java.lang.String)
	 */
	@Override
	public int delete(String id) {
		return activitDao.delete(id);
	}

	@Override
	public List<Map<String, Object>> getStatus() {
		return activitDao.queryStatus();
	}
	
}

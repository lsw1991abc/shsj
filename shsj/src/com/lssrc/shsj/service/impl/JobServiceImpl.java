/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月13日
 */
package com.lssrc.shsj.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;

import com.lssrc.shsj.dao.JobDao;
import com.lssrc.shsj.service.JobService;
import com.lssrc.util.PageFormater;

/**
 * @author Carl_Li
 *
 */
@Service("jobService")
public class JobServiceImpl implements JobService {

	@Autowired
	private JobDao jobDao;

	@Override
	public Map<String, Integer> getNavigator(int pageNo, int pageSize,
			String type) {
		int count = jobDao.queryCount(type);
		return PageFormater.getFormatPageNav(pageNo, count, pageSize);
	}

	@Override
	public Map<String, Object> getById(String id) {
		try {
			return jobDao.queryById(id);
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Map<String, Object>> getByPage(Map<String, Integer> navigator,
			String type) {
		int pageNo = navigator.get("nowPageNo");
		int pageSize = navigator.get("pageSize");
		return jobDao.queryByPage((pageNo - 1) * pageSize, pageSize, type);
	}

	@Override
	public List<Map<String, Object>> getByTop(int top, String type) {
		return jobDao.queryByPage(0, top, type);
	}

	@Override
	public int save(String organnizer, String title, String type, String place,
			String salary, String datetimeWork, int number,
			int numberLimit, String contact, String datetimeStart,
			String datetimeEnd, String auditionPlace, String content, String belong, 
			String userId) {
		return jobDao.save(organnizer, title, type, place, salary,
				datetimeWork, number, numberLimit, contact, datetimeStart,
				datetimeEnd, auditionPlace, content, belong, userId);
	}

	@Override
	public int delete(String id) {
		return jobDao.delete(id);
	}

	@Override
	public List<Map<String, Object>> getBelong() {
		return jobDao.queryBelong();
	}

}

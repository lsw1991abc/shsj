/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月14日
 */
package com.lssrc.shsj.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;

import com.lssrc.shsj.dao.DailyCountDao;
import com.lssrc.shsj.dao.DailyDao;
import com.lssrc.shsj.dao.impl.DailyDaoImpl;
import com.lssrc.shsj.dto.DailyDto;
import com.lssrc.shsj.service.DailyService;
import com.lssrc.util.PageFormater;
import com.lssrc.util.entity.SQLCondition;

/**
 * @author Carl_Li
 *
 */
@Service("dailyService")
public class DailyServiceImpl implements DailyService {

	@Autowired
	private DailyDao dailyDao;
	
	@Autowired
	private DailyCountDao dailyCountDao;

	@Override
	public Map<String, Integer> getNavigator(int pageNo, int pageSize) {
		int count = dailyDao.queryCount(null);
		return PageFormater.getFormatPageNav(pageNo, count, pageSize);
	}

	@Override
	public List<Map<String, Object>> getByPage(Map<String, Integer> navigator) {
		int pageNo = navigator.get("nowPageNo");
		int pageSize = navigator.get("pageSize");
		return dailyDao.queryByPage((pageNo - 1) * pageSize, pageSize, null);
	}

	@Override
	public DailyDto getById(String id) {
		try {
			Map<String, Object> daily = dailyDao.queryById(id);
			dailyCountDao.save(id);
			int dailyCount = dailyCountDao.queryCount(id);
			return new DailyDto(daily, dailyCount);
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Map<String, Object>> getByTop(int top) {
		return dailyDao.queryByPage(0, top, null);
	}

	@Override
	public Map<String, Integer> getNavigatorByUser(int pageNo, int pageSize, String userId) {
		int count = dailyDao.queryCount(userId);
		return PageFormater.getFormatPageNav(pageNo, count, pageSize);
	}

	@Override
	public List<Map<String, Object>> getByPageByUser(Map<String, Integer> navigator, String userId) {
		int pageNo = navigator.get("nowPageNo");
		int pageSize = navigator.get("pageSize");
		List<SQLCondition> conditions = new ArrayList<SQLCondition>();
		conditions.add(new SQLCondition(DailyDaoImpl.BUILDER, "=", userId));
		
		return dailyDao.queryByPage((pageNo - 1) * pageSize, pageSize, conditions);
	}

	@Override
	public int update(String id, String title, String content) {
		return dailyDao.update(id, title, content);
	}

	@Override
	public int save(String userId, String title, String content) {
		return dailyDao.save(userId, title, content);
	}

	@Override
	public int delete(String id) {
		return dailyDao.delete(id);
	}
	
}

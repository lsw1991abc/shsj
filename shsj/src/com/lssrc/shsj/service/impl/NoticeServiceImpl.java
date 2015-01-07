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

import com.lssrc.shsj.dao.NoticeDao;
import com.lssrc.shsj.service.NoticeService;
import com.lssrc.util.PageFormater;

/**
 * @author Carl_Li
 *
 */
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeDao noticeDao;

	@Override
	public Map<String, Integer> getNavigator(int pageNo, int pageSize) {
		int count = noticeDao.queryCount();
		return PageFormater.getFormatPageNav(pageNo, count, pageSize);
	}

	@Override
	public List<Map<String, Object>> getByPage(Map<String, Integer> navigator) {
		int pageNo = navigator.get("nowPageNo");
		int pageSize = navigator.get("pageSize");
		return noticeDao.queryByPage((pageNo - 1) * pageSize, pageSize);
	}

	@Override
	public Map<String, Object> getById(String id) {
		try {
			return noticeDao.queryById(id);
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Map<String, Object>> getByTop(int top) {
		return noticeDao.queryByPage(0, top);
	}

	@Override
	public int save(String title, String content, String userId) {
		return noticeDao.save(title, content, userId);
	}

	@Override
	public int delete(String id) {
		return noticeDao.delete(id);
	}

}

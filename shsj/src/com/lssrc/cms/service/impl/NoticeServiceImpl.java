/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月13日
 */
package com.lssrc.cms.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;

import com.lssrc.cms.dao.NoticeCountDao;
import com.lssrc.cms.dao.NoticeDao;
import com.lssrc.cms.dto.NoticeDto;
import com.lssrc.cms.service.NoticeService;
import com.lssrc.util.PageFormater;

/**
 * @author Carl_Li
 *
 */
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeDao noticeDao;
	
	@Autowired
	private NoticeCountDao noticeCountDao;

	@Override
	public Map<String, Integer> getNavigator(int pageNo, int pageSize, int type) {
		int count = noticeDao.queryCount(type);
		return PageFormater.getFormatPageNav(pageNo, count, pageSize);
	}

	@Override
	public List<Map<String, Object>> getByPage(Map<String, Integer> navigator, int type) {
		int pageNo = navigator.get("nowPageNo");
		int pageSize = navigator.get("pageSize");
		return noticeDao.queryByPage((pageNo - 1) * pageSize, pageSize, type);
	}

	@Override
	public NoticeDto getById(String id) {
		try {
			Map<String, Object> notice = noticeDao.queryById(id);
			noticeCountDao.save(id);
			int noticeCount = noticeCountDao.queryCount(id);
			return new NoticeDto(notice, noticeCount);
		} catch (IncorrectResultSizeDataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Map<String, Object>> getByTop(int top, int type) {
		return noticeDao.queryByPage(0, top, type);
	}

	@Override
	public int save(String title, String content, String userId, int type) {
		return noticeDao.save(title, content, userId, type);
	}

	@Override
	public int update(String id, String title, String content, String userId) {
		return noticeDao.update(id, title, content, userId);
	}

	@Override
	public int delete(String id) {
		return noticeDao.delete(id);
	}

}

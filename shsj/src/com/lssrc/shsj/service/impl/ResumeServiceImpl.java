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

import com.lssrc.shsj.dao.ResumeDao;
import com.lssrc.shsj.dao.UserDao;
import com.lssrc.shsj.dto.DailyDto;
import com.lssrc.shsj.service.ResumeService;
import com.lssrc.util.PageFormater;

/**
 * @author Carl_Li
 *
 */
@Service("resumeService")
public class ResumeServiceImpl implements ResumeService {

	@Autowired
	private ResumeDao resumeDao;
	
	@Override
	public Map<String, Integer> getNavigator(int pageNo, int pageSize) {
		int count = resumeDao.queryCount();
		return PageFormater.getFormatPageNav(pageNo, count, pageSize);
	}

	@Override
	public Map<String, Object> getById(String id) {
		try {
			return resumeDao.queryById(id);
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Map<String, Object>> getByPage(Map<String, Integer> navigator) {
		int pageNo = navigator.get("nowPageNo");
		int pageSize = navigator.get("pageSize");
		return resumeDao.queryByPage((pageNo - 1) * pageSize, pageSize);
	}

	@Override
	public Map<String, Object> getByUserId(String userId) {
		return resumeDao.queryByUserId(userId);
	}

	@Override
	public int update(Map<String, Object> resume) {
		return resumeDao.update(resume);
	}

}

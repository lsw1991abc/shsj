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

import com.lssrc.cms.dao.CandidateDao;
import com.lssrc.cms.service.CandidateService;
import com.lssrc.util.PageFormater;

/**
 * @author Carl_Li
 *
 */
@Service("candidateService")
public class CandidateServiceImpl implements CandidateService {
	
	@Autowired
	private CandidateDao candidateDao;

	/* (non-Javadoc)
	 * @see com.lssrc.shsj.service.CandidateService#getNavigator(int, int)
	 */
	@Override
	public Map<String, Integer> getNavigator(int pageNo, int pageSize) {
		int count = candidateDao.queryCount();
		return PageFormater.getFormatPageNav(pageNo, count, pageSize);
	}

	/* (non-Javadoc)
	 * @see com.lssrc.shsj.service.CandidateService#getByPage(java.util.Map)
	 */
	@Override
	public List<Map<String, Object>> getByPage(Map<String, Integer> navigator) {
		int pageNo = navigator.get("nowPageNo");
		int pageSize = navigator.get("pageSize");
		return candidateDao.queryByPage((pageNo - 1) * pageSize, pageSize);
	}

	/* (non-Javadoc)
	 * @see com.lssrc.shsj.service.CandidateService#getById(java.lang.String)
	 */
	@Override
	public Map<String, Object> getById(String id) {
		try {
			return candidateDao.queryById(id);
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}

}

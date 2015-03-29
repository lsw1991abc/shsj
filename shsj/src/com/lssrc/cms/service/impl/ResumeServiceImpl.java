/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月13日
 */
package com.lssrc.cms.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;

import com.lssrc.cms.dao.ResumeDao;
import com.lssrc.cms.service.ResumeService;
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
		Map<String, Object> resume = resumeDao.queryByUserId(userId);
		if (resume == null) {
			return null;
		} else {
			return resume;
		}
	}

	@Override
	public int update(Map<String, Object> resume) {
		if (StringUtils.isEmpty(resume.get("imgPath") + "")) {
			resume.put("imgPath", "/images/resume/s_201310151381812039172.jpg");
		}
		return resumeDao.update(resume);
	}

	@Override
	public int save(Map<String, Object> resume) {
		System.out.println("---------" + resume.get("imgPath") + "");
		if (StringUtils.isEmpty(resume.get("imgPath") + "")) {
			resume.put("imgPath", "/images/resume/s_201310151381812039172.jpg");
		}
		return resumeDao.save(resume);
	}

}

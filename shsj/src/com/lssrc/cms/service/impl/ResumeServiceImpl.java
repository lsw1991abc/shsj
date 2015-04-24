/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月13日
 */
package com.lssrc.cms.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;

import com.lssrc.cms.dao.ResumeMapper;
import com.lssrc.cms.entity.Resume;
import com.lssrc.cms.service.ResumeService;
import com.lssrc.util.Navigator;

/**
 * @author Carl_Li
 *
 */
@Service("resumeService")
public class ResumeServiceImpl implements ResumeService {

	@Autowired
	private ResumeMapper resumeMapper;
	
	@Override
	public Navigator getNavigator(int pageNo, int pageSize) {
		int count = resumeMapper.selectCount();
		return Navigator.formatPageNavigator(pageNo, count, pageSize);
	}

	@Override
	public Resume getById(String id) {
		try {
			return resumeMapper.selectByPrimaryKey(id);
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Resume> getByPage(Navigator navigator) {
		int pageNo = navigator.getNowPage();
		int pageSize = navigator.getPageSize();
		return resumeMapper.selectByPage((pageNo - 1) * pageSize, pageSize);
	}

	@Override
	public Resume getByUserId(String userId) {
		Resume resume = resumeMapper.selectByUserId(userId);
		if (resume == null) {
			return null;
		} else {
			return resume;
		}
	}

	@Override
	public int update(Resume resume) {
		
		if (StringUtils.isEmpty(resume.getrPic())) {
			resume.setrPic("/images/resume/s_201310151381812039172.jpg");
		}
		return resumeMapper.updateByPrimaryKey(resume);
	}

	@Override
	public int save(Resume resume) {
		if (StringUtils.isEmpty(resume.getrPic())) {
			resume.setrPic("/images/resume/s_201310151381812039172.jpg");
		}
		return resumeMapper.insert(resume);
	}

}

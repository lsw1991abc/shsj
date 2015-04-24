/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月13日
 */
package com.lssrc.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;

import com.lssrc.cms.dao.JobBelongMapper;
import com.lssrc.cms.dao.JobMapper;
import com.lssrc.cms.dao.JobTypeMapper;
import com.lssrc.cms.dto.JobDto;
import com.lssrc.cms.entity.Job;
import com.lssrc.cms.entity.JobBelong;
import com.lssrc.cms.entity.JobType;
import com.lssrc.cms.service.JobService;
import com.lssrc.util.Navigator;

/**
 * @author Carl_Li
 *
 */
@Service("jobService")
public class JobServiceImpl implements JobService {

	
	@Autowired
	private JobMapper jobMapper;
	
	@Autowired
	private JobBelongMapper jobBelongMapper;
	
	@Autowired
	private JobTypeMapper jobTypeMapper;

	@Override
	public Navigator getNavigator(int pageNo, int pageSize, String type) {
		int count = jobMapper.selectCount(type);
		return Navigator.formatPageNavigator(pageNo, count, pageSize);
	}

	@Override
	public JobDto getById(String id) {
		try {
			return jobMapper.selectByPrimaryKey(id);
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<JobDto> getByPage(Navigator navigator, String type) {
		int pageNo = navigator.getNowPage();
		int pageSize = navigator.getPageSize();
		return jobMapper.selectByPage((pageNo - 1) * pageSize, pageSize, type);
	}

	@Override
	public List<JobDto> getByTop(int top, String type) {
		return jobMapper.selectByPage(0, top, type);
	}

	@Override
	public int save(Job job) {
		return jobMapper.insert(job);
	}
	
	@Override
	public int update(Job job) {
		return jobMapper.updateByPrimaryKey(job);
	}

	@Override
	public int delete(String id) {
		return jobMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<JobBelong> getBelong() {
		return jobBelongMapper.selectByPage();
	}
	
	public List<JobType> getType() {
		return jobTypeMapper.selectByPage();
	}

}

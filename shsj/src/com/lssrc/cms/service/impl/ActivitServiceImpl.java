/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月11日
 */
package com.lssrc.cms.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;

import com.lssrc.cms.dao.ActivitMapper;
import com.lssrc.cms.dao.ActivitStatuMapper;
import com.lssrc.cms.dto.ActivitDto;
import com.lssrc.cms.entity.Activit;
import com.lssrc.cms.entity.ActivitStatu;
import com.lssrc.cms.service.ActivitService;
import com.lssrc.util.Navigator;

/**
 * @author Carl_Li
 *
 */
@Service("activitService")
public class ActivitServiceImpl implements ActivitService {

	@Autowired
	private ActivitMapper activitMapper;
	
	@Autowired
	private ActivitStatuMapper activitStatuMapper;
	
	@Override
	public ActivitDto getById(String id) {
		try {
			return activitMapper.selectByPrimaryKey(id);
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Activit> getByPage(Navigator navigator) {
		int pageNo = navigator.getNowPage();
		int pageSize = navigator.getPageSize();
		return activitMapper.selectByPage((pageNo - 1) * pageSize, pageSize);
	}

	@Override
	public Navigator getNavigator(int pageNo, int pageSize) {
		int count = activitMapper.selectCount();
		return Navigator.formatPageNavigator(pageNo, count, pageSize);
	}

	@Override
	public List<Activit> getByTop(int top) {
		return activitMapper.selectByPage(0, top);
	}

	@Override
	public int save(Activit activit) {
		if (StringUtils.isEmpty(activit.getaPic())) {
			activit.setaPic("/images/activit/default.jpg");
		}
		return activitMapper.insert(activit);
	}
	
	@Override
	public int update(Activit activit) {
		if (StringUtils.isEmpty(activit.getaPic())) {
			activit.setaPic("/images/activit/default.jpg");
		}
		return activitMapper.updateByPrimaryKey(activit);
	}

	@Override
	public int delete(String id) {
		return activitMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<ActivitStatu> getStatus() {
		return activitStatuMapper.selectByPage();
	}

	
	
}

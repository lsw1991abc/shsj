/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月14日
 */
package com.lssrc.shsj.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;

import com.lssrc.shsj.dao.TreasureCountDao;
import com.lssrc.shsj.dao.TreasureDao;
import com.lssrc.shsj.dto.DailyDto;
import com.lssrc.shsj.dto.TreasureDto;
import com.lssrc.shsj.service.TreasureService;
import com.lssrc.util.PageFormater;

/**
 * @author Carl_Li
 *
 */
@Service("treasureService")
public class TreasureServiceImpl implements TreasureService {
	
	@Autowired
	private TreasureDao treasureDao;
	
	@Autowired
	private TreasureCountDao treasureCountDao;

	/* (non-Javadoc)
	 * @see com.lssrc.shsj.service.TreasureService#getNavigator(int, int)
	 */
	@Override
	public Map<String, Integer> getNavigator(int pageNo, int pageSize) {
		int count = treasureDao.queryCount();
		return PageFormater.getFormatPageNav(pageNo, count, pageSize);
	}

	/* (non-Javadoc)
	 * @see com.lssrc.shsj.service.TreasureService#getByPage(java.util.Map)
	 */
	@Override
	public List<Map<String, Object>> getByPage(Map<String, Integer> navigator) {
		int pageNo = navigator.get("nowPageNo");
		int pageSize = navigator.get("pageSize");
		return treasureDao.queryByPage((pageNo - 1) * pageSize, pageSize);
	}

	/* (non-Javadoc)
	 * @see com.lssrc.shsj.service.TreasureService#getById(java.lang.String)
	 */
	@Override
	public TreasureDto getById(String id) {
		try {
			Map<String, Object> treasure = treasureDao.queryById(id);
			treasureCountDao.save(id);
			int treasureCount = treasureCountDao.queryCount(id);
			return new TreasureDto(treasure, treasureCount);
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.lssrc.shsj.service.TreasureService#getByTop(int)
	 */
	@Override
	public List<Map<String, Object>> getByTop(int top) {
		return treasureDao.queryByPage(0, top);
	}

}

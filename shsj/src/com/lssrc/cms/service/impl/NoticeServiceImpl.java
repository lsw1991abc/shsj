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

import com.lssrc.cms.dao.NoticeMapper;
import com.lssrc.cms.dto.NoticeDto;
import com.lssrc.cms.entity.Notice;
import com.lssrc.cms.entity.NoticeCount;
import com.lssrc.cms.service.NoticeService;
import com.lssrc.util.DateFormater;
import com.lssrc.util.Navigator;
import com.lssrc.util.UUID;

/**
 * @author Carl_Li
 *
 */
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeMapper noticeMapper;

	@Override
	public Navigator getNavigator(int pageNo, int pageSize, int type, String userId) {
		return Navigator.formatPageNavigator(pageNo, noticeMapper.selectCount(type, userId), pageSize);
	}

	@Override
	public List<Notice> getByPage(Navigator navigator, int type, String userId) {
		int pageNo = navigator.getNowPage();
		int pageSize = navigator.getPageSize();
		return noticeMapper.selectByPage((pageNo - 1) * pageSize, pageSize, type, userId);
	}

	@Override
	public NoticeDto getById(String id) {
		try {
			NoticeDto noticeDto = noticeMapper.selectByPrimaryKey(id);
			noticeMapper.updateCountByNotice(new NoticeCount(UUID.generateRandomUUID(), id, DateFormater.getDateTime()));
			noticeDto.setNoticeCount(noticeMapper.selectCountByNotice(id));
			return noticeDto;
		} catch (IncorrectResultSizeDataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Notice> getByTop(int top, int type) {
		return noticeMapper.selectByPage(0, top, type, null);
	}

	@Override
	public int save(Notice notice) {
		return noticeMapper.insert(notice);
	}

	@Override
	public int update(Notice notice) {
		return noticeMapper.updateByPrimaryKey(notice);
	}

	@Override
	public int delete(String id) {
		return noticeMapper.deleteByPrimaryKey(id);
	}

}

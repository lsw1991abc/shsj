/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月13日
 */
package com.lssrc.cms.service;

import java.util.List;

import com.lssrc.cms.dto.NoticeDto;
import com.lssrc.cms.entity.Notice;
import com.lssrc.util.Navigator;

/**
 * @author Carl_Li
 *
 */
public interface NoticeService {
	
	public static int TYPE_NOTICE = 1;
	public static int TYPE_TREASURE = 2;
	public static int TYPE_DAILY = 3;

	/**
	 * @param pageNo
	 * @param pageSize
	 * @param userId
	 * @return
	 */
	public Navigator getNavigator(int pageNo, int pageSize, int type, String userId);

	/**
	 * @param navigator
	 * @param typeDaily
	 * @param userId
	 * @return
	 */
	public List<Notice> getByPage(Navigator navigator, int type, String userId);

	/**
	 * @param id
	 * @return
	 */
	public NoticeDto getById(String id);

	/**
	 * @param top
	 * @param type
	 * @return
	 */
	public List<Notice> getByTop(int top, int type);

	/**
	 * @param title
	 * @param content
	 * @param object
	 * @return
	 */
	public int save(Notice notice);

	/**
	 * @param id
	 * @return
	 */
	public int delete(String id);

	/**
	 * @param notice
	 * @return
	 */
	public int update(Notice notice);

}

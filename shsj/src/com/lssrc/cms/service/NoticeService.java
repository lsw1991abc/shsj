/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月13日
 */
package com.lssrc.cms.service;

import java.util.List;
import java.util.Map;

import com.lssrc.cms.dto.NoticeDto;

/**
 * @author Carl_Li
 *
 */
public interface NoticeService {

	/**
	 * @param pageNo
	 * @param pageSize
	 * @param type
	 * @return
	 */
	Map<String, Integer> getNavigator(int pageNo, int pageSize, int type);

	/**
	 * @param navigator
	 * @param type
	 * @return
	 */
	List<Map<String, Object>> getByPage(Map<String, Integer> navigator, int type);

	/**
	 * @param id
	 * @return
	 */
	NoticeDto getById(String id);

	/**
	 * @param top
	 * @param type
	 * @return
	 */
	List<Map<String, Object>> getByTop(int top, int type);

	/**
	 * @param title
	 * @param content
	 * @param object
	 * @return
	 */
	int save(String title, String content, String userId, int type);

	/**
	 * @param id
	 * @return
	 */
	int delete(String id);

}

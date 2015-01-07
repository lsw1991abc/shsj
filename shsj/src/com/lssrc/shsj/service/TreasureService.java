/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月14日
 */
package com.lssrc.shsj.service;

import java.util.List;
import java.util.Map;

import com.lssrc.shsj.dto.TreasureDto;

/**
 * @author Carl_Li
 *
 */
public interface TreasureService {

	/**
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	Map<String, Integer> getNavigator(int pageNo, int pageSize);

	/**
	 * @param navigator
	 * @return
	 */
	List<Map<String, Object>> getByPage(Map<String, Integer> navigator);

	/**
	 * @param id
	 * @return
	 */
	TreasureDto getById(String id);

	/**
	 * @param i
	 * @return
	 */
	List<Map<String, Object>> getByTop(int top);

}

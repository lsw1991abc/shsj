/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2015年5月22日
 */
package com.lssrc.cms.service;

import java.util.List;

import com.lssrc.cms.entity.Option;

/**
 * @author Carl_Li
 *
 */
public interface OptionService {

	public List<Option> get();

	public Option getByKey(String key);
	
	public int updateByPrimaryKey(Option record);
	
}

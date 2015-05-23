/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2015年5月22日
 */
package com.lssrc.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lssrc.cms.dao.OptionMapper;
import com.lssrc.cms.entity.Option;
import com.lssrc.cms.service.OptionService;

/**
 * @author Carl_Li
 *
 */
@Service("optionService")
public class OptionServiceImpl implements OptionService {

	@Autowired
	private OptionMapper optionMapper;
	
	@Override
	public List<Option> get() {
		return optionMapper.selectByPage();
	}

	@Override
	public Option getByKey(String key) {
		return optionMapper.selectByKey(key);
	}

	@Override
	public int updateByPrimaryKey(Option option) {
		return optionMapper.updateByPrimaryKey(option);
	}

}

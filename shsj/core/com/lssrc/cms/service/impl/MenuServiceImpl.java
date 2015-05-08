/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2015年4月12日
 */
package com.lssrc.cms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lssrc.cms.dao.MenuMapper;
import com.lssrc.cms.entity.Menu;
import com.lssrc.cms.service.MenuService;

/**
 * @author Carl_Li
 *
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {

	private MenuMapper menuMapper;
	
	@Override
	public List<Menu> list() {
		return menuMapper.selectByPage();
	}

}

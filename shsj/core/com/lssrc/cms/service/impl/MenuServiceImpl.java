/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2015年4月12日
 */
package com.lssrc.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private MenuMapper menuMapper;
	
	@Override
	public List<Menu> getByPage() {
		return menuMapper.selectByPage();
	}

	@Override
	public Menu getById(String id) {
		return menuMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(Menu menu) {
		return menuMapper.insert(menu);
	}

	@Override
	public int update(Menu menu) {
		return menuMapper.updateByPrimaryKey(menu);
	}

	@Override
	public int delete(String id) {
		return menuMapper.deleteByPrimaryKey(id);
	}

}

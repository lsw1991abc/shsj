/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2015年4月12日
 */
package com.lssrc.cms.service;

import java.util.List;

import com.lssrc.cms.entity.Menu;

/**
 * @author Carl_Li
 *
 */
public interface MenuService {

	public List<Menu> getByPage();

	public Menu getById(String id);

	public int save(Menu menu);

	public int update(Menu menu);

	public int delete(String id);
	
}

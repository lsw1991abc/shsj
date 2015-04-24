package com.lssrc.cms.dao;

import java.util.List;

import com.lssrc.cms.entity.Menu;

public interface MenuMapper {
    int deleteByPrimaryKey(String menuId);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(String menuId);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKeyWithBLOBs(Menu record);

    int updateByPrimaryKey(Menu record);

	/**
	 * @return
	 */
	List<Menu> selectByPage();
}
package com.lssrc.cms.dao;

import java.util.List;

import com.lssrc.cms.entity.Menu;

public interface MenuMapper {
    int deleteByPrimaryKey(String menuId);

    int insert(Menu record);

    Menu selectByPrimaryKey(String menuId);

    int updateByPrimaryKey(Menu record);

	List<Menu> selectByPage();
}
package com.lssrc.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lssrc.cms.entity.Link;

public interface LinkMapper {
    int deleteByPrimaryKey(String lId);

    int insert(Link record);

    Link selectByPrimaryKey(String lId);

    int updateByPrimaryKey(Link record);

	List<Link> selectByPage(@Param("type") int type);
}
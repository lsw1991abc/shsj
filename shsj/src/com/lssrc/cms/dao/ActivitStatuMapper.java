package com.lssrc.cms.dao;

import java.util.List;

import com.lssrc.cms.entity.ActivitStatu;

public interface ActivitStatuMapper {
    int deleteByPrimaryKey(Integer asId);

    int insert(ActivitStatu record);

    ActivitStatu selectByPrimaryKey(Integer asId);

    int updateByPrimaryKey(ActivitStatu record);

	List<ActivitStatu> selectByPage();
}
package com.lssrc.cms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.lssrc.cms.dto.ActivitDto;
import com.lssrc.cms.entity.Activit;

public interface ActivitMapper {
    int deleteByPrimaryKey(String aId);

    int insert(Activit record);

    ActivitDto selectByPrimaryKey(String aId);

    int updateByPrimaryKey(Activit record);

	List<Activit> selectByPage(@Param("start") int start, @Param("pageSize") int pageSize);

	int selectCount();

	List<Map<String, Object>> selectStatus();
}
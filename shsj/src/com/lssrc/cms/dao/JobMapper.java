package com.lssrc.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lssrc.cms.dto.JobDto;
import com.lssrc.cms.entity.Job;
import com.lssrc.cms.entity.JobBelong;

public interface JobMapper {
    int deleteByPrimaryKey(String jId);

    int insert(Job record);

    JobDto selectByPrimaryKey(@Param("jId") String jId);

    int updateByPrimaryKey(Job record);
    
    List<JobDto> selectByPage(@Param("start") int start, @Param("pageSize") int pageSize, @Param("type") String type);

	int selectCount(@Param("type") String type);

	List<JobBelong> selectBelong();
}
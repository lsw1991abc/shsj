package com.lssrc.cms.dao;

import java.util.List;

import com.lssrc.cms.entity.JobType;

public interface JobTypeMapper {
    int deleteByPrimaryKey(String jtId);

    int insert(JobType record);

    JobType selectByPrimaryKey(String jtId);

    int updateByPrimaryKey(JobType record);

	List<JobType> selectByPage();
}
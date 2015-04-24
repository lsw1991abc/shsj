package com.lssrc.cms.dao;

import java.util.List;

import com.lssrc.cms.entity.JobBelong;

public interface JobBelongMapper {
    int deleteByPrimaryKey(String jbId);

    int insert(JobBelong record);

    JobBelong selectByPrimaryKey(String jbId);

    int updateByPrimaryKey(JobBelong record);

	List<JobBelong> selectByPage();
}
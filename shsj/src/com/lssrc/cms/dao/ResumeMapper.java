package com.lssrc.cms.dao;

import java.util.List;

import com.lssrc.cms.entity.Resume;

public interface ResumeMapper {
    int deleteByPrimaryKey(String rId);

    int insert(Resume record);

    int updateByPrimaryKey(Resume record);

	int selectCount();

	List<Resume> selectByPage(int start, int pageSize);

	Resume selectByPrimaryKey(String rId);
	
	Resume selectByUserId(String userId);
}
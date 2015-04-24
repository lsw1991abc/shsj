package com.lssrc.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lssrc.cms.dto.NoticeDto;
import com.lssrc.cms.entity.Notice;
import com.lssrc.cms.entity.NoticeCount;

public interface NoticeMapper {
    int deleteByPrimaryKey(String nId);

    int insert(Notice record);

    int updateByPrimaryKey(Notice record);

    int selectCountByNotice(@Param("nId") String nId);

    int selectCount(@Param("type") int type);

	int selectCount(@Param("type") int type, @Param("userId") String userId);
	
	void updateCountByNotice(NoticeCount noticeCount);

	NoticeDto selectByPrimaryKey(String nId);

	List<Notice> selectByPage(@Param("start") int start, @Param("pageSize") int pageSize, @Param("type") int type, @Param("userId") String userId);
}
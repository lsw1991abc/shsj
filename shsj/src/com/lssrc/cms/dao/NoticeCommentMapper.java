package com.lssrc.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lssrc.cms.dto.NoticeCommentDto;
import com.lssrc.cms.entity.NoticeComment;

public interface NoticeCommentMapper {
    int deleteByPrimaryKey(String ncId);

    int insert(NoticeComment record);

    NoticeComment selectByPrimaryKey(String ncId);

    int updateByPrimaryKey(NoticeComment record);

	List<NoticeCommentDto> selectByPage(@Param("start") int start, @Param("pageSize") int pageSize, @Param("type") int type, @Param("noticeId") String noticeId);

	int selectCount(@Param("type") int type, @Param("noticeId") String noticeId);
}
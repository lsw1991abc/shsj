package com.lssrc.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lssrc.cms.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User user);

    User selectByPrimaryKey(String userId);
    
    User selectByAccount(String account);

    int updateByPrimaryKey(User user);

    List<User> queryByPage(@Param("start") int start, @Param("pageSize") int pageSize, @Param("issys") int issys);

	int queryCountByIssys(int issys);

	int queryCountByUsername(String username);
}
package com.lssrc.cms.dao;

import java.util.List;

import com.lssrc.cms.entity.Option;

public interface OptionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Option record);

    Option selectByPrimaryKey(String id);
    
    Option selectByKey(String key);

    int updateByPrimaryKey(Option record);
    
    List<Option> selectByPage();
}
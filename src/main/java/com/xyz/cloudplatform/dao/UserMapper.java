package com.xyz.cloudplatform.dao;

import com.xyz.cloudplatform.model.User;

public interface UserMapper {

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

}
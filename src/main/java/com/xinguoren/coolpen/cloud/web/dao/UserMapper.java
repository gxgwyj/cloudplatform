package com.xinguoren.coolpen.cloud.web.dao;

import com.xinguoren.coolpen.cloud.web.model.User;

public interface UserMapper {

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

}
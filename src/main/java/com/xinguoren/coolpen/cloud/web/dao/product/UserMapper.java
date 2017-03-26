package com.xinguoren.coolpen.cloud.web.dao.product;

import com.xinguoren.coolpen.cloud.web.model.product.User;

public interface UserMapper {

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

}
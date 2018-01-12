package com.xyz.cloudplatform.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xyz.cloudplatform.dao.UserMapper;
import com.xyz.cloudplatform.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/3/14.
 */
@Service
public class UserServiceImpl {
    @Autowired
    UserMapper userMapper;
    public String getUserInfo(String code) {
        return "用户信息";
    }

    @Transactional
    public void saveUser(User user) {
        userMapper.insert(user);
    }
}

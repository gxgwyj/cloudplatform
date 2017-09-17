package com.xinguoren.coolpen.cloud.web.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xinguoren.coolpen.cloud.web.dao.UserMapper;
import com.xinguoren.coolpen.cloud.web.model.User;
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

package com.xinguoren.coolpen.cloud.web.service.user.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xinguoren.coolpen.cloud.web.service.user.UserService;

/**
 * Created by Administrator on 2017/3/14.
 */
@Service
public class UserServiceImpl implements UserService{
    public String getUserInfo(String code) {
        return "用户信息";
    }
}

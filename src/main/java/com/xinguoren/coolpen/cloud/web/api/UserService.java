package com.xinguoren.coolpen.cloud.web.api;

import com.xinguoren.coolpen.cloud.web.model.product.User;

/**
 * Created by Administrator on 2017/3/14.
 */
public interface UserService {
    String getUserInfo(String code);
    void saveUser(User user);
}

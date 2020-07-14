package com.jesse.shop.biz;

import com.jesse.shop.entity.LocalAuth;

/**
 * Created by Kong on 2020/7/10.
 */
public interface LocalAuthBiz {
    LocalAuth getLocalAuthByUsernameAndPwd(String userName, String password);
}

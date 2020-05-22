package com.jesse.hm.common.service;

import com.jesse.hm.common.entity.User;

/**
 * Created by Kong on 2020/5/22.
 */
public interface UserService {
    User login(String username, String password);
}

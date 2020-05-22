package com.jesse.hm.common.dao;

import com.jesse.hm.common.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Kong on 2020/5/22.
 */
@Repository("userDao")
public interface UserDao {
    User selectByName(String name);
}

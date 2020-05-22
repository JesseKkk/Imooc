package com.jesse.hm.common.service.impl;

import com.jesse.hm.common.dao.UserDao;
import com.jesse.hm.common.entity.User;
import com.jesse.hm.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;

/**
 * Created by Kong on 2020/5/22.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;


    public User login(String username, String password) {
        User user = userDao.selectByName(username);
        if (user == null) return null;
        if (user.getPassword().equals(password)) return user;
        return null;
    }
}

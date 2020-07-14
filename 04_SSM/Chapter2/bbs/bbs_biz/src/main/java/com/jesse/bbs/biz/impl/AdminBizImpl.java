package com.jesse.bbs.biz.impl;

import com.jesse.bbs.biz.AdminBiz;
import com.jesse.bbs.dao.AdminDao;
import com.jesse.bbs.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Kong on 2020/6/11.
 */
@Service("adminBiz")
public class AdminBizImpl implements AdminBiz {

    @Autowired
    private AdminDao adminDao;


    public Admin login(String username, String password) {
        Admin admin = adminDao.select(username);
        if (admin != null && admin.getPassword().equals(password)){
            return admin;
        }
        return null;
    }
}

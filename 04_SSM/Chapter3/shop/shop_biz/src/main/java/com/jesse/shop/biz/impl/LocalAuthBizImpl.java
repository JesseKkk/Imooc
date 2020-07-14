package com.jesse.shop.biz.impl;

import com.jesse.shop.biz.LocalAuthBiz;
import com.jesse.shop.dao.LocalAuthDao;
import com.jesse.shop.entity.LocalAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Kong on 2020/7/10.
 */
@Service("localAuthBiz")
public class LocalAuthBizImpl implements LocalAuthBiz {
    @Autowired
    LocalAuthDao localAuthDao;

    public LocalAuth getLocalAuthByUsernameAndPwd(String userName, String password) {
        return localAuthDao.queryLocalByUserNameAndPwd(userName, password);
    }
}

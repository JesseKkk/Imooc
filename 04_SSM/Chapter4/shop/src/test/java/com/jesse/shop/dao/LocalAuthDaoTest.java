package com.jesse.shop.dao;

import com.jesse.shop.entity.LocalAuth;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by Kong on 2020/7/10.
 */
@SpringBootTest
public class LocalAuthDaoTest{
    @Autowired
    private LocalAuthDao localAuthDao;

    @Test
    public void testQueryLocalByUserNameAndPwd() {
        LocalAuth localAuth = localAuthDao.queryLocalByUserNameAndPwd("kong", "123");
        System.out.println(localAuth);
    }
}

package com.jesse.transation.biz;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Kong on 2020/7/12.
 */
@SpringBootTest
public class TestBizTest {
    @Autowired
    TestBiz testBiz;

    @Test
    public void testTestBiz(){
        testBiz.operate1();
    }
}

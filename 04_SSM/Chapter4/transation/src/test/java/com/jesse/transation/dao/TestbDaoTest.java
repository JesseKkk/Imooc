package com.jesse.transation.dao;

import com.jesse.transation.entity.Testa;
import com.jesse.transation.entity.Testb;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by Kong on 2020/7/12.
 */
@SpringBootTest
public class TestbDaoTest {

    @Autowired
    TestbDao testbDao;

    @Test
    public void testInsertTestb() {
        Testb testb = new Testb();
        testb.setName("kong");
        testb.setPwd("123");
        int effectNum = testbDao.insertTestb(testb);
        System.out.println("effectNum = " + effectNum);
    }

    @Test
    public void testDeleteTestbById() {
        int effectNum = testbDao.deleteTestbById(8);
    }
}

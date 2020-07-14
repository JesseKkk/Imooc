package com.jesse.transation.biz.impl;

import com.jesse.transation.biz.TestBiz;
import com.jesse.transation.dao.TestaDao;
import com.jesse.transation.dao.TestbDao;
import com.jesse.transation.entity.Testa;
import com.jesse.transation.entity.Testb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Kong on 2020/7/12.
 */
@Service("testBiz")
public class TestBizImpl implements TestBiz {
    @Autowired
    TestaDao testaDao;

    @Autowired
    TestbDao testbDao;

    @Override
    @Transactional
    public void operate1() {
        Testa testa = new Testa();
        testa.setName("jin1");
        testa.setPwd("123");
        testaDao.insertTesta(testa);
        this.operate2();
    }


    @Override
    @Transactional
    public void operate2() {
        Testb testb = new Testb();
        testb.setName("jin2");
        testb.setPwd("123");
        testbDao.insertTestb(testb);
        int i = 1/0;
        testbDao.deleteTestbById(10);
    }
}

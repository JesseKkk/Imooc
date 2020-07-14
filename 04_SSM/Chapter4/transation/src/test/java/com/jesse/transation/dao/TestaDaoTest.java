package com.jesse.transation.dao;

import com.jesse.transation.entity.Testa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by Kong on 2020/7/12.
 */
@SpringBootTest
public class TestaDaoTest {

    @Autowired
    TestaDao testaDao;

    @Test
    public void testInsertTesta() {
        Testa testa = new Testa();
        testa.setName("kong");
        testa.setPwd("123");
        int effectNum = testaDao.insertTesta(testa);
        System.out.println("effectNum = " + effectNum);
    }

    @Test
    public void testDeleteTestaById() {
        int effectNum = testaDao.deleteTestaById(8);
    }
}

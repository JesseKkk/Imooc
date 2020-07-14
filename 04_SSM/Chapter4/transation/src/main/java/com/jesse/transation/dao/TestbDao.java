package com.jesse.transation.dao;

import com.jesse.transation.entity.Testb;
import org.springframework.stereotype.Repository;

/**
 * Created by Kong on 2020/7/12.
 */
@Repository("testbDao")
public interface TestbDao {
    int insertTestb(Testb testb);
    int deleteTestbById(int id);
}

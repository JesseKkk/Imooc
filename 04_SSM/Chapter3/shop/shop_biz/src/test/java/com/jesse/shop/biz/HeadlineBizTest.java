package com.jesse.shop.biz;

import com.jesse.shop.BaseTest;
import com.jesse.shop.dao.HeadLineDao;
import com.jesse.shop.entity.HeadLine;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Kong on 2020/7/9.
 */
public class HeadlineBizTest extends BaseTest {

    @Autowired
    HeadLineBiz headLineBiz;

    @Test
    public void testGetHeadLineList() {
        HeadLine headLine = new HeadLine();
        headLine.setEnableStatus(1);
        List<HeadLine> headLineList = headLineBiz.getHeadLineList(headLine);
        System.out.println("headLineList = " + headLineList);
    }
}

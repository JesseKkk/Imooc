package com.jesse.shop.biz;

import com.jesse.shop.BaseTest;
import com.jesse.shop.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Kong on 2020/6/22.
 */
public class AreaBizTest extends BaseTest {
    @Autowired
    private AreaBiz areaBiz;

    @Test
    public void testGetAreaList(){
        List<Area> areaList = areaBiz.getAreaList();
        System.out.println(areaList);
    }
}

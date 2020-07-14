package com.jesse.shop.biz;

import com.jesse.shop.entity.Area;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Created by Kong on 2020/6/22.
 */
@SpringBootTest
public class AreaBizTest{
    @Autowired
    private AreaBiz areaBiz;

    @Test
    public void testGetAreaList(){
        List<Area> areaList = areaBiz.getAreaList();
        System.out.println(areaList);
    }
}

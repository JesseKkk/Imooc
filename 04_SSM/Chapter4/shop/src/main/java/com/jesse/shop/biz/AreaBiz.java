package com.jesse.shop.biz;

import com.jesse.shop.entity.Area;

import java.util.List;

/**
 * Created by Kong on 2020/6/22.
 */
public interface AreaBiz {
    public static final String AREALISTKEY = "arealist";

    List<Area> getAreaList();
}

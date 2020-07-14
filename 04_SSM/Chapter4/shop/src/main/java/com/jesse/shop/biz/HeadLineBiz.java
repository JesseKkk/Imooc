package com.jesse.shop.biz;

import com.jesse.shop.entity.HeadLine;

import java.util.List;

/**
 * Created by Kong on 2020/6/30.
 */
public interface HeadLineBiz {
    public static final String HLLISTKEY = "headlinelist";
    List<HeadLine> getHeadLineList(HeadLine headLineCondition);
}

package com.jesse.shop.biz;

import com.jesse.shop.entity.StoreCategory;

import java.util.List;

/**
 * Created by Kong on 2020/6/24.
 */
public interface StoreCategoryBiz {
    public static final String SCLISTKEY = "storecategorylist";
    List<StoreCategory> getStoreCategoryList(StoreCategory storeCategoryCondition);
}

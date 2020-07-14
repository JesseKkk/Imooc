package com.jesse.shop.dao;

import com.jesse.shop.BaseTest;
import com.jesse.shop.entity.StoreCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kong on 2020/6/24.
 */
public class StoreCategoryDaoTest extends BaseTest {

    @Autowired
    private StoreCategoryDao storeCategoryDao;

    @Test
    public void testQueryStoreCategory() {
        List<StoreCategory> storeCategoryList = storeCategoryDao.queryStoreCategory(null);
        System.out.println(storeCategoryList.size());
    }
}

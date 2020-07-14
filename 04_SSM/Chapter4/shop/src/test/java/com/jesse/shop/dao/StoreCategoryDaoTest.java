package com.jesse.shop.dao;

import com.jesse.shop.entity.StoreCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Created by Kong on 2020/6/24.
 */
@SpringBootTest
public class StoreCategoryDaoTest{

    @Autowired
    private StoreCategoryDao storeCategoryDao;

    @Test
    public void testQueryStoreCategory() {
        List<StoreCategory> storeCategoryList = storeCategoryDao.queryStoreCategory(null);
        System.out.println(storeCategoryList.size());
    }
}

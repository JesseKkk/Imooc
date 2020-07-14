package com.jesse.shop.biz;

import com.jesse.shop.BaseTest;
import com.jesse.shop.entity.StoreCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Kong on 2020/7/9.
 */
public class StoreCategoryBizTest extends BaseTest {
    @Autowired
    StoreCategoryBiz storeCategoryBiz;

    @Test
    public void testGetStoreCateogryList() {
        StoreCategory childStoreCategory = new StoreCategory();
        StoreCategory parentStoreCategory = new StoreCategory();
        parentStoreCategory.setStoreCategoryId(12l);
        childStoreCategory.setParent(parentStoreCategory);
        List<StoreCategory> storeCategoryList = storeCategoryBiz.getStoreCategoryList(new StoreCategory());
    }
}

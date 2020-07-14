package com.jesse.shop.dao;

import com.jesse.shop.BaseTest;
import com.jesse.shop.entity.Area;
import com.jesse.shop.entity.PersonInfo;
import com.jesse.shop.entity.Store;
import com.jesse.shop.entity.StoreCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kong on 2020/6/22.
 */
public class StoreDaoTest extends BaseTest {
    @Autowired
    private StoreDao storeDao;

    @Test
    public void testQueryStoreListAndCount() {
        Store storeCondition = new Store();
        StoreCategory childCategory = new StoreCategory();
        StoreCategory parentCategory = new StoreCategory();
        parentCategory.setStoreCategoryId(12l);
        childCategory.setParent(parentCategory);
        storeCondition.setStoreCategory(childCategory);
        List<Store> storeList =  storeDao.queryStoreList(storeCondition,0,6);
        System.out.println("店铺列表的大小" + storeList.size());
        int count = storeDao.queryStoreCount(storeCondition);
        System.out.println("店铺总数" + count);
    }

    @Test
    public void testQueryByStoreId(){
        long storeId = 1l;
        Store store = storeDao.queryByStoreId(storeId);
    }

    @Test
    public void testInsertShop() {
        Store store = new Store();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        StoreCategory storeCategory = new StoreCategory();
        owner.setUserId(1l);
        area.setAreaId(2);
        storeCategory.setStoreCategoryId(1l);
        store.setOwner(owner);
        store.setArea(area);
        store.setStoreCategory(storeCategory);
        store.setStoreName("测试的店铺");
        store.setStoreDesc("test");
        store.setStoreAddr("test");
        store.setPhone("test");
        store.setStoreImg("test");
        store.setPriority(1);
        store.setCreateTime(new Date());
        store.setEnableStatus(1);
        store.setAdvice("审核中");
        int effectedNum = storeDao.insertStore(store);
        assertEquals(1, effectedNum);
    }

    @Test
    public void testUpdateShop() {
        Store store = new Store();
        store.setStoreId(1l);

        store.setStoreDesc("测试描述");
        store.setStoreAddr("测试地址");
        store.setLastEditTime(new Date());

        int effectedNum = storeDao.updateStore(store);
        assertEquals(1, effectedNum);
    }
}

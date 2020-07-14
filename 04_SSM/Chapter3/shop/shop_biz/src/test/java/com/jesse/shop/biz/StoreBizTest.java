package com.jesse.shop.biz;

import com.jesse.shop.BaseTest;
import com.jesse.shop.dto.ImageHolder;
import com.jesse.shop.dto.StoreExecution;
import com.jesse.shop.entity.Area;
import com.jesse.shop.entity.PersonInfo;
import com.jesse.shop.entity.Store;
import com.jesse.shop.entity.StoreCategory;
import com.jesse.shop.enums.StoreStateEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kong on 2020/6/23.
 */
public class StoreBizTest extends BaseTest {
    @Autowired
    private StoreBiz storeBiz;

    @Test
    public void testGetStoreList(){
        Store storeCondition = new Store();
        StoreCategory sc = new StoreCategory();
        sc.setStoreCategoryId(1l);
        storeCondition.setStoreCategory(sc);
        StoreExecution se = storeBiz.getStoreList(storeCondition,2,1);
        System.out.println("店铺列表数为：" + se.getStoreList().size());
        System.out.println("店铺总数数为：" + se.getCount());
    }

    @Test
    public void testModifyShop() throws FileNotFoundException {
        Store store = new Store();
        store.setStoreId(12l);
        store.setStoreName("修改后的店铺名称");
        File storeImg = new File("C:\\Users\\Kong\\Desktop\\jin.jpg");
        InputStream is = new FileInputStream(storeImg);
        ImageHolder imageHolder = new ImageHolder("jin.jpg",is);
        StoreExecution storeExecution = storeBiz.modifyStore(store,imageHolder);
        System.out.println("新的图片地址为：" + storeExecution.getStore().getStoreImg());

    }

    @Test
    public void testAddStore() throws FileNotFoundException {
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
        store.setStoreName("测试的店铺1");
        store.setStoreDesc("test1");
        store.setStoreAddr("test1");
        store.setPhone("test1");
        store.setPriority(1);
        store.setEnableStatus(StoreStateEnum.CHECK.getState());
        store.setAdvice("审核中");
        File storeImg = new File("C:\\Users\\Kong\\Desktop\\kong.jpg");
        InputStream is = new FileInputStream(storeImg);
        ImageHolder imageHolder = new ImageHolder(storeImg.getName(), is);
        StoreExecution se = storeBiz.addStore(store,imageHolder);
        assertEquals(StoreStateEnum.CHECK.getState(), se.getState());
    }
}

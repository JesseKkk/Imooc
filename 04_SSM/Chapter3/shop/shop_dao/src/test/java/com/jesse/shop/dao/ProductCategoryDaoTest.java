package com.jesse.shop.dao;

import com.jesse.shop.BaseTest;
import com.jesse.shop.entity.ProductCategory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kong on 2020/6/26.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductCategoryDaoTest extends BaseTest {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void testBQueryByStoreId(){
        long storeId = 1;
        List<ProductCategory> productCategoryList = productCategoryDao.queryProductCategoryList(storeId);
        System.out.println("该店铺自定义类别数为：" + productCategoryList.size());
    }

    @Test
    public void testABatchInsertProductCategory(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setProductCategoryName("商品类别test1");
        productCategory.setPriority(1);
        productCategory.setCreateTime(new Date());
        productCategory.setStoreId(1l);
        ProductCategory productCategory2 = new ProductCategory();
        productCategory2.setProductCategoryName("商品类别test2");
        productCategory2.setPriority(3);
        productCategory2.setCreateTime(new Date());
        productCategory2.setStoreId(1l);
        List<ProductCategory> productCategories = new ArrayList<ProductCategory>();
        productCategories.add(productCategory);
        productCategories.add(productCategory2);
        int effectedNum = productCategoryDao.batchInsertProductCategory(productCategories);
        assertEquals(2, effectedNum);
    }

    @Test
    public void testCDeleteProductCategory(){
        long storeId = 1;
        List<ProductCategory> productCategoryList = productCategoryDao.queryProductCategoryList(storeId);
        for (ProductCategory pc : productCategoryList){
            if ("商品类别test1".equals(pc.getProductCategoryName()) || "商品类别test2".equals(pc.getProductCategoryName())){
                int effectedNum = productCategoryDao.deleteProductCategory(pc.getProductCategoryId(), storeId);
                assertEquals(1,effectedNum);
            }
        }
    }
}

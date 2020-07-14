package com.jesse.shop.biz;

import com.jesse.shop.BaseTest;
import com.jesse.shop.dao.ProductDao;
import com.jesse.shop.dto.ImageHolder;
import com.jesse.shop.dto.ProductExecution;
import com.jesse.shop.entity.Product;
import com.jesse.shop.entity.ProductCategory;
import com.jesse.shop.entity.Store;
import com.jesse.shop.enums.ProductStateEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kong on 2020/6/29.
 */
public class ProductBizTest extends BaseTest {
    @Autowired
    private ProductBiz productBiz;

    @Test
    public void testAddProduct() throws FileNotFoundException {
        //创建storeId为1且productCategoryId为1的商品
        Product product = new Product();
        Store store = new Store();
        store.setStoreId(1l);
        ProductCategory pc = new ProductCategory();
        pc.setProductCategoryId(1l);
        product.setStore(store);
        product.setProductCategory(pc);
        product.setProductName("测试商品1");
        product.setProductDesc("测试商品1描述");
        product.setPriority(20);
        product.setCreateTime(new Date());
        product.setEnableStatus(ProductStateEnum.SUCCESS.getState());
        //创建缩略图文件流
        File thumbnailFile = new File("C:\\Users\\Kong\\Desktop\\kong.jpg");
        InputStream is = new FileInputStream(thumbnailFile);
        ImageHolder imageHolder = new ImageHolder(thumbnailFile.getName(),is);

        //创建两个商品详情图文件流并将它们添加到详情图列表中
        File thumbnailFile2 = new File("C:\\Users\\Kong\\Desktop\\jin.jpg");
        InputStream is2 = new FileInputStream(thumbnailFile2);
        ImageHolder imageHolder2 = new ImageHolder(thumbnailFile2.getName(),is2);

        File thumbnailFile3 = new File("C:\\Users\\Kong\\Desktop\\xing.png");
        InputStream is3 = new FileInputStream(thumbnailFile3);
        ImageHolder imageHolder3 = new ImageHolder(thumbnailFile3.getName(),is3);
        List<ImageHolder> imageHolderList = new ArrayList<ImageHolder>();
        imageHolderList.add(imageHolder2);
        imageHolderList.add(imageHolder3);
        try {
            ProductExecution pe = productBiz.addProduct(product, imageHolder, imageHolderList);
            assertEquals(ProductStateEnum.SUCCESS.getState(), pe.getState());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testModifyProduct() throws FileNotFoundException {
        //创建storeId为1且productCategoryId为1的商品实例并给成员变量赋值
        Product product = new Product();
        Store store = new Store();
        store.setStoreId(1l);
        ProductCategory pc = new ProductCategory();
        pc.setProductCategoryId(2l);
        product.setProductId(10l);
        product.setStore(store);
        product.setProductCategory(pc);
        product.setProductName("正式的商品");
        product.setProductDesc("正式的商品");
        //创建缩略图文件流
        File thumbnailFile = new File("C:\\Users\\Kong\\Desktop\\kong.jpg");
        InputStream is = new FileInputStream(thumbnailFile);
        ImageHolder imageHolder = new ImageHolder(thumbnailFile.getName(),is);

        //创建两个商品详情图文件流并将它们添加到商品详情图列表中
        File thumbnailFile2 = new File("C:\\Users\\Kong\\Desktop\\jin.jpg");
        InputStream is2 = new FileInputStream(thumbnailFile2);
        ImageHolder imageHolder2 = new ImageHolder(thumbnailFile2.getName(),is2);
        File thumbnailFile3 = new File("C:\\Users\\Kong\\Desktop\\xing.png");
        InputStream is3 = new FileInputStream(thumbnailFile3);
        ImageHolder imageHolder3 = new ImageHolder(thumbnailFile3.getName(),is3);
        List<ImageHolder> imageHolderList = new ArrayList<ImageHolder>();
        imageHolderList.add(imageHolder2);
        imageHolderList.add(imageHolder3);
        //添加商品并验证
        ProductExecution pe = productBiz.modifyProduct(product, imageHolder, imageHolderList);
        assertEquals(ProductStateEnum.SUCCESS.getState(), pe.getState());
    }
}

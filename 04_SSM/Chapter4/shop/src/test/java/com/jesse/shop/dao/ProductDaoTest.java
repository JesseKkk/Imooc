package com.jesse.shop.dao;

import com.jesse.shop.entity.Product;
import com.jesse.shop.entity.ProductCategory;
import com.jesse.shop.entity.ProductImg;
import com.jesse.shop.entity.Store;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Kong on 2020/6/29.
 */
@SpringBootTest
public class ProductDaoTest{
    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductImgDao productImgDao;

    @Test
    public void testAInsertProduct() throws Exception{
        Store store1 = new Store();
        store1.setStoreId(1l);
        ProductCategory pc1 = new ProductCategory();
        pc1.setProductCategoryId(1l);
        Product product1 = new Product();
        product1.setProductName("测试1");
        product1.setProductDesc("测试Desc1");
        product1.setImgAddr("test1");
        product1.setPriority(1);
        product1.setEnableStatus(1);
        product1.setCreateTime(new Date());
        product1.setLastEditTime(new Date());
        product1.setStore(store1);
        product1.setProductCategory(pc1);
        pc1.setProductCategoryId(1l);

        Product product2 = new Product();
        product2.setProductName("测试2");
        product2.setProductDesc("测试Desc2");
        product2.setImgAddr("test2");
        product2.setPriority(2);
        product2.setEnableStatus(0);
        product2.setCreateTime(new Date());
        product2.setLastEditTime(new Date());
        product2.setStore(store1);
        product2.setProductCategory(pc1);

        int effectedNum = productDao.insertProduct(product1);
        assertEquals(1, effectedNum);

        effectedNum = productDao.insertProduct(product2);
        assertEquals(1, effectedNum);
    }

    @Test
    public void testCQueryProductByProductId(){
        long productId = 1l;
        //prductId为1的商品里添加两个详情图片记录
        ProductImg productImg1 = new ProductImg();
        productImg1.setImgAddr("图片1");
        productImg1.setImgAddr("测试图片1");
        productImg1.setPriority(1);
        productImg1.setCreateTime(new Date());
        productImg1.setProductId(productId);
        ProductImg productImg2 = new ProductImg();
        productImg2.setImgAddr("图片2");
        productImg2.setImgAddr("测试图片2");
        productImg2.setPriority(2);
        productImg2.setCreateTime(new Date());
        productImg2.setProductId(productId);
        List<ProductImg> productImgList = new ArrayList<ProductImg>();
        productImgList.add(productImg1);
        productImgList.add(productImg2);
        int effectedNum = productImgDao.batchInsertProductImg(productImgList);
        assertEquals(2, effectedNum);
        Product product = productDao.queryProductById(productId);
        assertEquals(2, product.getProductImgList().size());
        effectedNum = productImgDao.deleteProductImgByProductId(productId);
        assertEquals(2, effectedNum);
    }

    @Test
    public void testDUpdateProduct(){
        Product product = new Product();
        ProductCategory pc = new ProductCategory();
        Store store = new Store();
        store.setStoreId(1l);
        pc.setProductCategoryId(1l);
        product.setProductId(1l);
        product.setStore(store);
        product.setProductName("第一个产品");
        product.setProductCategory(pc);
        //修改productId为1的商品的名称
        //以及商品类别并校验影响的行数是否为1
        int effectedNum = productDao.updateProduct(product);
        assertEquals(1, effectedNum);
    }

    @Test
    public void testBQueryProductList(){
        Product productCondition = new Product();
        //分页查询，预期返回三条结果
        List<Product> productList = productDao.queryProductList(productCondition, 0, 3);
        assertEquals(3, productList.size());
        //查询名称为测试的商品总数
        int count = productDao.queryProductCount(productCondition);
        assertEquals(5, count);
        //使用商品名称模糊查询，预期返回两条结果
        productCondition.setProductName("测试");
        productList = productDao.queryProductList(productCondition, 0, 3);
        assertEquals(2, productList.size());
        count = productDao.queryProductCount(productCondition);
        assertEquals(2, count);
    }

    @Test
    public void testEUpdateProductCategoryToNull(){
        //将productCategoryId为2的商品类别下面的商品的商品类别置为空
        int effectedNum = productDao.updateProductCategoryToNull(2l);
        assertEquals(1, effectedNum);
    }
}

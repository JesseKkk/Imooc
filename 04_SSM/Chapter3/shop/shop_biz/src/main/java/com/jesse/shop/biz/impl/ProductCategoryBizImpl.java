package com.jesse.shop.biz.impl;

import com.jesse.shop.biz.ProductCategoryBiz;
import com.jesse.shop.dao.ProductCategoryDao;
import com.jesse.shop.dao.ProductDao;
import com.jesse.shop.dto.ProductCategoryExecution;
import com.jesse.shop.entity.ProductCategory;
import com.jesse.shop.enums.ProductCategoryStateEnum;
import com.jesse.shop.exceptions.ProductOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kong on 2020/6/28.
 */
@Service("productCategoryBiz")
public class ProductCategoryBizImpl implements ProductCategoryBiz {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Autowired
    private ProductDao productDao;

    public List<ProductCategory> getProductCategoryList(Long storeId) {
        return productCategoryDao.queryProductCategoryList(storeId);
    }

    public ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList) throws ProductOperationException {
        if (productCategoryList != null && productCategoryList.size() > 0){
            int effectedNum = productCategoryDao.batchInsertProductCategory(productCategoryList);
            if (effectedNum <= 0){
                throw new ProductOperationException("店铺创建失败");
            }else {
                return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
            }
        }else {
            return new ProductCategoryExecution(ProductCategoryStateEnum.EMPTY_LIST);
        }
    }

    public ProductCategoryExecution deleteProductCategory(long productCategoryId, long storeId) throws ProductOperationException {
        //解除tb_product里的商品与该productcategoryId的关联
        try{
            int effectedNum = productDao.updateProductCategoryToNull(productCategoryId);
            if (effectedNum < 0){
                throw new RuntimeException("商品类别更新失败");
            }
        }catch (Exception e){
            throw new RuntimeException("deleteProductCategory error:" + e.getMessage());
        }
        //删除该productCategory
        try{
            int effectedNum = productCategoryDao.deleteProductCategory(productCategoryId, storeId);
            if (effectedNum <= 0){
                throw new ProductOperationException("商品类别删除失败");
            }else {
                return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
            }
        }catch (Exception e){
            throw new ProductOperationException("deleteProductCatgegory error:" + e.getMessage());
        }
    }
}

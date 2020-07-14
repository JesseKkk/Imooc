package com.jesse.shop.biz;

import com.jesse.shop.dto.ProductCategoryExecution;
import com.jesse.shop.entity.ProductCategory;
import com.jesse.shop.exceptions.ProductOperationException;

import java.util.List;

/**
 * Created by Kong on 2020/6/28.
 */
public interface ProductCategoryBiz {
    List<ProductCategory> getProductCategoryList(Long storeId);
    ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList) throws ProductOperationException;
    ProductCategoryExecution deleteProductCategory(long productCategoryId, long storeId) throws ProductOperationException;
}

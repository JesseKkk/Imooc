package com.jesse.shop.dao;

import com.jesse.shop.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Kong on 2020/6/26.
 */
@Repository("productCategoryDao")
public interface ProductCategoryDao {
    List<ProductCategory> queryProductCategoryList(long storeId);

    int batchInsertProductCategory(List<ProductCategory> productCategoryList);

    int deleteProductCategory(@Param("productCategoryId") long productCategoryId, @Param("storeId") long storeId);
}

package com.jesse.shop.dao;

import com.jesse.shop.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Kong on 2020/6/28.
 */
@Repository("productDao")
public interface ProductDao {
    int insertProduct(Product product);
    Product queryProductById(long productId);
    int updateProduct(Product product);
    List<Product> queryProductList(@Param("productCondition") Product productCondition,
                                   @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);
    int queryProductCount(@Param("productCondition") Product productCondition);
    int updateProductCategoryToNull(long productCategoryId);
}

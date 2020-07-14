package com.jesse.shop.dao;

import com.jesse.shop.entity.ProductImg;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Kong on 2020/6/28.
 */
@Repository("productImgDao")
public interface ProductImgDao {
    int batchInsertProductImg(List<ProductImg> productImgList);
    int deleteProductImgByProductId(long productId);
    List<ProductImg> queryProductImgList(long productId);
}

package com.jesse.shop.biz;

import com.jesse.shop.dto.ImageHolder;
import com.jesse.shop.dto.ProductExecution;
import com.jesse.shop.entity.Product;
import com.jesse.shop.exceptions.ProductOperationException;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Kong on 2020/6/29.
 */
public interface ProductBiz {
    ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgHolderList) throws ProductOperationException;

    Product getProductById(long productId);

    ProductExecution modifyProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgHolderList) throws ProductOperationException;

    ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize);
}

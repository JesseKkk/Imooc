package com.jesse.shop.biz;

import com.jesse.shop.dto.ImageHolder;
import com.jesse.shop.dto.StoreExecution;
import com.jesse.shop.entity.Store;

import java.io.File;
import java.io.InputStream;

/**
 * Created by Kong on 2020/6/23.
 */
public interface StoreBiz {
    Store getByStoreId(long storeId);
    StoreExecution modifyStore(Store store, ImageHolder thumbnail);
    StoreExecution addStore(Store store, ImageHolder thumbnail);
    StoreExecution getStoreList(Store storeCondition, int pageIndex, int pageSize);
}

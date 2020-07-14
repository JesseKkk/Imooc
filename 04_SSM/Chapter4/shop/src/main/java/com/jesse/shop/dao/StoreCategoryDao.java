package com.jesse.shop.dao;

import com.jesse.shop.entity.StoreCategory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Kong on 2020/6/24.
 */
@Repository("storeCategoryDao")
public interface StoreCategoryDao {
    List<StoreCategory> queryStoreCategory(@Param("storeCategoryCondition") StoreCategory storeCategoryCondition);
}

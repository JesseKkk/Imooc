package com.jesse.shop.dao;

import com.jesse.shop.entity.Store;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Kong on 2020/6/22.
 */
@Repository("storeDao")
public interface StoreDao {
    int insertStore(Store store);

    int updateStore(Store store);

    Store queryByStoreId(long storeId);

    /**
     * 分页查询店铺，可输入的条件有：店铺名（模糊），店铺状态，店铺类别，区域Id、owwner
     * @param storeCondition
     * @param rowIndex 从第几行开始取数据
     * @param pageSize pageSize返回的条数
     * @return
     */
    List<Store> queryStoreList(@Param("storeCondition") Store storeCondition, @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);

    int queryStoreCount(@Param("storeCondition") Store storeCondition);
}

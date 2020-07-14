package com.jesse.shop.biz.impl;

import com.jesse.shop.biz.StoreBiz;
import com.jesse.shop.dao.StoreDao;
import com.jesse.shop.dto.ImageHolder;
import com.jesse.shop.dto.StoreExecution;
import com.jesse.shop.entity.Store;
import com.jesse.shop.enums.StoreStateEnum;
import com.jesse.shop.exceptions.StoreOperationException;
import com.jesse.shop.util.ImageUtil;
import com.jesse.shop.util.PageCalculator;
import com.jesse.shop.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by Kong on 2020/6/23.
 */
@Service("storeBiz")
public class StoreBizImpl implements StoreBiz {

    @Autowired
    private StoreDao storeDao;

    public Store getByStoreId(long storeId) {
        return storeDao.queryByStoreId(storeId);
    }

    public StoreExecution modifyStore(Store store, ImageHolder thumbnail) {
        if (store == null || store.getStoreId() == null){
            return new StoreExecution(StoreStateEnum.NULL_STORE);
        } else {
            try {
                //1、判断是否需要处理图片
                if (thumbnail.getImage() != null && thumbnail.getImageName() != null && !"".equals(thumbnail.getImageName())) {
                    Store tempStore = storeDao.queryByStoreId(store.getStoreId());
                    if (tempStore.getStoreImg() != null) {
                        ImageUtil.deleteFileOrPath(tempStore.getStoreImg());
                    }
                    addStoreImg(store, thumbnail);
                }
                //2、更新店铺信息
                store.setLastEditTime(new Date());
                int effectedNum = storeDao.updateStore(store);
                if (effectedNum <= 0) {
                    return new StoreExecution(StoreStateEnum.INNER_ERROR);
                } else {
                    store = storeDao.queryByStoreId(store.getStoreId());
                    return new StoreExecution(StoreStateEnum.SUCCESS, store);
                }
            }catch (Exception e) {
                throw new StoreOperationException("modifyStore error:" + e.getMessage());
            }

        }
    }

    public StoreExecution addStore(Store store, ImageHolder thumbnail) {
        //空值判断
        if (store == null) {
            return new StoreExecution(StoreStateEnum.NULL_STORE);
        }
        try{
            //给店铺信息赋初始值
            store.setEnableStatus(0);
            store.setCreateTime(new Date());
            store.setLastEditTime(new Date());
            //添加店铺信息
            int effectedNum = storeDao.insertStore(store);
            if (effectedNum <= 0) {
                throw new StoreOperationException("店铺创建失败");
            } else{
                if (thumbnail.getImage() != null) {
                    //存储图片
                    try{
                        addStoreImg(store, thumbnail);
                    } catch (Exception e) {
                        throw new StoreOperationException("addStoreImg error:" + e.getMessage());
                    }
                    //更新店铺的图片地址
                    effectedNum = storeDao.updateStore(store);
                    if (effectedNum <= 0) {
                        throw new StoreOperationException("更新图片地址失败");
                    }
                }
            }
        } catch (Exception e) {
            throw new StoreOperationException("addStore error:" + e.getMessage());
        }
        return new StoreExecution(StoreStateEnum.CHECK, store);
    }

    public StoreExecution getStoreList(Store storeCondition, int pageIndex, int pageSize) {
        int rowIndex = PageCalculator.calculateRowIndex(pageIndex, pageSize);
        List<Store> storeList = storeDao.queryStoreList(storeCondition,rowIndex,pageSize);
        int count = storeDao.queryStoreCount(storeCondition);
        StoreExecution se = new StoreExecution();
        if (storeList != null){
            se.setStoreList(storeList);
            se.setCount(count);
        } else {
            se.setState(StoreStateEnum.INNER_ERROR.getState());
        }
        return se;
    }

    private void addStoreImg(Store store, ImageHolder thumbnail) {
        //获取store图片目录的相对值路径
        String dest = PathUtil.getStoreImagePath(store.getStoreId());
        String storeImgAddr = ImageUtil.generateThumbnail(thumbnail,dest);
        store.setStoreImg(storeImgAddr);
    }
}

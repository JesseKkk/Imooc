package com.jesse.shop.dto;

import com.jesse.shop.entity.Store;
import com.jesse.shop.enums.StoreStateEnum;

import java.util.List;

/**
 * Created by Kong on 2020/6/23.
 */
public class StoreExecution {
    //结果状态
    private int state;

    //状态标识
    private String stateInfo;

    //店铺数量
    private int count;

    //操作的store（增删改店铺的时候用到）
    private Store store;

    //store列表（查询店铺列表的时候用到）
    private List<Store> storeList;

    public StoreExecution() {

    }

    //店铺操作失败的时候使用的构造器
    public StoreExecution(StoreStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo =stateEnum.getStateInfo();
    }

    //店铺操作成功的时候使用的构造器
    public StoreExecution(StoreStateEnum stateEnum, Store store) {
        this.state = stateEnum.getState();
        this.stateInfo =stateEnum.getStateInfo();
        this.store = store;
    }

    //店铺操作成功的时候使用的构造器
    public StoreExecution(StoreStateEnum stateEnum, List<Store> storeList) {
        this.state = stateEnum.getState();
        this.stateInfo =stateEnum.getStateInfo();
        this.storeList = storeList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public List<Store> getStoreList() {
        return storeList;
    }

    public void setStoreList(List<Store> storeList) {
        this.storeList = storeList;
    }
}

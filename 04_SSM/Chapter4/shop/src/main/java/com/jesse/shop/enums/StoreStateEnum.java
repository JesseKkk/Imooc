package com.jesse.shop.enums;

/**
 * Created by Kong on 2020/6/23.
 */
public enum StoreStateEnum {
    CHECK(0, "审核中"), OFFLINE(-1, "非法店铺"),SUCCESS(1, "操作成功"),
    PASS(2, "通过认证"), INNER_ERROR(-1001, "内部系统错误"),NULL_STOREID(-1002,"StoreId为空"),
    NULL_STORE(-1003,"store信息为空");
    private int state;
    private String stateInfo;

    private StoreStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    //依据传入的state返回响应的enum值
    public  static StoreStateEnum stateOf(int state) {
        for (StoreStateEnum stateEnum : StoreStateEnum.values()) {
            if (stateEnum.getState() == state) {
                return stateEnum;
            }
        }
        return null;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
}

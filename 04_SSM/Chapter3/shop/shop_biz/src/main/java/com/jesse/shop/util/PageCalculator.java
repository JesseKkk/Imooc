package com.jesse.shop.util;

/**
 * Created by Kong on 2020/6/26.
 */
public class PageCalculator {
    public static int calculateRowIndex(int pageIndex, int pageSize) {
        return (pageIndex > 0)?(pageIndex - 1) * pageSize:0;
    }
}

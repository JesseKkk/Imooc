package com.jesse.shop.exceptions;

/**
 * Created by Kong on 2020/6/23.
 */
public class StoreCategoryOperationException extends RuntimeException {
    public StoreCategoryOperationException(String msg) {
        super(msg);
    }
}

package com.jesse.shop.exceptions;

/**
 * Created by Kong on 2020/6/23.
 */
public class StoreOperationException extends RuntimeException {
    public StoreOperationException(String msg) {
        super(msg);
    }
}

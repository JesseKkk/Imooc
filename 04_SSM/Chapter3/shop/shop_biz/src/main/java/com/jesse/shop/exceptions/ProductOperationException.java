package com.jesse.shop.exceptions;

/**
 * Created by Kong on 2020/6/23.
 */
public class ProductOperationException extends RuntimeException {
    public ProductOperationException(String msg) {
        super(msg);
    }
}

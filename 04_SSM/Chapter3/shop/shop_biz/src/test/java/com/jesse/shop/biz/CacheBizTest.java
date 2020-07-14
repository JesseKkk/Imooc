package com.jesse.shop.biz;

import com.jesse.shop.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Kong on 2020/7/9.
 */
public class CacheBizTest extends BaseTest {

    @Autowired
    CacheBiz cacheBiz;

    @Test
    public void testRemoveFromCache() {
        cacheBiz.removeFromCache("store");
    }
}

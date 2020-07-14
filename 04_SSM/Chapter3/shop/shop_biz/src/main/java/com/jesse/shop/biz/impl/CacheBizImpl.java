package com.jesse.shop.biz.impl;

import com.jesse.shop.biz.CacheBiz;
import com.jesse.shop.cache.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.Set;

/**
 * Created by Kong on 2020/7/9.
 */
@Service("cacheBiz")
public class CacheBizImpl implements CacheBiz {

    @Autowired
    private JedisUtil.Keys jedisKeys;

    public void removeFromCache(String keyPrefix) {
        Set<String> keySet = jedisKeys.keys(keyPrefix + "*");
        for (String key : keySet) {
            jedisKeys.del(key);
        }
    }
}

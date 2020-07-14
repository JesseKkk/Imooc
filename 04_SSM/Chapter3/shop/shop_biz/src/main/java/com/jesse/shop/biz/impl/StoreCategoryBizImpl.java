package com.jesse.shop.biz.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jesse.shop.biz.StoreCategoryBiz;
import com.jesse.shop.cache.JedisUtil;
import com.jesse.shop.dao.StoreCategoryDao;
import com.jesse.shop.entity.HeadLine;
import com.jesse.shop.entity.StoreCategory;
import com.jesse.shop.exceptions.HeadLineOperationException;
import com.jesse.shop.exceptions.StoreCategoryOperationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kong on 2020/6/24.
 */
@Service("storeCategoryBiz")
public class StoreCategoryBizImpl implements StoreCategoryBiz {
    @Autowired
    StoreCategoryDao storeCategoryDao;

    @Autowired
    private JedisUtil.Keys jedisKeys;

    @Autowired
    private JedisUtil.Strings jedisStrings;

    private static Logger logger = LoggerFactory.getLogger(StoreCategoryBizImpl.class);

    public List<StoreCategory> getStoreCategoryList(StoreCategory storeCategoryCondition) {
        String key = SCLISTKEY;
        List<StoreCategory> storeCategoryList = null;
        String jsonString = null;
        ObjectMapper mapper = new ObjectMapper();
        if (storeCategoryCondition == null){
            key = key + "_allfirstlevel";
        }else if (storeCategoryCondition != null && storeCategoryCondition.getParent() != null
                && storeCategoryCondition.getParent().getStoreCategoryId() != null){
            key = key + "_parent" + storeCategoryCondition.getParent().getStoreCategoryId();
        }else if (storeCategoryCondition != null){
            key = key + "_allsecondlevel";
        }

        if (!jedisKeys.exists(key)){
            storeCategoryList = storeCategoryDao.queryStoreCategory(storeCategoryCondition);
            try {
                jsonString = mapper.writeValueAsString(storeCategoryList);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                logger.error(e.getMessage());
                throw new StoreCategoryOperationException(e.getMessage());
            }
            jedisStrings.set(key, jsonString);
        }else {
            jsonString = jedisStrings.get(key);
            JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, StoreCategory.class);
            try {
                storeCategoryList = mapper.readValue(jsonString, javaType);
            } catch (IOException e) {
                e.printStackTrace();
                logger.error(e.getMessage());
                throw new StoreCategoryOperationException(e.getMessage());
            }
        }
        return storeCategoryList;
    }
}

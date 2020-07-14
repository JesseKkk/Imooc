package com.jesse.shop.biz.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jesse.shop.biz.HeadLineBiz;
import com.jesse.shop.cache.JedisUtil;
import com.jesse.shop.dao.HeadLineDao;
import com.jesse.shop.entity.Area;
import com.jesse.shop.entity.HeadLine;
import com.jesse.shop.exceptions.AreaOperationException;
import com.jesse.shop.exceptions.HeadLineOperationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kong on 2020/6/30.
 */
@Service("headLineBiz")
public class HeadLineBizImpl implements HeadLineBiz {

    @Autowired
    private HeadLineDao headLineDao;

    @Autowired
    private JedisUtil.Keys jedisKeys;

    @Autowired
    private JedisUtil.Strings jedisStrings;

    private static Logger logger = LoggerFactory.getLogger(HeadLineBizImpl.class);

    public List<HeadLine> getHeadLineList(HeadLine headLineCondition) {
        String key = HLLISTKEY;
        List<HeadLine> headLineList = null;
        String jsonString = null;
        ObjectMapper mapper = new ObjectMapper();
        if (headLineCondition != null && headLineCondition.getEnableStatus() != null) {
            key = key + "_" + headLineCondition.getEnableStatus();
        }
        if (!jedisKeys.exists(key)){
            headLineList = headLineDao.queryHeadLine(headLineCondition);
            try {
                jsonString = mapper.writeValueAsString(headLineList);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                logger.error(e.getMessage());
                throw new HeadLineOperationException(e.getMessage());
            }
            jedisStrings.set(key,jsonString);
        }else {
            jsonString = jedisStrings.get(key);
            JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, HeadLine.class);
            try {
                headLineList = mapper.readValue(jsonString, javaType);
            } catch (IOException e) {
                e.printStackTrace();
                logger.error(e.getMessage());
                throw new HeadLineOperationException(e.getMessage());
            }
        }

        return headLineList;
    }
}

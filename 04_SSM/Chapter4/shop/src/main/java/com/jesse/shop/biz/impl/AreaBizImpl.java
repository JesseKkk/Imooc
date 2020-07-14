package com.jesse.shop.biz.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jesse.shop.biz.AreaBiz;
import com.jesse.shop.cache.JedisUtil;
import com.jesse.shop.dao.AreaDao;
import com.jesse.shop.entity.Area;
import com.jesse.shop.exceptions.AreaOperationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kong on 2020/6/22.
 */
@Service("areaBiz")
public class AreaBizImpl implements AreaBiz {

    @Autowired
    private AreaDao areaDao;

    @Autowired
    private JedisUtil.Keys jedisKeys;

    @Autowired
    private JedisUtil.Strings jedisStrings;

    private static Logger logger = LoggerFactory.getLogger(AreaBizImpl.class);

    @Transactional(readOnly = true)
    public List<Area> getAreaList() {
        String key = AREALISTKEY;
        List<Area> areaList = null;
        String jsonString = null;
        ObjectMapper mapper = new ObjectMapper();
        if (!jedisKeys.exists(key)){
            areaList = areaDao.queryArea();
            try {
                jsonString = mapper.writeValueAsString(areaList);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                logger.error(e.getMessage());
                throw new AreaOperationException(e.getMessage());
            }
            jedisStrings.set(key, jsonString);
        }else {
            jsonString = jedisStrings.get(key);
            JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, Area.class);
            try {
                areaList = mapper.readValue(jsonString, javaType);
            } catch (IOException e) {
                e.printStackTrace();
                logger.error(e.getMessage());
                throw new AreaOperationException(e.getMessage());
            }
        }

        return areaList;
    }
}

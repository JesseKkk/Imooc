package com.jesse.shop.dao;

import com.jesse.shop.entity.Area;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Kong on 2020/6/22.
 */
@Repository("areaDao")
public interface AreaDao {
    List<Area> queryArea();
}

package com.jesse.hm.common.service;

import com.jesse.hm.common.entity.Dept;

import java.util.List;

/**
 * Created by Kong on 2020/5/22.
 */
public interface DeptService {
    void add(Dept dept);
    void remove(Integer id);
    void edit(Dept dept);
    Dept get(Integer id);
    List<Dept> getCid(Integer cid);
}

package com.jesse.hm.common.dao;

import com.jesse.hm.common.entity.Dept;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Kong on 2020/5/22.
 */
@Repository("deptDao")
public interface DeptDao {
    void insert(Dept dept);
    void delete(Integer id);
    void update(Dept dept);
    Dept selectById(Integer id);
    List<Dept> selectByCid(Integer cid);
}

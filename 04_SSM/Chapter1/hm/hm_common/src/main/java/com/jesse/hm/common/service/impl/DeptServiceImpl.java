package com.jesse.hm.common.service.impl;

import com.jesse.hm.common.dao.DeptDao;
import com.jesse.hm.common.entity.Dept;
import com.jesse.hm.common.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kong on 2020/5/22.
 */
@Service("deptService")
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    public void add(Dept dept) {
        deptDao.insert(dept);
    }

    public void remove(Integer id) {
        deptDao.delete(id);
    }

    public void edit(Dept dept) {
        deptDao.update(dept);
    }

    public Dept get(Integer id) {
        return deptDao.selectById(id);
    }

    public List<Dept> getCid(Integer cid) {
        return deptDao.selectByCid(cid);
    }
}

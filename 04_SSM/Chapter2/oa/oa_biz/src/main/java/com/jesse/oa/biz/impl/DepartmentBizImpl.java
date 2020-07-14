package com.jesse.oa.biz.impl;

import com.jesse.oa.biz.DepartmentBiz;
import com.jesse.oa.dao.DepartmentDao;
import com.jesse.oa.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kong on 2020/6/4.
 */
@Service("departmentBiz")
public class DepartmentBizImpl implements DepartmentBiz {

    @Autowired
    @Qualifier("departmentDao")
    private DepartmentDao departmentDao;

    public void add(Department department) {
        departmentDao.insert(department);
    }

    public void remove(String sn) {
        departmentDao.delete(sn);
    }

    public void edit(Department department) {
        departmentDao.update(department);
    }

    public Department get(String sn) {
        return departmentDao.select(sn);
    }

    public List<Department> getAll() {
        return departmentDao.selectAll();
    }
}

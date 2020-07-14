package com.jesse.oa.biz;

import com.jesse.oa.entity.Department;

import java.util.List;

/**
 * Created by Kong on 2020/6/4.
 */
public interface DepartmentBiz {

    void add(Department department);
    void remove(String sn);
    void edit(Department department);
    Department get(String sn);
    List<Department> getAll();
}

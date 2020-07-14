package com.jesse.oa.biz;

import com.jesse.oa.entity.Department;
import com.jesse.oa.entity.Employee;

import java.util.List;

/**
 * Created by Kong on 2020/6/4.
 */
public interface EmployeeBiz {

    void add(Employee employee);
    void edit(Employee employee);
    void remove(String sn);
    Employee get(String sn);
    List<Employee> getAll();
}

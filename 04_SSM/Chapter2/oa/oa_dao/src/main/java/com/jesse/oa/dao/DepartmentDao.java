package com.jesse.oa.dao;

import com.jesse.oa.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Kong on 2020/6/4.
 */
@Repository("departmentDao")
public interface DepartmentDao {
    void insert(Department department);
    void delete(String sn);
    void update(Department department);
    Department select(String sn);
    List<Department> selectAll();
}

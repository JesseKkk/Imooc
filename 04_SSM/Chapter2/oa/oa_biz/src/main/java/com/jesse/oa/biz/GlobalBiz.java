package com.jesse.oa.biz;

import com.jesse.oa.entity.Employee;

/**
 * Created by Kong on 2020/6/5.
 */
public interface GlobalBiz {

    Employee login(String sn, String password);
    void changePassword(Employee employee);
}

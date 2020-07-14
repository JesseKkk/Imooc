package com.jesse.bbs.dao;

import com.jesse.bbs.entity.Admin;
import org.springframework.stereotype.Repository;

/**
 * Created by Kong on 2020/6/11.
 */
@Repository("adminDao")
public interface AdminDao {
    Admin select(String username);
}

package com.jesse.bbs.biz;

import com.jesse.bbs.entity.Admin;
import org.springframework.stereotype.Service;

/**
 * Created by Kong on 2020/6/11.
 */
public interface AdminBiz {
    Admin login(String username, String password);
}

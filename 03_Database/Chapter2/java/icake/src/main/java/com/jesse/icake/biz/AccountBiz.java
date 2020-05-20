package com.jesse.icake.biz;

import com.jesse.icake.entity.Account;

public interface AccountBiz {
    Account login(String name, String password);
}

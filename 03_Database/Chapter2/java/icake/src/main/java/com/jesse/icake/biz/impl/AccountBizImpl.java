package com.jesse.icake.biz.impl;

import com.jesse.icake.biz.AccountBiz;
import com.jesse.icake.dao.AccountDao;
import com.jesse.icake.entity.Account;
import com.jesse.icake.global.DaoFactory;

import java.util.List;

public class AccountBizImpl implements AccountBiz {

    private AccountDao accountDao = DaoFactory.getInstance().getDao(AccountDao.class);

    public Account login(String name, String password) {
        List<Account> list = accountDao.selectByName(name);
        for (Account account : list) {
            if (account.getPassword().equals(password))
                return account;
        }
        return null;
    }
}

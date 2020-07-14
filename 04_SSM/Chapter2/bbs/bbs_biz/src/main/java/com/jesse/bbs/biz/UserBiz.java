package com.jesse.bbs.biz;

import com.jesse.bbs.entity.User;

import java.util.List;

/**
 * Created by Kong on 2020/6/11.
 */
public interface UserBiz {
    void add(User user);
    void edit(User user);
    void remove(int id);
    User get(int id);
    User getByName(String username);
    List<User> getAll();
    void lock(int id);
    void unLock(int id);
    void register(User user);
    User login(String username, String password);
}

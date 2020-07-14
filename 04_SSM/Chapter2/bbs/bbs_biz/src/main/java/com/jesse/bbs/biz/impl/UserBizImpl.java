package com.jesse.bbs.biz.impl;

import com.jesse.bbs.biz.UserBiz;
import com.jesse.bbs.dao.UserDao;
import com.jesse.bbs.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kong on 2020/6/11.
 */
@Service("userBiz")
public class UserBizImpl implements UserBiz {

    @Autowired
    private UserDao userDao;

    public void add(User user) {
        userDao.insert(user);
    }

    public void edit(User user) {
        userDao.update(user);
    }

    //设置用户状态为删除状态
    public void remove(int id) {
        User user = userDao.select(id);
        user.setUserStatus(2);
        userDao.update(user);
    }

    public User get(int id) {
        return userDao.select(id);
    }

    public User getByName(String username) {
        return userDao.selectByName(username);
    }

    //查询所有正常和锁定状态的用户
    public List<User> getAll() {
        return userDao.selectAll();
    }

    public void lock(int id) {
        User user = userDao.select(id);
        user.setUserStatus(1);
        userDao.update(user);
    }

    public void unLock(int id) {
        User user = userDao.select(id);
        user.setUserStatus(0);
        userDao.update(user);
    }

    public void register(User user) {
        user.setUserStatus(0);
        userDao.insert(user);
    }

    public User login(String username, String password) {
        User user = userDao.selectByName(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}

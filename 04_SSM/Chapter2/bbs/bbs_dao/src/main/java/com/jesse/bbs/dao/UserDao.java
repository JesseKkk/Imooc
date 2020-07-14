package com.jesse.bbs.dao;

import com.jesse.bbs.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Kong on 2020/6/11.
 */
@Repository("userDao")
public interface UserDao {
    void insert(User user);
    void update(User user);
    User select(int id);
    User selectByName(String username);
    List<User> selectAll();
}

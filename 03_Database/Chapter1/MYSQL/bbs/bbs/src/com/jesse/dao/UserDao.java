package com.jesse.dao;

import com.jesse.domain.User;

public interface UserDao {

	void add(User user);

	User login(User user);

	void update(User user);

}

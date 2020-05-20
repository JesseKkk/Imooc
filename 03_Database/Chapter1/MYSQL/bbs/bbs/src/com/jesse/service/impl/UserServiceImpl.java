package com.jesse.service.impl;

import com.jesse.dao.UserDao;
import com.jesse.dao.impl.UserDaoImpl;
import com.jesse.domain.User;
import com.jesse.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public void add(User user) {
		UserDao userDao = new UserDaoImpl();
		userDao.add(user);
	}

	@Override
	public User login(User user) {
		UserDao userDao = new UserDaoImpl();
		return userDao.login(user);
	}

	@Override
	public void update(User user) {
		UserDao userDao = new UserDaoImpl();
		userDao.update(user);
	}

}

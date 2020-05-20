package com.jesse.service.impl;

import com.jesse.dao.UserDao;
import com.jesse.dao.impl.UserDaoImpl;
import com.jesse.domain.User;
import com.jesse.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public User login(User user) {
		//调用DAO的方法查询用户是否存在
		UserDao userDao = new UserDaoImpl();
		return userDao.login(user);
	}

}

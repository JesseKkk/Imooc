package com.jesse.service;

import java.util.List;

import com.jesse.domain.User;

public interface UserService {
	public void regist(List<User> userList, User user);

	public User login(List<User> userList, User user);
}

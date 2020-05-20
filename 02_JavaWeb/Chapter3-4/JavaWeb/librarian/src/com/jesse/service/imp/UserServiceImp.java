package com.jesse.service.imp;

import java.util.List;

import com.jesse.domain.User;
import com.jesse.service.UserService;

public class UserServiceImp implements UserService {

	@Override
	public User login(List<User> userList, User user) {
		for(User a : userList) {
			if(a.getUsername().equals(user.getUsername()) && a.getPassword().equals(user.getPassword())) {
				return a;
			}
		}
		return null;
	}
}

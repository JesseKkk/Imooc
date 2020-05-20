package com.jesse.service.imp;

import java.util.List;

import com.jesse.domain.User;
import com.jesse.service.UserService;

public class UserServiceImp implements UserService {

	@Override
	public void regist(List<User> userList, User user) {
		// 保存用户的信息：
		userList.add(user);
	}

	@Override
	public User login(List<User> userList, User user) {
		for(User existUser : userList) {
			if(existUser.getUsername().equals(user.getUsername()) && existUser.getPassword().equals(user.getPassword())) {
				return existUser;
			}
		}
		return null;
	}

	

}

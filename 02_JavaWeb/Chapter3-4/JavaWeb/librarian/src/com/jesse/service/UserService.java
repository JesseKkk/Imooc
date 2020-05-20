package com.jesse.service;

import java.util.List;

import com.jesse.domain.User;

public interface UserService {

	User login(List<User> userList, User user);

}

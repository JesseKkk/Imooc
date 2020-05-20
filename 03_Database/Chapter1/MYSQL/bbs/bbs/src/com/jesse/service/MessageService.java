package com.jesse.service;

import com.jesse.domain.Message;
import com.jesse.domain.PageBean;
import com.jesse.domain.User;

public interface MessageService {

	void add(Message message);

	Message find(int mid);

	void update(Message message);

	void delete(int mid);

	PageBean findByPage(int page);

	PageBean findByPage(int page, User existUser);

}

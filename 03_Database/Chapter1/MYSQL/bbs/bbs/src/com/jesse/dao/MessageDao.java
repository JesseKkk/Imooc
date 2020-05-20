package com.jesse.dao;

import java.util.List;

import com.jesse.domain.Message;
import com.jesse.domain.User;

public interface MessageDao {

	void add(Message message);

	Message find(int mid);

	void update(Message message);

	void delete(int mid);

	int findCount();

	List<Message> findByPage(int begin, int limit);

	int findCount(User existUser);

	List<Message> findByPage(User existUser, int begin, int limit);

}

package com.jesse.service.impl;

import java.util.List;

import com.jesse.dao.MessageDao;
import com.jesse.dao.impl.MessageDaoImpl;
import com.jesse.domain.Message;
import com.jesse.domain.PageBean;
import com.jesse.domain.User;
import com.jesse.service.MessageService;

public class MessageServiceImpl implements MessageService {

	@Override
	public void add(Message message) {
		MessageDao messageDao = new MessageDaoImpl();
		messageDao.add(message);
	}

	@Override
	public Message find(int mid) {
		MessageDao messageDao = new MessageDaoImpl();
		return messageDao.find(mid);
	}

	@Override
	public void update(Message message) {
		MessageDao messageDao = new MessageDaoImpl();
		messageDao.update(message);		
	}

	@Override
	public void delete(int mid) {
		MessageDao messageDao = new MessageDaoImpl();
		messageDao.delete(mid);		
	}

	@Override
	public PageBean findByPage(int page) {
		PageBean pageBean = new PageBean();
		//封装当前的页数：
		pageBean.setPage(page);
		//封装每页显示记录数
		int limit = 6;
		pageBean.setLimit(limit);
		//封装总记录数：
		MessageDao messageDao = new MessageDaoImpl();
		int totalCount = messageDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数：（根据总记录数进行计算）
		int totalPage = 0;
		if(totalCount%limit == 0) {
			totalPage = totalCount/limit;
		}else {
			totalPage = totalCount/limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		//封装每页显示数据的集合：Select * FROM message AS m,  user AS u  WHERE m.uid=u.uid LIMIT begin,limit
		int begin = (page-1) * limit;
		List<Message> list = messageDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public PageBean findByPage(int page, User existUser) {
		PageBean pageBean = new PageBean();
		//封装当前的页数：
		pageBean.setPage(page);
		//封装每页显示记录数
		int limit = 6;
		pageBean.setLimit(limit);
		//封装总记录数：
		MessageDao messageDao = new MessageDaoImpl();
		int totalCount = messageDao.findCount(existUser);
		pageBean.setTotalCount(totalCount);
		//封装总页数：（根据总记录数进行计算）
		int totalPage = 0;
		if(totalCount%limit == 0) {
			totalPage = totalCount/limit;
		}else {
			totalPage = totalCount/limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		//封装每页显示数据的集合：Select * FROM message AS m,  user AS u  WHERE m.uid=u.uid AND uid=? LIMIT begin,limit
		int begin = (page-1) * limit;
		List<Message> list = messageDao.findByPage(existUser,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

}

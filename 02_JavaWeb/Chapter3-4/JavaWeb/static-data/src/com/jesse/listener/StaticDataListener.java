package com.jesse.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.jesse.listener.entity.Channel;

public class StaticDataListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		List<Channel> list = new ArrayList<Channel>();
		list.add(new Channel("免费课程", "http://www.jesse.com/1"));
		list.add(new Channel("实战课程", "http://www.jesse.com/2"));
		list.add(new Channel("就业班", "http://www.jesse.com/3"));
		sce.getServletContext().setAttribute("channelList", list);
	}

}

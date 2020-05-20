package com.jesse.total;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class RequestTotalListener implements ServletContextListener, ServletRequestListener  {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();
		String url = request.getRequestURL().toString();
		if(url.endsWith("/rt") == true || url.endsWith("total.html")) {
			return;
		}
		// TODO Auto-generated method stub
		//TimeList: 10:02  10:03 10:04  10:05
		//ValueList:   5        7      10      
		List<String> timeList = (List)sre.getServletContext().getAttribute("timeList");
		List<Integer> valueList = (List)sre.getServletContext().getAttribute("valueList");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String time = sdf.format(date);
		if(timeList.indexOf(time) == -1) {
			timeList.add(time);
			valueList.add(1);
			sre.getServletContext().setAttribute("timelist", timeList);
			sre.getServletContext().setAttribute("valueList", valueList);
		}else {
			int index = timeList.indexOf(time);
			int value = valueList.get(index);
			valueList.set(index, value+1);
			sre.getServletContext().setAttribute("valueList", valueList);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		List<String> timeList = new ArrayList<String>();
		List<Integer> valueList = new ArrayList<Integer>();
		sce.getServletContext().setAttribute("timeList", timeList);
		sce.getServletContext().setAttribute("valueList", valueList);
	}

}

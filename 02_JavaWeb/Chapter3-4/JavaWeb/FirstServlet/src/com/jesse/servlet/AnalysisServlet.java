package com.jesse.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

//注解方式必须设置url
@WebServlet(urlPatterns="/unused",loadOnStartup=2)
public class AnalysisServlet extends HttpServlet{

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("正在分析结果");
	}

}

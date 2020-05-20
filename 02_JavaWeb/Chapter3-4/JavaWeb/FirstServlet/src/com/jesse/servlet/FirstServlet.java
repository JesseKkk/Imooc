package com.jesse.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{

	public FirstServlet() {
		System.out.println("正在创建FirstServlet对象");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("正在初始化FirstServlet对象");
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String add1 = request.getParameter("add1");
		int a = 0;
		try {
			a = Integer.parseInt(add1);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String add2 = request.getParameter("add2");
		int b = 0;
		try {
			b = Integer.parseInt(add2);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.setContentType("text/html;charset=utf-8"); //2
		response.setCharacterEncoding("utf-8"); //3
		PrintWriter out = response.getWriter();
		out.println("<h1>加法计算器</h1>");
		out.println("<h2>运算结果为："+ (a+b) + "</h2>");
	}

	@Override
	public void destroy() {
		System.out.println("正在销毁servlet对象"); 
	}
	
}

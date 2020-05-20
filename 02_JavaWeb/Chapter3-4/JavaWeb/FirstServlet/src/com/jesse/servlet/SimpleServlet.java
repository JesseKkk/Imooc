package com.jesse.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleServlet extends HttpServlet{
	@Override
	//service是处理请求的核心方法，无论是get或者是post都会被service()方法处理
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String methodName = request.getMethod();
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String sex = request.getParameter("sex");
		String[] specs = request.getParameterValues("spec");
		PrintWriter out =  response.getWriter();	//想浏览器输出的数据流
		out.println("<h1>method=" + methodName + "</h1>");
		out.println("<h1>name=" + name + "</h1>");
		out.println("<h1>mobile=" + mobile + "</h1>");
		out.println("<h1>sex=" + sex + "</h1>");
		for(String a : specs) {
			out.println("<h1>spec=" + a + "</h1>");		
		}
		out.println("<a href='http://www.baidu.com'>Baidu</a>");
	}
}

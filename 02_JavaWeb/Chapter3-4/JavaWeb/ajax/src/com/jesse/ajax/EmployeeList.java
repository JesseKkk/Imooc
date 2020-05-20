package com.jesse.ajax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class EmployeeList
 */
@WebServlet("/emp")
public class EmployeeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Employee> list = new ArrayList<Employee>();
		String[] str1  = {"稻香", "晴天", "告白气球"};
		String[] str2  = {"千千阙歌", "傻女", "七友"};
		String[] str3  = {"一块红布", "假行僧", "新长征路上的摇滚"};
		list.add(new Employee(str1, str2, str3));
		String json = JSON.toJSONString(list);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println(json);
	}

}

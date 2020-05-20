package com.jesse.web.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.jesse.domain.Data;
import com.jesse.service.DataService;
import com.jesse.service.Impl.DataServiceImpl;

@WebServlet("/QueryDataServlet")
public class QueryDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//此Servlet用于根据查询字段searchContent显示数据
		//1、接收数据
		//2、封装数据
		String searchContent = request.getParameter("searchContent");
		///3、处理数据
		List<Data> dataList = (List<Data>)request.getServletContext().getAttribute("dataList");
		String json = "";
		if(searchContent.equals("")) {
			//当字段默认为空时，提供所有数据
			json = JSON.toJSONString(dataList);
		}else {	
			//实现根据id、图书名、分类进行查询，提供查询的数据
			DataService dataService = new DataServiceImpl();
			List<Data> queryDataList = dataService.query(dataList,searchContent);
			json = JSON.toJSONString(queryDataList);
		}
		//4、显示数据
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(json);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

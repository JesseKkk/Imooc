package com.jesse.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.jesse.domain.Book;
import com.jesse.service.BookService;
import com.jesse.service.imp.BookServiceImp;


@WebServlet("/bookdata")
public class BookDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//此Servlet用于根据查询字段searchContent显示数据
		//接收数据
		String searchContent = request.getParameter("searchContent");
		//处理数据
		List<Book> bookList = (List<Book>)request.getServletContext().getAttribute("bookList");
		String json = "";
		if(searchContent.equals("")) {
			//当字段默认为空时，提供所有数据
			json = JSON.toJSONString(bookList);
		}else {	
			//实现根据id、图书名、分类进行查询，提供查询的数据
			BookService bookService = new BookServiceImp();
			List<Book> queryBookList = bookService.query(bookList,searchContent);
			json = JSON.toJSONString(queryBookList);
		}
		//显示数据
		response.getWriter().println(json);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

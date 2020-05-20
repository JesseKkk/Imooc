package com.jesse.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jesse.domain.Book;
import com.jesse.service.BookService;
import com.jesse.service.imp.BookServiceImp;


@WebServlet("/deletebook")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收数据
		String bookId = request.getParameter("bookId");
		//处理数据
		BookService bookService = new BookServiceImp();
		List<Book> bookList = (List<Book>)request.getServletContext().getAttribute("bookList");
		bookService.delete(bookList, bookId);
		getServletContext().setAttribute("bookList", bookList);
		//显示数据
		response.sendRedirect(request.getContextPath() + "/bookList.jsp");	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

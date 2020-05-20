package com.jesse.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updatebooktransfer")
public class UpdateBookTransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*此Servlet解决bookList.jsp修改请求的一个问题：
		 当bookList.jsp发出修改请求，updateBook.jsp要默认显示bookId，有两种方式：
		 第一种是让bookList.jsp修改的URL中携带参数，直接跳转到updateBook.jsp，
		 在updateBook.jsp采用el表达式${param.bookId }获得bookId。
		 但是当upadateBook.jsp中的价格输入错误向UpdateBookSevlet提交时，
		 要返回到updataBook.jsp，显示价格类型错误，并且要回传默认的bookId，
		 此时采用getRequestDispatcher无法回传bookId，采用sendRedirect无法显示价格错误提示。
		 
		 第二种是让bookList.jsp修改请求跳转到UpdateBookTransferServlet,在request设置属性
		 bookId，转发请求到updateBook.jsp，在updateBook.jsp采用${requestScope.bookId}获得bookId。
		 当updateBook.jsp中的价格输入错误向UpdateBookServlet提交时，也向reqeust设置属性bookId
		 采用getRequestDispatcher，显示价格类型错误和回传bookId
		*/
		//接收数据
		String bookId = request.getParameter("bookId");
		//处理数据
		//让request携带bookId，使得updateBook.jsp中能默认显示bookId
		request.setAttribute("bookId", bookId);
		//显示数据
		request.getRequestDispatcher("/updateBook.jsp").forward(request, response);								
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}

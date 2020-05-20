package com.jesse.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jesse.domain.Category;
import com.jesse.service.CategoryService;
import com.jesse.service.imp.CategoryServiceImp;

@WebServlet("/deletecategory")
public class DeleteCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收数据
		String categoryId = request.getParameter("categoryId");
		//处理数据
		CategoryService categoryService = new CategoryServiceImp();
		List<Category> categoryList = (List<Category>)request.getServletContext().getAttribute("categoryList");
		categoryService.delete(categoryList,categoryId);
		getServletContext().setAttribute("categoryList", categoryList);				
		//显示数据
		response.sendRedirect(request.getContextPath() + "/categoryList.jsp");		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

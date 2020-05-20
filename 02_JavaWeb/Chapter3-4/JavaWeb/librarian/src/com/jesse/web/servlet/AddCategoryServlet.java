package com.jesse.web.servlet;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jesse.domain.Category;
import com.jesse.service.CategoryService;
import com.jesse.service.imp.CategoryServiceImp;


@WebServlet("/addcategory")
public class AddCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收数据
		String categoryId = request.getParameter("categoryId");
		// id正则校验
		if(!Pattern.matches("ca\\d{4}", categoryId)) {
			request.setAttribute("msg", "请按照如下格式输入分类ID：caxxxx(x代表数字)");
			request.getRequestDispatcher("/addCategory.jsp").forward(request, response);
			return;
		}
		String categoryName = request.getParameter("categoryName");
		//封装数据
		Category category = new Category();
		category.setCategoryId(categoryId);
		category.setCategoryName(categoryName);
		//处理数据
		CategoryService categoryService = new CategoryServiceImp();
		List<Category> categoryList = (List<Category>)request.getServletContext().getAttribute("categoryList");
		//增加的同时判断id是否存在，并且按照id进行排序
		if(!categoryService.add(categoryList,category)) {
			request.setAttribute("msg", "当前分类已经存在");
			request.getRequestDispatcher("/addCategory.jsp").forward(request, response);
			return;			
		}else {
			request.getServletContext().setAttribute("categoryList", categoryList);			
		}
		//显示数据
		response.sendRedirect(request.getContextPath() + "/categoryList.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

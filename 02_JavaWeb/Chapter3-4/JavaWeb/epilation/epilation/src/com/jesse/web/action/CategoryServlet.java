package com.jesse.web.action;

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
import com.jesse.service.Impl.CategoryServiceImpl;

@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//根据method分类处理
		String methodname = request.getParameter("method");
		if("addCategory".equals(methodname)) {
			//增加分类
			addCategory(request,response);
		}else if("deleteCategory".equals(methodname)){
			//删除分类
			deleteCategory(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	/**
	 * 分类模块：删除
	 * @throws IOException 
	 */
	private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//1、接收数据
		String categoryId = request.getParameter("categoryId");
		//2、封装数据
		//3、处理数据
		CategoryService categoryService = new CategoryServiceImpl();
		List<Category> categoryList = (List<Category>)request.getServletContext().getAttribute("categoryList");
		categoryService.delete(categoryList,categoryId);
		getServletContext().setAttribute("categoryList", categoryList);				
		//4、显示数据
		response.sendRedirect(request.getContextPath() + "/admin/categoryList.jsp");		
	}
	
	/**
	 * 分类模块：增加
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、接收数据
		String categoryId = request.getParameter("categoryId");
		// id正则校验
		if(!Pattern.matches("ca\\d{4}", categoryId)) {
			request.setAttribute("msg", "请按照如下格式输入分类ID：caxxxx(x代表数字)");
			request.getRequestDispatcher("/admin/addCategory.jsp").forward(request, response);
			return;
		}
		String categoryName = request.getParameter("categoryName");
		//2、封装数据
		Category category = new Category();
		category.setCategoryId(categoryId);
		category.setCategoryName(categoryName);
		//3、处理数据
		CategoryService categoryService = new CategoryServiceImpl();
		List<Category> categoryList = (List<Category>)request.getServletContext().getAttribute("categoryList");
		//增加的同时判断id是否存在，并且按照id进行排序
		if(!categoryService.add(categoryList,category)) {
			request.setAttribute("msg", "当前分类已经存在");
			request.getRequestDispatcher("/admin/addCategory.jsp").forward(request, response);
			return;			
		}else {
			request.getServletContext().setAttribute("categoryList", categoryList);			
		}
		//4、显示数据
		response.sendRedirect(request.getContextPath() + "/admin/categoryList.jsp");			
	}

}

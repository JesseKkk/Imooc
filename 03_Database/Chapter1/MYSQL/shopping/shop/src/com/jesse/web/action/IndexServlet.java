package com.jesse.web.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jesse.domain.Category;
import com.jesse.domain.PageBean;
import com.jesse.domain.Product;
import com.jesse.service.CategoryService;
import com.jesse.service.ProductService;
import com.jesse.service.impl.CategoryServiceImpl;
import com.jesse.service.impl.ProductServiceImpl;


@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、接收数据
		int page = 0;
		String currPage =request.getParameter("page");
		if(currPage == null) {
			page = 1;
		}else {
			page = Integer.parseInt(currPage);
		}
		//2、封装数据
		//3、调用业务层处理数据
		//查询操作
		CategoryService categoryService = new CategoryServiceImpl();
		List<Category> categoryList = categoryService.findAll();
		//分页查询商品的数据：
		ProductService productService = new ProductServiceImpl();
		PageBean<Product>  pageBean = productService.findByPage(page);
		
		//4、页面跳转
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

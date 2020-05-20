package com.jesse.library.web.controller;

import com.jesse.library.biz.CategoryBiz;
import com.jesse.library.biz.Impl.CategoryBizImpl;
import com.jesse.library.entity.Category;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class CategoryController {
    private CategoryBiz categoryBiz = new CategoryBizImpl();

    //  /admin/Category/list.do
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = categoryBiz.getCategoryList();
        request.setAttribute("categoryList",categoryList);
        request.getRequestDispatcher("/WEB-INF/pages/admin/category.jsp").forward(request, response);
    }

    //  /admin/Category/toAdd.do
    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/admin/add_category.jsp").forward(request, response);
    }

    //  /admin/Category/add.do
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Category category = new Category();
        category.setName(name);
        category.setCreateTime(new Date());
        categoryBiz.setCategory(category);
        response.sendRedirect("list.do");
    }
}

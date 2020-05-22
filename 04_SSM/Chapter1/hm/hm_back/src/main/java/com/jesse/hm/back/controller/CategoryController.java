package com.jesse.hm.back.controller;

import com.jesse.hm.common.entity.Category;
import com.jesse.hm.common.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Kong on 2020/5/21.
 */
@Controller("categoryController")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    //  /category/list.do   /category_list.jsp
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> list = categoryService.getAll();
        request.setAttribute("LIST",list);
        request.getRequestDispatcher("../category_list.jsp").forward(request,response);
    }

    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../category_add.jsp").forward(request,response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        Category category = new Category();
        category.setName(name);

        categoryService.add(category);
        response.sendRedirect("list.do");
    }

    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Category category = categoryService.get(id);
        request.setAttribute("OBJ", category);
        request.getRequestDispatcher("../category_edit.jsp").forward(request,response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");

        Category category = new Category();
        category.setName(name);
        category.setId(id);
        categoryService.edit(category);
        response.sendRedirect("list.do");
    }

    public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));

        categoryService.remove(id);
        response.sendRedirect("list.do");
    }
}

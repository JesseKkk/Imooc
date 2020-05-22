package com.jesse.hm.back.controller;

import com.jesse.hm.common.entity.Category;
import com.jesse.hm.common.entity.Dept;
import com.jesse.hm.common.service.CategoryService;
import com.jesse.hm.common.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Kong on 2020/5/22.
 */
@Controller("deptController")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @Autowired
    private CategoryService categoryService;

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer cid = Integer.parseInt(request.getParameter("cid"));
        List<Dept> dList = deptService.getCid(cid);
        request.setAttribute("DLIST",dList);
        List<Category> list = categoryService.getAll();
        request.setAttribute("LIST",list);
        request.getRequestDispatcher("../dept_list.jsp").forward(request,response);
    }

    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> list = categoryService.getAll();
        request.setAttribute("LIST",list);
        request.getRequestDispatcher("../dept_add.jsp").forward(request,response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Integer cid = Integer.parseInt(request.getParameter("cid"));

        Dept dept = new Dept();
        dept.setName(name);
        dept.setCid(cid);
        deptService.add(dept);
        response.sendRedirect("list.do?cid="+ cid);
    }

    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Dept dept = deptService.get(id);
        request.setAttribute("OBJ",dept);
        List<Category> list = categoryService.getAll();
        request.setAttribute("LIST",list);
        request.getRequestDispatcher("../dept_edit.jsp").forward(request,response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Integer cid = Integer.parseInt(request.getParameter("cid"));

        Dept dept = new Dept();
        dept.setId(id);
        dept.setName(name);
        dept.setCid(cid);
        deptService.edit(dept);
        response.sendRedirect("list.do?cid="+ cid);
    }

    public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Dept dept = deptService.get(id);
        Integer cid = dept.getCid();
        deptService.remove(id);
        response.sendRedirect("list.do?cid="+ cid);
    }
}

package com.jesse.library.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jesse.library.biz.BookBiz;
import com.jesse.library.biz.CategoryBiz;
import com.jesse.library.biz.Impl.BookBizImpl;
import com.jesse.library.biz.Impl.CategoryBizImpl;
import com.jesse.library.entity.Book;
import com.jesse.library.entity.Category;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DefaultController {
    private BookBiz bookBiz = new BookBizImpl();
    private CategoryBiz categoryBiz = new CategoryBizImpl();

    //  /index.do
    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = categoryBiz.getCategoryList();
        request.setAttribute("categoryList",categoryList);
        String pageNum = request.getParameter("pageNum");
        if (pageNum == null) pageNum="1";
        PageHelper.startPage(Integer.parseInt(pageNum),8);
        List<Book> bookList = bookBiz.getBookListAll();
        PageInfo pageInfo = PageInfo.of(bookList);
        request.setAttribute("pageInfo", pageInfo);
        request.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(request, response);

    }
}

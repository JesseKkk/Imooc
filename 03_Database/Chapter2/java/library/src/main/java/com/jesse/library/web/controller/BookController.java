package com.jesse.library.web.controller;

import com.jesse.library.biz.BookBiz;
import com.jesse.library.biz.CategoryBiz;
import com.jesse.library.biz.Impl.BookBizImpl;
import com.jesse.library.biz.Impl.CategoryBizImpl;
import com.jesse.library.entity.Book;
import com.jesse.library.entity.Category;
import com.jesse.library.utils.UploadUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class BookController {
    private BookBiz bookBiz = new BookBizImpl();
    private CategoryBiz categoryBiz = new CategoryBizImpl();

    //  /admin/Book/list.do
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cid = Integer.parseInt(request.getParameter("cid"));
        List<Book> bookList = bookBiz.getBookListByCid(cid);
        request.setAttribute("bookList",bookList);
        List<Category> categoryList = categoryBiz.getCategoryList();
        request.setAttribute("categoryList",categoryList);
        request.getRequestDispatcher("/WEB-INF/pages/admin/book.jsp").forward(request,response);
    }

    //  /admin/Book/toAdd.do
    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = categoryBiz.getCategoryList();
        request.setAttribute("categoryList",categoryList);
        request.getRequestDispatcher("/WEB-INF/pages/admin/add_book.jsp").forward(request, response);
    }

    //  /admin/Book/add.do
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Map<String,String>> listMap = UploadUtils.uploadFile(request);
        List<Book> listBook = new ArrayList<Book>();
        Book book = null;
        for (Map<String, String> map : listMap) {
            book = new Book();
            book.setName(map.get("name"));
            book.setCategoryId(Integer.parseInt(map.get("categoryId")));
            book.setLevel(Integer.parseInt(map.get("level")));
            book.setPrice(Integer.parseInt(map.get("price")));
            book.setImgPath(map.get("path"));
            book.setCreateTime(new Date());
            book.setUpdateTime(new Date());
            listBook.add(book);
        }
        bookBiz.addListBook(listBook);
        response.sendRedirect("/admin/Category/list.do");
    }

}

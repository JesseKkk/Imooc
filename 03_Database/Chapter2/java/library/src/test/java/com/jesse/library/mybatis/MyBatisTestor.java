package com.jesse.library.mybatis;

import com.jesse.library.biz.BookBiz;
import com.jesse.library.biz.CategoryBiz;
import com.jesse.library.biz.Impl.BookBizImpl;
import com.jesse.library.biz.Impl.CategoryBizImpl;
import com.jesse.library.entity.Book;
import com.jesse.library.entity.Category;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyBatisTestor {
    @Test
    public void testCategorySelectAll(){
        CategoryBiz categoryBiz = new CategoryBizImpl();
        List<Category> list = categoryBiz.getCategoryList();
        for (Category c : list) {
            System.out.println(c);
        }
    }

    @Test
    public void testCategoryInset(){
        CategoryBiz categoryBiz = new CategoryBizImpl();
        Category category = new Category();
        category.setName("jesse");
        category.setCreateTime(new Date());
        categoryBiz.setCategory(category);
    }

    @Test
    public void testBookListByCid(){
        BookBiz bookBiz = new BookBizImpl();
        List<Book> list = bookBiz.getBookListByCid(1);
        for (Book b : list) {
            System.out.println(b);
        }
    }

}

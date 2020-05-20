package com.jesse.web.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.jesse.domain.Book;
import com.jesse.domain.Category;
import com.jesse.domain.User;
import com.jesse.service.imp.BookServiceImp;
import com.jesse.service.imp.CategoryServiceImp;

@WebListener
public class InitListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
         
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("图书系统数据加载中...");
    	//加载用户信息
        List<User> userList = new ArrayList<User>();
        User user1 = new User("孔金星", "jx909428");
        User user2 = new User("Jesse", "123");
        userList.add(user1);
        userList.add(user2);
        sce.getServletContext().setAttribute("userList", userList);
        //加载目录信息
        List<Category> categoryList = CategoryServiceImp.getCategorydb(); 
        sce.getServletContext().setAttribute("categoryList", categoryList);
        //加载图书信息
        List<Book> bookList = BookServiceImp.getBooklist();
        sce.getServletContext().setAttribute("bookList", bookList);
    }
	
}

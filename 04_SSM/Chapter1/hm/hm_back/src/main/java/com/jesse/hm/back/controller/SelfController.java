package com.jesse.hm.back.controller;

import com.jesse.hm.common.entity.Category;
import com.jesse.hm.common.entity.Dept;
import com.jesse.hm.common.entity.User;
import com.jesse.hm.common.service.CategoryService;
import com.jesse.hm.common.service.DeptService;
import com.jesse.hm.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kong on 2020/5/22.
 */
@Controller("selfController")
public class SelfController {

    @Autowired
    UserService userService;

    //  /toLogin.do
    public void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    //  /login.do
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userService.login(username,password);
        if (user == null){
            response.sendRedirect("toLogin.do");
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("USER",user);
            response.sendRedirect("category/list.do");
        }
    }
}

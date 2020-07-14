package com.jesse.bbs.global;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Kong on 2020/6/11.
 */
public class BackLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        //管理员登录后才可访问后端页面
        String url = httpServletRequest.getRequestURI();
        if (url.toLowerCase().indexOf("login")>=0) {
            return true;
        }

        HttpSession session = httpServletRequest.getSession();
        if (session.getAttribute("admin") != null) {
            return true;
        }

        httpServletResponse.sendRedirect("/back/to_admin_login");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

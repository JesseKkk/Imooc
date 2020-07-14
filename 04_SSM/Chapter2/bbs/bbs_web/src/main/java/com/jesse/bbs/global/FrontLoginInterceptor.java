package com.jesse.bbs.global;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Kong on 2020/6/11.
 */
public class FrontLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        //用户登录后，才可进行发帖操作
        String url = httpServletRequest.getRequestURI();
        if (url.toLowerCase().indexOf("addpost") < 0) {
            return true;
        }

        HttpSession session = httpServletRequest.getSession();
        if (session.getAttribute("user") != null) {
            return true;
        }

        httpServletResponse.sendRedirect("/front/to_userLogin");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

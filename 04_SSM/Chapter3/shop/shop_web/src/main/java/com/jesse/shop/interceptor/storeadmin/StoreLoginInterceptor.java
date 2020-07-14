package com.jesse.shop.interceptor.storeadmin;

import com.jesse.shop.entity.PersonInfo;
import com.jesse.shop.entity.Store;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Kong on 2020/7/10.
 */
public class StoreLoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 从session中取出用户信息来
        PersonInfo user = (PersonInfo)request.getSession().getAttribute("user");
        if (user != null) {
            // 做空值判断，确保userId不为空并且该帐号的可用状态为1，并且用户类型为店家
            if (user != null && user.getUserId() != null && user.getUserId() > 0 && user.getEnableStatus() == 1)
                // 若通过验证则返回true,拦截器返回true之后，用户接下来的操作得以正常执行
                return true;
        }
        // 若不满足登录验证，则直接跳转到帐号登录页面
        response.sendRedirect("/local/login");
        return false;
    }
}

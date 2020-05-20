package com.jesse.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.jesse.domain.User;

@WebFilter(value = {"/admin/*","/AddEditMessageServlet","/MyMessageServlet","/UserServlet"})
public class PrivilegeFilter implements Filter {


	public void destroy() {	
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//获得session进行判断
		HttpServletRequest req = (HttpServletRequest)request;
		User existUser = (User)req.getSession().getAttribute("existUser");
		if(existUser == null) {
			//没有登录：
			request.setAttribute("msg", "你没有登录，没有权限访问！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}

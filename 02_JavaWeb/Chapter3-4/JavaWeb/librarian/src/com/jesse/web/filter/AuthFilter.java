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
import javax.servlet.http.HttpServletResponse;

import com.jesse.domain.User;

@WebFilter(filterName = "AuthFilter", urlPatterns = "*.jsp") 
public class AuthFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		//登录页排除身份验证
		String uri = req.getRequestURI();
		String[] fields = uri.split("/");
		if(fields[fields.length - 1].equals("login.jsp")) {
			chain.doFilter(request, response);
		}else {
			User user = (User)req.getSession().getAttribute("existUser");
			HttpServletResponse res = (HttpServletResponse)response;
			if(user != null) {
				chain.doFilter(request, response);
			}else {
				res.sendRedirect(req.getContextPath() + "/401.html");
			}
		}
	}


	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}

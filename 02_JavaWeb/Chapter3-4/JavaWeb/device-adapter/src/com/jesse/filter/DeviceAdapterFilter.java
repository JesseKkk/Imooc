package com.jesse.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeviceAdapterFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res =(HttpServletResponse)response;
		/*
		 * /index.html
		 * PC: /desktop/index.html
		 * MOBILE: /mobile/index.html
		 * 
		 *  /test.html
		 *  PC: /desktop/test.html
		 *  MOBILE: /mobile/test.html
		 */
		String uri = req.getRequestURI();
		System.out.println("URI:"+ uri);
		if(uri.startsWith("/desktop") || uri.startsWith("/mobile")) {
			chain.doFilter(request, response);
		}else {
			String userAgent = req.getHeader("user-agent").toLowerCase();
			System.out.println(userAgent);
			String targetURI = "";
			if(userAgent.indexOf("android")!=-1 || userAgent.indexOf("iphone")!=-1) {
				targetURI = "/mobile" + uri;
				System.out.println("移动端设备正在访问，重新跳转URI：" + targetURI);
				res.sendRedirect(targetURI);
			}else {
				targetURI = "/desktop" + uri;
				System.out.println("PC端设备正在访问，重新跳转URI：" + targetURI);
				res.sendRedirect(targetURI);				
			}
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}

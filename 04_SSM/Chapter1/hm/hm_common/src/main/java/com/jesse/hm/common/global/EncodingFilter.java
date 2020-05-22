package com.jesse.hm.common.global;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Kong on 2020/5/21.
 */
public class EncodingFilter implements Filter {

    private String encoding = "UTF-8";

    public void init(FilterConfig filterConfig) throws ServletException {
        if (filterConfig.getInitParameter("ENCODING")!=null)
            encoding = filterConfig.getInitParameter("ENCODING");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        chain.doFilter(request,response);
    }

    public void destroy() {
        encoding = null;
    }
}

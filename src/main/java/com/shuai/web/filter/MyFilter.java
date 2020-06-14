package com.shuai.web.filter;

import javax.servlet.*;
import java.io.IOException;
/**
 *  @Description：自定义过滤器
 *  @Author: guai
 *  @Date：2020/6/14 11:32
**/
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}

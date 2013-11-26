//package com.ggz.controller;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//
//public class NoCacheFilter implements Filter {
//
//    FilterConfig filterConfig = null;
//
//    public void init(FilterConfig filterConfig) throws ServletException{
//        this.filterConfig = filterConfig;
//    }
//
//    public void destroy(){
//
//    }
//
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException{
//        HttpServletResponse hsr = (HttpServletResponse) servletResponse;
//        hsr.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
//        hsr.setHeader("Pragma", "no-cache"); // HTTP 1.0.
//        hsr.setDateHeader("Expires", 0); // Proxies.
//        filterChain.doFilter(servletRequest, servletResponse);
//
//    }
//}

package com.wang.web.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 演示获取请求头信息
 */
@WebServlet("/requestDemo1")
public class requestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求方式
        String method = request.getMethod();
        System.out.println(method);
        //获取虚拟目录(重要)
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        //获取Servlet路径
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        //获取get方式请求方式
        String queryString = request.getQueryString();
        System.out.println(queryString);
        //获取请求URL（重要）
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL);
        //获取协议及版本
        String protocol = request.getProtocol();
        System.out.println(protocol);
        //获取客户机的IP地址
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

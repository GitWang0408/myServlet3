package com.wang.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "regist", value = "/regist")
public class regist extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String[]> parameterMap = request.getParameterMap();

        Set<String> keyset = parameterMap.keySet();
        for (String name : keyset){
            String[] values = parameterMap.get(name);
            System.out.println(name);
            for (String value : values){
                System.out.println(name + "=" + value);
            }
            System.out.println();
        }
        //请求转发
        request.getRequestDispatcher("/regist.html").forward(request,response);

    }
}

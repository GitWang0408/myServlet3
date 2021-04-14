package com.wang.web.servlet;

import com.wang.web.servlet.beans.User;
import com.wang.web.servlet.beans.UserDao;
import com.wang.web.servlet.beans.UserDaoImpl;
import com.wang.web.servlet.utils.ConnectionUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class loginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDao userDao = new UserDaoImpl();
        User user = userDao.getUserByUsernameAndPassword(username, password);
        System.out.println(user);
        if(user != null){
            request.getRequestDispatcher("/success.html").forward(request,response);
            System.out.println("登录成功");
        } else if (user == null) {
            request.getRequestDispatcher("/defeat.html").forward(request,response);
            System.out.println("登录失败");

        }
        //请求转发
//        request.getRequestDispatcher("/regist.html").forward(request,response);
    }
}

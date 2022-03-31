package com.HeZhihao.week6;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "SearchServlet", value = "/SearchServlet")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String txt = request.getParameter("txt");
        String choose = request.getParameter("search");
        System.out.println(choose+" "+txt);
        if(txt == ""){
            request.getRequestDispatcher("index.jsp").forward(request,response);
            System.out.println("hhhcao");
        }
        else {
            if(choose.equals("baidu")) response.sendRedirect("https://www.baidu.com/s?wd="+txt);
            else if(Objects.equals(choose,"bing")) response.sendRedirect("https://cn.bing.com/search?q="+txt);
            else if(choose == "google") response.sendRedirect("https://www.google.com/search?q="+txt);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

package com.example.hezhihaoweek3;

import com.HeZhihao.dao.UserDao;
import com.HeZhihao.week7.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class register extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
        super.init();
        try{
            con = (Connection) getServletContext().getAttribute("con");
            System.out.println("666666");
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Game Over");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        User user = null;
        try{
            user = new User();
            user.setUsername(req.getParameter("username"));
            user.setPassword(req.getParameter("password"));
            user.setPassword(req.getParameter("email"));
            user.setPassword(req.getParameter("gender"));
            user.setPassword(req.getParameter("Birthdate"));
            System.out.println(user.getUsername()+" "+user.getEmail());
            UserDao userDao = new UserDao();
            if(userDao.saveUser(con,user)){
                System.out.println("good");
            }
            else System.out.println("fail");
            req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req,resp);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("出错啦");
        }
//        try{
//            System.out.println("hh");
//            String in_2 = "select * from HeZhihaotable";
//            ps = con.prepareStatement(in_2);
//            System.out.println("22222hao");
//            ResultSet rs = ps.executeQuery();
//            System.out.println("nwwwwww");
//            PrintWriter pw = resp.getWriter();
//            pw.println("结果"+"<br>");
//            pw.println("<table border = "+"1"+">");
//            pw.println("<tr>");
//            pw.println("<td>username</td>"
//                    + "<td>password</td>"
//                    + "<td>email</td>"
//                    + "<td>gender</td>"
//                    + "<td>Birthdate</td>");
//            pw.println("</tr>");
//            while(rs.next()){
//                String use = rs.getString("username");
//                String pas = rs.getString("password");
//                String ema = rs.getString("email");
//                String gen = rs.getString("gender");
//                String bir = rs.getString("Birthdate");
//                pw.println("<tr>");
//                pw.println("<td>" + use + "</td>"
//                        + "<td>" + pas + "</td>"
//                        + "<td>" + ema + "</td>"
//                        + "<td>" + gen + "</td>"
//                        + "<td>" + bir + "</td>");
//                pw.println("</tr>");
//            }
//            pw.println("</table>");
//            pw.close();
//        }
//        catch (SQLException e)
//        {
//            e.printStackTrace();
//            System.out.println("hhh有问题");
//        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/register.jsp").forward(req,resp);
    }
}

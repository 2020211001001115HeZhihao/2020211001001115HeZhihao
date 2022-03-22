package com.example.hezhihaoweek3;

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
        String driver = getServletContext().getInitParameter("driver");
        String url = getServletContext().getInitParameter("url");
        String usr = getServletContext().getInitParameter("usr");
        String pas = getServletContext().getInitParameter("pas");
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url,usr,pas);
            System.out.println("666666");
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Game Over");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String Birthdate = req.getParameter("Birthdate");
        PreparedStatement ps = null;

        try{
            String in = "insert into HeZhihaotable values ('"+username+"','"+password+"','"+email+"','"+
                    gender+"','"+Birthdate+"')";
            System.out.println(in);
            ps = con.prepareStatement(in);
            System.out.println("6*6 = 666666");
            ps.executeUpdate();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("出错啦");
        }
        try{
            System.out.println("hh");
            String in_2 = "select * from HeZhihaotable";
            ps = con.prepareStatement(in_2);
            System.out.println("22222hao");
            ResultSet rs = ps.executeQuery();
            System.out.println("nwwwwww");
            PrintWriter pw = resp.getWriter();
            pw.println("结果"+"<br>");
            pw.println("<table border = "+"1"+">");
            pw.println("<tr>");
            pw.println("<td>username</td>"
                    + "<td>password</td>"
                    + "<td>email</td>"
                    + "<td>gender</td>"
                    + "<td>Birthdate</td>");
            pw.println("</tr>");
            while(rs.next()){
                String use = rs.getString("username");
                String pas = rs.getString("password");
                String ema = rs.getString("email");
                String gen = rs.getString("gender");
                String bir = rs.getString("Birthdate");
                pw.println("<tr>");
                pw.println("<td>" + use + "</td>"
                        + "<td>" + pas + "</td>"
                        + "<td>" + ema + "</td>"
                        + "<td>" + gen + "</td>"
                        + "<td>" + bir + "</td>");
                pw.println("</tr>");
            }
            pw.println("</table>");
            pw.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("hhh有问题");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

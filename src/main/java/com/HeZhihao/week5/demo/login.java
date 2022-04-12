package com.HeZhihao.week5.demo;

import com.HeZhihao.dao.UserDao;
import com.HeZhihao.week7.JDBCServletContextListener;
import com.HeZhihao.week7.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class login extends HttpServlet {
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("nccccb");
        req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserDao userDao = new UserDao();
        try {
            User user = userDao.findByUsernamePassword(con,username,password);
            if(user != null){
                req.setAttribute("user",user);
                System.out.println(user.getUsername());
                req.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(req,resp);

            }
            else {
                req.setAttribute("message","Username or Password Error");
                req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req,resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        try {
//            String sql = "select * from HeZhihaotable where username = '"+username+
//                    "' and password = '"+password+"'";
//            ResultSet stm = con.createStatement().executeQuery(sql);
//            if(stm.next()){
//                req.setAttribute("username",stm.getString("username"));
//                req.setAttribute("password",stm.getString("password"));
//                req.setAttribute("email",stm.getString("email"));
//                req.setAttribute("gender",stm.getString("gender"));
//                req.setAttribute("Birthdate",stm.getString("Birthdate"));
//                req.getRequestDispatcher("userinfo.jsp").forward(req,resp);
//            }
//            else {
//                req.setAttribute("message","Username or Password Error");
//                req.getRequestDispatcher("login.jsp").forward(req,resp);
//            }
//
////            Statement stmt = con.createStatement();
////            ResultSet selected = stmt.executeQuery("select username,password from HeZhihaotable");
////            boolean ave = false;
////            PrintWriter writer = resp.getWriter();
////            while(selected.next()){
////
////                String use = selected.getString("username");
////                String pas = selected.getString("password");
////                System.out.println(username+"  hhhhlou11111  "+use);
////                System.out.println(password+"  hhhhlou22222  "+pas);
////                if(Objects.equals(username, use) && Objects.equals(pas, password)){
////                    writer.println("Congratulations! </br>");
////                    writer.println("Welcome! " + username +"</br>");
////                    ave = true;
////                    writer.println("<a href=\"ConfigDemoServlet\">check</a>");
////                    break;
////                }
////            }
////            if(!ave){
////                writer.println("Sorry!!!Login fail!!");
////            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}

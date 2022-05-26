package com.HeZhihao.controller;

import com.HeZhihao.dao.OrderDao;
import com.HeZhihao.dao.UserDao;
import com.HeZhihao.model.Order;
import com.HeZhihao.week7.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/accountDetails")
public class AccountDetailsServlet extends HttpServlet {
    private Connection con=null;
    @Override
    public void init() throws  ServletException{
        con = (Connection) getServletContext().getAttribute("con");
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        if(session!=null && session.getAttribute("user")!=null) {
            User user = (User) session.getAttribute("user");
            int id = Integer.parseInt(user.getId());
            UserDao dao = new UserDao();
            try {
                user = dao.findById(con, id);
                request.setAttribute("user", user);
                OrderDao orderDao = new OrderDao();
                List<Order> orderList = orderDao.findByUserId(con, id);
                request.setAttribute("orderList", orderList);
                request.getRequestDispatcher("WEB-INF/views/accountDetails.jsp").forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else
        {
            response.sendRedirect("login");
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
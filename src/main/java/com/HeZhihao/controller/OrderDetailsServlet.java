package com.HeZhihao.controller;

import com.HeZhihao.dao.OrderDao;
import com.HeZhihao.model.Item;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/orderDetails")
public class OrderDetailsServlet extends HttpServlet {
    private Connection con=null;
    public  void init() throws ServletException{
        con = (Connection)getServletContext().getAttribute("con");
    }
    public void destroy(){
        super.destroy();
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId=request.getParameter("orderId")!=null?
                Integer.parseInt(request.getParameter("orderId")):0;
        Item item=new Item();
        OrderDao dao = new OrderDao();
        List<Item> items=dao.findItemsByOrderId(con,orderId);
        request.setAttribute("itemList",items);
        String path="orderDetails.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

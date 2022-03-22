package week4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;


public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = getServletConfig().getInitParameter("name");
        String id = getServletConfig().getInitParameter("id");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("name:"+name+ "</br>");
        out.println("id:"+id+ "</br>");
        out.println("</body></html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

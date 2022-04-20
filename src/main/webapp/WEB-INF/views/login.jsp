<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022/3/29
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<center><h1>Login</h1></center>
<%
    if((request.getAttribute("message") != null)) {
        PrintWriter ps = response.getWriter();
        out.println("<h3>" + request.getAttribute("message") + "</h3>");
        System.out.println("ywtoooooo " + request.getAttribute("message"));
    }
%>
<%
    request.getCookies();
    Cookie[] allCookies = request.getCookies();
    String username = "",password = "",rememberMeVal = "";
    if(allCookies!=null){
        for(Cookie c:allCookies){
            if(c.getName().equals("cUsername")){
                username = c.getValue();
            }
            if(c.getName().equals("cPassword")){
                password = c.getValue();
            }
            if(c.getName().equals("cRememberMe")){
                rememberMeVal = c.getValue();
            }
        }
    }
%>
<form action="login" method="post">
    <div style="text-align: center">
        Username: <input type="text" name="username" value="<%=username%>"/><br/>
        Password: <input type="password" name="password" value="<%=password%>"/><br/>
        <input type="checkbox" name="rememberMe" value="1"<%=rememberMeVal.equals("1")?"checked":""%>checked/>RememberMe<br>
        <input type="submit" value="Submit"/>
    </div>
</form>
<%@include file="footer.jsp"%>

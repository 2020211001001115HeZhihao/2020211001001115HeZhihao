<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022/3/31
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<center><h1>User Info</h1></center>
<%--<div style="text-align: center">--%>
    <table border="1" align="center">
        <tr><td>Username:</td><td><%=request.getAttribute("username")%></td></tr>
        <tr><td>Password:</td><td><%=request.getAttribute("password")%></td></tr>
        <tr><td>Email:</td><td><%=request.getAttribute("email")%></td></tr>
        <tr><td>Gender:</td><td><%=request.getAttribute("gender")%></td></tr>
        <tr><td>Birthdate:</td><td><%=request.getAttribute("Birthdate")%></td></tr>
    </table>
<%--</div>--%>
<%@include file="footer.jsp"%>

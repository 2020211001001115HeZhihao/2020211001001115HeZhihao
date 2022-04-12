<%@ page import="com.HeZhihao.week7.User" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022/3/31
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<center><h1>User Info</h1></center>
<%
    User user = (User) request.getAttribute("user");
%>
<%--<div style="text-align: center">--%>
    <table border="1" align="center">
        <tr><td>Username:</td><td><%=user.getUsername()%></td></tr>
        <tr><td>Password:</td><td><%=user.getPassword()%></td></tr>
        <tr><td>Email:</td><td><%=user.getEmail()%></td></tr>
        <tr><td>Gender:</td><td><%=user.getGender()%></td></tr>
        <tr><td>Birthdate:</td><td><%=user.getBirthdate()%></td></tr>
    </table>
<%--</div>--%>
<%@include file="footer.jsp"%>

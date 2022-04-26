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
    User u = null;
    if(request.getAttribute("update") != null) {
        u = (User) request.getAttribute("user");
    } else {
        u = (User) session.getAttribute("user");
    }
%>
<%--<div style="text-align: center">--%>
    <table border="1" align="center">
        <tr><td>Username:</td><td><%=u.getUsername()%></td></tr>
        <tr><td>Password:</td><td><%=u.getPassword()%></td></tr>
        <tr><td>Email:</td><td><%=u.getEmail()%></td></tr>
        <tr><td>Gender:</td><td><%=u.getGender()%></td></tr>
        <tr><td>Birthdate:</td><td><%=u.getBirthdate()%></td></tr>
        <tr><a href="updateUser">Update</a></tr>
    </table>
<%--</div>--%>
<%@include file="footer.jsp"%>

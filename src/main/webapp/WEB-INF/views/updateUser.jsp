<%@ page import="com.HeZhihao.week7.User" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022/4/20
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%
    User u = (User) session.getAttribute("user");

%>
<form method="post" action="updateUser">
    <div style="text-align: center">
        Username: <input type="hidden" name="username" value="<%=u.getUsername()%>"/><br/>
        Password: <input type="password" name="password" value="<%=u.getPassword()%>"/><br/>
        Email: <input type="text" name="email"value="<%=u.getEmail()%>"/><br>
        Gender: <input type="radio" name = "gender" value="male" <%="male".equals(u.getGender())?"checked":""%>> Male
        <input type="radio" name = "gender" value="female" <%="female".equals(u.getGender())?"checked":""%>> Female<br/>
        Birthdate: <input type="text name=" name="Birthdate"value="<%=u.getBirthdate()%>"/><br/>
        <input type="submit" value="Save Changes"/>
    </div>
</form>
<%@include file="footer.jsp"%>

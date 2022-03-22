<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022/3/15
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/register">
    <div style="text-align: center">
        Register <br/>
        Username: <input type="text" name="username"/><br/>
        Password: <input type="password" name="password"/><br/>
        Email: <input type="text" name="email"/><br>
        Gender: <input type="radio" name = "gender"> Male <input type="radio" name = "gender"> Female<br/>
        Birthdate: <input type="text name=" name="Birthdate" /><br/>
        <input type="submit" value="Register"/>
    </div>
</form>
<a href="ConfigDemoServlet">week4.ConfigDemoServlet</a>
</body>
</html>

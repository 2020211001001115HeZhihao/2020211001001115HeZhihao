<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@include file="header.jsp"%>
<form method = "get" target="_blank" action="search">
    <div style="text-align: center">
        <input type="text" name="txt" size="30"/>
        <select name="search">
            <option value="baidu">Baidu</option>
            <option value="bing">Bing</option>
            <option value="google">Google</option>
        </select>
        <input type="submit" value="Search"/>
    </div>
</form>
<a href="hello-servlet">Hello Servlet</a>
<%@include file="footer.jsp"%>
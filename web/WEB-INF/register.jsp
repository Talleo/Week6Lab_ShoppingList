<%-- 
    Document   : register
    Created on : 13-Oct-2022, 9:21:40 AM
    Author     : godim
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>

        <form action="ShoppingList" method="post">
            Username: <input type="text" name="username" value="${username}">
            <input type="hidden" name="action" value="register">
            <input type="submit" value="Register name">
        </form>
        <br/>
        <div>${message}</div>
    </body>
</html>

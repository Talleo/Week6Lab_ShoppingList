<%-- 
    Document   : shoppingList
    Created on : 13-Oct-2022, 9:21:59 AM
    Author     : godim
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        Hello, ${username} <a href="ShoppingList?action=logout">Logout</a>
        <br/>
        <h2>List</h2>

        <form action="" method="post">
            <h2>Add item: </h2>
            <input type="text" name="item">
            <input type="submit" value="Add">
            <input type="hidden" name="action" value="add">
        </form>

        <form action="" method="post">
            <ul>
                <c:forEach var="item" items="${shoppingCart}">
                    <li><input type="radio" name="item" value="${item}">${item}</li>
                    </c:forEach>
            </ul>
            
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form>
    </body>
</html>

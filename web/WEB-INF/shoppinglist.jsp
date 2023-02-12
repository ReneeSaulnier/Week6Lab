<%-- 
    Document   : shoppinglist
    Created on : 11-Feb-2023, 8:09:38 PM
    Author     : Renee
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
        <br>
        <p>Hello, ${username}</p>
        <br>
        <a href="shoppinglist?action=logout">Logout</a>
        <br>
        <h2>List</h2>
        
        <form action="" method="post">
            <h2>Add Item:</h2>
            <input type="text" name="items">
            <input type="submit" value="Add Item">
            <input type="hidden" name="action" value="add">
        </form>
        
        <form action="" method="post">
            <br>
                <c:forEach items="${items}" var="items">
                &emsp;<input type="radio" name="itemlist" value="${items}">${items}
                </c:forEach>
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form>
        
    </body>
</html>

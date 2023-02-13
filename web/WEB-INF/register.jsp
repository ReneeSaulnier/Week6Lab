<%-- 
    Document   : register
    Created on : 11-Feb-2023, 8:09:22 PM
    Author     : Renee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="shoppinglist" method="post">
            Username:<input type="text" name="username">
            <input type="hidden" name="action" value="register">
            <input type="submit" value="Register name"> 
            <br>
            ${message}
        </form>
    </body>
</html>

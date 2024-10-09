<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List All Users</title>
</head>
<body>
   <h1>List All Users</h1>
   <br>
   <ul>
        <c:forEach items="${users}" var="u">
            <li>${u.userId} | ${u.firstName} | ${u.email} | ${u.password} | ${u.deleted} | <a href="delete?userId=${u.userId}">Delete</a> </li>
            <br>
        </c:forEach>
   </ul>
</body>
</html>
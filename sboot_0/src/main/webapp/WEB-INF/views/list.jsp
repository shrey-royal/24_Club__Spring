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
   <a href="search">Search User</a>
   <br>
   <ul>
        <c:forEach items="${users}" var="u">
            <li>
                ${u.userId} | ${u.firstName} | ${u.email} | ${u.password} | ${u.deleted} |
                <form action="/update" method="post" style="display:inline;">
                    <input type="hidden" name="userId" value="${u.userId}">
                    <button type="submit">Update</button>
                </form>
                |
                <form action="/delete" method="post" style="display:inline;">
                    <input type="hidden" name="userId" value="${u.userId}">
                    <button type="submit">Delete</button>
                </form>
                </li>
            <br>
        </c:forEach>
   </ul>
</body>
</html>
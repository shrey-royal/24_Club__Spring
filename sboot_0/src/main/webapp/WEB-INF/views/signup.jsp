<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Signup</title>
</head>
<body>
    <h2>Signup</h2>

    <s:form action="save" method="post" modelAttribute="user">
        FirstName: <s:input path="firstName" />
        <s:errors path="firstName"></s:errors>
        <br><br>
        Email: <s:input path="email"/>
        <s:errors path="email"></s:errors>
        <br><br>
        Password: <s:input path="password"/>
        <s:errors path="password"></s:errors>
        <br><br>
        <input type="submit" value="Signup"/>
    </s:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update User</title>
</head>
<body>
   <h2>Signup</h2>

       <s:form action="updateuser" method="post" modelAttribute="user">
           <s:input type="hidden" path="userId" value="${user.userId}"/>
           FirstName: <s:input path="firstName" value="${user.getFirstName()}" />
           <s:errors path="firstName"></s:errors>
           <br><br>
           Email: <s:input path="email" value="${user.getEmail()}"/>
           <s:errors path="email"></s:errors>
           <br><br>
           Password: <s:input path="password" value="${user.getPassword()}"/>
           <s:errors path="password"></s:errors>
           <br><br>
           <input type="submit" value="Update"/>
       </s:form>
</body>
</html>
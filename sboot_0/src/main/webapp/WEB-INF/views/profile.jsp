<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
    <h2>Welcome, ${user.firstName}!</h2>
    <p>Email: ${user.email}</p>

    <h3>Profile Picture</h3>
    <c:if test="${not empty user.profilePic}">
        <img src="${pageContext.request.contextPath}/uploads/${user.email}/${user.profilePic}" width="150"/>
    </c:if>

    <form action="${pageContext.request.contextPath}/user/uploadProfilePic" method="post" enctype="multipart/form-data">
        <input type="file" name="file" /><br/>
        <input type="submit" value="Upload Picture" />
    </form>

    <form action="${pageContext.request.contextPath}/user/deleteProfilePic" method="post">
        <input type="submit" value="Delete Profile Picture" />
    </form>

    <form action="${pageContext.request.contextPath}/user/logout" method="post">
        <input type="submit" value="Logout" />
    </form>
</body>
</html>
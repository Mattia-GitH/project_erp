<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <title>Create User</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div align="center">
    <a href="<c:url value="/logout" />">Logout</a>

    <a href="${pageContext.request.contextPath}/create">Create User</a>
    <br>
    <sec:authorize access="isAuthenticated()">
        Welcome Back, <sec:authentication property="name"/>
    </sec:authorize>

    <h1>Users List</h1>
    <table border="1" cellpadding="10">
        <thead>
        <tr>
            <th>Username</th>
            <th>password</th>
            <th>roles</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listUsers}" var="user">
            <tr>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.roles}</td>
                <td><a href="<c:url value='/edit/${user.username}' />">Edit</a></td>
                <td><a href="${pageContext.request.contextPath}/delete/${user.username}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
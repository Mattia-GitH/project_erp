<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div align="center">
    <h1>File List</h1>
    <table border="1" cellpadding="10">
        <thead>
        <tr>
            <th>File ID</th>
            <th>Order number</th>
            <th>File name</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${files}" var="file">
            <tr>
                <td>${file.id}</td>
                <td>${file.order_number}</td>
                <td><a href="${pageContext.request.contextPath}/download/${file.id}">${file.name}</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>

    <meta charset="utf-8"/>
    <title>Create New Product</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div align="center">
    <form:form method="post" modelAttribute="user" action="${pageContext.request.contextPath}/save">
        <table border="1">
            <tr>
                <th colspan="2">Insert User</th>
            </tr>
            <tr>
                <td><form:label path="username">username:</form:label></td>
                <td><form:input required="true" path="username"></form:input></td>
            </tr>
            <tr>
                <td><form:label path="password">password:</form:label></td>
                <td><form:input required="true" path="password"></form:input></td>
            </tr>
            <tr>
                <td><form:label path="roles">roles:</form:label></td>
                <td><form:input required="true"     path="roles"></form:input></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit"/></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
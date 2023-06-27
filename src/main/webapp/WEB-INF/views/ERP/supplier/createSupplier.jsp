<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>

    <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet">
    <meta charset="utf-8"/>
    <title>Create New Supplier</title>
</head>
<body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<jsp:include page="../header.jsp"/>
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-10">
            <form:form method="post" modelAttribute="supplier"
                       action="${pageContext.request.contextPath}/save_supplier">
                <table class="table table-striped">
                    <tr>
                        <th colspan="2">Create Supplier</th>
                    </tr>
                    <tr>
                        <td><form:label path="supplier">Supplier:</form:label></td>
                        <td><form:input class="form-control" path="supplier"></form:input></td>
                    </tr>
                    <tr>
                        <td><form:label path="address">Address:</form:label></td>
                        <td><form:input class="form-control" path="address"></form:input></td>
                    </tr>
                    <tr>
                        <td><form:label path="mail">Mail:</form:label></td>
                        <td><form:input class="form-control" type="email" path="mail"></form:input></td>
                    </tr>
                    <tr>
                        <td><form:label path="phone">Phone:</form:label></td>
                        <td><form:input class="form-control" type="number" path="phone"></form:input></td>
                    </tr>
                    <tr>
                        <td><form:label path="prod_name">Prod name:</form:label></td>
                        <td><form:input class="form-control" path="prod_name"></form:input></td>
                    </tr>
                    <tr>
                        <td><form:label path="rma">Rma:</form:label></td>
                        <td><form:checkbox class="form-check-input" path="rma"></form:checkbox></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" class="btn btn-outline-primary"/></td>
                    </tr>
                </table>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
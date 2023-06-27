<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
    <link href="style.css" rel="stylesheet">

    <meta charset="UTF-8">


    <title>Warehouse</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-2">
            <form:form method="post" modelAttribute="itcView" action="/ITC">
                <form:label path="supplier">Supplier:</form:label>
                <form:select path="supplier" class="selectpicker form-control">
                    <form:option value=""></form:option>
                    <c:forEach items="${supList}" var="suppliers">
                        <form:option value="${suppliers.supplier}">${suppliers.supplier}</form:option>
                    </c:forEach>
                </form:select>
                <input type="submit" class="btn btn-outline-primary"/>
            </form:form>
        </div>

        <div class="col-10">
            <h1>Warehouse</h1>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>IMEI</th>
                        <th>Model</th>
                        <th>GB</th>
                        <th>Grade Supplier</th>
                        <th>Supplier</th>
                        <th>Test</th>
                        <th>Reports</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${phones}" var="phone">
                        <tr>
                            <td class="align-middle">${phone.imei}</td>
                            <td class="align-middle">${phone.model}</td>
                            <td class="align-middle">${phone.gb}</td>
                            <td class="align-middle">${phone.grade_sup}</td>
                            <td class="align-middle">${phone.supplier}</td>
                            <td class="align-middle"><a class="btn btn-outline-primary" href="/new_test/${phone.imei}">test</a>
                            </td>
                            <td class="align-middle"><a class="btn btn-outline-primary" href="/reports/${phone.imei}">Reports</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

</body>
</html>
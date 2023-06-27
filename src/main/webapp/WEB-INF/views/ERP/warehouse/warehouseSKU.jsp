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

    <title>Warehouse SKU View</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-2">
            <form:form action="${pageContext.request.contextPath}/warehouseSku" modelAttribute="filter">
                <form:label path="sku">SKU:</form:label>
                <form:select class="selectpicker form-control" path="sku">
                    <form:option value=""></form:option>
                    <c:forEach items="${sku}" var="sku">
                        <form:option type="text" value="${sku}">${sku}</form:option>
                    </c:forEach>
                </form:select>
                <form:label path="model">Model:</form:label>
                <form:select class="selectpicker form-control" path="model">
                    <form:option value=""></form:option>
                    <c:forEach items="${phoneModel}" var="model">
                        <form:option type="text" value="${model}">${model}</form:option>
                    </c:forEach>
                </form:select>
                <form:label path="gb">GB:</form:label>
                <form:select class="selectpicker form-control" path="gb">
                    <form:option value="0"></form:option>
                    <c:forEach items="${gbPhone}" var="gbPhone">
                        <form:option type="text" value="${gbPhone}">${gbPhone}</form:option>
                    </c:forEach>
                </form:select>
                <form:label path="color">Color:</form:label>
                <form:select class="selectpicker form-control" path="color">
                    <form:option value=""></form:option>
                    <c:forEach items="${color}" var="color">
                        <form:option value="${color}">${color}</form:option>
                    </c:forEach>
                </form:select>
                <input type="submit" class="btn btn-outline-primary" value="confirm"/>
            </form:form>
        </div>
        <div class="col-10">
            <h1><a style="color: #044454; text-decoration:none" href="${pageContext.request.contextPath}/warehouse">Warehouse</a> SKU View</h1>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>SKU</th>
                        <th>Model</th>
                        <th>GB</th>
                        <th>Color</th>
                        <th>QTY</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${warehouses}" var="warehouse">
                        <tr>
                            <td class="align-middle"><a href="${pageContext.request.contextPath}/warehouseSku/${warehouse.sku}">${warehouse.sku}</a></td>
                            <td class="align-middle">${warehouse.model}</td>
                            <td class="align-middle">${warehouse.gb}</td>
                            <td class="align-middle">${warehouse.color}</td>
                            <td class="align-middle">${warehouse.phoneQty}</td>
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
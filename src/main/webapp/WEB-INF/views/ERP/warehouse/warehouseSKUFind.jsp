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
    <link href="/style.css" rel="stylesheet">

    <meta charset="UTF-8">

    <style>
        .container {
            max-width: 1580px !important;
        }
    </style>

    <title>Warehouse</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-2">
            <form:form action="${pageContext.request.contextPath}/warehouseSku/${sku}" modelAttribute="filter">
                <form:label path="imei">Imei:</form:label>
                <form:input type="text" class="form-control" path="imei"/>
                <form:label path="order_number">N&deg;order:</form:label>
                <form:select class="selectpicker form-control" path="order_number">
                    <form:option value=""></form:option>
                    <c:forEach items="${orderNumber}" var="orderNumber">
                        <form:option type="text" value="${orderNumber}">${orderNumber}</form:option>
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
                <form:label path="grade">Grade:</form:label>
                <form:select class="selectpicker form-control" path="grade">
                    <form:option value=""></form:option>
                    <c:forEach items="${grade}" var="grade">
                        <form:option value="${grade}">${grade}</form:option>
                    </c:forEach>
                </form:select>
                <form:label path="supplier">Supplier:</form:label>
                <form:select class="selectpicker form-control" path="supplier">
                    <form:option value=""></form:option>
                    <c:forEach items="${supplier}" var="supplier">
                        <form:option value="${supplier}">${supplier}</form:option>
                    </c:forEach>
                </form:select>
                <form:label path="actual_status">Actual Status:</form:label>
                <form:select class="selectpicker form-control" path="actual_status">
                    <c:forEach items="${phases}" var="phase">
                        <form:option value="${phase.phase}">${phase.phase}</form:option>
                    </c:forEach>
                </form:select>
                <input type="submit" class="btn btn-outline-primary" value="confirm"/>
            </form:form>
        </div>
        <div class="col-10">
            <h1><a style="color: #044454; text-decoration:none" href="${pageContext.request.contextPath}/warehouse">Warehouse</a></h1>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>N&deg;Order</th>
                        <th><a href="${pageContext.request.contextPath}/warehouseSku">SKU</a></th>
                        <th>IMEI</th>
                        <th>Actual Status</th>
                        <th>Operator</th>
                        <th>Send To</th>
                        <th>Model</th>
                        <th>GB</th>
                        <th>Color</th>
                        <th>Grade</th>
                        <th>Supplier</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${warehouses}" var="warehouse">
                        <tr>
                            <td class="align-middle"><a
                                    href="${pageContext.request.contextPath}/purchased-details/${warehouse.order_number}">${warehouse.order_number}</a>
                            </td>
                            <td class="align-middle">${warehouse.sku}</td>
                            <td class="align-middle">${warehouse.imei}</td>
                            <td class="align-middle text-center"><c:if test="${warehouse.actual_status == null}">WAITING</c:if>${warehouse.actual_status}</td>
                            <td class="align-middle">${warehouse.operator}</td>
                            <td class="align-middle">${warehouse.send_to}</td>
                            <td class="align-middle">${warehouse.model}</td>
                            <td class="align-middle">${warehouse.gb}</td>
                            <td class="align-middle">${warehouse.color}</td>
                            <td class="align-middle">${warehouse.grade}</td>
                            <td class="align-middle">${warehouse.supplier}</td>
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
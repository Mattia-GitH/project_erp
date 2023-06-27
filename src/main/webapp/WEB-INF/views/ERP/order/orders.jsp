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
    <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>Warehouse entry</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-2">
            <form:form action="${pageContext.request.contextPath}/orders" modelAttribute="filter">
                <form:label path="order_number">N&deg;order:</form:label>
                <form:select class="selectpicker form-control" path="order_number">
                    <form:option value="${backFilter.order_number}"></form:option>
                    <c:forEach items="${orderNumber}" var="orderNumber">
                        <form:option type="text" value="${orderNumber}">${orderNumber}</form:option>
                    </c:forEach>
                </form:select>
                <form:label path="tracking">Tracking:</form:label>
                <form:select class="selectpicker form-control" path="tracking">
                    <form:option value=""></form:option>
                    <c:forEach items="${tracking}" var="track">
                        <form:option type="text" value="${track}">${track}</form:option>
                    </c:forEach>
                </form:select>
                <form:label path="model">Model:</form:label>
                <form:select class="selectpicker form-control" path="model">
                    <form:option value="${backFilter.model}"></form:option>
                    <c:forEach items="${phoneModel}" var="model">
                        <form:option type="text" value="${model}">${model}</form:option>
                    </c:forEach>
                </form:select>
                <form:label path="gb">GB:</form:label>
                <form:select class="selectpicker form-control" path="gb">
                    <c:if test="${backFilter.gb == null}">
                        <form:option value="0"></form:option>
                    </c:if>
                    <c:if test="${backFilter.gb != null}">
                        <form:option value="${backFilter.gb}">${backFilter.gb}</form:option>
                    </c:if>

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
                <input type="submit" class="btn btn-outline-primary" value="confirm"/>
            </form:form>
        </div>

        <div class="col-10">
            <h1>Warehouse&nbsp;entry</h1>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>N&deg; order</th>
                        <th>Tracking</th>
                        <th>Model</th>
                        <th>GB</th>
                        <th>Grade Supplier</th>
                        <th>Qty/Insert</th>
                        <th>Supplier</th>
                        <th>Imei</th>
                        <th>Label</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${orders}" var="ord">
                        <td>${ord.order_number}</td>
                        <td>${ord.tracking}</td>
                        <td>${ord.model}</td>
                        <td>${ord.gb}</td>
                        <td>${ord.grade}</td>
                        <td>${ord.init_qty}/${ord.init_qty - ord.qty}</td>
                        <td>${ord.supplier}</td>
                        <c:choose>
                            <c:when test="${ord.qty > 0}"><td>
                                <form:form method="post" modelAttribute="order" action="${pageContext.request.contextPath}/insert_imei">
                                    <form:hidden path="id" value="${ord.id}"/>
                                    <form:hidden path="id_article" value="${ord.id_article}"/>
                                    <form:hidden path="qty" value="${ord.qty}"/>
                                    <form:hidden path="id_supplier" value="${ord.id_supplier}"/>
                                    <form:hidden path="date" value="${ord.date}"/>
                                    <form:hidden path="number_order" value="${ord.order_number}"/>
                                    <input class="btn btn-outline-primary" type="submit"/></td>
                                </form:form>
                            </c:when>
                            <c:otherwise>
                                <td style="color: green">COMPLETE</td>
                            </c:otherwise>
                        </c:choose>
                        <td>
                            <a target="_blank" class="btn btn-outline-primary" href="${pageContext.request.contextPath}/batchLabel/${ord.supplier}/${ord.order_number}/ITC/${ord.model}">Label</a>
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
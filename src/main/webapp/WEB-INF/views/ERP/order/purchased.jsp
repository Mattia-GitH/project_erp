<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <link rel="stylesheet" href="style.css">
    <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet">
    <meta charset="UTF-8">

    <title>Orders</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-2">
            <form:form modelAttribute="dataF" action="${pageContext.request.contextPath}/purchased">
                <form:label path="supplier">Supplier:</form:label>
                <form:select class="selectpicker form-control" path="supplier">
                    <form:option value=""></form:option>
                    <c:forEach items="${supplier}" var="supplier">
                        <form:option type="text" value="${supplier.supplier}">${supplier.supplier}</form:option>
                    </c:forEach>
                </form:select>
                <label path="order_number_filter">N&deg;order:</label>
                <select class="selectpicker form-control" name="order_number_filter">
                    <option value=""></option>
                    <c:forEach items="${dataFilter}" var="dataFilter">
                        <option type="number"
                                value="${dataFilter.order_number}">${dataFilter.order_number}</option>
                    </c:forEach>
                </select>
                <form:label path="date">Date: </form:label>
                <form:select class="selectpicker form-control" path="date">
                    <form:option value=""></form:option>
                    <c:forEach items="${dataFilter}" var="dataFilter">
                        <fmt:formatDate var="date" pattern="yyyy-MM-dd" value="${dataFilter.date_purchase}"/>
                        <form:option type="date" value="${date}">${date}</form:option>
                    </c:forEach>
                </form:select>
                <input type="submit" class="btn btn-outline-primary" value="confirm"/>
            </form:form>
        </div>

        <div class="col-10">
            <h1>Order List</h1>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>N&deg; Order</th>
                        <th>Date of purchase</th>
                        <th>Supplier</th>
                        <th>QTY/Insert</th>
                        <th>Total</th>
                        <th>Courier</th>
                        <th>Tracking</th>
                        <th>Paid</th>
                        <th>Details</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${purchasedList}" var="purchased">
                        <fmt:formatDate pattern="yyyy/MM/dd"
                                        value="${purchased.date_purchase}" var="date"/>
                        <tr>
                            <td class="align-middle">${purchased.order_number}</td>
                            <td class="align-middle"><fmt:formatDate pattern="yyyy-MM-dd"
                                                                     value="${purchased.date_purchase}"/>
                            </td class="align-middle">
                            <td class="align-middle">${purchased.supplier}</td>
                            <c:if test="${purchased.init_qty == purchased.qty}">
                            <td class="align-middle" style="color: green">${purchased.init_qty}/${purchased.init_qty}</td>
                            </c:if>
                            <c:if test="${purchased.init_qty != purchased.qty}">
                            <td class="align-middle">${purchased.init_qty}/${purchased.init_qty - purchased.qty}</td>
                            </c:if>
                            <td class="align-middle">${purchased.price}&euro;</td>
                            <td class="align-middle text-center">

                                <button type="button" class="btn btn-outline-dark" data-bs-toggle="modal"
                                        data-bs-target="#${purchased.courier}${purchased.order_number}${date}">${purchased.courier}</button>
                            </td>
                            <td class="align-middle">
                                <button type="button" class="btn btn-outline-dark" data-bs-toggle="modal"
                                        data-bs-target="#${date}${fn:replace(purchased.tracking, ' ', '')}${purchased.order_number}">${purchased.tracking}</button>
                            </td>
                            <td class="align-middle">
                                <button type="button" class="btn btn-outline-dark" data-bs-toggle="modal"
                                        data-bs-target="#${purchased.order_number}">
                                    <c:choose>
                                        <c:when test="${purchased.paid == false}">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="red"
                                                 class="bi bi-x" viewBox="0 0 16 16">
                                                <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
                                            </svg>
                                        </c:when>
                                        <c:when test="${purchased.paid == true}">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="green"
                                                 class="bi bi-check" viewBox="0 0 16 16">
                                                <path d="M10.97 4.97a.75.75 0 0 1 1.07 1.05l-3.99 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425a.267.267 0 0 1 .02-.022z"/>
                                            </svg>
                                        </c:when>
                                    </c:choose>
                                </button>
                            </td>
                            <td class="align-middle"><a class="btn btn-outline-primary"
                                                        href="${pageContext.request.contextPath}/purchased-details/${purchased.order_number}">Details</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<c:forEach items="${purchasedList}" var="purchased">
    <div class="modal fade" id="${purchased.order_number}" tabindex="-1" aria-labelledby="${purchased.order_number}Label"
         aria-hidden="true">
        <div class="modal-dialog">
            <form:form action="${pageContext.request.contextPath}/purchased">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="${purchased.order_number}Label">Order ${purchased.order_number} paid?</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <table class="table table-striped">
                        <tr>
                            <td>Order number:</td>
                            <td><input class="form-check" name="order_number" value="${purchased.order_number}"
                                       readonly/></td>
                        </tr>
                        <tr>
                            <td>Paid:</td>
                            <td><input type="checkbox" id="checkbox1" class="form-check-input" name="paid"
                                       <c:if test="${purchased.paid == true}">checked value="true"</c:if>/></td>
                        </tr>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <input type="submit" class="btn btn-outline-primary" value="submit"/>
                </div>
                </form:form>
            </div>
        </div>
    </div>

    <div class="modal fade" id="${purchased.courier}${purchased.order_number}${date}" tabindex="-1" aria-labelledby="${purchased.courier}${purchased.order_number}${date}Label"
         aria-hidden="true">
        <div class="modal-dialog">
            <form:form action="${pageContext.request.contextPath}/purchased">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="${purchased.courier}${purchased.order_number}${date}Label">Order ${purchased.order_number} courier?</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <table class="table table-striped">
                        <tr>
                            <td>Order number:</td>
                            <td><input class="form-check" name="order_numberCourrier" value="${purchased.order_number}"
                                       readonly/></td>
                        </tr>
                        <tr>
                            <td>Courier:</td>
                            <td>
                                <select type="text" class="form-select" name="courier">
                                    <option value="${purchased.courier}" selected>${purchased.courier}</option>
                                    <option value="DHL">DHL</option>
                                    <option value="GLS">GLS</option>
                                    <option value="TNT">TNT</option>
                                </select>
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <input type="submit" class="btn btn-outline-primary" value="submit"/>
                </div>
                </form:form>
            </div>
        </div>
    </div>

    <div class="modal fade" id="${date}${fn:replace(purchased.tracking, ' ', '')}${purchased.order_number}" tabindex="-1" aria-labelledby="${date}${fn:replace(purchased.tracking, ' ', '')}${purchased.order_number}Label"
         aria-hidden="true">
        <div class="modal-dialog">
            <form:form action="${pageContext.request.contextPath}/purchased">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="${date}${fn:replace(purchased.tracking, ' ', '')}${purchased.order_number}lLabel">Order ${purchased.order_number} tracking?</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <table class="table table-striped">
                        <tr>
                            <td>Order number:</td>
                            <td><input class="form-check" name="order_numberTracking" value="${purchased.order_number}"
                                       readonly/></td>
                        </tr>
                        <tr>
                            <td>Tracking:</td>
                            <td>
                                <input type="text" class="form-input" name="tracking" value="${purchased.tracking}"/>
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <input type="submit" class="btn btn-outline-primary" value="submit"/>
                </div>
                </form:form>
            </div>
        </div>
    </div>
</c:forEach>




</body>
</html>
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

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">

    <meta charset="UTF-8">

    <style>
        .container {
            max-width: 1580px !important;
        }
    </style>

    <title>Output SKU</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-2">
            <form:form action="${pageContext.request.contextPath}/outputImeiSku/${sku}" modelAttribute="filter">
                <form:label path="imei">Imei:</form:label>
                <form:input type="text" class="form-control" path="imei"/>
                <form:label path="order_number">N&deg;order:</form:label>
                <form:select class="selectpicker form-control" path="order_number">
                    <form:option value=""></form:option>
                    <c:forEach items="${orderNumber}" var="orderNumber">
                        <form:option type="text" value="${orderNumber}">${orderNumber}</form:option>
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
            <h1>Output</h1>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>N&deg;Order</th>
                        <th>SKU</th>
                        <th>IMEI</th>
                        <th>Model</th>
                        <th>GB</th>
                        <th>Color</th>
                        <th>Grade</th>
                        <th>Supplier</th>
                        <th>Send</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${warehouses}" var="warehouse">
                        <tr>
                            <td class="align-middle">${warehouse.order_number}</td>
                            <td class="align-middle">${warehouse.sku}</td>
                            <td class="align-middle">${warehouse.imei}</td>
                            <td class="align-middle">${warehouse.model}</td>
                            <td class="align-middle">${warehouse.gb}</td>
                            <td class="align-middle">${warehouse.color}</td>
                            <td class="align-middle">${warehouse.grade}</td>
                            <td class="align-middle">${warehouse.supplier}</td>
                            <td class="align-middle"><button class="btn btn-outline-success" data-bs-target="#send${warehouse.imei}Modal" data-bs-toggle="modal"><i class="bi bi-box-seam"></i></button></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<c:forEach items="${warehouses}" var="warehouse">
<div class="modal fade" id="send${warehouse.imei}Modal" tabindex="-1" aria-labelledby="send${warehouse.imei}ModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="send${warehouse.imei}ModalLabel">Ship</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="${pageContext.request.contextPath}/shipping">
            <input type="hidden" name="imei" value="${warehouse.imei}">
            <div class="modal-body">
                <div class="input-group mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-default">Tracking</span>
                    <input type="text" name="tracking" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-order">Order id</span>
                    <input type="text" name="order_id" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-order">
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-market">Market</span>
                    <select name="market" class="form-select selectpicker"  aria-describedby="inputGroup-sizing-market">
                        <option value="BACKMARKET">BACKMARKET</option>
                        <option value="REFURBED">REFURBED</option>
                        <option value="SENSO">SENSO</option>
                    </select>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-courier">courier</span>
                    <select name="courier" class="form-select selectpicker"  aria-describedby="inputGroup-sizing-courier">
                        <option value="TNT">TNT</option>
                        <option value="DHL">DHL</option>
                        <option value="FedEx">FedEx</option>
                        <option value="FedEx">SDA</option>
                    </select>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-price">&euro;</span>
                    <input type="number" name="price" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-price">
                </div>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-primary">Ship <i class="bi bi-truck"></i></button>
            </div>
            </form>
        </div>
    </div>
</div>
</c:forEach>
</body>
</html>
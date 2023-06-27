<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <meta charset="UTF-8">
    <title>Purchased</title>

    <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet">

</head>
<body>
<jsp:include page="../header.jsp"/>
<c:set var="totIE"/>
<c:set var="totII"/>
<c:set var="pieces"/>
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-8">
            <h1>Purchase Details</h1>

            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Model</th>
                    <th>GB</th>
                    <th>Grade</th>
                    <th>Qty</th>
                    <th>Price i.e</th>
                    <th>Price i.i</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${purchasedDetailsList}" var="purchased">
                    <c:set var="sup_order_number" value="${purchased.sup_order_number}"/>
                    <c:set var="supplier" value="${purchased.supplier}"/>
                    <c:set var="order_number" value="${purchased.order_number}"/>
                    <c:set var="date" value="${purchased.date_purchase}"/>
                    <c:set var="iva" value="${purchased.iva}"/>
                    <c:set var="totIE" value="${totIE + purchased.price * purchased.init_qty}"/>
                    <c:set var="totII"
                           value="${totII + purchased.price * purchased.init_qty * purchased.iva / 100 + purchased.price * purchased.init_qty}"/>
                    <tr>
                        <td>${purchased.model}</td>
                        <td>${purchased.gb}</td>
                        <td>${purchased.grade_sup}</td>
                        <td>${purchased.init_qty}/${purchased.init_qty - purchased.qty}</td>
                        <td>${purchased.price * purchased.init_qty}&euro;</td>
                        <td>
                                ${purchased.price * purchased.init_qty * purchased.iva / 100 + purchased.price * purchased.init_qty}&euro;
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
                <tfoot>
                <tr>
                    <td colspan="4">
                    </td>
                    <td>
                        ${totIE}&euro;
                    </td>
                    <td>
                        ${totII}&euro;
                    </td>
                </tr>
                </tfoot>
            </table>
        </div>
        <div class="col-4">
            <h1>Info</h1>
            <h6>N&deg;Order: ${order_number}</h6>
            <h6>N&deg;order supplier: ${sup_order_number}<i class="bi bi-pencil-square" style="color: #007d9a"
                                                            onclick="$('#supOrderNumberModal').modal('show')"></i></h6>
            <h6>Supplier: ${supplier}</h6>
            <h6>IVA: ${iva}%</h6>
            <h6>Date order: <fmt:formatDate pattern="yyyy/MM/dd"
                                            value="${date}"/></h6>
            <h6>Payment method: ${pay.payment_options}</h6>
            Paid:
            <button style="border:none; background-color:white" data-bs-toggle="modal"
                    data-bs-target="#${order_number}">
                <c:choose>
                    <c:when test="${pay.paid == false}">
                        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="red" class="bi bi-x"
                             viewBox="0 0 16 16">
                            <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
                        </svg>
                    </c:when>
                    <c:when test="${pay.paid == true}">
                        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="green" class="bi bi-check"
                             viewBox="0 0 16 16">
                            <path d="M10.97 4.97a.75.75 0 0 1 1.07 1.05l-3.99 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425a.267.267 0 0 1 .02-.022z"/>
                        </svg>
                    </c:when>
                </c:choose>
            </button>
            <p></p>
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                Upload File
            </button>

            <c:forEach items="${files}" var="file">
                <h6>${file.format} <a href="${pageContext.request.contextPath}/download/${file.id}">${file.name}</a><a
                        href="${pageContext.request.contextPath}/delete/${file.id}/${order_number}">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red" class="bi bi-trash"
                         viewBox="0 0 16 16">
                        <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                        <path fill-rule="evenodd"
                              d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                    </svg>
                </a></h6>
            </c:forEach>
        </div>
    </div>
</div>

<div class="modal fade" id="supOrderNumberModal" tabindex="-1" aria-labelledby="supOrderNumberModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="supOrderNumberModalLabel">N&deg;order supplier</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form:form action="${pageContext.request.contextPath}/number_order_supplier/${order_number}">
                <div class="modal-body">
                    <table class="table table-striped">
                        <tr>
                            <td>N&deg;order supplier:</td>
                            <td><input type="text" name="sup_order_number" value="${sup_order_number}"/></td>
                        </tr>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <input class="btn btn-outline-primary" target="_blank" type="submit"/>
                </div>
            </form:form>
        </div>
    </div>
</div>

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Upload file</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form:form method="post" enctype="multipart/form-data"
                           action="${pageContext.request.contextPath}/upload_file_modal">
                <table class="table table-striped">
                    <tr>
                        <th colspan="2">Upload file</th>
                    </tr>
                    <tr>
                        <td>N&deg;order:</td>
                        <td><input class="form-control" name="order_number" value="${order_number}" readonly/></td>
                    </tr>
                    <tr>
                        <td>File:</td>
                        <td><input type="file" name="file"/></td>
                    </tr>
                    <tr>
                        <td>Type:</td>
                        <td>
                            <select class="form-control" name="format">
                                <option value="invoice">invoice</option>
                                <option value="document">document</option>
                                <option value="image">image</option>
                            </select>
                        </td>
                    </tr>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <input class="btn btn-outline-primary" target="_blank" type="submit"/>
            </div>
            </form:form>
        </div>
    </div>
</div>

<div class="modal fade" id="${order_number}" tabindex="-1" aria-labelledby="exampleModalLabel2" aria-hidden="true">
    <div class="modal-dialog">
        <form:form action="${pageContext.request.contextPath}/purchased-details/${order_number}">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel2">Order ${order_number} paid?</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <table class="table table-striped">
                    <tr>
                        <td>Order number:</td>
                        <td><input class="form-check" name="order_number" value="${order_number}" readonly/></td>
                    </tr>
                    <tr>
                        <td>Paid:</td>
                        <td><input type="checkbox" id="checkbox1" class="form-check-input" name="paid"
                                   <c:if test="${pay.paid == true}">checked value="true"</c:if>/></td>
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

</body>
</html>
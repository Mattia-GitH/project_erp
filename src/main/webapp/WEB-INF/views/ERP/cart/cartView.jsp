<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>


    <meta charset="UTF-8">
    <title>Cart</title>

    <script>
        $(function () {
            $('[data-toggle="tooltip"]').tooltip()
        })
    </script>

    <style>
        table{
            table-layout: fixed;
        }
        td{
            word-wrap:break-word
        }

    </style>
    <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../header.jsp" />
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-12">
            <h1>Cart</h1>
            <c:choose>
                <c:when test="${date.date == null}">
                    <div class="alert alert-warning" role="alert">
                        Remember to insert date
                    </div>
                </c:when>
            </c:choose>
            <form:form method="POST" action="${pageContext.request.contextPath}/to_order/${date.date}" modelAttribute="cartList">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Model</th>
                        <th>GB</th>
                        <th>Grade Supplier</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>IVA</th>
                        <th>Tot. Price</th>
                        <th>Supplier</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <script>
                        let qty = [];
                        let price = [];
                        let iva = [];
                        let total = [];
                        let final = 0;

                        function totalPrice(i){
                            qty[i] = document.getElementById("qty"+[i]).value;
                            price[i] = document.getElementById("price"+[i]).value;
                            iva[i] = document.getElementById("iva"+[i]).value;
                            let finalPrice = qty[i] * price[i] + (qty[i] * price[i]/100) * iva[i];
                            document.getElementById('total'+[i]).innerHTML = finalPrice + "\u20AC";
                        }
                    </script>
                    <c:forEach items="${cartList.cartList}" var="cartView" varStatus="status">
                        <tr>
                            <form:input class="form-control" path="cartList[${status.index}].id_article"
                                        value="${cartView.id_article}" readonly="true" style="display:none"/>
                            <form:input class="form-control" path="cartList[${status.index}].id_supplier"
                                        value="${cartView.id_supplier}" readonly="true" style="display:none"/>
                            <td><form:input class="form-control" path="cartList[${status.index}].id"
                                            value="${cartView.id}" readonly="true"/></td>
                            <td>${cartView.model}</td>
                            <td>${cartView.gb}</td>
                            <td>${cartView.grade_sup}</td>
                            <td><form:input id="qty${status.index}" class="form-control" path="cartList[${status.index}].qty"
                                            value="${cartView.qty}" onkeyup="totalPrice(${status.index})" readonly="true"/></td>
                            <td><form:input id="price${status.index}" data-toggle="tooltip" data-placement="top" title="Remember to insert date" class="form-control" path="cartList[${status.index}].price"
                                            value="${cartView.price}" onkeyup="totalPrice(${status.index})"/></td>

                            <td>
                                <form:select path="cartList[${status.index}].iva" id="iva${status.index}" data-toggle="tooltip" data-placement="top" title="Remember to insert date" class="selectpicker form-control"  onchange="totalPrice(${status.index})">
                                    <form:option value="0">0</form:option>
                                    <form:option value="5">5</form:option>
                                    <form:option value="10">10</form:option>
                                    <form:option value="22">22</form:option>
                                </form:select>
                            </td>
                            <td><p id="total${status.index}"></p></td>
                            <td>${cartView.supplier}</td>
                            <td><a href="${pageContext.request.contextPath}/cart/delete/${cartView.id}">Remove</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal">
                    Insert Date
                </button>
                <a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/make_order">Add Article</a>
                <c:choose>
                    <c:when test="${date.date == null}">
                        <input id="sendOrder" type="submit" value="Send Order" class="btn btn-outline-primary disabled text-end"/>
                    </c:when>
                    <c:when test="${date.date != null}">
                        <input id="sendOrder" type="submit" value="Send Order" class="btn btn-outline-primary text-end"/>
                    </c:when>
                </c:choose>
            </form:form>

        </div>
    </div>
</div>



<div class="modal" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Insert Date</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>
            <div class="modal-body">
                <form:form method="POST" action="${pageContext.request.contextPath}/cart_view" modelAttribute="date">
                    <form:input type="date" class="form-control" path="date"/>
                    <input style="margin-top: 10px" class="btn btn-outline-primary" type="submit" value="save date"/>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet">

    <style>
        .form-control{
            max-width: 463px!important;
        }

        .select2-container .select2-selection--single {
            height: 38px!important;
            border: 1px solid #dee2e6!important;
        }
    </style>

    <meta charset="utf-8"/>
    <title>Make Order</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
<script>
    $(document).ready(function() {
        $('.js-basic-single').select2();
    });
</script>
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-10">
            <form:form method="post" modelAttribute="order" action="${pageContext.request.contextPath}/cart">
                <table class="table table-striped">
                    <tr>
                        <th colspan="2">New Order</th>
                    </tr>
                    <tr>
                        <td><form:label path="id_article">Article:</form:label></td>
                        <td><form:select path="id_article" class="selectpicker form-control js-basic-single" required="true">
                            <form:option value=""></form:option>
                            <c:forEach items="${articles}" var="articles">
                                <form:option value="${articles.id}">
                                    ${articles.model} ${articles.gb} ${articles.grade_sup}
                                </form:option>
                            </c:forEach>
                        </form:select>
                        </td>
                    </tr>
                    <tr>
                        <form:hidden path="id"/>
                        <td><form:label path="qty">Quantity:</form:label></td>
                        <td><form:input path="qty" class="form-control"></form:input></td>
                    </tr>
                    <tr>
                        <td><form:label path="id_supplier">Supplier:</form:label></td>
                        <td><form:select path="id_supplier" class="selectpicker form-control">
                            <c:forEach items="${suppliers}" var="suppliers">
                                <form:option
                                        value="${suppliers.id}">${suppliers.supplier}</form:option>
                            </c:forEach>
                        </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/create_article">Create Article</a>
                            <a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/cart_view">Go to Cart</a>
                        </td>
                        <td class="text-end"><input type="submit" class="btn btn-outline-success"/></td>
                    </tr>
                </table>
            </form:form>
        </div>
        <div class="col-10" style="margin-top: 100px">
            <h5>Cart Preview </h5>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Model</th>
                    <th>GB</th>
                    <th>Grade Supplier</th>
                    <th>Quantity</th>
                    <th>Supplier</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${cartList.cartList}" var="cartView" varStatus="status">
                    <tr>
                        <td>${cartView.id}</td>
                        <td>${cartView.model}</td>
                        <td>${cartView.gb}</td>
                        <td>${cartView.grade_sup}</td>
                        <td>${cartView.qty}</td>
                        <td>${cartView.supplier}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
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
    <title>Create New Product</title>
</head>
<body>
<jsp:include page="../header.jsp" />
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-10">
            <form:form method="post" modelAttribute="order" action="${pageContext.request.contextPath}/save_order">
                <table class="table table-striped">
                    <tr>
                        <th colspan="2">New Order</th>
                    </tr>
                    <tr>
                        <form:hidden path="id"/>
                        <form:hidden path="id_article"/>
                        <td><form:label path="qty">Quantity:</form:label></td>
                        <td><form:input path="qty"  class="form-control"></form:input></td>
                    </tr>
                    <tr>
                        <td><form:label path="id_supplier">Supplier:</form:label></td>
                        <td><form:select path="id_supplier" class="selectpicker form-control">
                            <c:forEach items="${suppliers}" var="suppliers">
                                <form:option
                                        value="${suppliers.id}">${suppliers.supplier} - ${suppliers.batch}</form:option>
                            </c:forEach>
                        </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td><form:label path="date">Date:</form:label></td>
                        <td>
                            <form:input type="date" class="form-control" path="date"></form:input>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit"/></td>
                    </tr>
                </table>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
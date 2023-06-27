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
    <title>Planning Preview</title>

    <style>
        Table {
            float: left;
            margin: 2px;
            border: 2px solid #E8E8E8;
        }

        button.btn.btn-outline-danger {
            height: 126px;
            width: 126px;
        }
    </style>

</head>
<body>
<jsp:include page="../header.jsp"/>
<script src="${pageContext.request.contextPath}/JS/addPlan.js"></script>

<div class="container">
    <div class="row">
        <div class="col-3">
            <h1>Planning</h1><a href="${pageContext.request.contextPath}/truncatePlanPreview" class='btn btn-outline-danger' type="button">Empty</a>
            <div class="table">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Qty</th>
                        <th>Status</th>
                        <th>SKU</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${planPreview}" var="list">
                        <c:if test="${list.status == null}"><c:set var="status" value="ITC"/> ITC</c:if>
                        <c:if test="${list.status != null}"><c:set var="status" value="${list.status}"/></c:if>
                        <tr>
                            <td>${list.qty}</td>
                            <td>
                                    ${status}
                            </td>
                            <td>${list.sku}</td>
                            <td><a href="/delete/plan/${list.id}">delete</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col-9">
            <form:form modelAttribute="plan" action="${pageContext.request.contextPath}/create_plan">
                <div>
                    <button class="btn btn-outline-primary" onclick="add()" type="button">ADD</button>
                    <input class="btn btn-outline-primary" type="submit"/>
                </div>
                <br>
                <label>date:</label>
                <input class="form-control" name="sDate" type="date"/>
                <div class="plan" id="planTable">
                    <table>
                        <tr>
                            <td>
                                <form:label path="planList[0].sku">sku:</form:label>
                            </td>
                            <td>
                                <form:select id="sku" class="form-control" path="planList[0].sku">
                                    <c:forEach items="${planPreview}" var="list">
                                        <form:option value="${list.sku}">${list.sku}</form:option>
                                    </c:forEach>
                                </form:select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="planList[0].qty" value="1">qty:</form:label>
                            </td>
                            <td>
                                <form:input type="number" class="form-control" path="planList[0].qty"></form:input>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="planList[0].status">status:</form:label>
                            </td>
                            <td>
                                <form:select class="form-control" path="planList[0].status">
                                    <c:forEach items="${phases}" var="phase">
                                        <form:option value="${phase.phase}">${phase.phase}</form:option>
                                    </c:forEach>
                                </form:select>
                            </td>
                        </tr>
                    </table>
                </div>
                <div id="remove">

                </div>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>

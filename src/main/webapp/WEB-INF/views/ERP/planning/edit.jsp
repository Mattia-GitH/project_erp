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

    <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>Edit plan</title>

</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-12">
            <form:form modelAttribute="planToEdit" action="${pageContext.request.contextPath}/saveEditedPlan">
                <form:hidden path="id" value="${planToEdit.id}"/>
                <div>
                    <label name="sDate"> Date: </label>
                    <fmt:formatDate var="date" pattern="yyyy-MM-dd"
                                    value="${planToEdit.date}"/>
                    <input class="form-control" type="date" name="sDate" value="${date}"/>
                </div>
                <div>

                    <form:label path="sku">SKU: </form:label>

                    <form:select class="form-control" path="sku">
                        <form:option value="${planToEdit.sku}">${planToEdit.sku}</form:option>
                        <c:forEach items="${sku}" var="sku">
                            <form:option value="${sku}">${sku}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
                <div>
                    <form:label path="status">status: </form:label>

                    <form:select class="form-control" path="status">
                        <form:option value="${planToEdit.status}">${planToEdit.status}</form:option>
                        <c:forEach items="${phases}" var="phase">
                            <form:option value="${phase.phase}">${phase.phase}</form:option>
                        </c:forEach>
                    </form:select>
                </div>

                <div>
                    <form:label path="qty">qty: </form:label>

                    <form:input class="form-control" path="qty" type="nomber" value="${planToEdit.qty}"></form:input>
                </div>
                <div>
                    <form:label path="operator">Operator: </form:label>

                    <form:select class="form-control" path="operator">
                        <form:option value="${planToEdit.operator}">${planToEdit.operator}</form:option>
                        <c:forEach items="${users}" var="user">
                            <form:option value="${user.username}">${user.username}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
                <input type="submit" class="btn btn-outline-primary">
            </form:form>
        </div>
    </div>
</div>

</body>
</html>

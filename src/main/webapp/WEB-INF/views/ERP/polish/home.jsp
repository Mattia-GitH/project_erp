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

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <title>Polish</title>

    <style>
        .form-group {
            margin-top: 50px;
        }
    </style>

</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <form:form method="post" modelAttribute="polishContainer" action="${pageContext.request.contextPath}/polishing">
        <div class="row">
        <c:forEach items="${polish}" var="polish" varStatus="status">
            <div class="col-3">
                <div class="form-group">
                    <form:label class="form-label" path="polishList[${status.index}].imei">imei ${status.index + 1}:
                        <form:input class="form-control" path="polishList[${status.index}].imei"></form:input></form:label>
                </div>
            </div>
            <c:if test="${status.index == 3}">
                </div>
                <div class="row">
            </c:if>
        </c:forEach>
        </div>
        <div class="row justify-content-md-center">
            <button class="btn btn-outline-primary" type="submit">START</button>
        </div>
    </form:form>
</div>
</body>
</html>

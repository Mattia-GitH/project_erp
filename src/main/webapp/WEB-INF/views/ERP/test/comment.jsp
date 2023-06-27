<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet">
    <meta charset="utf-8"/>
    <title>Comment</title>
</head>
<body>
<jsp:include page="../header.jsp" />
<div class="container">
    <div class="row" style="margin-top: 50px; alignment: center">
        <form:form method="post" modelAttribute="comment" action="${pageContext.request.contextPath}/save_comment">
            <form:hidden path="status" value="${status}"/>
            <div class="form-group">
                <form:label path="imei">imei:</form:label>
                <form:input path="imei" value="${imei}" readonly="true"></form:input>
            </div>
            <div class="form-group" style="display:none">
                <form:label path="id_issue">id issue:</form:label>
                <form:input path="id_issue" value="${issue}" readonly="true"></form:input>
            </div>
            <div class="form-group">
                <form:label path="comment">Comment: </form:label>
                <form:input class="form-control" path="comment" ></form:input>
            </div>
            <div class="form-group">
                <input type="submit" class="btn btn-outline-success"/>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>
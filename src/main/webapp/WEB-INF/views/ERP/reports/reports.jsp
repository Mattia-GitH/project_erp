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
    <title>All phones</title>
</head>
<body>
<jsp:include page="../header.jsp" />
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-10">
            <h1>All phones</h1>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>IMEI</th>
                    <th>Date</th>
                    <th>Show</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${reports}" var="report">
                    <tr>
                        <td>${report.imei}</td>
                        <td>${report.date}</td>
                        <td><a href="${pageContext.request.contextPath}/report/${report.imei}/${report.date}">show</a> </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
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
    <title>Articles</title>
</head>
<body>
<jsp:include page="../header.jsp" />
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-10">
            <h1>Article List - <a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/create_article">Create Article</a> - <a
                    class="btn btn-outline-primary" href="${pageContext.request.contextPath}/cart_view">Cart</a></h1>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Article ID</th>
                    <th>Model</th>
                    <th>GB</th>
                    <th>Grade Supplier</th>
                    <th>Color</th>
                    <th>Order</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${articleList}" var="article">
                    <tr>
                        <td>${article.id}</td>
                        <td>${article.model}</td>
                        <td>${article.gb}</td>
                        <td>${article.grade_sup}</td>
                        <td>${article.color}</td>
                        <td><a href="<c:url value='/toCart/${article.id}' />">To Cart</a></td>
                        <td><a href="${pageContext.request.contextPath}/delete/article/${article.id}">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
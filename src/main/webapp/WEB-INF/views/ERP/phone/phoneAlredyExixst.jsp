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
    <script language="javascript" type="text/javascript">
        document.addEventListener("keydown", (event) => {
            if (event.keyCode === 13 && event.target.nodeName === "INPUT") {
                const form = event.target.form;
                const index = [...form].indexOf(event.target);
                form.elements[index + 1].focus();
                event.preventDefault();
            }
        });
    </script>

    <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>Insert IMEI</title>
</head>
<body>
<jsp:include page="../header.jsp" />
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-10">
            <h1>Phone Already Exist</h1>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Article ID</th>
                        <th>Model</th>
                        <th>GB</th>
                        <th>Imei</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${phones.phones}" var="phone" varStatus="status">
                        <tr>
                            <td>${phone.id_article}</td>
                            <td>${phone.model}</td>
                            <td>${phone.gb}</td>
                            <td>${phone.imei}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
        </div>
    </div>
</div>
</body>
</html>
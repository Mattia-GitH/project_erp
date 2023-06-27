<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
    <link href="/style.css" rel="stylesheet">

    <meta charset="utf-8"/>
    <title>Upload New file</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-10">
            <form:form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/upload_file">
                <table class="table table-striped">
                    <tr>
                        <th colspan="2">Upload file</th>
                    </tr>
                    <tr>
                        <td>N&deg;order:</td>
                        <td><input class="form-control" name="order_number" value="${order_number}" readonly/></td>
                    </tr>
                    <tr>
                        <td>File:</td>
                        <td><input type="file" name="file"/></td>
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
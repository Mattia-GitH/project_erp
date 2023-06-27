<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
    <link href="style.css" rel="stylesheet">
    <style>
        .btn-outline-primary {
            --bs-btn-color: #004750;
            --bs-btn-border-color: #004750;
            --bs-btn-hover-color: #fff;
            --bs-btn-hover-bg: #004750;
            --bs-btn-hover-border-color: #004750;
            --bs-btn-focus-shadow-rgb: 13,110,253;
            --bs-btn-active-color: #fff;
            --bs-btn-active-bg: #004750;
            --bs-btn-active-border-color: #004750;
            --bs-btn-active-shadow: inset 0 3px 5px rgba(0, 0, 0, 0.125);
            --bs-btn-disabled-color: #004750;
            --bs-btn-disabled-bg: transparent;
            --bs-btn-disabled-border-color: #004750;
            --bs-gradient: none;
        }
    </style>


    <meta charset="utf-8"/>
    <title>Grading</title>
</head>
<body>
<jsp:include page="../header.jsp" />
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-10">
            <form:form method="post" modelAttribute="grading" action="/save_grade">
                <table class="table table-striped">
                    <tr>
                        <th colspan="2">Grading</th>
                    </tr>
                    <tr>
                        <td><form:label path="imei">imei:</form:label></td>
                        <td><form:input class="form-control" path="imei" readonly="true"></form:input></td>
                    </tr>
                    <tr>
                        <td><form:label path="grade_sup">Grade supplier:</form:label></td>
                        <td><form:input class="form-control" path="grade_sup" readonly="true"></form:input></td>
                    </tr>
                    <tr>
                        <td><form:label path="grade_check">Grade Check:</form:label></td>
                        <td>
                            <form:select class="selectpicker form-control" path="grade_check">
                                <form:option value="A">A</form:option>
                                <form:option value="B">B</form:option>
                                <form:option value="C">C</form:option>
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td class="text-end"><input class="btn btn-outline-primary" type="submit" value="continue"/></td>
                    </tr>
                </table>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
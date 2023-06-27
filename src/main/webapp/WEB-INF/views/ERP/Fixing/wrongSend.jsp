<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<title>Wrong</title>
<div class="container">
    <div class="row">
        <div class="col-12">


            <h1>${phone.imei}</h1>
            <p>This phone was sent to <span style="font-weight:bold"> ${phone.send_to} </span> from <span
                    style="font-weight:bold"> ${phone.actualStatus} </span> by <span
                    style="font-weight:bold"> ${phone.operator} </span> in
                date <span style="font-weight:bold">${phone.date}</span></p>

            <a href="${pageContext.request.contextPath}/fixing" class="btn btn-outline-primary">Back to fixing</a>

        </div>
    </div>
</div>

</body>
</html>

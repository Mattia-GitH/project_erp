<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet">

    <meta charset="UTF-8">
    <title>FIXING</title>

    <style>
        #status {
            height: 60px;
            border: none;
            overflow: hidden;
        }

        #status::-moz-focus-inner {
            border: 0;
        }

        #status:focus {
            outline: none;
        }

        #status option {
            width: 300px;
            font-size: 1.2em;
            padding: 10px 0;
            text-align: center;
            margin-right: 160px;
            display: inline-block;
            cursor: pointer;
            border: #004750 solid 1px;
            border-radius: 5px;
            color: #004750;
        }
    </style>
</head>
<body>
<jsp:include page="../header.jsp"/>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<div class="container">
    <div class="toast-container p-3 top-0 start-50 translate-middle-x">
        <div id="processing" class="toast" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="toast-header">
                <div class="spinner-grow text-primary"></div>
                <strong class="me-auto">&nbsp;&nbsp;Processing ...</strong>
                <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close" onclick="$('#processing').hide()"></button>
            </div>
        </div>
    </div>
    <div class="row justify-content-md-center">
        <div class="col-12">
            <h1>
                <sec:authorize access="isAuthenticated()">
                    Welcome Back, <sec:authentication property="name"/>
                </sec:authorize>
            </h1>
        </div>
    </div>
    <div class="row">
        <div class="col-12">
            <form:form action="${pageContext.request.contextPath}/fixingView">
                <label for="imei"><h4>IMEI</h4></label>
                <input id="imei" class="form-control" name="sImei" required>
                <br>
                <label for="status"><h4>Status</h4></label>
                <select required class="selectpicker form-control text-center" name="status" id="status" multiple>
                    <c:if test="${status == 'FIXING' || status == 'TECHLAB'}">
                        <option selected>${status}</option>
                    </c:if>
                    <option>FIXING</option>
                    <option>TECHLAB</option>
                </select>
                <input style="width: 100%" class="btn btn-outline-primary" id="submit" type="submit" onclick="$('#processing').show()">
            </form:form>
            <i class="bi bi-phone fs-2"><span style="font-size: 30px;">${phoneDone.size()}</span></i>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>IMEI</th>
                        <th>DATE</th>
                        <th>SEND TO</th>
                        <th>TIMER</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${phoneDone}" var="phone">
                        <tr>
                            <td>${phone.imei}</td>
                            <td>${phone.date}</td>
                            <td>
                                    ${phone.send_to}
                                <c:choose>
                                    <c:when test="${phone.send_to == 'FIXING'}"><i class="bi bi-wrench" style="color: green"></i></c:when>
                                    <c:when test="${phone.send_to == 'TECHLAB'}"><i class="bi bi-wrench" style="color: blue"></i></c:when>
                                    <c:when test="${phone.send_to == 'PACKING'}"><i class="bi bi-box-seam-fill" style="color: saddlebrown"></i></c:when>
                                    <c:when test="${phone.send_to == 'RMA'}"><i class="bi bi-exclamation-octagon" style="color: red"></i></c:when>
                                </c:choose>
                            </td>
                            <td>${phone.timer}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

</body>
</html>
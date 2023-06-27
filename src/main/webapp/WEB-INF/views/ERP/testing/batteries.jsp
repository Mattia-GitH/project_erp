<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet">
    <meta charset="utf-8"/>
    <title>Battery</title>
    <style>
        input#hour, input#minute, input#second {
            max-width: 25px;
            border: transparent;
        }

        span#msecond {
            color: transparent;
        }
    </style>

    <script>
        $(document).ready(function () {
            $("#start").trigger('click');
        });
    </script>
</head>
<body>
<jsp:include page="../header.jsp"/>
<form:form method="post" modelAttribute="battery" action="${pageContext.request.contextPath}/status/${status}">
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
        <div class="row">
            <div class="col-12">
                <script>
                    let hr = ${hours};
                    let min = ${mins};
                    let sec = ${seconds};
                    let count = 0;

                </script>

                <div>
                    <input name="hours" id="hour" readonly="true"></input>
                    <span type="text">:</span>
                    <input name="mins" id="minute" readonly="true"></input>
                    <span type="text">:</span>
                    <input name="seconds" id="second" readonly="true"></input>
                    <span id="msecond" class="time">00</span>
                </div>
                <div class="buttons">
                    <button type="button" class="btn btn-outline-primary" id="start">Start</button>
                    <button type="button" class="btn btn-danger" id="stop">Stop</button>
                </div>
            </div>
        </div>
        <div class="row">
            <c:forEach items="${batteries}" var="battery" varStatus="status">
                <div class="col-6">
                    <div class="form-group">
                        <form:label path="batteryList[${status.index}].imei">imei:</form:label>
                        <form:input path="batteryList[${status.index}].imei" value="${battery.imei}"
                                    readonly="true"></form:input>
                    </div>
                    <div class="form-group">
                        <form:label path="batteryList[${status.index}].cycles">CYCLES: </form:label>
                        <form:input class="form-control" path="batteryList[${status.index}].cycles"></form:input>
                    </div>
                    <div class="form-group">
                        <form:label path="batteryList[${status.index}].soh">SOH: </form:label>
                        <form:input class="form-control" path="batteryList[${status.index}].soh"></form:input>
                    </div>
                    <div class="form-group">
                        <form:label class="form-check-label"
                                    path="batteryList[${status.index}].replace"><h5>Replace: </h5></form:label>
                        <form:checkbox class="form-check-input"
                                       path="batteryList[${status.index}].replace"></form:checkbox>
                    </div>
                </div>
            </c:forEach>
            <input type="submit" id="submit" onclick="$('#processing').show()" class="btn btn-outline-primary"/>
        </div>
    </div>
</form:form>

<script src="${pageContext.request.contextPath}/clock.js"></script>
</body>
</html>

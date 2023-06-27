<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <style>
        .btn-outline-primary {
            --bs-btn-color: #004750;
            --bs-btn-border-color: #004750;
            --bs-btn-hover-color: #fff;
            --bs-btn-hover-bg: #004750;
            --bs-btn-hover-border-color: #004750;
            --bs-btn-focus-shadow-rgb: 13, 110, 253;
            --bs-btn-active-color: #fff;
            --bs-btn-active-bg: #004750;
            --bs-btn-active-border-color: #004750;
            --bs-btn-active-shadow: inset 0 3px 5px rgba(0, 0, 0, 0.125);
            --bs-btn-disabled-color: #004750;
            --bs-btn-disabled-bg: transparent;
            --bs-btn-disabled-border-color: #004750;
            --bs-gradient: none;
        }

        input#hour, input#minute, input#second {
            max-width: 25px;
            border: transparent;
        }

        span#msecond {
            color: transparent;
        }
    </style>
    <script>
        function postmessage() {
            var msg = $('#msg').val();
            $.ajax({
                method: 'POST',
                data: {message: msg},
                url: '${pageContext.request.contextPath}/message'
            });

            $('#msg').val("");
            $('#sent').val("Sent!!!");
        }


    </script>

    <meta charset="utf-8"/>
    <title>Grading</title>
</head>
<body>
<script>
    $(document).ready(function () {
        $("#start").trigger('click');
        if (${status == "TESTING"}) {
            document.grading.submit();
        }
    });
</script>

<jsp:include page="../header.jsp"/>
<div class="container">
    <div class="toast-container p-3 top-0 start-50 translate-middle-x" id="toastPlacement"
         data-original-class="toast-container p-3">
        <c:if test="${msg0 != null}">
            <div class="toast fade show">
                <div class="toast-header">
                    <svg class="bd-placeholder-img rounded me-2" width="20" height="20"
                         xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice"
                         focusable="false">
                        <rect width="100%" height="100%" fill="red"></rect>
                    </svg>
                    <strong class="me-auto">Error</strong>
                    <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
                </div>
                <div class="toast-body">
                        ${msg0}
                </div>
            </div>
        </c:if>
        <c:if test="${msg1 != null}">
            <div class="toast fade show">
                <div class="toast-header">
                    <svg class="bd-placeholder-img rounded me-2" width="20" height="20"
                         xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice"
                         focusable="false">
                        <rect width="100%" height="100%" fill="red"></rect>
                    </svg>
                    <strong class="me-auto">Error</strong>
                    <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
                </div>
                <div class="toast-body">
                        ${msg1}
                </div>
            </div>
        </c:if>
        <c:if test="${msg2 != null}">
            <div class="toast fade show">
                <div class="toast-header">
                    <svg class="bd-placeholder-img rounded me-2" width="20" height="20"
                         xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice"
                         focusable="false">
                        <rect width="100%" height="100%" fill="red"></rect>
                    </svg>
                    <strong class="me-auto">Error</strong>
                    <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
                </div>
                <div class="toast-body">
                        ${msg2}
                </div>
            </div>
        </c:if>
        <c:if test="${msg3 != null}">
            <div class="toast fade show">
                <div class="toast-header">
                    <svg class="bd-placeholder-img rounded me-2" width="20" height="20"
                         xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice"
                         focusable="false">
                        <rect width="100%" height="100%" fill="red"></rect>
                    </svg>
                    <strong class="me-auto">Error</strong>
                    <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
                </div>
                <div class="toast-body">
                        ${msg3}
                </div>
            </div>
        </c:if>
        <div id="processing" class="toast" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="toast-header">
                <div class="spinner-grow text-primary"></div>
                <strong class="me-auto">&nbsp;&nbsp;Processing ...</strong>
                <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"
                        onclick="$('#processing').hide()"></button>
            </div>
        </div>
    </div>
    <form:form method="post" name="grading" modelAttribute="grading"
               action="${pageContext.request.contextPath}/test/${status}">
        <div class="row">
            <div class="col-12">
                <script>
                    let hr = 0;
                    let min = 0;
                    let sec = 0;
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


        <div class="row justify-content-md-center">
            <c:forEach items="${gradeList}" var="grade" varStatus="status">
                <div class="col-3">
                    <table class="table table-striped">
                        <tr>
                            <td><form:label path="gradeList[${status.index}].imei">Imei:</form:label></td>
                            <td><form:input class="form-control" path="gradeList[${status.index}].imei"
                                            readonly="true" value="${grade.imei}"></form:input></td>
                        </tr>
                        <tr>
                            <td><form:label
                                    path="gradeList[${status.index}].grade_sup">Grade supplier:</form:label></td>
                            <td><form:input class="form-control" path="gradeList[${status.index}].grade_sup"
                                            readonly="true" value="${grade.grade_sup}"></form:input></td>
                        </tr>
                        <tr>
                            <td><form:label path="gradeList[${status.index}].grade_check">Grade Check:</form:label></td>
                            <td>
                                <form:select class="selectpicker form-control"
                                             path="gradeList[${status.index}].grade_check">
                                    <form:option value="A">A</form:option>
                                    <form:option value="B">B</form:option>
                                    <form:option value="C">C</form:option>
                                    <form:option value="D">D</form:option>
                                    <form:option value="F">F</form:option>
                                    <form:option value="W">W</form:option>
                                </form:select>
                            </td>
                        </tr>
                    </table>
                </div>
            </c:forEach>
        </div>
        <div class="row">
            <input type="submit" id="submit" onclick="$('#processing').show()" class="btn btn-outline-primary"/>
            <c:if test="${msg1 != null || msg2 != null || msg3 != null || msg4 != null}">
                <a href="${pageContext.request.contextPath}/testing" class="btn btn-outline-primary">Go Back</a>
            </c:if>
        </div>
    </form:form>
</div>


<script src="${pageContext.request.contextPath}/clock.js"></script>
</body>
</html>

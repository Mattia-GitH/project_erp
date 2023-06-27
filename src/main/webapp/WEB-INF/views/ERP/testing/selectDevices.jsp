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
    <title>Multi Test</title>

    <style>
        .raulwwq0-button-1 {
            cursor: pointer;
            background: transparent;
            position: relative;
            display: inline-block;
            padding: 15px 30px;
            outline: none;
            border: 2px solid #007d9a;
            margin: 40px;
            width: 150px;
            height: 60px;
            text-transform: uppercase;
            font-weight: 900;
            text-decoration: none;
            letter-spacing: 2px;
            color: black;
            -webkit-box-reflect: below 0px linear-gradient(transparent, #0002);
            transition: 0.45s;
            transition-delay: 0s;
        }

        .raulwwq0-button-1:hover {
            transition-delay: 0.5s;
            color: #fff;
            box-shadow: 0 0 10px #007d9a, 0 0 20px #007d9a, 0 0 40px #007d9a,
            0 0 80px #007d9a, 0 0 100px #007d9a;
        }

        .raulwwq0-button-1 span {
            position: relative;
            z-index: 100;
        }

        .raulwwq0-button-1::before {
            content: '';
            position: absolute;
            left: -20px;
            top: 50%;
            transform: translateY(-50%);
            width: 20px;
            height: 2px;
            background: #007d9a;
            box-shadow: 5px -8px 0 #007d9a, 5px 8px 0 #007d9a;
            transition: width 0.5s, left 0.5s, height 0.5s, box-shadow 0.5s;
            transition-delay: 0.5s, 0.5s, 0s, 0s;
        }

        .raulwwq0-button-1:hover::before {
            width: 60%;
            height: 100%;
            left: -2px;
            box-shadow: 5px 0 0 #007d9a, 5px 0 0 #007d9a;
            transition-delay: 0s, 0s, 0.5s, 0.5s;
        }

        .raulwwq0-button-1::after {
            content: '';
            position: absolute;
            right: -20px;
            top: 50%;
            transform: translateY(-50%);
            width: 20px;
            height: 2px;
            background: #007d9a;
            box-shadow: -5px -8px 0 #007d9a, -5px 8px 0 #007d9a;
            transition: width 0.5s, right 0.5s, height 0.5s, box-shadow 0.5s;
            transition-delay: 0.5s, 0.5s, 0s, 0s;
        }

        .raulwwq0-button-1:hover::after {
            width: 60%;
            height: 102%;
            right: -2px;
            box-shadow: -5px 0 0 #007d9a, -5px 0 0 #007d9a;
            transition-delay: 0s, 0s, 0.5s, 0.5s;
        }


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
    <script type="text/javascript">
        document.addEventListener("keydown", function (event) {
            if (event.key === "Enter") {
                event.preventDefault();
                // trovare l'elemento successivo nella sequenza di tabulazione
                var nextElement = event.target.nextElementSibling;
                while (nextElement) {
                    if (nextElement.tabIndex >= 0 && !nextElement.disabled) {
                        nextElement.focus();
                        break;
                    }
                    nextElement = nextElement.nextElementSibling;
                }
            }
        })

        function checkImei() {
            let imei = []
            let imei1 = document.getElementById("imei1").value;
            let imei2 = document.getElementById("imei2").value;
            let imei3 = document.getElementById("imei3").value;
            let imei4 = document.getElementById("imei4").value;

            let bool1 = false;
            let bool2 = false;
            let bool3 = false;
            let bool4 = false;

            if (imei1 !== "") {
                if (!imei.includes(imei1)) {
                    imei.push(imei1);
                    bool1 = false;
                } else {
                    bool1 = true;
                    alert("Imei Already Insert " + imei1);
                }
            }
            if (imei2 !== "") {
                if (!imei.includes(imei2)) {
                    imei.push(imei2);
                    bool2 = false;
                } else {
                    bool2 = true;
                    alert("Imei Already Insert " + imei2);
                }
            }
            if (imei3 !== "") {
                if (!imei.includes(imei3)) {
                    imei.push(imei3);
                    bool3 = false;
                } else {
                    bool3 = true;
                    alert("Imei Already Insert " + imei3);
                }
            }
            if (imei4 !== "") {
                if (!imei.includes(imei4)) {
                    imei.push(imei4);
                    bool4 = false;
                } else {
                    bool4 = true;
                    alert("Imei Already Insert " + imei4);
                }
            }
            if (bool1 === true || bool2 === true || bool3 === true || bool4 === true) {
                $("#btnStart").css("display", "none");
            } else {
                $("#btnStart").css("display", "block");
            }
        }
    </script>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <div class="d-flex justify-content-end"><a href="${pageContext.request.contextPath}/itc/export/excel" style="background-color: #1D6F42"
                                                   class="btn btn-primary me-md-2" onclick="$('.toast').toast('show');"
                                                   type="button">ITC <i class="bi bi-filetype-xlsx"></i></a>
        </div>
    </sec:authorize>

    <div class="toast-container p-3 top-0 start-50 translate-middle-x" id="toastPlacement"
         data-original-class="toast-container p-3">
        <div class="toast fade">
            <div class="toast-header">
                <svg class="bd-placeholder-img rounded me-2" width="20" height="20" aria-hidden="true"
                     preserveAspectRatio="xMidYMid slice" focusable="false">
                    <rect width="100%" height="100%" fill="green"></rect>
                </svg>
                <strong class="me-auto">Excel</strong>
                <small>exporting...</small>
                <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
            </div>
            <div class="toast-body">
                Exporting in excel
            </div>
        </div>
    </div>


    <div class="toast-container p-3 top-0 start-50 translate-middle-x">
        <div id="processing" class="toast" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="toast-header">
                <div class="spinner-grow text-primary"></div>
                <strong class="me-auto">&nbsp;&nbsp;Processing ...</strong>
                <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"
                        onclick="$('#processing').hide()"></button>
            </div>
        </div>
    </div>
    <form:form id="formId" method="post" modelAttribute="imei" action="${pageContext.request.contextPath}/grading">
        <label for="status"><h4>Status</h4></label>

        <select required class="selectpicker form-control text-center" name="status" id="status" multiple>
            <c:if test="${status == 'ITC' || status == 'TESTING'}">
                <option selected>${status}</option>
            </c:if>
            <option>ITC</option>
            <option>TESTING</option>
        </select>
        <div class="row justify-content-md-center">
            <div class="col-3">
                <form:label path="imei1">IMEI 1:</form:label>
                <form:input path="imei1" id="imei1" value=""
                            onchange="$('#imei2').prop('disabled', false ), checkImei()" class="form-control"
                            required="true"></form:input>
            </div>
            <div class="col-3">
                <form:label path="imei2">IMEI 2:</form:label>
                <form:input id="imei2" value="" onchange="$('#imei3').prop('disabled', false ), checkImei()"
                            path="imei2"
                            class="form-control" disabled="true"></form:input>
            </div>
            <div class="col-3">
                <form:label path="imei3">IMEI 3:</form:label>
                <form:input id="imei3" value="" onchange="$('#imei4').prop('disabled', false ), checkImei()"
                            path="imei3"
                            class="form-control" disabled="true"></form:input>
            </div>
            <div class="col-3">
                <form:label path="imei4">IMEI 4:</form:label>
                <form:input id="imei4" value="" path="imei4" class="form-control" disabled="true"
                            onchange="checkImei()"></form:input>
            </div>
        </div>
        <div class="d-flex justify-content-center" style="margin-top: 50px">
            <button type="submit" id="btnStart" class="raulwwq0-button-1" onclick="$('#processing').show()">
                <span>START</span></button>
        </div>
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
                            <c:when test="${phone.send_to == 'FIXING'}"><i class="bi bi-wrench"
                                                                           style="color: green"></i></c:when>
                            <c:when test="${phone.send_to == 'TECHLAB'}"><i class="bi bi-wrench"
                                                                            style="color: blue"></i></c:when>
                            <c:when test="${phone.send_to == 'PACKING'}"><i class="bi bi-box-seam-fill"
                                                                            style="color: saddlebrown"></i></c:when>
                            <c:when test="${phone.send_to == 'RMA'}"><i class="bi bi-exclamation-octagon"
                                                                        style="color: red"></i></c:when>
                        </c:choose>
                    </td>
                    <td>${phone.timer}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>


</div>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>

    <script src="${pageContext.request.contextPath}/JS/inputRange.js"/>

    <title>Polishing</title>

</head>
<body>
<jsp:include page="../header.jsp"/>
<style>
    .form-group {
        max-width: 350px;
        border: solid #004750;
        border-radius: 30px;
        box-shadow: 1px 1px 20px 0px #008697;
        margin-top: 30px;
        text-align: center;
        margin-left: 3%;
    }
</style>
<div class="container" style="max-width: 95%">
    <div class="row">
        <c:if test="${msg.size() > 0}">
            <button class="btn btn-outline-danger" onclick="history.back()">Go Back</button>
        </c:if>
    </div>
    <div class="row">
        <c:forEach items="${msg}" varStatus="ind" var="msg">
            <div class="toast-container position-static">
                <div class="toast" id="toast${ind.index}" role="alert" aria-live="assertive" aria-atomic="true">
                    <div class="toast-header">
                        <strong class="me-auto">Not found in Polish</strong>
                        <button type="button" class="btn-close" onclick="$('#toast${ind.index}').hide()"
                                data-bs-dismiss="toast" aria-label="Close"></button>
                    </div>
                    <div class="toast-body">
                            ${msg}
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <form:form method="post" modelAttribute="polishContainer" action="${pageContext.request.contextPath}/polish/save">
        <div class="row justify-content-md-center">
            <button style="margin-top: 20px;" class="btn btn-outline-primary" type="submit">SAVE</button>
        </div>
        <div class="row">
        <c:forEach items="${polish}" var="polish" varStatus="status">
            <c:set var="ind" value="${status.index}"/>
            <div class="col-3">
                <div class="form-group" style="max-width: 350px; text-align: center;">
                    <c:forEach items="${timesPolish}" var="times">
                        <c:if test="${times[status.index].imei == polish.imei}">
                            <h5 style="color: red">Times in polish: ${times.size()}</h5>
                        </c:if>
                    </c:forEach>
                    <form:input class="form-control" path="polishList[${status.index}].imei" style="margin-top: 17px"
                                required="true"
                                readonly="true" value="${polish.imei}"></form:input>

                    <form:label style="margin-bottom: 10px; margin-top: 30px;" class="form-label"
                                path="polishList[${status.index}].time">Time:
                        <br>
                        <input type="range" style="max-width:180px; width: 180px;" name="time${status.index}" required
                               class="form-range"
                               value="0" min="0" max="30" step="1" id="time${status.index}"
                               oninput="this.nextElementSibling.value = this.value">
                        <output style="font-size: xx-large;"></output>
                        <br>
                    </form:label>
                    <style>
                        @import url(https://fonts.googleapis.com/css?family=Lato:300,400,900);

                        .button-wrap {
                            position: relative;
                            top: 50%;
                        }

                        @media (max-width: 40em) {
                            .button-wrap {
                                margin-top: -1.5em;
                            }
                        }

                        .button-label {
                            display: inline-block;
                            padding: 10px 15px;
                            margin: 0px 10px 10px 10px;
                            cursor: pointer;
                            color: #292929;
                            border-radius: 0.25em;
                            background: #efefef;
                            box-shadow: 0 3px 10px rgba(0, 0, 0, 0.2), inset 0 -3px 0 rgba(0, 0, 0, 0.22);
                            transition: 0.3s;
                            -webkit-user-select: none;
                            -moz-user-select: none;
                            -ms-user-select: none;
                            user-select: none;
                            font-size: 30px;
                        }

                        .button-label h1 {
                            font-size: 1em;
                            font-family: "Lato", sans-serif;
                        }

                        .button-label:hover {
                            background: #d6d6d6;
                            color: #101010;
                            box-shadow: 0 3px 10px rgba(0, 0, 0, 0.2), inset 0 -3px 0 rgba(0, 0, 0, 0.32);
                        }

                        .button-label:active {
                            transform: translateY(2px);
                            box-shadow: 0 3px 10px rgba(0, 0, 0, 0.2), inset 0px -1px 0 rgba(0, 0, 0, 0.22);
                        }

                        @media (max-width: 40em) {
                            .button-label {
                                padding: 0em 1em 3px;
                                margin: 0.25em;
                            }
                        }

                        .done-button:checked + .button-label {
                            background: #2ECC71;
                            color: #efefef;
                        }

                        .done-button:checked + .button-label:hover {
                            background: #29b765;
                            color: #e2e2e2;
                        }

                        .same-button:checked + .button-label {
                            background: #ff7500;
                            color: #efefef;
                        }

                        .same-button:checked + .button-label:hover {
                            background: #ff7500;
                            color: #e2e2e2;
                        }

                        .fail-button:checked + .button-label {
                            background: #cc2e2e;
                            color: #efefef;
                        }

                        .fail-button:checked + .button-label:hover {
                            background: #b72929;
                            color: #e2e2e2;
                        }

                        .hidden {
                            display: none;
                        }
                    </style>
                    <p>Result</p>
                    <div class="button-wrap">
                        <form:radiobutton class="hidden radio-label done-button" required="true"
                                          onclick="$('#btn-${status.index}').hide();"
                                          path="polishList[${status.index}].result" id="done-button${status.index}"
                                          value="DONE"/>
                        <form:label class="button-label" for="done-button${status.index}"
                                    path="polishList[${status.index}].result">
                            <h5>DONE</h5>
                        </form:label>
                        <form:radiobutton class="hidden radio-label same-button"
                                          onclick="$('#btn-${status.index}').hide();"
                                          path="polishList[${status.index}].result" id="same-button${status.index}"
                                          value="SAME"/>
                        <form:label class="button-label" for="same-button${status.index}"
                                    path="polishList[${status.index}].result">
                            <h5>SAME</h5>
                        </form:label>
                        <form:radiobutton class="hidden radio-label fail-button"
                                          onclick="$('#btn-${status.index}').show();"
                                          path="polishList[${status.index}].result" id="fail-button${status.index}"
                                          value="FAIL" required="true"/>
                        <form:label class="button-label" for="fail-button${status.index}"
                                    path="polishList[${status.index}].result">
                            <h5>FAIL</h5>
                        </form:label>
                    </div>
                    <hr>
                    <div class="button-wrap" id="status${status.index}">
                        <div class="container">
                            <div class="button-wrap" id="btn-${status.index}" style="display: none">
                                <p>Send to</p>
                                <input class="hidden radio-label done-button" type="radio" name="send_to${status.index}"
                                       id="fixing-button${status.index}" value="FIXING"
                                       onclick="$('#issueModal${status.index}').modal('show');"/>
                                <label class="button-label" for="fixing-button${status.index}">
                                    <h5>FIXING</h5>
                                </label>
                                <input class="hidden radio-label same-button" type="radio" name="send_to${status.index}"
                                       id="techlab-button${status.index}" value="TECHLAB"
                                       onclick="$('#issueModal${status.index}').modal('show');"/>
                                <label class="button-label" for="techlab-button${status.index}">
                                    <h5>TECHLAB</h5>
                                </label>
                                <input class="hidden radio-label fail-button" type="radio" name="send_to${status.index}"
                                       id="scraps-button${status.index}" value="SCRAPS"
                                       onclick="$('#issueModal${status.index}').modal('show');"/>
                                <label class="button-label" for="scraps-button${status.index}">
                                    <h5>SCRAPS</h5>
                                </label>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <c:if test="${status.index == 3}">
                </div>
                <div class="row">
            </c:if>

            <script>
                array${status.index} = [];
                array${status.index}.push("${polish.imei}");
            </script>

            <div class="modal fade" id="issueModal${status.index}" tabindex="-1"
                 aria-labelledby="issueModalLabel${status.index}" aria-hidden="true">
                <div class="modal-dialog modal-xl">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="issueModalLabel${status.index}">Issue</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-3">
                                    <c:set var="divClose"/>
                                    <c:forEach items="${issues}" var="issue">
                                    <div class="form-check">
                                        <label for="${issue.tl}" class="form-check-label"
                                               data-bs-toggle="tooltip" data-bs-placement="right"
                                               data-bs-title="${issue.label}">
                                            <input type="checkbox" onclick="toArray('${polish.imei}', '${issue.tl}')"
                                                   class="form-check-input"
                                                   name="${issue.tl}"/>
                                                ${issue.tl}</label>
                                    </div>
                                    <c:set value="${divClose + 1}" var="divClose"/>
                                    <c:if test="${divClose == 14}">
                                    <c:set value="${divClose = 0}" var="divClose"/>
                                </div>
                                <div class="col-3">
                                    </c:if>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" id="close" data-bs-dismiss="modal">Close
                            </button>
                            <button type="button" class="btn btn-primary">Save changes</button>
                        </div>
                    </div>
                </div>
            </div>
            <input type="hidden" name="tlList${status.index}" id="tlList${status.index}" value="">
        </c:forEach>
        </div>
    </form:form>
</div>


<script>
    function toArray(imei, tl) {
        if (array0.includes(imei)) {
            if (array0.includes(tl)) {
                let index = array0.indexOf(tl);
                array0.splice(index, 1);
                $("#tlList0").val(array0);
            } else {
                array0.push(tl);
                $("#tlList0").val(array0);
            }
        } else if (array1.includes(imei)) {
            if (array1.includes(tl)) {
                let index = array1.indexOf(tl);
                array1.splice(index, 1);
                $("#tlList1").val(array1);
            } else {
                array1.push(tl);
                $("#tlList1").val(array1);
            }
        } else if (array2.includes(imei)) {
            if (array2.includes(tl)) {
                let index = array2.indexOf(tl);
                array2.splice(index, 1);
                $("#tlList2").val(array2);
            } else {
                array2.push(tl);
                $("#tlList2").val(array2);
            }
        } else if (array3.includes(imei)) {
            if (array3.includes(tl)) {
                let index = array3.indexOf(tl);
                array3.splice(index, 1);
                $("#tlList3").val(array3);
            } else {
                array3.push(tl);
                $("#tlList3").val(array3);
            }
        } else if (array4.includes(imei)) {
            if (array4.includes(tl)) {
                let index = array4.indexOf(tl);
                array4.splice(index, 1);
                $("#tlList4").val(array4);
            } else {
                array4.push(tl);
                $("#tlList4").val(array4);
            }
        } else if (array5.includes(imei)) {
            if (array5.includes(tl)) {
                let index = array5.indexOf(tl);
                array5.splice(index, 1);
                $("#tlList5").val(array5);
            } else {
                array5.push(tl);
                $("#tlList5").val(array5);
            }
        } else if (array6.includes(imei)) {
            if (array6.includes(tl)) {
                let index = array6.indexOf(tl);
                array6.splice(index, 1);
                $("#tlList6").val(array6);
            } else {
                array6.push(tl);
                $("#tlList6").val(array6);
            }
        } else if (array7.includes(imei)) {
            if (array7.includes(tl)) {
                let index = array7.indexOf(tl);
                array7.splice(index, 1);
                $("#tlList7").val(array7);
            } else {
                array7.push(tl);
                $("#tlList7").val(array7);
            }
        }
    }
    $(".toast").show();
</script>
</body>
</html>

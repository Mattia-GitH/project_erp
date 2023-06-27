<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<head>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>


    <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet">
    <style>
        .container, .container-lg, .container-md, .container-sm, .container-xl, .container-xxl {
            max-width: 100%;
        }

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

        li#testMenu {
            position: inherit;
        }

        ul#dropTestMenu {
            position: inherit;
        }

        li {
            max-height: 150px;
        }

        input#hour, input#minute, input#second {
            max-width: 25px;
            border: transparent;
        }

        span#msecond {
            color: transparent;
        }

        label.form-check-label {
            max-width: 56px;
            width: 100%;
        }


        .iOS {
            height: 60px;
            border: none;
            overflow: hidden;
        }

        .iOS::-moz-focus-inner {
            border: 0;
        }

        .iOS:focus {
            outline: none;
        }

        .iOS option {
            width: 130px;
            font-size: 1.2em;
            padding: 10px 0;
            text-align: center;
            margin-right: 20px;
            display: inline-block;
            cursor: pointer;
            border: #004750 solid 1px;
            border-radius: 5px;
            color: #004750;
        }
    </style>
    <title>Testing</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<script src="${pageContext.request.contextPath}/jQuery.tabable-required-focus.js"></script>
<script>
    $(document).ready(function () {
        $.tabableRequiredFieldsFocus();
    });
    $(document).ready(function () {
        $("#start").trigger('click');
    });

    function issueList(imei, issue,) {
        this.imei = imei;
        this.issue = issue;
    }

    function createCom() {
        let issue = document.getElementById("issue").value;
        let imei = document.getElementById("imei").value;
        let comment = document.getElementById("comment").value;

        console.log("HERE");

        $.ajax({
            url: "${pageContext.request.contextPath}/createComment/" + imei + "/" + issue,
            data: {
                comments: comment
            }
        });
        $("#tlModal"  + imei).modal("show");
        $("#comCreated").show();
    }
</script>

<div class="container">
    <div class="toast-container p-3 top-0 start-50 translate-middle-x">

        <div id="processing" class="toast" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="toast-header">
                <div class="spinner-grow text-primary"></div>
                <strong class="me-auto">&nbsp;&nbsp;Processing ...</strong>
                <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"
                        onclick="$('#processing').hide()"></button>
            </div>
        </div>
        <div class="toast align-items-center text-bg-primary border-0" id="comCreated" role="alert" data-bs-autohide="true" aria-live="assertive" aria-atomic="true">
            <div class="d-flex">
                <div class="toast-body">
                    Comment created
                </div>
                <button type="button" onclick="$('#comCreated').hide()" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
            </div>
        </div>
    </div>
    <c:if test="${msg1 != null || msg2 != null || msg3 != null || msg4 != null}">
        <div class="row justify-content-md-center">
                ${msg1} ${msg2} ${msg3} ${msg4}
        </div>
    </c:if>

    <c:set value="${status}" var="cStatus"/>

    <form:form method="post" modelAttribute="test" action="${pageContext.request.contextPath}/status/${status}">
        <div class="row">
            <input type="hidden" name="actual_status" value="${actual_status}"/>
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
        <div class="row justify-content-md-center" style="margin-top: 30px">

            <c:forEach items="${multiTest}" var="test" varStatus="status">

                <div class="col-3 border-end">
                    <div class="form-group">
                        <form:label path="testList[${status.index}].imei">imei:
                            <form:input path="testList[${status.index}].imei" readonly="true"
                                        value="${test.imei}"></form:input></form:label>
                        <br>
                        <form:label path="testList[${status.index}].iOS">iOS:</form:label>
                        <br>
                        <form:select class="iOS" path="testList[${status.index}].iOS" required="true" multiple="true">
                            <form:option onclick="$('#confirmation').css('display', 'initial')"
                                         value="Updated">Updated</form:option>
                            <form:option onclick="$('#confirmation').css('display', 'initial')"
                                         value="Old Version">Old Version</form:option>
                        </form:select>
                        <form:hidden path="testList[${status.index}].operator" value="${test.operator}"/>
                    </div>
                    <button type="button" class="btn btn-outline-danger" data-bs-toggle="modal"
                            style="margin-top: 10px; width: 280px"
                            data-bs-target="#tlModal${test.imei}">
                        Add TL
                    </button>
                    <br>
                    <br>
                    <br>
                    <label for="soh${status.index}" class="form-label">SoH:</label>
                    <br>
                    <input type="range" style="max-width:180px" name="soh${status.index}" class="form-range" value="0" min="0" max="100" step="5" id="soh${status.index}"  oninput="this.nextElementSibling.value = this.value">
                    <output></output>
                    <br>
                    <label for="cycles${status.index}" class="form-label">Cycles</label>
                    <br>
                    <input type="range"  style="max-width:180px" name="cycles${status.index}" class="form-range" value="0" min="0" max="1000" step="100" id="cycles${status.index}"  oninput="this.nextElementSibling.value = this.value">
                    <output></output>
                </div>

                <div class="modal fade" id="tlModal${test.imei}" tabindex="-1" aria-labelledby="tlModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog modal-xl">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="tlModalLabel">TL List</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <div class="col-3">
                                        <c:set var="divClose"/>
                                        <c:forEach items="${issueList}" var="issue">
                                        <div class="form-check">
                                            <form:label for="${test.imei}${issue.tl}" class="form-check-label"
                                                        path="testList[${status.index}].${issue.tl}"
                                                        data-bs-toggle="tooltip" data-bs-placement="right"
                                                        data-bs-title="${issue.label}">
                                                <form:checkbox id="${test.imei}${issue.tl}"
                                                               onchange="addReport('${test.imei}','${issue.tl}')"
                                                               class="form-check-input"
                                                               path="testList[${status.index}].${issue.tl}"/>
                                                ${issue.tl}</form:label>
                                            <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal"
                                                    data-bs-target="#commentModal"
                                                    onclick="setCommentValue('${test.imei}','${issue.tl}')">
                                                Comment
                                            </button>
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
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div style="text-align: center;">
            <button class="btn btn-outline-primary"
                    style="width: 100%; margin-top: 135px; max-width: 600px; display: none" id="confirmation"
                    data-bs-toggle="modal" data-bs-target="#confirmInsertTL" type="button">Confirm
            </button>
        </div>
        <div class="modal fade" id="confirmInsertTL" tabindex="-1" aria-labelledby="confirmInsertTlLabel"
             aria-hidden="true">
            <div class="modal-dialog modal-xl">
                <div class="modal-content">
                    <div class="modal-header">
                        <h2 class="modal-title" id="confirmInsertTlLabel">Do you have already inserted TL? <br> Did you
                            put TL2 where it was needed?</h2>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <button type="button" class="btn btn-danger" style="width: 50%; height:100px"
                                    data-bs-dismiss="modal">NO
                            </button>
                            <button type="submit" class="btn btn-outline-success" style="width: 50%; height:100px"
                                    onclick="$('#submit').css('display', 'block'); $('#confirmation').css('display', 'none');"
                                    data-bs-dismiss="modal">YES
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </form:form>
</div>

<div class="modal fade" id="commentModal" tabindex="-1" aria-labelledby="commentModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="commentModalLabel">Comment</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"
                        aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <input type="hidden" id="issue">
                <input type="hidden" id="status" value="${status}">
                <input type="hidden" id="imei">
                <input type="text" id="comment" class="form-control">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-outline-success" onclick="createCom();" data-bs-dismiss="modal">
                    Save
                </button>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/clock.js"></script>
<script>
    // Initialize tooltips
    let tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
    let tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
        return new bootstrap.Tooltip(tooltipTriggerEl)
    })


    let tlList = [];
    let list = document.createElement('ul');

    function addReport(imei, tl) {
        if (${status == "TESTING"}) {
            $.ajax({url: "${pageContext.request.contextPath}/reportFixing/" + imei + "/" + tl});
        }

        Array.prototype.getIndexOf = function (imei, tl) {

            let arr = this;

            for (let i = 0; i < arr.length; i++) {
                if (arr[i].imei === imei && arr[i].issue === tl) {
                    return i;
                }
            }
            return -1;
        }

        if (!tlList.some(item => item.imei === imei && item.issue === tl)) {
            tlList.push(new issueList(imei, tl))
        } else {
            tlList.splice(tlList.getIndexOf(imei, tl), 1)
        }


        filterImei(imei);
    }

    let string = "";

    function filterImei(imei) {
        for (let x = 0; x < tlList.length; x++) {
            if (tlList.filter(i => i.imei === imei)[x] !== undefined) {
                string = string + "<br>" + tlList.filter(i => i.imei === imei)[x].issue;
            }
        }
        document.getElementById('listTl' + imei).innerHTML = string;
        string = "";
    }

    function setCommentValue(imei, issue) {
        document.getElementById("issue").value = issue;
        document.getElementById("imei").value = imei;

        document.getElementById("issue").text = issue;
        document.getElementById("imei").text = imei;
    }
</script>
</body>
</html>

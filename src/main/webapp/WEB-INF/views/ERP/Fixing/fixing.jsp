<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
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

        .timer {
            border-color: transparent;
            background-color: transparent;
            max-width: 50px;
        }

        div#timer {
            background-color: rgb(0 0 0 / 5%);
            border-radius: 10px;
            max-width: 350px;
            height: 50px;
            margin: 10px;
        }

        span.select2-selection.select2-selection--single {
            height: 40px;
        }

        .select2.select2-container.select2-container--default {
            width: 70% !important;
        }

        /*

        better timer: https://jsfiddle.net/Mottie/sML8b/

         */

        .container {
            margin-left: 240px !important;
        }

        div#commentsBox {
            border: 2px solid #D3D3D3;
            border-radius: 20px;
        }

        .alert-UNREPAIR {
            --bs-alert-color: var(--bs-danger-text);
            --bs-alert-bg: var(--bs-danger-bg-subtle);
            --bs-alert-border-color: var(--bs-danger-border-subtle);
            --bs-alert-link-color: var(--bs-danger-text);
        }

        .alert-LINE {
            --bs-alert-color: var(--bs-light-text);
            --bs-alert-bg: var(--bs-light-bg-subtle);
            --bs-alert-border-color: var(--bs-light-border-subtle);
            --bs-alert-link-color: var(--bs-light-text);
        }

        .alert-TECHLAB {
            --bs-alert-color: var(--bs-warning-text);
            --bs-alert-bg: var(--bs-warning-bg-subtle);
            --bs-alert-border-color: var(--bs-warning-border-subtle);
            --bs-alert-link-color: var(--bs-warning-text);
        }

        input#hour, input#minute, input#second {
            max-width: 25px;
            border: transparent;
        }

        span#msecond {
            color: transparent;
        }

        .tl {
            margin-right: 300px;
        }

        .tlClass {
            width: 100% !important;
            max-width: 100% !important;
        }
    </style>
    <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>${status}</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<link href="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/css/select2.min.css" rel="stylesheet"/>
<script src="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/js/select2.min.js"></script>
<script>
    $(document).ready(function () {
        $(".selection").select2();
    });
    $(document).ready(function () {
        $("#start").trigger('click');
    });
</script>
<script src="${pageContext.request.contextPath}/JS/addIssue.js"></script>

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
    </div>
    <h1>${status}</h1>
    <form:form action="${pageContext.request.contextPath}/fixed/${status}" modelAttribute="toRepair">
    <div class="row text-center">


        <script>
            let hr = 0;
            let min = 0;
            let sec = 0;
            let count = 0;

            function sendCode() {
                let codeInterrupt = document.getElementById("code").value;
                if (codeInterrupt === "UGCwdFJW") {
                    $.ajax({
                        url: "${pageContext.request.contextPath}/interrupt_rep/FIXING/${info.imei}",
                        data: {
                            code: codeInterrupt,
                        }
                    });
                    window.location.href = "${pageContext.request.contextPath}/fixing";
                } else {
                    alert("Wrong code");
                }
            }

            function notNeed(index) {

                if ($("#select" + index).prop('disabled')) {
                    $("#select" + index).select2("enable");

                    $("#repair" + index).attr('src', '${pageContext.request.contextPath}/images/repair.jpg');

                    console.log("enabled");

                } else {
                    document.getElementById("notNeed" + index).value = "Don't needed";
                    document.getElementById("notNeed" + index).text = "Don't needed";
                    document.getElementById("notNeed" + index).selected = "true";
                    $("#select" + index).val("Don't needed").trigger("change");

                    $("#select" + index).select2("enable", false);

                    $("#repair" + index).attr('src', '${pageContext.request.contextPath}/images/repairGreen.jpg');

                    console.log("disabled");
                }

            }

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

            function sendStatus() {
                if (document.getElementById("send_to").value === "TECHLAB") {
                    $('#sendToModal').modal('show');
                }
            }

            function toTechlab() {
                $("#send_to").val("TESTING").change();

                let codeSendTo = document.getElementById("codeSendTo").value;
                if (codeSendTo === "UGCwdFJW") {
                    $('#sendToModal').modal('hide');
                    $('#techlabModal').modal('show');
                    $("#send_to").val("TECHLAB").change();
                } else {
                    alert("Wrong code");
                }
            }

            function closeSend() {
                $("#send_to").val("TESTING").change();
            }

        </script>

        <div>
            <form:input path="hours" id="hour" readonly="true"></form:input>
            <span type="text">:</span>
            <form:input path="mins" id="minute" readonly="true"></form:input>
            <span type="text">:</span>
            <form:input path="seconds" id="second" readonly="true"></form:input>
            <span id="msecond" class="time">00</span>
        </div>

        <div class="buttons">
            <button type="button" class="btn btn-outline-primary" id="start">Start</button>
            <button type="button" class="btn btn-danger" id="stop">Pause</button>

            <button type="button" class="btn btn-light" data-bs-toggle="modal" data-bs-target="#interruptModal">
                interrupt
            </button>

            <div class="modal fade" id="interruptModal" tabindex="-1" aria-labelledby="interruptModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="interruptModalLabel">Insert code</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <label>Code</label>
                            <input class="form-label" id="code" type="password" name="code"/>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="button" onclick="sendCode()" class="btn btn-primary">Save changes</button>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <c:set var="actual_status" value="${status}"/>
        <c:set var="imei" value="${info.imei}"/>
    </div>
    <div class="row justify-content-md-center">
        <div class="col-3"><img style="max-height:300px; max-width:350px"
                                src="${pageContext.request.contextPath}/images/${fn:replace(info.model,' ', '')}${info.color}.jpg">
        </div>
        <div class="col-2">
            <p>Info</p>
            <p>imei: ${info.imei}</p>
            <p>Model: ${info.model}</p>
            <p>GB: ${info.gb}</p>
            <p>Color: ${info.color}</p>
            <p>SKU: ${info.sku}</p>
            <p>Supplier: ${info.prod_name}</p>
            <p>N&deg;order: ${info.order_number}</p>
        </div>
        <div class="col-4">
            <h5 class="text-center">Cycles: ${battery.cycles} / Soh: ${battery.soh}%</h5>

            <sec:authentication property="name" var="operator"/>

            <div id="tlIssue">
                <c:forEach items="${toRepair.reparations}" var="repair" varStatus="status">
                    <form:hidden path="reparations[${status.index}].imei" value="${info.imei}"/>
                    <form:hidden path="reparations[${status.index}].operator" value="${operator}"/>
                    <form:hidden class="form-control" path="reparations[${status.index}].tl" value="${repair.tl}"/>
                    <div class="col-auto">
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="tl"><h5>${repair.tl}</h5></div>
                            </div>

                            <form:select style="max-width:280px" id="select${status.index}"
                                         class="form-control selection"
                                         path="reparations[${status.index}].component" required="true">
                                <form:option id="notNeed${status.index}" value=""></form:option>
                                <c:forEach items="${componentSKU}" var="sku">
                                    <form:option value="${sku.sku}">${sku.sku}</form:option>
                                </c:forEach>
                            </form:select>

                            <img id="repair${status.index}"
                                 src="${pageContext.request.contextPath}/images/repair.jpg"
                                 style="height:30px; padding-left:10px; padding-top: 10px"
                                 onclick="notNeed(${status.index})">
                        </div>
                        <hr>
                    </div>
                    <c:set var="index" value="${status.index}"/>
                </c:forEach>
            </div>
            <div id="addedProblem">

            </div>


            <form:select onchange="sendStatus()" class="form-control" path="send_to" required="true">
                <form:option value="TESTING">TESTING</form:option>
                <form:option value="TECHLAB">TECHLAB</form:option>
            </form:select>

            <div class="modal fade" id="sendToModal" tabindex="-1" aria-labelledby="sendToModalLabel"
                 data-bs-backdrop="static" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="sendToModalLabel">Insert code</h1>
                            <button type="button" onclick="closeSend()" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <label>Code</label>
                            <input class="form-label" id="codeSendTo" type="password" name="code"/>
                        </div>
                        <div class="modal-footer">
                            <button type="button" onclick="closeSend()" class="btn btn-secondary"
                                    data-bs-dismiss="modal">Close
                            </button>
                            <button type="button" onclick="toTechlab()" class="btn btn-primary">Save changes
                            </button>
                        </div>
                    </div>
                </div>
            </div>


            <button style="margin-top: 30px" type="button" class="btn btn-primary" data-bs-toggle="modal"
                    data-bs-target="#issueModal">
                Add Issue
            </button>

            <div class="modal fade" id="issueModal" tabindex="-1" aria-labelledby="issueModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="issueModalLabel">Insert Code</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <label>Code</label>
                            <input class="form-label" id="codeIssue" type="password" name="codeIssue"/>
                        </div>
                        <div class="modal-footer">
                            <button type="button" id="closeIssue" class="btn btn-secondary" data-bs-dismiss="modal">
                                Close
                            </button>
                            <button type="button" onclick="addIssue()" class="btn btn-primary">Save changes</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-3" id="commentsBox">
            <h6>Comments</h6>

            <c:forEach items="${comments}" var="comment">
                <c:forEach items="${issueList}" var="issue">
                    <c:if test="${issue.tl == comment.id_issue}">
                        <div class="alert alert-${issue.department}" role="alert">
                                ${comment.id_issue} - ${comment.operator}:<br>${comment.comment}
                        </div>
                    </c:if>
                </c:forEach>
            </c:forEach>
        </div>
        <input style="float:right; margin-top:30px" type="submit" id="submit" onclick="$('#processing').show()"
               class="btn btn-outline-primary" value="Save"/>

    </div>


</div>
</form:form>
</div>


<div class="modal fade" id="techlabModal" tabindex="-1" aria-labelledby="techlabModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="techlabModalLabel">Modal title</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form:form modelAttribute="sendTechlab"
                           action="${pageContext.request.contextPath}/fixing${status}">
                    <div class="row">
                        <div class="col-3">
                            <c:set var="divClose"/>
                            <c:forEach items="${issueList}" var="issue">
                            <form:hidden path="imei" value="${info.imei}" />
                            <div class="form-check">
                                <form:label for="${info.imei}${issue.tl}" class="form-check-label"
                                            path="${issue.tl}"
                                            data-bs-toggle="tooltip" data-bs-placement="right"
                                            data-bs-title="${issue.label}">
                                    <form:checkbox id="${info.imei}${issue.tl}"
                                                   class="form-check-input"
                                                   path="${issue.tl}"/>
                                    ${issue.tl}</form:label>
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
                </form:form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="submit" onclick="$('#sendTechlab').submit()" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>


<div style="display: none">
    <select id="tl">
        <c:forEach items="${issueList}" var="issue">
            <option value="${issue.tl}">${issue.tl}</option>
        </c:forEach>
    </select>
    <select id="componentSku">
        <c:forEach items="${componentSKU}" var="sku">
            <option value="${sku.sku}">${sku.sku}</option>
        </c:forEach>
    </select>
</div>



<script>
    let index = '${index}';
    let operator = "${operator}";
    let imei = ${imei};

    function report(index){
        let tlToPost = document.getElementById("reparations" + index + ".tl").value
        let imeiToPost = document.getElementById("reparations" + index + ".imei").value

        $.ajax({url: "${pageContext.request.contextPath}/reportFixing/" + imeiToPost + "/" + tlToPost});
    }
</script>
<script src="${pageContext.request.contextPath}/clock.js"></script>
</body>
</html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
    <title>Create New Status</title>
    <style>
        input#hour, input#minute, input#second {
            max-width: 25px;
            border: transparent;
        }

        span#msecond {
            color: transparent;
        }

        input#submit {
            width: 100%;
            margin-top: 50px;
        }
    </style>


</head>
<body>
<jsp:include page="../header.jsp"/>
<script>
    $(document).ready(function () {
        $("#start").trigger('click');
    });
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
    </div>
    <form:form method="post" modelAttribute="status" action="${pageContext.request.contextPath}/save/${actual_status}">
        <div class="row">
            <div class="col-12">
                <script>
                    let hr = ${hours};
                    let min = ${mins};
                    let sec = ${seconds};
                    let count = 0;

                    let btn0 = false;
                    let btn1 = false;
                    let btn2 = false;
                    let btn3 = false;
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
            <c:forEach items="${statuses}" var="status" varStatus="st">
                <div class="col-3">
                    <div class="form-group">
                        <form:hidden path="statusList[${st.index}].id" value="${status.id}"
                                     readonly="true"></form:hidden>
                        <form:label path="statusList[${st.index}].imei">imei:</form:label>
                        <form:input path="statusList[${st.index}].imei" value="${status.imei}"
                                    readonly="true"></form:input>
                    </div>
                    Hint:<p id="hint${st.index}"></p>
                    <div class="form-group">
                        <form:label path="statusList[${st.index}].send_to">Send to: </form:label>
                        <form:select id="status${st.index}" class="selectpicker form-control"
                                     path="statusList[${st.index}].send_to" required="true">
                            <form:option id="selected${st.index}" value=""></form:option>
                            <c:forEach items="${phases}" var="phase">
                                <c:if test="${phase.phase == 'POLISH' || phase.phase == 'FIXING' || phase.phase == 'TECHLAB' || phase.phase == 'PACKING' || phase.phase == 'RMA' || phase.phase == 'SCRAPS' }">
                                    <form:option value="${phase.phase}">${phase.phase}</form:option>
                                </c:if>
                            </c:forEach>
                        </form:select>
                        <div style="text-align: center;">
                            <button id="confirm${st.index}" type="button" style="margin-top: 30px" class="btn btn-danger"
                                    onclick="confirmStatus(${st.index})">confirm
                            </button>
                        </div>
                    </div>
                    <div>
                        <c:forEach items="${test}" var="test">
                            <c:if test="${test.imei == status.imei}">
                                <script>
                                    if (${test.TL0 == true || test.TL1 == true || test.TL2 == true || test.TL4 == true ||
                    test.TL5 == true  || test.TL5A == true || test.TL5B == true || test.TL8P == true || test.TL9 == true || test.TL10 == true || test.TL10G == true
                     || test.TL11G == true  || test.TL13 == true || test.TL14 == true || test.TL14P == true || test.TL14B == true
                      || test.TL16 == true || test.TL18 == true }) {
                                        document.getElementById("hint${st.index}").innerText = "FIXING";
                                        document.getElementById("selected${st.index}").value = "FIXING";
                                        document.getElementById("selected${st.index}").text = "FIXING";
                                    }
                                    if (${test.TL19A == true || test.TL22 == true
                       || test.TL24 == true || test.TL26 == true || test.TL32 == true || test.TL36 == true || test.TL2T == true || test.TL8 == true || test.TL9T == true || test.TL10T == true || test.TL11 == true || test.TL12 == true || test.TL14A == true || test.TL14T == true ||
                        test.TL15 == true || test.TL17 == true || test.TL19 == true  || test.TL21 == true || test.TL22T == true || test.TL26T == true || test.TL27 == true || test.TL27T == true || test.TL28 == true || test.TL28T == true ||
                        test.TL29 == true || test.TL29A == true || test.TL29B == true || test.TL29C == true || test.TL30 == true || test.TL36T == true || test.TL38 == true ||
                        test.TL39 == true || test.TL42 == true || test.TL40 == true}) {
                                        document.getElementById("hint${st.index}").innerText = "TECHLAB";
                                        document.getElementById("selected${st.index}").value = "TECHLAB";
                                        document.getElementById("selected${st.index}").text = "TECHLAB";
                                    }
                                    if (${test.TL37 == true || test.TL41 == true || test.TL42A == true}) {
                                        document.getElementById("hint${st.index}").innerText = "SCRAPS";
                                        document.getElementById("selected${st.index}").value = "SCRAPS";
                                        document.getElementById("selected${st.index}").text = "SCRAPS";
                                    }
                                    if (${test.TL0 == false && test.TL1 == false && test.TL2 == false && test.TL4 == false &&
                    test.TL5 == false  && test.TL5A == false && test.TL5B == false && test.TL8P == false && test.TL9 == false && test.TL10 == false && test.TL10G == false
                     && test.TL11 == false && test.TL11G == false  && test.TL13 == false && test.TL14 == false && test.TL14P == false && test.TL14B == false
                      && test.TL16 == false && test.TL17 == false && test.TL18 == false && test.TL19 == false && test.TL19A == false && test.TL21 == false && test.TL22 == false
                       && test.TL24 == false && test.TL26 == false && test.TL32 == false && test.TL36 == false && test.TL40 == false && test.TL2T == false && test.TL8 == false && test.TL9T == false && test.TL10T == false && test.TL12 == false && test.TL14A == false && test.TL14T == false &&
                        test.TL15 == false && test.TL22T == false && test.TL26T == false && test.TL27 == false && test.TL27T == false && test.TL28 == false && test.TL28T == false &&
                        test.TL29 == false && test.TL29A == false && test.TL29B == false && test.TL29C == false && test.TL30 == false && test.TL36T == false && test.TL38 == false &&
                        test.TL39 == false && test.TL42 == false && test.TL37 == false && test.TL41 == false && test.TL42A == false}) {
                                        document.getElementById("hint${st.index}").innerText = "PACKING";
                                        document.getElementById("selected${st.index}").value = "PACKING";
                                        document.getElementById("selected${st.index}").text = "PACKING";
                                    }
                                </script>


                                <ul id="list${st.index}">
                                    <c:if test="${test.TL0 == true}">
                                        <li>TL0</li>
                                    </c:if>
                                    <c:if test="${test.TL1 == true}">
                                        <li>TL1</li>
                                    </c:if>
                                    <c:if test="${test.TL2 == true}">
                                        <li>TL2</li>
                                    </c:if>
                                    <c:if test="${test.TL2T == true}">
                                        <li>TL2T</li>
                                    </c:if>
                                    <c:if test="${test.TL4 == true}">
                                        <li>TL4</li>
                                    </c:if>
                                    <c:if test="${test.TL5 == true}">
                                        <li>TL5</li>
                                    </c:if>
                                    <c:if test="${test.TL5A == true}">
                                        <li>TL5A</li>
                                    </c:if>
                                    <c:if test="${test.TL5B == true}">
                                        <li>TL5B</li>
                                    </c:if>
                                    <c:if test="${test.TL8 == true}">
                                        <li>TL8</li>
                                    </c:if>
                                    <c:if test="${test.TL8P == true}">
                                        <li>TL8P</li>
                                    </c:if>
                                    <c:if test="${test.TL9 == true}">
                                        <li>TL9</li>
                                    </c:if>
                                    <c:if test="${test.TL9T == true}">
                                        <li>TL9T</li>
                                    </c:if>
                                    <c:if test="${test.TL10 == true}">
                                        <li>TL10</li>
                                    </c:if>
                                    <c:if test="${test.TL10G == true}">
                                        <li>TL10G</li>
                                    </c:if>
                                    <c:if test="${test.TL10T == true}">
                                        <li>TL10T</li>
                                    </c:if>
                                    <c:if test="${test.TL11 == true}">
                                        <li>TL11</li>
                                    </c:if>
                                    <c:if test="${test.TL11G == true}">
                                        <li>TL11G</li>
                                    </c:if>
                                    <c:if test="${test.TL12 == true}">
                                        <li>TL12</li>
                                    </c:if>
                                    <c:if test="${test.TL13 == true}">
                                        <li>TL13</li>
                                    </c:if>
                                    <c:if test="${test.TL14 == true}">
                                        <li>TL14</li>
                                    </c:if>
                                    <c:if test="${test.TL14P == true}">
                                        <li>TL14P</li>
                                    </c:if>
                                    <c:if test="${test.TL14A == true}">
                                        <li>TL14A</li>
                                    </c:if>
                                    <c:if test="${test.TL14B == true}">
                                        <li>TL14B</li>
                                    </c:if>
                                    <c:if test="${test.TL14T == true}">
                                        <li>TL14T</li>
                                    </c:if>
                                    <c:if test="${test.TL15 == true}">
                                        <li>TL15</li>
                                    </c:if>
                                    <c:if test="${test.TL16 == true}">
                                        <li>TL16</li>
                                    </c:if>
                                    <c:if test="${test.TL17 == true}">
                                        <li>TL17</li>
                                    </c:if>
                                    <c:if test="${test.TL18 == true}">
                                        <li>TL18</li>
                                    </c:if>
                                    <c:if test="${test.TL19 == true}">
                                        <li>TL19</li>
                                    </c:if>
                                    <c:if test="${test.TL19A == true}">
                                        <li>TL19A</li>
                                    </c:if>
                                    <c:if test="${test.TL21 == true}">
                                        <li>TL21</li>
                                    </c:if>
                                    <c:if test="${test.TL22 == true}">
                                        <li>TL22</li>
                                    </c:if>
                                    <c:if test="${test.TL22T == true}">
                                        <li>TL22T</li>
                                    </c:if>
                                    <c:if test="${test.TL24 == true}">
                                        <li>TL24</li>
                                    </c:if>
                                    <c:if test="${test.TL26 == true}">
                                        <li>TL26</li>
                                    </c:if>
                                    <c:if test="${test.TL26T == true}">
                                        <li>TL26T</li>
                                    </c:if>
                                    <c:if test="${test.TL27 == true}">
                                        <li>TL27</li>
                                    </c:if>
                                    <c:if test="${test.TL27T == true}">
                                        <li>TL27T</li>
                                    </c:if>
                                    <c:if test="${test.TL28 == true}">
                                        <li>TL28</li>
                                    </c:if>
                                    <c:if test="${test.TL28T == true}">
                                        <li>TL28T</li>
                                    </c:if>
                                    <c:if test="${test.TL29 == true}">
                                        <li>TL29</li>
                                    </c:if>
                                    <c:if test="${test.TL29A == true}">
                                        <li>TL29A</li>
                                    </c:if>
                                    <c:if test="${test.TL29B == true}">
                                        <li>TL29B</li>
                                    </c:if>
                                    <c:if test="${test.TL29C == true}">
                                        <li>TL29C</li>
                                    </c:if>
                                    <c:if test="${test.TL30 == true}">
                                        <li>TL30</li>
                                    </c:if>
                                    <c:if test="${test.TL32 == true}">
                                        <li>TL32</li>
                                    </c:if>
                                    <c:if test="${test.TL36 == true}">
                                        <li>TL36</li>
                                    </c:if>
                                    <c:if test="${test.TL36T == true}">
                                        <li>TL36T</li>
                                    </c:if>
                                    <c:if test="${test.TL37 == true}">
                                        <li>TL37</li>
                                    </c:if>
                                    <c:if test="${test.TL38 == true}">
                                        <li>TL38</li>
                                    </c:if>
                                    <c:if test="${test.TL39 == true}">
                                        <li>TL39</li>
                                    </c:if>
                                    <c:if test="${test.TL40 == true}">
                                        <li>TL40</li>
                                    </c:if>
                                    <c:if test="${test.TL41 == true}">
                                        <li>TL41</li>
                                    </c:if>
                                    <c:if test="${test.TL42 == true}">
                                        <li>TL42</li>
                                    </c:if>
                                    <c:if test="${test.TL42A == true}">
                                        <li>TL42A</li>
                                    </c:if>
                                </ul>
                            </c:if>
                        </c:forEach>
                    </div>

                </div>
                <script>
                    let ar = [];
                    ar = document.getElementById("list${st.index}").getElementsByTagName("li");

                    if (ar.includes('<li>TL2</li>')) {
                        console.log("TL2");
                    }
                    if (ar.includes("TL5")) {
                        console.log("TL5");
                    }
                </script>
            </c:forEach>
        </div>
        <input type="submit" id="submit" style="display: none" onclick="$('#processing').show()"
               class="btn btn-outline-primary"/>
    </form:form>
</div>
<script>
    function confirmStatus(indBtn) {
        switch (indBtn) {
            case 0:
                if (btn0 === false) {
                    btn0 = true;
                    $('#status0').hide();
                    $("#confirm0").removeClass("btn-danger");
                    $("#confirm0").addClass("btn-success");
                } else if (btn0 === true) {
                    btn0 = false
                    $('#status0').show();
                    $("#confirm0").removeClass("btn-success");
                    $("#confirm0").addClass("btn-danger");
                }
                break;
            case 1:
                if (btn1 === false) {
                    btn1 = true;
                    $('#status1').hide();
                    $("#confirm1").removeClass("btn-danger");
                    $("#confirm1").addClass("btn-success");
                } else if (btn1 === true) {
                    btn1 = false
                    $('#status1').show();
                    $("#confirm1").removeClass("btn-success");
                    $("#confirm1").addClass("btn-danger");
                }
                break;
            case 2:
                if (btn2 === false) {
                    btn2 = true;
                    $('#status2').hide();
                    $("#confirm2").removeClass("btn-danger");
                    $("#confirm2").addClass("btn-success");
                } else if (btn2 === true) {
                    btn2 = false
                    $('#status2').show();
                    $("#confirm2").removeClass("btn-success");
                    $("#confirm2").addClass("btn-danger");
                }
                break;
            case 3:
                if (btn3 === false) {
                    btn3 = true;
                    $('#status3').hide();
                    $("#confirm3").removeClass("btn-danger");
                    $("#confirm3").addClass("btn-success");
                } else if (btn3 === true) {
                    btn3 = false
                    $('#status3').show();
                    $("#confirm3").removeClass("btn-success");
                    $("#confirm3").addClass("btn-danger");
                }
                break;
        }

        let size = ${statuses.size()};

        if (size < 4){
            btn3 = true;
        } if (size < 3){
            btn2 = true;
        } if (size < 2){
            btn1 = true;
        }

        if (btn0 === true && btn1 === true && btn2 === true && btn3 === true) {
            $('#submit').show()
        } else {
            $('#submit').hide()
        }
    }
</script>
<script src="${pageContext.request.contextPath}/clock.js"></script>
</body>
</html>

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
    <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet">

    <meta charset="UTF-8">
    <title>Packing</title>

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

        input#hour, input#minute, input#second {
            max-width: 25px;
            border: transparent;
        }

        span#msecond {
            color: transparent;
        }

        @import url(https://fonts.googleapis.com/css?family=Lato:300,400,900);
        .button-wrap {
            position: relative;
            text-align: center;
            top: 50%;
            margin-top: -2.5em;
        }

        @media (max-width: 40em) {
            .button-wrap {
                margin-top: -1.5em;
            }
        }

        .button-label {
            display: inline-block;
            padding: 10px 15px;
            margin: 0px 0px 30px 90px;
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

        .select-button:checked + .button-label {
            background: #2ECC71;
            color: #efefef;
        }

            .select-button:checked + .button-label:hover {
                background: #29b765;
                color: #e2e2e2;
            }

        .hidden {
            display: none;
        }

        #rev {
            color: white;
            background: red;
            font-size: 50px;
            font-weight: 1000;
            border-radius: 50px;
            border: solid red;
            max-width: 250px;
            margin-left: 45%;
            animation: color-change 1s infinite;
        }

        @keyframes color-change {
            0% {
                color: red;
                background: white;
                border: solid white;
            }
            50% {
                color: white;
                background: red;
                border: solid red;
            }
            100% {
                color: red;
                background: white;
                border: solid white;
            }
        }

    </style>
</head>
<body>
<jsp:include page="../header.jsp"/>
<script>
    $(document).ready(function () {
        $("#start").trigger('click');
    });

    function getTl(tlCheck) {
        let tl = tlCheck;

        $.ajax({url: "${pageContext.request.contextPath}/reportFixing/${info.imei}/" + tl});

    }

    function comment() {
        let tlIssue = document.getElementById("reportTl").value;

        document.getElementById("comment").href = "${pageContext.request.contextPath}/comment_create/PACKING/${info.imei}/" + tlIssue;
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
    </div>
    <form:form modelAttribute="pack" action="${pageContext.request.contextPath}/packed">
    <div class="row">
        <div class="col-12">
            <div style="margin-bottom: 50px">
                <script>
                    let hr = 0;
                    let min = 0;
                    let sec = 0;
                    let count = 0;
                </script>
                <div>
                    <input name="hours" onchange="setHour()" id="hour" readonly="true"></input>
                    <span type="text">:</span>
                    <input name="mins" onchange="setMinute()" id="minute" readonly="true"></input>
                    <span type="text">:</span>
                    <input name="seconds" onchange="setSecond()" id="second" readonly="true"></input>
                    <span id="msecond" class="time">00</span>
                </div>
                <div class="buttons">
                    <button type="button" class="btn btn-outline-primary" id="start">Start</button>
                    <button type="button" class="btn btn-danger" id="stop">Stop</button>
                </div>
            </div>
        </div>
    </div>
    <div class="row justify-content-md-center">
        <div style="text-align: center;">
            <c:if test="${rev == true}">
                <h2 id="rev">REV</h2>
            </c:if>
        </div>
    </div>
    <div class="row">
        <div class="col-3">
            <img style="max-height:300px; max-width:350px"
                 src="${pageContext.request.contextPath}/images/${fn:replace(info.model,' ', '')}${info.color}.jpg">
        </div>
        <div class="col-2">
            <p>Info</p>
            <p style="color: red;">Times in polish: ${timesPolish.size()}</p>
            <p>imei: ${info.imei}</p>
            <p>Model: ${info.model}</p>
            <p>GB: ${info.gb}</p>
            <p>Color: ${info.color}</p>
            <p>SKU: ${info.sku}</p>
            <p>Supplier: ${info.prod_name}</p>
            <p>N&deg;order: ${info.order_number}</p>
        </div>
        <div class="col-7">
            <button style="margin-bottom:30px" type="button" class="btn btn-primary" data-bs-toggle="modal"
                    data-bs-target="#issueModal">
                found issues
            </button>

            <div>
                <div class="button-wrap">
                    <h4 style="color: red">Select GB</h4>
                    <c:choose>
                        <c:when test="${info.model == 'iPhone SE' || info.model == 'iPhone SE3' || info.model == 'iPhone XR' || info.model == 'iPhone 11' || info.model == 'iPhone 12M' || info.model == 'iPhone 12'}">
                            <form:radiobutton class="hidden radio-label select-button" path="gb" id="64-button"
                                              value="64" required="true"/>
                            <form:label class="button-label" for="64-button" path="gb">
                                <h5>64</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="gb" id="128-button"
                                              value="128"/>
                            <form:label class="button-label" for="128-button" path="gb">
                                <h5>128</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="gb" id="256-button"
                                              value="256"/>
                            <form:label class="button-label" for="256-button" path="gb">
                                <h5>256</h5>
                            </form:label>
                        </c:when>
                        <c:when test="${info.model == 'iPhone SE3' || info.model == 'iPhone X' || info.model == 'iPhone XS' || info.model == 'iPhone XSM' || info.model == 'iPhone 11P' || info.model == 'iPhone 11PM'}">
                            <form:radiobutton class="hidden radio-label select-button" path="gb" id="64-button"
                                              value="64" required="true"/>
                            <form:label class="button-label" for="64-button" path="gb">
                                <h5>64</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="gb" id="256-button"
                                              value="256"/>
                            <form:label class="button-label" for="256-button" path="gb">
                                <h5>256</h5>
                            </form:label>
                        </c:when>
                        <c:when test="${info.model == 'iPhone 12P' || info.model == 'iPhone 12PM' || info.model == 'iPhone 13' || info.model == 'iPhone 13M' }">
                            <form:radiobutton class="hidden radio-label select-button" path="gb" id="128-button"
                                              value="128"/>
                            <form:label class="button-label" for="128-button" path="gb">
                                <h5>128</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="gb" id="256-button"
                                              value="256"/>
                            <form:label class="button-label" for="256-button" path="gb">
                                <h5>256</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="gb" id="512-button"
                                              value="512" required="true"/>
                            <form:label class="button-label" for="512-button" path="gb">
                                <h5>512</h5>
                            </form:label>
                        </c:when>
                    </c:choose>
                </div>
                <form:hidden path="imei" value="${info.imei}"/>
                <hr>
                <div class="button-wrap">
                    <h4 style="color: red">Select Color</h4>
                    <c:choose>
                        <c:when test="${info.model == 'iPhone SE' || info.model == 'iPhone SE3'}">
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Red-button"
                                              value="Red" required="true"/>
                            <form:label class="button-label" for="Red-button" path="color">
                                <h5>Red</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Black-button"
                                              value="Black"/>
                            <form:label class="button-label" for="Black-button" path="color">
                                <h5>Black</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="White-button"
                                              value="White"/>
                            <form:label class="button-label" for="White-button" path="color">
                                <h5>White</h5>
                            </form:label>
                        </c:when>
                        <c:when test="${info.model == 'iPhone X'}">
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Silver-button"
                                              value="Silver" required="true"/>
                            <form:label class="button-label" for="Silver-button" path="color">
                                <h5>Silver</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color"
                                              id="SpaceGrey-button"
                                              value="Black"/>
                            <form:label class="button-label" for="SpaceGrey-button" path="color">
                                <h5>Black</h5>
                            </form:label>
                        </c:when>
                        <c:when test="${info.model == 'iPhone XS'}">
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Silver-button"
                                              value="Silver" required="true"/>
                            <form:label class="button-label" for="Silver-button" path="color">
                                <h5>Silver</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Gold-button"
                                              value="Gold"/>
                            <form:label class="button-label" for="Gold-button" path="color">
                                <h5>Gold</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color"
                                              id="SpaceGrey-button"
                                              value="Black"/>
                            <form:label class="button-label" for="SpaceGrey-button" path="color">
                                <h5>Black</h5>
                            </form:label>
                        </c:when>
                        <c:when test="${info.model == 'iPhone XR'}">
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Blue-button"
                                              value="Blue" required="true"/>
                            <form:label class="button-label" for="Blue-button" path="color">
                                <h5>Blue</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Coral-button"
                                              value="Coral"/>
                            <form:label class="button-label" for="Coral-button" path="color">
                                <h5>Coral</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Yellow-button"
                                              value="Yellow"/>
                            <form:label class="button-label" for="Yellow-button" path="color">
                                <h5>Yellow</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Red-button"
                                              value="Red"/>
                            <form:label class="button-label" for="Red-button" path="color">
                                <h5>Red</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="White-button"
                                              value="White"/>
                            <form:label class="button-label" for="White-button" path="color">
                                <h5>White</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Black-button"
                                              value="Black"/>
                            <form:label class="button-label" for="Black-button" path="color">
                                <h5>Black</h5>
                            </form:label>
                        </c:when>
                        <c:when test="${info.model == 'iPhone 11'}">
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Green-button"
                                              value="Green"/>
                            <form:label class="button-label" for="Green-button" path="color">
                                <h5>Green</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Purple-button"
                                              value="Purple"/>
                            <form:label class="button-label" for="Purple-button" path="color">
                                <h5>Purple</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Yellow-button"
                                              value="Yellow"/>
                            <form:label class="button-label" for="Yellow-button" path="color">
                                <h5>Yellow</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Red-button"
                                              value="Red"/>
                            <form:label class="button-label" for="Red-button" path="color">
                                <h5>Red</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="White-button"
                                              value="White"/>
                            <form:label class="button-label" for="White-button" path="color">
                                <h5>White</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Black-button"
                                              value="Black"/>
                            <form:label class="button-label" for="Black-button" path="color">
                                <h5>Black</h5>
                            </form:label>
                        </c:when>
                        <c:when test="${info.model == 'iPhone 11P' || info.model == 'iPhone 11PM'}">
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Silver-button"
                                              value="Silver" required="true"/>
                            <form:label class="button-label" for="Silver-button" path="color">
                                <h5>Silver</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Gold-button"
                                              value="Gold"/>
                            <form:label class="button-label" for="Gold-button" path="color">
                                <h5>Gold</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color"
                                              id="SpaceGrey-button"
                                              value="Black"/>
                            <form:label class="button-label" for="SpaceGrey-button" path="color">
                                <h5>Black</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color"
                                              id="MidnightGreen-button"
                                              value="Green"/>
                            <form:label class="button-label" for="MidnightGreen-button" path="color">
                                <h5>Green</h5>
                            </form:label>
                        </c:when>
                        <c:when test="${info.model == 'iPhone 12'}">
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Green-button"
                                              value="Green"/>
                            <form:label class="button-label" for="Green-button" path="color">
                                <h5>Green</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Purple-button"
                                              value="Purple"/>
                            <form:label class="button-label" for="Purple-button" path="color">
                                <h5>Purple</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Blue-button"
                                              value="Blue"/>
                            <form:label class="button-label" for="Blue-button" path="color">
                                <h5>Blue</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Red-button"
                                              value="Red"/>
                            <form:label class="button-label" for="Red-button" path="color">
                                <h5>Red</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="White-button"
                                              value="White"/>
                            <form:label class="button-label" for="White-button" path="color">
                                <h5>White</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Black-button"
                                              value="Black"/>
                            <form:label class="button-label" for="Black-button" path="color">
                                <h5>Black</h5>
                            </form:label>
                        </c:when>
                        <c:when test="${info.model == 'iPhone 12M'}">
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Green-button"
                                              value="Green"/>
                            <form:label class="button-label" for="Green-button" path="color">
                                <h5>Green</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Purple-button"
                                              value="Purple"/>
                            <form:label class="button-label" for="Purple-button" path="color">
                                <h5>Purple</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Blue-button"
                                              value="Blue"/>
                            <form:label class="button-label" for="Blue-button" path="color">
                                <h5>Blue</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Red-button"
                                              value="Red"/>
                            <form:label class="button-label" for="Red-button" path="color">
                                <h5>Red</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="White-button"
                                              value="White"/>
                            <form:label class="button-label" for="White-button" path="color">
                                <h5>White</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Black-button"
                                              value="Black"/>
                            <form:label class="button-label" for="Black-button" path="color">
                                <h5>Black</h5>
                            </form:label>
                        </c:when>
                        <c:when test="${info.model == 'iPhone 12P' || info.model == 'iPhone 12PM'}">
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Silver-button"
                                              value="Silver" required="true"/>
                            <form:label class="button-label" for="Silver-button" path="color">
                                <h5>Silver</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Gold-button"
                                              value="Gold"/>
                            <form:label class="button-label" for="Gold-button" path="color">
                                <h5>Gold</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Graphite-button"
                                              value="Black"/>
                            <form:label class="button-label" for="Graphite-button" path="color">
                                <h5>Black</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color"
                                              id="PacificBlue-button"
                                              value="Blue"/>
                            <form:label class="button-label" for="PacificBlue-button" path="color">
                                <h5>Blue</h5>
                            </form:label>
                        </c:when>
                        <c:when test="${info.model == 'iPhone 13' || info.model == 'iPhone 13M'}">
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Red-button"
                                              value="Red" required="true"/>
                            <form:label class="button-label" for="Red-button" path="color">
                                <h5>Red</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="White-button"
                                              value="White" required="true"/>
                            <form:label class="button-label" for="White-button" path="color">
                                <h5>White</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Black-button"
                                              value="Black" required="true"/>
                            <form:label class="button-label" for="Black-button" path="color">
                                <h5>Black</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Blue-button"
                                              value="Blue" required="true"/>
                            <form:label class="button-label" for="Blue-button" path="color">
                                <h5>Blue</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Pink-button"
                                              value="Pink" required="true"/>
                            <form:label class="button-label" for="Pink-button" path="color">
                                <h5>Pink</h5>
                            </form:label>
                            <form:radiobutton class="hidden radio-label select-button" path="color" id="Green-button"
                                              value="Green" required="true"/>
                            <form:label class="button-label" for="Green-button" path="color">
                                <h5>Green</h5>
                            </form:label>
                        </c:when>
                    </c:choose>
                </div>
                <hr>
                <div class="button-wrap">
                    <h4 style="color: red">Select Grade</h4>
                    <input class="hidden radio-label select-button" type="radio" name="grade" id="a-button" value="A"
                           required/>
                    <label class="button-label" for="a-button">
                        <h5>A</h5>
                    </label>
                    <input class="hidden radio-label select-button" type="radio" name="grade" id="b-button" value="B"/>
                    <label class="button-label" for="b-button">
                        <h5>B</h5>
                    </label>
                    <input class="hidden radio-label select-button" type="radio" name="grade" id="c-button" value="C"/>
                    <label class="button-label" for="c-button">
                        <h5>C</h5>
                    </label>
                </div>
                <hr>
                <h4 style="color: red">Send To</h4>
                <select name="send_to" class="selectpicker form-control">
                    <option value="STOCK">STOCK</option>
                    <option value="POLISH">POLISH</option>
                </select>
                <c:if test="${rev == true}">
                    <button id="save" style="margin-bottom:30px; width: 100%; margin-top:50px;" type="button" class="btn btn-primary" data-bs-toggle="modal"
                            data-bs-target="#modalconfirmRev">
                        SAVE
                    </button>

                    <input id="submit" style="width: 100%; margin-top:50px; display: none" type="submit" onclick="$('#processing').show()"
                           class="btn btn-outline-primary">
                </c:if>
                <c:if test="${rev == false}">
                    <input id="submit" style="width: 100%; margin-top:50px;" type="submit" onclick="$('#processing').show()"
                           class="btn btn-outline-primary">
                </c:if>
                </form:form>

            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="modalconfirmRev" tabindex="-1" aria-labelledby="modalconfirmRevLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-xl">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="modal-title" id="confirmRev">Did you write "R" on the label?</h2>
                <button type="button" class="btn-close" data-bs-dismiss="modal"
                        aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <button type="button" class="btn btn-danger" style="width: 50%; height:100px"
                            data-bs-dismiss="modal">NO
                    </button>
                    <button  type="button" class="btn btn-outline-success" style="width: 50%; height:100px"
                             onclick="$('#submit').css('display', 'block'); $('#save').css('display', 'none');"
                             data-bs-dismiss="modal">YES
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="issueModal" tabindex="-1" aria-labelledby="issueModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl">
        <input type="hidden" name="hours" id="hour2" readonly="true"/>
        <input type="hidden" name="mins" id="minute2" readonly="true"/>
        <input type="hidden" name="seconds" id="second2" readonly="true"/>

        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="issueModalLabel">Report issues</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form:form modelAttribute="sendTechlab"
                           action="${pageContext.request.contextPath}/packingReport">
                    <div class="row">
                        <div class="col-12">
                            <h4 style="color: red">Send To</h4>
                            <select name="status" required class="form-control">
                                <option value="FIXING">FIXING</option>
                                <option value="TECHLAB">TECHLAB</option>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-3">
                            <c:set var="divClose"/>
                            <c:forEach items="${issues}" var="issue">
                            <form:hidden path="imei" value="${info.imei}"/>
                            <div class="form-check">
                                <form:label for="${info.imei}${issue.tl}" class="form-check-label"
                                            path="${issue.tl}"
                                            data-bs-toggle="tooltip" data-bs-placement="right"
                                            data-bs-title="${issue.label}">
                                    <form:checkbox onclick="getTl('${issue.tl}')" id="${info.imei}${issue.tl}"
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
                <button type="button" class="btn btn-secondary" id="close" data-bs-dismiss="modal">Close</button>
                <button type="submit" onclick="$('#sendTechlab').submit()"
                        onmouseover="setHour(), setMinute(), setSecond()" class="btn btn-primary">Save changes
                </button>
            </div>
        </div>
    </div>
</div>

<script>
    function setHour() {
        document.getElementById("hour2").value = document.getElementById("hour").value
        console.log(document.getElementById("hour2").value)
    }

    function setMinute() {
        document.getElementById("minute2").value = document.getElementById("minute").value
        console.log(document.getElementById("minute2").value)
    }

    function setSecond() {
        document.getElementById("second2").value = document.getElementById("second").value
        console.log(document.getElementById("second2").value)
    }
</script>

<script src="${pageContext.request.contextPath}/clock.js"></script>
</body>
</html>

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
    <link href="style.css" rel="stylesheet">
    <meta charset="utf-8"/>
    <title>Battery</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <div class="row" style="margin-top: 50px; alignment: center">
        <div class="col-4">
            <p>Grade Supplier: ${grade.grade_sup}</p>
            <p>Grade Check: ${grade.grade_check}</p>
            <p>TL CODE:</p>
            <ul>
                <c:choose>
                    <c:when test="${test.i_1 == true}">
                        <li>TL 2</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_2 == true}">
                        <li>TL 2T</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_3 == true}">
                        <li>TL 4</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_4 == true}">
                        <li>TL 5</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_5 == true}">
                        <li>TL 5A</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_6 == true}">
                        <li>TL 8</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_7 == true}">
                        <li>TL 8P</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_8 == true}">
                        <li>TL 14</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_9 == true}">
                        <li>TL 14P</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_10 == true}">
                        <li>TL 14A</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_11 == true}">
                        <li>TL 14T</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_12 == true}">
                        <li>TL 9</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_13 == true}">
                        <li>TL 9T</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_14 == true}">
                        <li>TL 10</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_15 == true}">
                        <li>TL 10P</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_16 == true}">
                        <li>TL 10A</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_17 == true}">
                        <li>TL 11T</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_18 == true}">
                        <li>TL 11P</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_19 == true}">
                        <li>TL 11A</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_20 == true}">
                        <li>TL 16</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_21 == true}">
                        <li>TL 15</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_22 == true}">
                        <li>TL 21</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_23 == true}">
                        <li>TL 12</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_24 == true}">
                        <li>TL 13</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_25 == true}">
                        <li>TL 18</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_26 == true}">
                        <li>TL 19</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_27 == true}">
                        <li>TL 19A</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_28 == true}">
                        <li>TL 20</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_29 == true}">
                        <li>TL 32</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_30 == true}">
                        <li>TL 24</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_31 == true}">
                        <li>TL 26</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_32 == true}">
                        <li>TL 26T</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_33 == true}">
                        <li>TL 27T</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_34 == true}">
                        <li>TL 28T</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_35 == true}">
                        <li>TL 30</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_36 == true}">
                        <li>TL 36</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_37 == true}">
                        <li>TL 36T</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_38 == true}">
                        <li>TL 37</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_39 == true}">
                        <li>TL 41</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_40 == true}">
                        <li>TL 42A</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_41 == true}">
                        <li>TL 38</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_42 == true}">
                        <li>TL 39</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_43 == true}">
                        <li>TL 40</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_44 == true}">
                        <li>TL 40T</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_45 == true}">
                        <li>TL 42</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_46 == true}">
                        <li>TL 29</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_47 == true}">
                        <li>TL 29A</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_48 == true}">
                        <li>TL 29B</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_49 == true}">
                        <li>TL 29C</li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${test.i_50 == true}">
                        <li>TL 17</li>
                    </c:when>
                </c:choose>
            </ul>
        </div>
        <div class="col-8">
            <form:form method="post" modelAttribute="battery" action="/save_battery">
                <div class="form-group">
                    <form:label path="imei">imei:</form:label>
                    <form:input path="imei" value="${imei}" readonly="true"></form:input>
                </div>
                <div class="form-group">
                    <form:label path="cycles">CYCLES: </form:label>
                    <form:input class="form-control" path="cycles"></form:input>
                </div>
                <div class="form-group">
                    <form:label path="soh">SOH: </form:label>
                    <form:input class="form-control" path="soh"></form:input>
                </div>
                <div class="form-group">
                    <form:label class="form-check-label" path="replace">Replace: </form:label>
                    <form:checkbox class="form-check-input" path="replace"></form:checkbox>
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-outline-primary"/>
                </div>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
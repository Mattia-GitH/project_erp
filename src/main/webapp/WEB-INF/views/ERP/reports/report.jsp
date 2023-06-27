<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>

    <style>
        .icon,
        .text {
            vertical-align: middle;
            display: inline-block;
        }
    </style>
    <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>All phones</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container" style="padding-top: 50px">
    <div class="row">
        <c:forEach items="${report}" var="report" varStatus="status">
            <c:if test="${status.index == 0}">
                <div class="col-2">
                </div>
                <div class="col-4">
                    <h5>IMEI: ${report.imei}</h5>
                    <h5>Model: ${phone.model}</h5>
                    <h5>GB: ${phone.gb}</h5>
                </div>
                <div class="col-4">
                    <h5>Date: ${report.date}</h5>
                    <h5>Operator: ${report.operator}</h5>
                    <h5>Sent to: ${report.status}</h5>
                </div>
                <div class="col-2" style="padding-bottom: 20px">
                </div>
                <hr>
                <div class="col-3" style="display: inline-block">
                    <c:choose>
                        <c:when test="${report.i_1 == true}">
                            <a href="/comment/${report.imei}/I_1/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                            BATTERY
                            </span>
                                </p>
                            </a>
                        </c:when>
                        <c:when test="${report.i_1 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                            BATTERY
                            </span>
                            </p>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_2 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                            BATTERY AFTER REPLACE
                            </span>
                            </p>

                        </c:when>
                        <c:when test="${report.i_2 == true}">
                            <a href="/comment/${report.imei}/I_2/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                            BATTERY AFTER REPLACE
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_3 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                            TRUE TONE
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_3 == true}">
                            <a href="/comment/${report.imei}/I_3/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                            TRUE TONE
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_4 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                            DISPLAY \ TOUCH
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_4 == true}">
                            <a href="/comment/${report.imei}/I_4/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                            DISPLAY \ TOUCH
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_5 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                            SCREEN SEALING
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_5 == true}">
                            <a href="/comment/${report.imei}/I_5/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                            SCREEN SEALING
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_6 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                            NO FRONT CAMERA
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_6 == true}">
                            <a href="/comment/${report.imei}/I_6/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                            NO FRONT CAMERA
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_7 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                            DIRTY OVER CAMERA
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_7 == true}">
                            <a href="/comment/${report.imei}/I_7/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                            DIRTY OVER CAMERA
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_8 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                            NO BACK CAMERA
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_8 == true}">
                            <a href="/comment/${report.imei}/I_8/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                            NO BACK CAMERA
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_9 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                            DIRT GLASS
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_9 == true}">
                            <a href="/comment/${report.imei}/I_9/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                            DIRT GLASS
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_10 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                            BROKE CAMERA GLASS
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_10 == true}">
                            <a href="/comment/${report.imei}/I_10/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                            BROKE CAMERA GLASS
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_11 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                            CAMERA FRAME LOOSE
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_11 == true}">
                            <a href="/comment/${report.imei}/I_11/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                            CAMERA FRAME LOOSE
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_12 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                            VIBRATION
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_12 == true}">
                            <a href="/comment/${report.imei}/I_12/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                            VIBRATION
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_13 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                            NO VIBRATION AFTER REPLACE
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_13 == true}">
                            <a href="/comment/${report.imei}/I_13/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                            NO VIBRATION AFTER REPLACE
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                </div>
                <div class="col-3">
                    <c:choose>
                        <c:when test="${report.i_14 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                            NO AUDIO (RING/SPEAKERPHONE)
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_14 == true}">
                            <a href="/comment/${report.imei}/I_14/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                            NO AUDIO (RING/SPEAKERPHONE)
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_15 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                            DIRTY ON LOWER SPEAKER
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_15 == true}">
                            <a href="/comment/${report.imei}/I_15/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                            DIRTY ON LOWER SPEAKER
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_16 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                    AUDIO GRID REPLACE
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_16 == true}">
                            <a href="/comment/${report.imei}/I_16/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                            AUDIO GRID REPLACE
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_17 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                    NO AUDIO FROM SPEAKER
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_17 == true}">
                            <a href="/comment/${report.imei}/I_17/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                            NO AUDIO FROM SPEAKER
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_18 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                    DIRTY ON UPPER SPEAKER
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_18 == true}">
                            <a href="/comment/${report.imei}/I_18/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                            DIRTY ON UPPER SPEAKER
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_19 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                    REPLACE ONLY GRID
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_19 == true}">
                            <a href="/comment/${report.imei}/I_19/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                                        REPLACE ONLY GRID
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_20 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                    NO MICROPHONE (VIDEO)
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_20 == true}">
                            <a href="/comment/${report.imei}/I_20/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                                        NO MICROPHONE (VIDEO)
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_21 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                    NO FRONT MICROPHONE (SIRI)
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_21 == true}">
                            <a href="/comment/${report.imei}/I_21/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                                       NO FRONT MICROPHONE (SIRI)
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_22 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                    NO MICROPHONE (CALL)
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_22 == true}">
                            <a href="/comment/${report.imei}/I_22/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                                       NO MICROPHONE (CALL)
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_23 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                    PROXY SENSOR
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_23 == true}">
                            <a href="/comment/${report.imei}/I_23/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                                       PROXY SENSOR
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_24 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                    NO TORCH / FLASH
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_24 == true}">
                            <a href="/comment/${report.imei}/I_24/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                                       NO TORCH / FLASH
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_25 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                    POWER BUTTON
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_25 == true}">
                            <a href="/comment/${report.imei}/I_25/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                                       POWER BUTTON
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_26 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                     VOLUME BOTTONS/MUTE KO
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_26 == true}">
                            <a href="/comment/${report.imei}/I_26/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                                        VOLUME BOTTONS/MUTE KO
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>

                </div>
                <div class="col-3">
                    <c:choose>
                        <c:when test="${report.i_27 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                     NO COMPASS FEATURE
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_27 == true}">
                            <a href="/comment/${report.imei}/I_27/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                                        NO COMPASS FEATURE
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_28 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                     SOFTWARE
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_28 == true}">
                            <a href="/comment/${report.imei}/I_28/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                                        SOFTWARE
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_29 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                     ITUNES ERROR (NAND)
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_29 == true}">
                            <a href="/comment/${report.imei}/I_29/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                                        ITUNES ERROR (NAND)
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_30 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                     LIQUID CONTACT
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_30 == true}">
                            <a href="/comment/${report.imei}/I_30/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                                        LIQUID CONTACT
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_31 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                     REBOOT
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_31 == true}">
                            <a href="/comment/${report.imei}/I_31/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                                        REBOOT
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_32 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                     PANIC FULL
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_32 == true}">
                            <a href="/comment/${report.imei}/I_32/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                                        PANIC FULL
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_33 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                     BLUETOOTH
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_33 == true}">
                            <a href="/comment/${report.imei}/I_33/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                                        BLUETOOTH
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_34 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                     WIFI
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_34 == true}">
                            <a href="/comment/${report.imei}/I_34/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                                        WIFI
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_35 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                     CPU OVERHEATING
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_35 == true}">
                            <a href="/comment/${report.imei}/I_35/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                                        CPU OVERHEATING
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_36 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                     SIM
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_36 == true}">
                            <a href="/comment/${report.imei}/I_36/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                                        SIM
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_37 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                     SIM NOT DETECTED
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_37 == true}">
                            <a href="/comment/${report.imei}/I_37/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                                        SIM NOT DETECTED
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_38 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                     BASEBAND
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_38 == true}">
                            <a href="/comment/${report.imei}/I_38/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                                        BASEBAND
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                </div>
                <div class="col-3">
                    <c:choose>
                        <c:when test="${report.i_39 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                     LOCKED & BLACKLIST
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_39 == true}">
                            <a href="/comment/${report.imei}/I_39/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                                        LOCKED & BLACKLIST
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_40 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                     NO POWER \ SHORT TO GROUND
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_40 == true}">
                            <a href="/comment/${report.imei}/I_40/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                                        NO POWER \ SHORT TO GROUND
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>

                    <c:choose>
                        <c:when test="${report.i_41 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                     DOCK CHARGE
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_41 == true}">
                            <a href="/comment/${report.imei}/I_41/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                                        DOCK CHARGE
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_42 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                     WIRELESS CHARGING
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_42 == true}">
                            <a href="/comment/${report.imei}/I_42/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                                        WIRELESS CHARGING
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_43 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                     UNBLOCKED BACKCOVER
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_43 == true}">
                            <a href="/comment/${report.imei}/I_43/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                                        UNBLOCKED BACKCOVER
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_44 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                     BROKEN/BENT FRAME AND GLASS
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_44 == true}">
                            <a href="/comment/${report.imei}/I_44/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                                        BROKEN/BENT FRAME AND GLASS
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_45 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                     NEED MOTHERBOARD DIAG
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_45 == true}">
                            <a href="/comment/${report.imei}/I_45/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                                        NEED MOTHERBOARD DIAG
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_46 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                     FACE ID / TOUCH ID
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_46 == true}">
                            <a href="/comment/${report.imei}/I_46/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                                        FACE ID / TOUCH ID
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_47 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                     A - DOT PROJECTOR
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_47 == true}">
                            <a href="/comment/${report.imei}/I_47/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                                        A - DOT PROJECTOR
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_48 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                     B- FLOOD ILLUMINATOR
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_48 == true}">
                            <a href="/comment/${report.imei}/I_48/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                                        B- FLOOD ILLUMINATOR
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_49 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                     C- INFRARED CAMERA
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_49 == true}">
                            <a href="/comment/${report.imei}/I_49/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                                        C- INFRARED CAMERA
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${report.i_50 == false}">
                            <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green"
                                 class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                            </svg>
                            </span>
                                <span class="text">
                                      NFC Pay
                            </span>
                            </p>
                        </c:when>
                        <c:when test="${report.i_50 == true}">
                            <a href="/comment/${report.imei}/I_50/${report.date}" target="_blank">
                                <p>
                        <span class="icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red"
                                 class="bi bi-x-circle-fill" viewBox="0 0 16 16" style="float:left">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                            </svg>
                        </span>
                                    <span class="text">
                                         NFC Pay
                            </span>
                                </p>
                            </a>
                        </c:when>
                    </c:choose>
                </div>
            </c:if>
        </c:forEach>
    </div>
</div>
</body>
</html>
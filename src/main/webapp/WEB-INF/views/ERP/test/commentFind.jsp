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
    <link href="style.css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>Comment</title>
</head>
<body>
<jsp:include page="../header.jsp" />
<div class="container">
    <div class="row justify-content-md-center">
        <h1>Comment</h1>
        <div class="card text-center">
            <div class="card-header">
                IMEI: ${comment.imei} | Date: ${comment.date} | Found in: ${comment.status}
            </div>
            <div class="card-body">
                <h5 class="card-title"><c:choose>
                    <c:when test="${comment.id_issue == 'I_1'}">Battery</c:when>
                    <c:when test="${comment.id_issue == 'I_2'}">NO CHARGE AFTER REPLACE</c:when>
                    <c:when test="${comment.id_issue == 'I_3'}">INSTALL TRUE TONE</c:when>
                    <c:when test="${comment.id_issue == 'I_4'}">REPLACE SCREEN TOUCH PANEL</c:when>
                    <c:when test="${comment.id_issue == 'I_5'}">REPLACE FRAMESCREEN GLUE AND USE PRESS</c:when>
                    <c:when test="${comment.id_issue == 'I_6'}">REPLACE FRONT CAMERA MODULE</c:when>
                    <c:when test="${comment.id_issue == 'I_7'}">REMOVE DUST WITH AIR AND CLEAN</c:when>
                    <c:when test="${comment.id_issue == 'I_8'}">REPLACE BACK CAMERA MODULE</c:when>
                    <c:when test="${comment.id_issue == 'I_9'}">REMOVE DUST WITH AIR AND CLEAN</c:when>
                    <c:when test="${comment.id_issue == 'I_10'}">INSTALL NEW CAMERA GLASS</c:when>
                    <c:when test="${comment.id_issue == 'I_11'}">WELD FRAME INSIDE HOUSING WITH PULSE WELDER</c:when>
                    <c:when test="${comment.id_issue == 'I_12'}">REPLACE TAPTIC ENGINE</c:when>
                    <c:when test="${comment.id_issue == 'I_13'}">NO VIBRATION AFTER REPLACE</c:when>
                    <c:when test="${comment.id_issue == 'I_14'}">REPLACE LOW RINGER</c:when>
                    <c:when test="${comment.id_issue == 'I_15'}">TRY TO CLEAN AND REMOVE DUST</c:when>
                    <c:when test="${comment.id_issue == 'I_16'}">REPLACE ONLY GRID</c:when>
                    <c:when test="${comment.id_issue == 'I_17'}">
                        REPLACE ONLY SPEAKER MODULE</c:when>
                    <c:when test="${comment.id_issue == 'I_18'}">
                        TRY TO CLEAN AND REMOVE DUST</c:when>
                    <c:when test="${comment.id_issue == 'I_19'}">REPLACE ONLY GRID</c:when>
                    <c:when test="${comment.id_issue == 'I_20'}">NO MICROPHONE VIDEO, REPLACE DOCK CHARGE FLAT</c:when>
                    <c:when test="${comment.id_issue == 'I_21'}">REPLACE SIRI MIC FROM FLAT</c:when>
                    <c:when test="${comment.id_issue == 'I_22'}">
                        REPLACE DOCK CHARGE FLAT</c:when>
                    <c:when test="${comment.id_issue == 'I_23'}">SWAP TO ANOTHER PS FLEX</c:when>
                    <c:when test="${comment.id_issue == 'I_24'}">
                        REPLACE FLAT POWERFLASH</c:when>
                    <c:when test="${comment.id_issue == 'I_25'}">POWER BOTTON KO</c:when>
                    <c:when test="${comment.id_issue == 'I_26'}">
                        VOLUME BOTTONS/MUTE KO</c:when>
                    <c:when test="${comment.id_issue == 'I_27'}">NO COMPASS FEATURE</c:when>
                    <c:when test="${comment.id_issue == 'I_28'}">UPDATE IOS TO LAST</c:when>
                    <c:when test="${comment.id_issue == 'I_29'}">
                        TRY ANOTHER COMPUTER , CABLE IN DFU</c:when>
                    <c:when test="${comment.id_issue == 'I_30'}">LIQUID CONTACT</c:when>
                    <c:when test="${comment.id_issue == 'I_31'}">REBOOT</c:when>
                    <c:when test="${comment.id_issue == 'I_32'}">PANIC FULL</c:when>
                    <c:when test="${comment.id_issue == 'I_33'}">NO BLUETOOTH</c:when>
                    <c:when test="${comment.id_issue == 'I_34'}">NO WIFI</c:when>
                    <c:when test="${comment.id_issue == 'I_35'}">CPU OVERHEATING</c:when>
                    <c:when test="${comment.id_issue == 'I_36'}">
                        TRY TO FIXREPLACE SIM READER</c:when>
                    <c:when test="${comment.id_issue == 'I_37'}">SIM DOESN T WORK</c:when>
                    <c:when test="${comment.id_issue == 'I_38'}">BASEBAND</c:when>
                    <c:when test="${comment.id_issue == 'I_39'}">SIM/MDM/ICLOUD LOCKED OR BLACK LISTED</c:when>
                    <c:when test="${comment.id_issue == 'I_40'}">NO POWER SHORT TO GROUND</c:when>
                    <c:when test="${comment.id_issue == 'I_41'}">REPLACE DOCK CHARGE FLAT</c:when>
                    <c:when test="${comment.id_issue == 'I_42'}">REPLACE NFC CHARGE COIL FLEX</c:when>
                    <c:when test="${comment.id_issue == 'I_43'}">
                        TRY TO GLUE AND PRESS</c:when>
                    <c:when test="${comment.id_issue == 'I_44'}">REPLACE FULL HOUSING WITH FLEX</c:when>
                    <c:when test="${comment.id_issue == 'I_45'}">NEED MOTHERBOARD DIAG</c:when>
                    <c:when test="${comment.id_issue == 'I_46'}">FACE ID / TOUCH ID</c:when>
                    <c:when test="${comment.id_issue == 'I_47'}">A - DOT PROJECTOR </c:when>
                    <c:when test="${comment.id_issue == 'I_48'}">B- FLOOD ILLUMINATOR </c:when>
                    <c:when test="${comment.id_issue == 'I_49'}">C- INFRARED CAMERA</c:when>
                    <c:when test="${comment.id_issue == 'I_50'}">NFC Pay</c:when>
                </c:choose></h5>
                <p class="card-text">${comment.comment}</p>
            </div>
        </div>
    </div>
</div>

</body>
</html>
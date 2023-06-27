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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"
            integrity="sha512-STof4xm1wgkfm7heWqFJVn58Hm3EtS31XFaagaa8VMReCXAkQnJZ+jEy8PCC/iT18dFy95WcExNHFTqLyp72eQ=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <style>
        .checkboxes label {
            display: inline-block;
            padding-right: 10px;
            white-space: nowrap;
        }
        .checkboxes input {
            vertical-align: middle;
        }
        .checkboxes label span {
            vertical-align: middle;
        }
        label {
            width: 500px;
        }
        .container, .container-lg, .container-md, .container-sm, .container-xl {
            max-width: 100%!important;
        }
    </style>
    <script type="text/javascript">
        let tl = new Array();
        let list = document.createElement('ul');
        function toTl(string) {
            if (!tl.includes(string)) {
                tl.push(string)
            } else {
                tl.splice(tl.indexOf(string), 1)
            }
            function makeUL(array) {
                document.getElementById('listTl').innerHTML = "";
                let list = document.createElement('ul');
                for (let i = 0; i < tl.length; i++) {
                    let item = document.createElement('li');
                    item.appendChild(document.createTextNode(tl[i]));
                    list.appendChild(item);
                }
                return list;
            }
            document.getElementById('listTl').appendChild(makeUL(tl[0]));
        }
        console.log(tl);
    </script>
    <link href="/style.css" rel="stylesheet">
    <meta charset="utf-8"/>
    <title>Testing</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <div class="row" style="margin-top: 50px">
        <div class="col-4">
            <p>Grade Supplier: ${grade.grade_sup}</p>
            <p>Grade Check: ${grade.grade_check}</p>
            <div id="listTl"></div>
        </div>

        <div class="col-8">
            <form:form method="post" modelAttribute="test" action="/save_test">
                <div class="form-group" style="margin-bottom: 20px">
                    <form:label path="imei">imei:
                        <form:input path="imei" value="${test.imei}" readonly="true"></form:input></form:label>
                </div>
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <li class="nav-item"><a class="nav-link active" id="tab1-tab" data-bs-toggle="tab" href="#tab1"
                                            role="tab" aria-controls="tab1" aria-selected="true">Wifi - Bluetooth</a>
                    </li>
                    <li class="nav-item"><a class="nav-link" id="tab2-tab" data-bs-toggle="tab" href="#tab2" role="tab"
                                            aria-controls="tab2" aria-selected="false">Speaker / Microphone</a></li>
                    <li class="nav-item"><a class="nav-link" id="tab3-tab" data-bs-toggle="tab" href="#tab3" role="tab"
                                            aria-controls="tab3" aria-selected="false">Vibration</a></li>
                    <li class="nav-item"><a class="nav-link" id="tab4-tab" data-bs-toggle="tab" href="#tab4" role="tab"
                                            aria-controls="tab4" aria-selected="false">Buttons / Compass</a></li>
                    <li class="nav-item"><a class="nav-link" id="tab5-tab" data-bs-toggle="tab" href="#tab5" role="tab"
                                            aria-controls="tab5" aria-selected="false">Face ID / Touch ID</a></li>
                    <li class="nav-item"><a class="nav-link" id="tab6-tab" data-bs-toggle="tab" href="#tab6" role="tab"
                                            aria-controls="tab6" aria-selected="false">Display</a></li>
                    <li class="nav-item"><a class="nav-link" id="tab7-tab" data-bs-toggle="tab" href="#tab7" role="tab"
                                            aria-controls="tab7" aria-selected="false">Cameras</a></li>
                    <li class="nav-item"><a class="nav-link" id="tab8-tab" data-bs-toggle="tab" href="#tab8" role="tab"
                                            aria-controls="tab8" aria-selected="false">Flash</a></li>
                    <li class="nav-item"><a class="nav-link" id="tab9-tab" data-bs-toggle="tab" href="#tab9" role="tab"
                                            aria-controls="tab9" aria-selected="false">Proximity Sensor</a></li>
                    <li class="nav-item"><a class="nav-link" id="tab10-tab" data-bs-toggle="tab" href="#tab10"
                                            role="tab" aria-controls="tab10" aria-selected="false">Charge</a></li>
                    <li class="nav-item"><a class="nav-link" id="tab11-tab" data-bs-toggle="tab" href="#tab11"
                                            role="tab" aria-controls="tab11" aria-selected="false">NFC Pay</a></li>
                    <li class="nav-item"><a class="nav-link" id="tab12-tab" data-bs-toggle="tab" href="#tab12"
                                            role="tab" aria-controls="tab12" aria-selected="false">SIM</a></li>
                    <li class="nav-item"><a class="nav-link" id="tab13-tab" data-bs-toggle="tab" href="#tab13"
                                            role="tab" aria-controls="tab13" aria-selected="false">Reboot / Panic
                        Full</a></li>
                    <li class="nav-item"><a class="nav-link" id="tab14-tab" data-bs-toggle="tab" href="#tab14"
                                            role="tab" aria-controls="tab14" aria-selected="false">iOS</a></li>
                    <li class="nav-item"><a class="nav-link" id="tab15-tab" data-bs-toggle="tab" href="#tab15"
                                            role="tab" aria-controls="tab15" aria-selected="false">Battery</a></li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button"
                           aria-expanded="false">Other</a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" id="tab16-tab" data-bs-toggle="tab" href="#tab16" role="tab"
                                   aria-controls="tab16">Backcover</a></li>
                            <li><a class="dropdown-item" id="tab17-tab" data-bs-toggle="tab" href="#tab17" role="tab"
                                   aria-controls="tab17">UNREPAIRABLE</a></li>
                            <li><a class="dropdown-item" id="tab18-tab" data-bs-toggle="tab" href="#tab18" role="tab"
                                   aria-controls="tab18">CPU</a></li>
                            <li><a class="dropdown-item" id="tab19-tab" data-bs-toggle="tab" href="#tab19" role="tab"
                                   aria-controls="tab19">Motherboard</a></li>
                            <li><a class="dropdown-item" id="tab20-tab" data-bs-toggle="tab" href="#tab20" role="tab"
                                   aria-controls="tab20">Liquid</a></li>
                        </ul>
                    </li>
                </ul>
                <div class="tab-content" id="myTabContent" style="height: 408px">
                    <div class="tab-pane p-4 fade show active" id="tab1" role="tabpanel" aria-labelledby="tab1-tab">
                        <div class="form-check">
                            <form:label class="form-check-label"
                                        path="I_33">
                                <form:checkbox class="form-check-input" path="I_33"
                                               onclick="toTl('TL 27')"></form:checkbox>TL 27 - NO BLUETOOTH</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_33">Comment</a></span>

                        </div>
                        <div class="form-check">
                            <form:label class="form-check-label" path="I_34">
                                <form:checkbox onclick="toTl('TL 28')" class="form-check-input"
                                               path="I_34"></form:checkbox>TL 28 - NO WI-FI</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_34">Comment</a>
                        </div>

                    </div>
                    <div class="tab-pane p-4 fade" id="tab2" role="tabpanel" aria-labelledby="tab2-tab">
                        <div class="form-check">
                            <form:label class="form-check-label"
                                        path="I_14">
                                <form:checkbox onclick="toTl('TL 10')" class="form-check-input"
                                               path="I_14"></form:checkbox>TL 10 - NO AUDIO FROM LOWER SPEAKER
                            </form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_14">Comment</a>
                        </div>
                        <div class="form-check">
                            <form:label class="form-check-label"
                                        path="I_15">
                                <form:checkbox onclick="toTl('TL 10P')" class="form-check-input"
                                               path="I_15"></form:checkbox>TL 10P - LOW OR POOR AUDIO DUE DUST INSIDE
                            </form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_15">Comment</a>
                        </div>
                        <div class="form-check">
                            <form:label class="form-check-label"
                                        path="I_16">
                                <form:checkbox onclick="toTl('TL 10A')" class="form-check-input"
                                               path="I_16"></form:checkbox>TL 10A - RINGER GRID IS TOO DIRTY OR DAMAGED AFTER CLEANING
                            </form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_16">Comment</a>
                        </div>
                        <div class="form-check">
                            <form:label class="form-check-label"
                                        path="I_17">
                                <form:checkbox onclick="toTl('TL 11')" class="form-check-input"
                                               path="I_17"></form:checkbox>TL 11 - NO AUDIO FROM UPPER SPEAKER
                            </form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_17">Comment</a>
                        </div>
                        <div class="form-check">
                            <form:label class="form-check-label"
                                        path="I_18">
                                <form:checkbox onclick="toTl('TL 11P')" class="form-check-input"
                                               path="I_18"></form:checkbox>TL 11P - LOW OR POOR AUDIO DUE DUST INSIDE
                            </form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_18">Comment</a>
                        </div>
                        <div class="form-check">
                            <form:label class="form-check-label"
                                        path="I_19">
                                <form:checkbox onclick="toTl('TL 11A')" class="form-check-input"
                                               path="I_19"></form:checkbox>TL 11A - NO AUDIO FROM UPPER SPEAKER
                            </form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_19">Comment</a>
                        </div>
                        <div class="form-check">
                            <form:label class="form-check-label"
                                        path="I_20">
                                <form:checkbox onclick="toTl('TL 16')" class="form-check-input"
                                               path="I_20"></form:checkbox>TL 16 - MISSING AUDIO IN RECORDINGS
                            </form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_20">Comment</a>
                        </div>
                        <div class="form-check">
                            <form:label class="form-check-label"
                                        path="I_21">
                                <form:checkbox onclick="toTl('TL 15')" class="form-check-input"
                                               path="I_21"></form:checkbox>TL 15 - SIRI CAN'T EAR YOU \ MISSING FRONT AUDIO
                            </form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_21">Comment</a>
                        </div>
                        <div class="form-check">
                            <form:label class="form-check-label"
                                        path="I_22">
                                <form:checkbox onclick="toTl('TL 21')" class="form-check-input"
                                               path="I_22"></form:checkbox>TL 21 - MISSING OUTBOUND AUDIO </form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_22">Comment</a>
                        </div>
                    </div>
                    <div class="tab-pane p-4 fade" id="tab3" role="tabpanel" aria-labelledby="tab3-tab">
                        <div class="form-check">
                            <form:label class="form-check-label" path="I_12">
                                <form:checkbox onclick="toTl('TL 9')" class="form-check-input"
                                               path="I_12"></form:checkbox>TL 9 - MISSING VIBRATION FEEDBACK
                            </form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_12">Comment</a>
                        </div>
                        <div class="form-check">
                            <form:label class="form-check-label"
                                        path="I_13">
                                <form:checkbox onclick="toTl('TL 9T')" class="form-check-input"
                                               path="I_13"></form:checkbox>TL 9T - VIBRATION STILL NOT WORK AFTER REPLACEMENT
                            </form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_13">Comment</a>
                        </div>
                    </div>
                    <div class="tab-pane p-4 fade" id="tab4" role="tabpanel" aria-labelledby="tab4-tab">
                        <div class="form-check">
                            <form:label class="form-check-label" path="I_25">
                                <form:checkbox onclick="toTl('TL 18')" class="form-check-input"
                                               path="I_25"></form:checkbox>TL 18 - POWER BOTTON KO</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_25">Comment</a>
                        </div>
                        <div class="form-check">
                            <form:label class="form-check-label" path="I_26">
                                <form:checkbox onclick="toTl('TL 19')" class="form-check-input"
                                               path="I_26"></form:checkbox>TL 19 - VOLUME BUTTONS/MUTE KO</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_26">Comment</a>
                        </div>
                        <div class="form-check">
                            <form:label class="form-check-label" path="I_27">
                                <form:checkbox onclick="toTl('TL 19A')" class="form-check-input"
                                               path="I_27"></form:checkbox>TL 19A - NO COMPASS FEATURE</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_27">Comment</a>
                        </div>
                    </div>
                    <div class="tab-pane p-4 fade" id="tab5" role="tabpanel" aria-labelledby="tab5-tab">
                        <div class="form-check">
                            <form:label class="form-check-label" path="I_46">
                                <form:checkbox onclick="toTl('TL 29')" class="form-check-input"
                                               path="I_46"></form:checkbox>TL 29 - FACE ID / TOUCH ID</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_46">Comment</a>
                        </div>
                        <div class="form-check">
                            <form:label class="form-check-label" path="I_47">
                                <form:checkbox onclick="toTl('TL 29A')" class="form-check-input"
                                               path="I_47"></form:checkbox>TL 29A - A - DOT PROJECTOR</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_47">Comment</a>
                        </div>
                        <div class="form-check">
                            <form:label class="form-check-label" path="I_48">
                                <form:checkbox onclick="toTl('TL 29B')" class="form-check-input"
                                               path="I_48"></form:checkbox>TL 29B - B- FLOOD ILLUMINATOR </form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_48">Comment</a>
                        </div>
                        <div class="form-check">
                            <form:label class="form-check-label" path="I_49">
                                <form:checkbox onclick="toTl('TL 29C')" class="form-check-input"
                                               path="I_49"></form:checkbox>TL 29C - C- INFRARED CAMERA </form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_49">Comment</a>
                        </div>
                    </div>
                    <div class="tab-pane p-4 fade" id="tab6" role="tabpanel" aria-labelledby="tab6-tab">
                        <div class="form-check">
                            <form:label class="form-check-label" path="I_3">
                                <form:checkbox onclick="toTl('TL 4')" class="form-check-input"
                                               path="I_3"></form:checkbox>TL 4 - TRUE TONE</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_3">Comment</a>
                        </div>
                        <div class="form-check">
                            <form:label class="form-check-label" path="I_4">
                                <form:checkbox onclick="toTl('TL 5')" class="form-check-input"
                                               path="I_4"></form:checkbox>TL 5 - DISPLAY \ TOUCH</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_4">Comment</a>
                        </div>
                        <div class="form-check">
                            <form:label class="form-check-label" path="I_5">
                                <form:checkbox onclick="toTl('TL 5A')" class="form-check-input"
                                               path="I_5"></form:checkbox>TL 5A - SCREEN SEALING</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_5">Comment</a>
                        </div>
                    </div>
                    <div class="tab-pane p-4 fade" id="tab7" role="tabpanel" aria-labelledby="tab7-tab">
                        <div class="form-check">
                            <form:label class="form-check-label" path="I_6">
                                <form:checkbox onclick="toTl('TL 8')" class="form-check-input"
                                               path="I_6"></form:checkbox>TL 8 - NO FRONT CAMERA</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_6">Comment</a>
                        </div>
                        <div class="form-check">
                            <form:label class="form-check-label" path="I_7">
                                <form:checkbox onclick="toTl('TL 8P')" class="form-check-input"
                                               path="I_7"></form:checkbox>TL 8P - DIRTY OVER CAMERA</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_7">Comment</a>
                        </div>
                        <div class="form-check">
                            <form:label class="form-check-label" path="I_8">
                                <form:checkbox onclick="toTl('TL 14')" class="form-check-input"
                                               path="I_8"></form:checkbox>TL 14 - NO BACK CAMERA</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_8">Comment</a>
                        </div>
                        <div class="form-check">
                            <form:label class="form-check-label" path="I_9">
                                <form:checkbox onclick="toTl('TL 14P')" class="form-check-input"
                                               path="I_9"></form:checkbox>TL 14P - DIRT GLASS</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_9">Comment</a>
                        </div>
                        <div class="form-check">
                            <form:label class="form-check-label" path="I_10">
                                <form:checkbox onclick="toTl('TL 14A')" class="form-check-input"
                                               path="I_10"></form:checkbox>TL 14A - BROKE CAMERA GLASS</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_10">Comment</a>
                        </div>
                        <div class="form-check">
                            <form:label class="form-check-label" path="I_11">
                                <form:checkbox onclick="toTl('TL 14T')" class="form-check-input"
                                               path="I_11"></form:checkbox>TL 14T - CAMERA FRAME LOOSE</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_11">Comment</a>
                        </div>
                    </div>
                    <div class="tab-pane p-4 fade" id="tab8" role="tabpanel" aria-labelledby="tab8-tab">
                        <div class="form-check">
                            <form:label class="form-check-label" path="I_24">
                                <form:checkbox onclick="toTl('TL 13')" class="form-check-input"
                                               path="I_24"></form:checkbox>TL 13 - NO FLASH</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_24">Comment</a>
                        </div>
                    </div>
                    <div class="tab-pane p-4 fade" id="tab9" role="tabpanel" aria-labelledby="tab9-tab">
                        <div class="form-check">
                            <form:label class="form-check-label"
                                        path="I_23">
                                <form:checkbox onclick="toTl('TL 12')" class="form-check-input"
                                               path="I_23"></form:checkbox>TL 12 - PROXIMITY SENSOR NOT WORKING</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_23">Comment</a>
                        </div>
                    </div>
                    <div class="tab-pane p-4 fade" id="tab10" role="tabpanel" aria-labelledby="tab10-tab">
                        <div class="form-check">
                            <form:label class="form-check-label" path="I_41">
                                <form:checkbox onclick="toTl('TL 38')" class="form-check-input" path="I_41"></form:checkbox>TL 38 - DOCK CHARGE</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_41">Comment</a>
                        </div>
                        <div class="form-check">
                            <form:label class="form-check-label" path="I_42">
                                <form:checkbox onclick="toTl('TL 39')" class="form-check-input"
                                               path="I_42"></form:checkbox>TL 39 - WIRELESS CHARGING</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_42">Comment</a>
                        </div>
                    </div>
                    <div class="tab-pane p-4 fade" id="tab11" role="tabpanel" aria-labelledby="tab11-tab">
                        <div class="form-check">
                            <form:label class="form-check-label" path="I_50">
                                <form:checkbox onclick="toTl('TL 17')" class="form-check-input"
                                               path="I_50"></form:checkbox>TL 17 - NFC Pay</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_50">Comment</a>
                        </div>
                    </div>
                    <div class="tab-pane p-4 fade" id="tab12" role="tabpanel" aria-labelledby="tab12-tab">
                        <div class="form-check">
                            <form:label class="form-check-label" path="I_36">
                                <form:checkbox onclick="toTl('TL 36')" class="form-check-input"
                                               path="I_36"></form:checkbox>TL 36 - SIM NOT DETECTED</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_36">Comment</a>
                        </div>
                        <div class="form-check">
                            <form:label class="form-check-label" path="I_37">
                                <form:checkbox onclick="toTl('TL 36T')" class="form-check-input"
                                               path="I_37"></form:checkbox>TL 36T - SIM NOT DETECTED</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_37">Comment</a>
                        </div>
                    </div>
                    <div class="tab-pane p-4 fade" id="tab13" role="tabpanel" aria-labelledby="tab13-tab">
                        <div class="form-check">
                            <form:label class="form-check-label" path="I_31">
                                <form:checkbox onclick="toTl('TL 26')" class="form-check-input"
                                               path="I_31"></form:checkbox>TL 26 - REBOOT</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_31">Comment</a>
                        </div>
                        <div class="form-check">
                            <form:label class="form-check-label" path="I_32">
                                <form:checkbox onclick="toTl('TL 26T')" class="form-check-input" path="I_32"></form:checkbox>TL 26T - PANIC FULL</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_32">Comment</a>
                        </div>
                    </div>
                    <div class="tab-pane p-4 fade" id="tab14" role="tabpanel" aria-labelledby="tab14-tab">
                        <div class="form-check">
                            <form:label class="form-check-label"
                                        path="I_28">
                                <form:checkbox onclick="toTl('TL 20')" class="form-check-input"
                                               path="I_28"></form:checkbox>TL 20 - IOS UPDATE LOWER THAN STANDARD</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_28">Comment</a>
                        </div>
                        <div class="form-check">
                            <form:label class="form-check-label" path="I_29">
                                <form:checkbox onclick="toTl('TL 32')" class="form-check-input"
                                               path="I_29"></form:checkbox>TL 32 - ITUNES ERROR (NAND)</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_29">Comment</a>
                        </div>
                    </div>
                    <div class="tab-pane p-4 fade" id="tab15" role="tabpanel" aria-labelledby="tab15-tab">
                        <div class="form-check">
                            <form:label class="form-check-label" path="I_1">
                                <form:checkbox onclick="toTl('TL 2')" class="form-check-input"
                                               path="I_1"></form:checkbox>TL 2 - REPLACE BATTERY</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_1">Comment</a>
                        </div>
                        <div class="form-check">
                            <form:label class="form-check-label" path="I_2">
                                <form:checkbox onclick="toTl('TL 2T')" class="form-check-input"
                                               path="I_2"></form:checkbox>TL 2T - NO CHARGE AFTER REPLACE</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_2">Comment</a>
                        </div>
                    </div>
                    <div class="tab-pane p-4 fade" id="tab16" role="tabpanel" aria-labelledby="tab16-tab">
                        <div class="form-check">
                            <form:label class="form-check-label"
                                        path="I_43">
                                <form:checkbox onclick="toTl('TL 40')" class="form-check-input"
                                               path="I_43"></form:checkbox>TL 40 - BACK COVER LOOSE AND GLUED IN SOME AREAS</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_43">Comment</a>
                        </div>
                        <div class="form-check">
                            <form:label class="form-check-label"
                                        path="I_44">
                                <form:checkbox onclick="toTl('TL 40T')" class="form-check-input"
                                               path="I_44"></form:checkbox>TL 40T - BROKEN OR BENT FRAME AND GLASS</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_44">Comment</a>
                        </div>
                    </div>
                    <div class="tab-pane p-4 fade" id="tab17" role="tabpanel" aria-labelledby="tab17-tab">
                        <div class="form-check">
                            <form:label class="form-check-label" path="I_38">
                                <form:checkbox onclick="toTl('TL 37')" class="form-check-input"
                                               path="I_38"></form:checkbox>TL 37 -IMEI IS MISSING</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_38">Comment</a>
                        </div>
                        <div class="form-check">
                            <form:label class="form-check-label" path="I_39">
                                <form:checkbox onclick="toTl('TL 41')" class="form-check-input"
                                               path="I_39"></form:checkbox>TL 41 - LOCKED & BLACKLIST</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_39">Comment</a>
                        </div>
                        <div class="form-check">
                            <form:label class="form-check-label"
                                        path="I_40">
                                <form:checkbox onclick="toTl('TL 42A')" class="form-check-input"
                                               path="I_40"></form:checkbox>TL 42A - NO POWER \ SHORT TO GROUND</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_40">Comment</a>
                        </div>
                    </div>
                    <div class="tab-pane p-4 fade" id="tab18" role="tabpanel" aria-labelledby="tab18-tab">
                        <div class="form-check">
                            <form:label class="form-check-label" path="I_35">
                                <form:checkbox onclick="toTl('TL 30')" class="form-check-input"
                                               path="I_35"></form:checkbox>TL 30 - PHONE GET HOT IN IDLE</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_35">Comment</a>
                        </div>
                    </div>
                    <div class="tab-pane p-4 fade" id="tab19" role="tabpanel" aria-labelledby="tab19-tab">
                        <div class="form-check">
                            <form:label class="form-check-label"
                                        path="I_45">
                                <form:checkbox onclick="toTl('TL 42')" class="form-check-input"
                                               path="I_45"></form:checkbox>TL 42 - ISSUE NOT LISTED THAT NEED DIAGNOSIS</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_45">Comment</a>
                        </div>
                    </div>
                    <div class="tab-pane p-4 fade" id="tab20" role="tabpanel" aria-labelledby="tab20-tab">
                        <div class="form-check">
                            <form:label class="form-check-label"
                                        path="I_30">
                                <form:checkbox onclick="toTl('TL 24')" class="form-check-input"
                                               path="I_30"></form:checkbox>TL 24 - CLEAR SIGN OF MOISTURE AND RUST INSIDE</form:label>
                            <a class="btn btn-outline-primary" target="_blank"
                               href="/comment/${test.imei}/I_30">Comment</a>
                        </div>
                    </div>
                </div>
                <div class="form-group text-end">
                    <input type="submit" class="btn btn-outline-primary"/>
                </div>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
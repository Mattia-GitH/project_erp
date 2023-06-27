<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>

    <link href="/style.css" rel="stylesheet">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">

    <meta charset="UTF-8">

    <style>
        .container {
            max-width: 1580px !important;
        }

        div#performanceITC {
            margin-left: 45px;
        }

        div#performanceTesting {
            margin-left: 45px;
        }

        div#performanceFixing {
            margin-left: 45px;
        }

        div#performanceTechlab {
            margin-left: 45px;
        }

        div#performancePacking {
            margin-left: 45px;
        }

        .phase {
            max-width: 300px;
        }

        div#operatorITC {
            border: solid #ffc107e0;
            border-radius: 30px;
            box-shadow: 1px 1px 20px 0px yellow;
            margin: 0px 0px 50px 0px;
        }

        div#operatorFixing {
            border: solid darkgreen;
            border-radius: 30px;
            box-shadow: 1px 1px 20px 0px green;
            margin: 0px 0px 50px 0px;
        }

        div#operatorTechlab {
            border: solid dodgerblue;
            border-radius: 30px;
            box-shadow: 1px 1px 20px 0px dodgerblue;
            margin: 0px 0px 50px 0px;
        }

        div#operatorTesting {
            border: solid orangered;
            border-radius: 30px;
            box-shadow: 1px 1px 20px 0px orange;
            margin: 0px 0px 50px 0px;
        }

        div#operatorPacking {
            border: solid blueviolet;
            border-radius: 30px;
            box-shadow: 1px 1px 20px 0px violet;
            margin: 0px 0px 50px 0px;
        }

    </style>

    <title>Reports</title>

    <script src="https://cdn.plot.ly/plotly-latest.min.js"></script>

</head>
<body>
<jsp:include page="header.jsp"/>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css"/>

<c:set var="warehouse"
       value="${itcToDo + fixingToDo + testingToDo + techlabToDo + packingToDo + scrapsToDo + stockToDo}"/>
<div class="container">
    <div class="row justify-content-md-center">
        <H3>Work Days: ${workDays}</H3>
        <input type="text" name="daterange"/>
        <form id="dates" action="${pageContext.request.contextPath}/reports">
            <input type="hidden" id="start" name="start">
            <input type="hidden" id="end" name="end">
        </form>
        <script>
            $(function () {
                $('input[name="daterange"]').daterangepicker({
                    opens: 'left'
                }, function (start, end, label) {
                    console.log("A new date selection was made: " + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));
                    $("#start").val(start.format('YYYY-MM-DD'));
                    $("#end").val(end.format('YYYY-MM-DD'));
                    $("#dates").submit();
                });
            });
        </script>
    </div>


    <div class="row">
        <div class="col-3">
            <div style="text-align: center;">
                <p>ITC</p>
            </div>
            <div id='itc'></div>
            <script>
                var gd = document.getElementById('itc');
                var data = [{
                    type: 'funnel',
                    y: ["Warehouse", "To Do", "Done"],
                    x: [${warehouse}, ${itcToDo}, ${itcDone}],
                    hoverinfo: 'x+percent previous+percent initial'
                }];

                var layout = {margin: {l: 100, t: 0}, width: 400, height: 180}

                Plotly.newPlot('itc', data, layout);
            </script>
        </div>
        <div class="col-3">
            <div style="text-align: center;">
                <p>Fixing</p>
            </div>
            <div id='fixing'></div>
            <script>
                var gd = document.getElementById('fixing');
                var data = [{
                    type: 'funnel',
                    y: ["To Do", "Done"],
                    x: [${fixingToDo}, ${fixingDone}],
                    hoverinfo: 'x+percent previous+percent initial'
                }];

                var layout = {margin: {l: 100, t: 0}, width: 400, height: 180}

                Plotly.newPlot('fixing', data, layout);
            </script>
        </div>
        <div class="col-3">
            <div style="text-align: center;">
                <p>Techlab</p>
            </div>
            <div id='techlab'></div>
            <script>
                var gd = document.getElementById('techlab');
                var data = [{
                    type: 'funnel',
                    y: ["To Do", "Done"],
                    x: [${techlabToDo}, ${techlabDone}],
                    hoverinfo: 'x+percent previous+percent initial'
                }];

                var layout = {margin: {l: 100, t: 0}, width: 400, height: 180}

                Plotly.newPlot('techlab', data, layout);
            </script>
        </div>
        <div class="col-3">
            <div style="text-align: center;">
                <p>Testing</p>
            </div>
            <div id='testing'></div>
            <script>
                var gd = document.getElementById('testing');
                var data = [{
                    type: 'funnel',
                    y: ["To Do", "Done"],
                    x: [${testingoDo}, ${testingDone}],
                    hoverinfo: 'x+percent previous+percent initial'
                }];

                var layout = {margin: {l: 100, t: 0}, width: 400, height: 180}

                Plotly.newPlot('testing', data, layout);
            </script>
        </div>
    </div>
    <div class="row justify-content-md-center">
        <div class="col-3">
            <div style="text-align: center;">
                <p>Packing</p>
            </div>
            <div id='packing'></div>
            <script>
                var gd = document.getElementById('packing');
                var data = [{
                    type: 'funnel',
                    y: ["Warehouse", "To Do", "Done"],
                    x: [${warehouse}, ${packingToDo}, ${packingDone}],
                    hoverinfo: 'x+percent previous+percent initial'
                }];

                var layout = {margin: {l: 100, t: 0}, width: 400, height: 180}

                Plotly.newPlot('packing', data, layout);
            </script>
        </div>
        <div class="col-3">
            <div style="text-align: center;">
                <p>Stock</p>
            </div>
            <div id='stock'></div>
            <script>
                var gd = document.getElementById('stock');
                var data = [{
                    type: 'funnel',
                    y: ["Packing Done", "To Do", "Done"],
                    x: [${packingDone}, ${stockToDo}, ${stockDone}],
                    hoverinfo: 'x+percent previous+percent initial'
                }];

                var layout = {margin: {l: 100, t: 0}, width: 400, height: 180}

                Plotly.newPlot('stock', data, layout);
            </script>
        </div>
    </div>
    <hr>

    <div class="row justify-content-md-center">
        <div class="col-12">
            <div id="myPlotPhaseQty" style="width:100%;max-width:900px"></div>
            <script>
                var xArray = ${phaseList};
                var yArray = ${pQty};

                var layout = {title: "Production"};

                var data = [{labels: xArray, values: yArray, hole: .4, type: "pie"}];

                Plotly.newPlot("myPlotPhaseQty", data, layout);
            </script>
        </div>
    </div>
    <hr>

    <div class="row justify-content-md-center">
        <div class="col-4" id="containerITC">
            <div>
                <div id="performanceITC" style="width:100%;max-width:400px"></div>
                <script>
                    let workDays = ${workDays};

                    var xArray = ${operatorListITC};
                    let qtyITCArray = ${oQtyITC};

                    let totQty = 0;
                    let target = xArray.length * 100 * workDays;

                    for (let i = 0; i < qtyITCArray.length; i++) {
                        totQty = totQty + qtyITCArray[i];
                    }

                    var data = [
                        {
                            type: "indicator",
                            value: totQty,
                            delta: {reference: target},
                            gauge: {axis: {visible: true, range: [0, target]}},
                            domain: {row: 0, column: 0}
                        }];

                    let fteITC = ${operatorListITC.size()};

                    var layout = {
                        width: 300,
                        height: 270,
                        margin: {t: 25, b: 25, l: 25, r: 30},
                        grid: {rows: 0, columns: 2, pattern: "independent"},
                        template: {
                            data: {
                                indicator: [
                                    {
                                        title: {text: "ITC<br><span style='font-size:0.8em;color:gray'>FTE:  " + fteITC + "</span>"},
                                        mode: "number+delta+gauge",
                                        delta: {reference: 2}
                                    }
                                ]
                            }
                        }
                    };

                    Plotly.newPlot('performanceITC', data, layout);
                </script>

                <div id="myPlotOperatorQtyITC" style="width:100%;max-width:400px"></div>
                <script>
                    var xArray = ${operatorListITC};
                    var yArray = ${oQtyITC};

                    var data = [{
                        x: xArray,
                        y: yArray,
                        type: "bar"
                    }];

                    Plotly.newPlot("myPlotOperatorQtyITC", data);
                </script>
            </div>
        </div>

        <div class="col-4" id="containerFixing">
            <div>
                <div id="performanceFixing" style="width:100%;max-width:400px"></div>
                <script>
                    var fixingArray = ${operatorListFixing};
                    let qtyFixingArray = ${oQtyFixing};

                    let totQtyFixing = 0;
                    let targetFixing = fixingArray.length * 40 * workDays;

                    for (let i = 0; i < qtyFixingArray.length; i++) {
                        totQtyFixing = totQtyFixing + qtyFixingArray[i];
                    }

                    var dataFixing = [
                        {
                            type: "indicator",
                            value: totQtyFixing,
                            delta: {reference: targetFixing},
                            gauge: {axis: {visible: true, range: [0, targetFixing]}},
                            domain: {row: 0, column: 0}
                        }];

                    let fteFixing = ${operatorListFixing.size()};

                    var layoutFixing = {
                        width: 300,
                        height: 270,
                        margin: {t: 25, b: 25, l: 25, r: 30},
                        grid: {rows: 0, columns: 2, pattern: "independent"},
                        template: {
                            data: {
                                indicator: [
                                    {
                                        title: {text: "Fixing<br><span style='font-size:0.8em;color:gray'>FTE:  " + fteFixing + "</span>"},
                                        mode: "number+delta+gauge",
                                        delta: {reference: 2}
                                    }
                                ]
                            }
                        }
                    };

                    Plotly.newPlot('performanceFixing', dataFixing, layoutFixing);
                </script>

                <div id="myPlotOperatorQtyFixing" style="width:100%;max-width:400px"></div>
                <script>
                    var xArray = ${operatorListFixing};
                    var yArray = ${oQtyFixing};

                    var data = [{
                        x: xArray,
                        y: yArray,
                        type: "bar"
                    }];

                    Plotly.newPlot("myPlotOperatorQtyFixing", data);
                </script>
            </div>
        </div>

        <div class="col-4" id="containerTesting">
            <div>
                <div id="performanceTesting" style="width:100%;max-width:400px"></div>
                <script>
                    var testingArray = ${operatorListTesting};
                    let qtyTestingArray = ${oQtyTesting};

                    let totQtyTesting = 0;
                    let targetTesting = testingArray.length * 100 * workDays;

                    for (let i = 0; i < qtyTestingArray.length; i++) {
                        totQtyTesting = totQtyTesting + qtyTestingArray[i];
                    }

                    var dataTesting = [
                        {
                            type: "indicator",
                            value: totQtyTesting,
                            delta: {reference: targetTesting},
                            gauge: {axis: {visible: true, range: [0, targetTesting]}},
                            domain: {row: 0, column: 0}
                        }];

                    let fteTesting = ${operatorListTesting.size()};

                    var layoutTesting = {
                        width: 300,
                        height: 270,
                        margin: {t: 25, b: 25, l: 25, r: 30},
                        grid: {rows: 0, columns: 2, pattern: "independent"},
                        template: {
                            data: {
                                indicator: [
                                    {
                                        title: {text: "Testing<br><span style='font-size:0.8em;color:gray'>FTE:  " + fteTesting + "</span>"},
                                        mode: "number+delta+gauge",
                                        delta: {reference: 2}
                                    }
                                ]
                            }
                        }
                    };

                    Plotly.newPlot('performanceTesting', dataTesting, layoutTesting);
                </script>

                <div id="myPlotOperatorQtyTesting" style="width:100%;max-width:400px"></div>
                <script>
                    var xArray = ${operatorListTesting};
                    var yArray = ${oQtyTesting};

                    var data = [{
                        x: xArray,
                        y: yArray,
                        type: "bar"
                    }];

                    Plotly.newPlot("myPlotOperatorQtyTesting", data);
                </script>
            </div>
        </div>
    </div>
    <div class="row justify-content-md-center">
        <div class="col-4" id="containerTechlab">
            <div>
                <div id="performanceTechlab" style="width:100%;max-width:400px"></div>
                <script>
                    var techlabArray = ${operatorListTechlab};
                    let qtyTechlabArray = ${oQtyTechlab};

                    let totQtyTechlab = 0;
                    let targetTechlab = techlabArray.length * 40 * workDays;

                    for (let i = 0; i < qtyTechlabArray.length; i++) {
                        totQtyTechlab = totQtyTechlab + qtyTechlabArray[i];
                    }

                    var dataTechlab = [
                        {
                            type: "indicator",
                            value: totQtyTechlab,
                            delta: {reference: targetTechlab},
                            gauge: {axis: {visible: true, range: [0, targetTechlab]}},
                            domain: {row: 0, column: 0}
                        }];

                    let fteTechlab = ${operatorListTechlab.size()};

                    var layoutTechlab = {
                        width: 300,
                        height: 270,
                        margin: {t: 25, b: 25, l: 25, r: 30},
                        grid: {rows: 0, columns: 2, pattern: "independent"},
                        template: {
                            data: {
                                indicator: [
                                    {
                                        title: {text: "Techlab<br><span style='font-size:0.8em;color:gray'>FTE:  " + fteTechlab + "</span>"},
                                        mode: "number+delta+gauge",
                                        delta: {reference: 2}
                                    }
                                ]
                            }
                        }
                    };

                    Plotly.newPlot('performanceTechlab', dataTechlab, layoutTechlab);
                </script>

                <div id="myPlotOperatorQtyTechlab" style="width:100%;max-width:400px"></div>
                <script>
                    var xArray = ${operatorListTechlab};
                    var yArray = ${oQtyTechlab};

                    var data = [{
                        x: xArray,
                        y: yArray,
                        type: "bar"
                    }];

                    Plotly.newPlot("myPlotOperatorQtyTechlab", data);
                </script>
            </div>
        </div>

        <div class="col-4" id="containerPacking">
            <div>
                <div id="performancePacking" style="width:100%;max-width:400px"></div>
                <script>
                    var packingArray = ${operatorListPacking};
                    let qtyPackingArray = ${oQtyPacking};

                    let totQtyPacking = 0;
                    let targetPacking = packingArray.length * 100 * workDays;

                    for (let i = 0; i < qtyPackingArray.length; i++) {
                        totQtyPacking = totQtyPacking + qtyPackingArray[i];
                    }

                    var dataPacking = [
                        {
                            type: "indicator",
                            value: totQtyPacking,
                            delta: {reference: targetPacking},
                            gauge: {axis: {visible: true, range: [0, targetPacking]}},
                            domain: {row: 0, column: 0}
                        }];

                    let ftePacking = ${operatorListPacking.size()};

                    var layoutPacking = {
                        width: 300,
                        height: 270,
                        margin: {t: 25, b: 25, l: 25, r: 30},
                        grid: {rows: 0, columns: 2, pattern: "independent"},
                        template: {
                            data: {
                                indicator: [
                                    {
                                        title: {text: "Packing<br><span style='font-size:0.8em;color:gray'>FTE:  " + ftePacking + "</span>"},
                                        mode: "number+delta+gauge",
                                        delta: {reference: 2}
                                    }
                                ]
                            }
                        }
                    };

                    Plotly.newPlot('performancePacking', dataPacking, layoutPacking);
                </script>

                <div id="myPlotOperatorQtyPacking" style="width:100%;max-width:400px"></div>
                <script>
                    var xArray = ${operatorListPacking};
                    var yArray = ${oQtyPacking};

                    var data = [{
                        x: xArray,
                        y: yArray,
                        type: "bar"
                    }];

                    Plotly.newPlot("myPlotOperatorQtyPacking", data);
                </script>
            </div>
        </div>
    </div>
    <hr>
    <div id="operatorITC" class="row justify-content-md-center">
        <h2>ITC</h2>
        <h4>FTE: ${operatorListITC.size()}</h4>
        <H3>Work Days: ${workDays}</H3>

        <c:forEach items="${operatorListITC}" varStatus="st">
            <c:set var="operator"
                   value="${fn:substring(operatorListITC[st.index], 1, fn:length(operatorListITC[st.index]) - 1)}  "/>
            <div class="phase">
                <div id="performanceITC${operator}" style="width:100%;max-width:400px"></div>
                <script>
                    var dataITC${operator} = [
                        {
                            type: "indicator",
                            value: ${oQtyITC[st.index]},
                            delta: {reference: 100 * workDays},
                            gauge: {axis: {visible: true, range: [0, 100 * workDays]}},
                            domain: {row: 0, column: 0}
                        }];

                    var layoutITC${operator} = {
                        width: 200,
                        height: 175,
                        margin: {t: 25, b: 25, l: 25, r: 30},
                        grid: {rows: 0, columns: 2, pattern: "independent"},
                        template: {
                            data: {
                                indicator: [
                                    {
                                        title: {text: "${operator}"},
                                        mode: "number+delta+gauge",
                                        delta: {reference: 2}
                                    }
                                ]
                            }
                        }
                    };

                    Plotly.newPlot('performanceITC${operator}', dataITC${operator}, layoutITC${operator});
                </script>
            </div>
        </c:forEach>
    </div>

    <div id="operatorFixing" class="row justify-content-md-center">
        <h2>Fixing</h2>
        <h4>FTE: ${operatorListFixing.size()}</h4>
        <H3>Work Days: ${workDays}</H3>

        <c:forEach items="${operatorListFixing}" varStatus="st">
            <c:set var="operator"
                   value="${fn:substring(operatorListFixing[st.index], 1, fn:length(operatorListFixing[st.index]) - 1)}  "/>
            <div class="phase">
                <div id="performanceFixing${operator}" style="width:100%;max-width:400px"></div>
                <script>
                    var dataFixing${operator} = [
                        {
                            type: "indicator",
                            value: ${oQtyFixing[st.index]},
                            delta: {reference: 40 * workDays},
                            gauge: {axis: {visible: true, range: [0, 40 * workDays]}},
                            domain: {row: 0, column: 0}
                        }];

                    var layoutFixing${operator} = {
                        width: 200,
                        height: 175,
                        margin: {t: 25, b: 25, l: 25, r: 30},
                        grid: {rows: 0, columns: 2, pattern: "independent"},
                        template: {
                            data: {
                                indicator: [
                                    {
                                        title: {text: "${operator}"},
                                        mode: "number+delta+gauge",
                                        delta: {reference: 2}
                                    }
                                ]
                            }
                        }
                    };

                    Plotly.newPlot('performanceFixing${operator}', dataFixing${operator}, layoutFixing${operator});
                </script>
            </div>
        </c:forEach>
    </div>

    <div id="operatorTechlab" class="row justify-content-md-center"fwa>
        <h2>Techlab</h2>
        <h4>FTE: ${operatorListTechlab.size()}</h4>
        <H3>Work Days: ${workDays}</H3>

        <c:forEach items="${operatorListTechlab}" varStatus="st">
            <c:set var="operator"
                   value="${fn:substring(operatorListTechlab[st.index], 1, fn:length(operatorListTechlab[st.index]) - 1)}  "/>
            <div class="phase">
                <div id="performanceTechlab${operator}" style="width:100%;max-width:400px"></div>
                <script>
                    var dataTechlab${operator} = [
                        {
                            type: "indicator",
                            value: ${oQtyTechlab[st.index]},
                            delta: {reference: 20 * workDays},
                            gauge: {axis: {visible: true, range: [0, 20 * workDays]}},
                            domain: {row: 0, column: 0}
                        }];

                    var layoutTechlab${operator} = {
                        width: 200,
                        height: 175,
                        margin: {t: 25, b: 25, l: 25, r: 30},
                        grid: {rows: 0, columns: 2, pattern: "independent"},
                        template: {
                            data: {
                                indicator: [
                                    {
                                        title: {text: "${operator}"},
                                        mode: "number+delta+gauge",
                                        delta: {reference: 2}
                                    }
                                ]
                            }
                        }
                    };

                    Plotly.newPlot('performanceTechlab${operator}', dataTechlab${operator}, layoutTechlab${operator});
                </script>
            </div>
        </c:forEach>
    </div>

    <div id="operatorTesting" class="row justify-content-md-center">
        <h2>Testing</h2>
        <h4>FTE: ${operatorListTesting.size()}</h4>
        <H3>Work Days: ${workDays}</H3>

        <c:forEach items="${operatorListTesting}" varStatus="st">
            <c:set var="operator"
                   value="${fn:substring(operatorListTesting[st.index], 1, fn:length(operatorListTesting[st.index]) - 1)}  "/>
            <div class="phase">
                <div id="performanceTesting${operator}" style="width:100%;max-width:400px"></div>
                <script>
                    var dataTesting${operator} = [
                        {
                            type: "indicator",
                            value: ${oQtyTesting[st.index]},
                            delta: {reference: 100 * workDays},
                            gauge: {axis: {visible: true, range: [0, 100 * workDays]}},
                            domain: {row: 0, column: 0}
                        }];

                    var layoutTesting${operator} = {
                        width: 200,
                        height: 175,
                        margin: {t: 25, b: 25, l: 25, r: 30},
                        grid: {rows: 0, columns: 2, pattern: "independent"},
                        template: {
                            data: {
                                indicator: [
                                    {
                                        title: {text: "${operator}"},
                                        mode: "number+delta+gauge",
                                        delta: {reference: 2}
                                    }
                                ]
                            }
                        }
                    };

                    Plotly.newPlot('performanceTesting${operator}', dataTesting${operator}, layoutTesting${operator});
                </script>
            </div>
        </c:forEach>

    </div>

    <div id="operatorPacking" class="row justify-content-md-center">
        <h2>Packing</h2>
        <h4>FTE: ${operatorListPacking.size()}</h4>
        <H3>Work Days: ${workDays}</H3>

        <c:forEach items="${operatorListPacking}" varStatus="st">
            <c:set var="operator"
                   value="${fn:substring(operatorListPacking[st.index], 1, fn:length(operatorListPacking[st.index]) - 1)}  "/>
            <div class="phase">
                <div id="performancePacking${operator}" style="width:100%;max-width:400px"></div>
                <script>
                    var dataPacking${operator} = [
                        {
                            type: "indicator",
                            value: ${oQtyPacking[st.index]},
                            delta: {reference: 200 * workDays},
                            gauge: {axis: {visible: true, range: [0, 200 * workDays]}},
                            domain: {row: 0, column: 0}
                        }];

                    var layoutPacking${operator} = {
                        width: 200,
                        height: 190,
                        margin: {t: 25, b: 25, l: 25, r: 30},
                        grid: {rows: 0, columns: 2, pattern: "independent"},
                        template: {
                            data: {
                                indicator: [
                                    {
                                        title: {text: "${operator}"},
                                        mode: "number+delta+gauge",
                                        delta: {reference: 2}
                                    }
                                ]
                            }
                        }
                    };

                    Plotly.newPlot('performancePacking${operator}', dataPacking${operator}, layoutPacking${operator});
                </script>
            </div>
        </c:forEach>

    </div>
    <hr>
    <div class="row" style="margin:100px">
        <table class="table table-striped">
            <thead>
            <th>Operator</th>
            <th>Start</th>
            <th>Finish</th>
            <th>Time average</th>
            </thead>
            <c:forEach items="${analyticsFistLast}" var="firstLast">
                <c:forEach items="${analyticsAvg}" var="analyticsAvg">
                    <c:if test="${firstLast.param == analyticsAvg.param}">
                        <tr>
                            <td>${firstLast.param}</td>
                            <td>${firstLast.first}</td>
                            <td>${firstLast.last}</td>
                            <td>${analyticsAvg.avgTime}</td>
                        </tr>
                    </c:if>
                </c:forEach>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>

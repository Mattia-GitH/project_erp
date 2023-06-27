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
    <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>Planning</title>

    <script type="text/javascript">
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
    </script>
</head>
<body>
<jsp:include page="../header.jsp"/>
<script>
    function filter() {
        let sku = document.getElementById("sku").value;
        let model = document.getElementById("model").value;
        let gb = document.getElementById("gb").value;
        let color = document.getElementById("color").value;

        if (sku === '') {
            let sFilter = "";
            if (model !== "") sFilter = sFilter + model.substring(7).replaceAll(" ", "").toUpperCase();
            if (gb !== "") sFilter = sFilter + gb;
            if (color !== "") sFilter = sFilter + color.replaceAll(" ", "").toUpperCase()
            document.getElementById('filter').value = "%" + sFilter + "%";
        } else {
            document.getElementById('filter').value = "%" + sku + "%";
        }
    }
</script>
<div class="container">
    <div class="row">
        <div class="col-2">
            <form:form action="${pageContext.request.contextPath}/planning">
                <input type="hidden" class="form-control" id="filter" name="filter"/>
                <input style="width: 100%" class="btn btn-outline-primary" type="submit">
                <br>
                <label>Status: </label>
                <select class="form-control" name="status">
                    <option value=""></option>
                    <c:forEach items="${phases}" var="phase">
                        <option value="${phase.phase}">${phase.phase}</option>
                    </c:forEach>
                </select>
            </form:form>
            <label>SKU: </label>
            <select onchange="filter()" id="sku" class="selectpicker form-control">
                <option value=""></option>
                <c:forEach items="${sku}" var="sku">
                    <option value="${sku}">${sku}</option>
                </c:forEach>
            </select>
            <label>Model: </label>
            <select onchange="filter()" id="model" class="selectpicker form-control">
                <option value=""></option>
                <c:forEach items="${phoneModel}" var="model">
                    <option value="${model}">${model}</option>
                </c:forEach>
            </select>
            <label>GB: </label>
            <select onchange="filter()" id="gb" class="selectpicker form-control">
                <option value=""></option>
                <c:forEach items="${gbPhone}" var="gbPhone">
                    <option value="${gbPhone}">${gbPhone}</option>
                </c:forEach>
            </select>
            <label>Color: </label>
            <select onchange="filter()" id="color" class="selectpicker form-control">
                <option value=""></option>
                <c:forEach items="${color}" var="color">
                    <option value="${color}">${color}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-7">
            <h1>Planning</h1>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Status</th>
                        <th>Qty</th>
                        <th>SKU</th>
                        <th>Model</th>
                        <th>GB</th>
                        <th>Color</th>
                        <th>Grade</th>
                        <th>Add to plan</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${planningView}" var="list">
                        <form:form modelAttribute="plan" action="/planning">
                            <tr>
                                <td><c:if test="${list.status == null}"><c:set var="status"
                                                                               value="ITC"/> ITC</c:if><c:if
                                        test="${list.status != null}"><c:set var="status"
                                                                             value="${list.status}"/>${list.status}
                                </c:if></td>
                                <td>${list.qty}</td>
                                <td>${list.sku}</td>
                                <td>${list.model}</td>
                                <td>${list.gb}</td>
                                <td>${list.color}</td>
                                <td>${list.grade}</td>

                                <form:hidden path="status" value="${status}"/>
                                <form:hidden path="sku" value="${list.sku}"/>
                                <form:hidden path="qty" value="${list.qty}"/>

                                <td><input type="submit" class="btn btn-outline-primary" value="add"></td>
                            </tr>
                        </form:form>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col-3">
            <h4><a href="${pageContext.request.contextPath}/plan_preview">Plan Preview</a></h4>
            <div class="table-responsive">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Status</th>
                        <th>SKU</th>
                        <th>Grade</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${planPreview}" var="list">
                        <tr>
                            <td><c:if test="${list.status == null}"><c:set var="status" value="ITC"/> ITC</c:if><c:if
                                    test="${list.status != null}"><c:set var="status"
                                                                         value="${list.status}"/>${list.status}
                            </c:if></td>
                            <td>${list.sku}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <title>Plan Home</title>

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
    <style>
        button#btnRemove {
            width: 210px;
            height: 90px;
        }

        .container{
            max-width: 95%;
        }
    </style>
</head>
<body onload="hide()">
<jsp:include page="../header.jsp"/>
<script src="${pageContext.request.contextPath}/JS/addOperator.js"></script>
<script>
    function hide() {
        $('.delete').css('display', 'none');
    }

    let x = 0;

    function deletePlan() {
        if (x % 2 === 0) {
            $('.delete').css('display', 'block');
            x++
        } else {
            $('.delete').css('display', 'none');
            x++
        }

    }
</script>

<div class="container">
    <div class="row">
        <div class="col-2">
            <form:form action="${pageContext.request.contextPath}/planned">
                <div>
                    <label for="sfDate">Date:</label>
                    <input class="form-control" id="sfDate" name="sfDate" type="date"/>
                </div>
                <div>
                    <label for="fStatus">Status:</label>
                    <select class="form-control" id="fStatus" name="fStatus">
                        <option value=""></option>
                        <c:forEach items="${phases}" var="phase">
                            <option value="${phase.phase}">${phase.phase}</option>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    <label for="fSku">SKU:</label>
                    <select id="fSku" class="form-control" name="fSku">
                        <option value=""></option>
                        <c:forEach items="${planPreview}" var="list">
                            <option value="${list.sku}">${list.sku}</option>
                        </c:forEach>
                    </select>
                </div>
                <input class="btn btn-outline-primary" value="filter" type="submit">
            </form:form>
        </div>
        <div class="col-5">
            <h1>Planning
                <button onclick="deletePlan()" class="btn btn-outline-danger" type="button">Edit</button>
            </h1>

            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th class="delete">delete</th>
                        <th>Date</th>
                        <th>Status</th>
                        <th>Qty</th>
                        <th>SKU</th>
                        <th>details</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${planned}" var="list">
                        <fmt:formatDate var="date" pattern="yyyy-MM-dd"
                                        value="${list.date}"/>
                        <tr>
                            <td class="delete">
                                <a class="btn btn-outline-danger"
                                   href="${pageContext.request.contextPath}/deletePlan/${list.date}/${list.status}/${list.sku}">Delete</a>
                            </td>
                            <td>${date}</td>
                            <td>${list.status}</td>
                            <td>${list.qty}</td>
                            <td>${list.sku}</td>
                            <td><a href="${pageContext.request.contextPath}/planned/${list.id}">details</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <c:if test="${id != null}">
        <div class="col-5">

            <c:set var="qtyPlanned"/>
            <div class="table-responsive">
                <c:forEach items="${plannedDetails}" var="detail">
                    <c:forEach items="${operators}" var="operator">
                        <c:if test="${operator == detail.operator}">
                            <c:set var="qtyPlanned" value="${qtyPlanned + detail.qty}"/>
                        </c:if>
                    </c:forEach>
                </c:forEach>
                <c:forEach items="${plannedDetails}" var="progress">
                    <c:set var="qtyPlanned" value="${qtyPlanned + progress.qty}"/>
                </c:forEach>

                <c:if test="${qtyAvailable < qtyPlanned}">
                    <h4 style="color: red">
                        Available QTY: ${qtyAvailable}
                        Planned QTY: ${qtyPlanned}
                    </h4>
                </c:if>
                <c:if test="${qtyAvailable == qtyPlanned || qtyAvailable > qtyPlanned}">
                    <h4 style="color: green">
                        Available QTY: ${qtyAvailable}
                        Planned QTY: ${qtyPlanned}
                    </h4>
                </c:if>


                <div class="alert alert-danger" id="tooQty" role="alert" style="display: none">
                    Too quantity assigned
                </div>

                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Date</th>
                        <th>Status</th>
                        <th>Done/Qty</th>
                        <th>SKU</th>
                        <th>Operator</th>
                        <th>Edit</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${plannedDetails}" var="detail">
                        <fmt:formatDate var="date" pattern="yyyy-MM-dd"
                                        value="${detail.date}"/>
                        <tr>
                            <td>${date}</td>
                            <td>${detail.status}</td>
                            <c:if test="${detail.operator == null}">
                                <td id="qtyToAssign">${detail.qty}</td>
                            </c:if>
                            <c:if test="${detail.operator != null}">
                                <c:forEach items="${planProgress}" var="progress">
                                    <c:if test="${progress.sku == detail.sku && progress.status == detail.status && progress.operator == detail.operator}">
                                        <c:set var="done" value="${progress.done}" />
                                    </c:if>
                                </c:forEach>

                                <c:choose>
                                    <c:when test="${done >= detail.qty}">
                                        <td style="color: green">${done}/${detail.qty}</>
                                    </c:when>
                                    <c:when test="${done < detail.qty}">
                                        <td style="color: orange">${done}/${detail.qty}</>
                                    </c:when>
                                    <c:when test="${done == null}">
                                        <td style="color: red">0/${detail.qty}</>
                                    </c:when>
                                </c:choose>
                            </c:if>
                            <td>${detail.sku}</td>
                            <td><c:if test="${detail.operator == null}">TO ASSIGN</c:if>${detail.operator}</td>
                            <td>
                                <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                        data-bs-target="#${detail.id}Modal">Edit
                                </button>
                            </td>
                        </tr>

                        <div class="modal fade" id="${detail.id}Modal" tabindex="-1"
                             aria-labelledby="${detail.id}ModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h1 class="modal-title fs-5" id="${detail.id}ModalLabel">Edit plan</h1>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <form action="editPlan/${detail.id}" name="editPlan">
                                            <input type="hidden" name="id" value="${detail.id}">
                                            <label>Qty
                                                <input class="form-control" type="number" name="qty"
                                                       value="${detail.qty}"></label>
                                            <label>Operator
                                                <select class="form-control" name="operator">
                                                    <option value="${detail.operator}">${detail.operator}</option>
                                                    <c:forEach items="${users}" var="user">
                                                        <c:if test="${user.roles == 'ROLE_LINE'}">
                                                            <option value="${user.username}">${user.username}</option>
                                                        </c:if>
                                                    </c:forEach>
                                                </select>
                                            </label>
                                        </form>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                                        </button>
                                        <button type="button" onclick="document.forms['editPlan'].submit()"
                                                class="btn btn-primary">Save changes
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>


                    </c:forEach>
                    </tbody>
                </table>

                <form:form modelAttribute="plan" action="/planOperator/${id}">
                    <div>
                        <c:forEach items="${plannedDetails}" var="detail">
                            <c:if test="${detail.operator == null}">
                                <button class="btn btn-outline-primary" onclick="add()" type="button">Add Operator
                                </button>
                                <input class="btn btn-outline-primary" type="submit" value="Save"/>
                            </c:if>
                        </c:forEach>
                    </div>
                    <br>
                    <div class="plan" id="planTable">
                        <select id="operator" style="display: none">
                            <c:forEach items="${users}" var="user">
                                <c:if test="${user.roles == 'ROLE_LINE'}">
                                    <option value="${user.username}">${user.username}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </div>
                    <div id="remove">

                    </div>
                </form:form>
            </div>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>

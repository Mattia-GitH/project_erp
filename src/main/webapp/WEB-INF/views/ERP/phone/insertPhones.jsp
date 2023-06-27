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

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>

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
        .align-right {
            text-align: right;
            border: 0;
        }

        i.bi.bi-plus-circle:hover {
            color: red;
        }

        i.bi.bi-plus-circle {
            transition: 0.3s;
        }
    </style>

    <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet">

    <meta charset="UTF-8">
    <title>Insert IMEI</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-4">
            <p>Date: <span id="oDate">${order.date}</span><i class="bi bi-calendar"
                                                             style="padding-left: 10px; color: green"
                                                             onclick="$('#dateModal').modal('show');"></i></p>
            <p>Order number: ${order.number_order}</p>
            <p>Supplier: ${supplier.supplier}</p>
            <p>QTY: ${order.qty} <i class="bi bi-plus-circle"  onclick="$('#qtyModal').modal('show');" ></i></p>
        </div>
        <div class="col-8">
            <h1>Insert IMEI</h1>
            <fmt:parseDate pattern="yyyy-MM-dd" value="${order.date}" var="date"/>
            <fmt:formatDate pattern="yyyy-MM-dd"
                            value="${date}" var="date2"/>

            <form:form method="POST"
                       action="${pageContext.request.contextPath}/save_phones/${supplier.id}/${date2}/${order.number_order}/${order.id}"
                       modelAttribute="phones">
                <table class="table table-striped">
                    <div class="align-right">
                        <input type="submit" class="btn btn-outline-primary" value="Save"/>
                    </div>
                    <form:select id="color" class="selectpicker form-control" path="color" required="true">
                        <form:option value=""></form:option>
                        <c:choose>
                            <c:when test="${article.model == 'iPhone SE' || article.model == 'iPhone SE3'}">
                                <form:option value="Black">Black</form:option>
                                <form:option value="White">White</form:option>
                                <form:option value="Red">Red</form:option>
                            </c:when>
                            <c:when test="${article.model == 'iPhone X'}">
                                <form:option value="Silver">Silver</form:option>
                                <form:option value="Black">Black</form:option>
                            </c:when>
                            <c:when test="${article.model == 'iPhone XS' || article.model == 'iPhone XSM'}">
                                <form:option value="Silver">Silver</form:option>
                                <form:option value="Black">Black</form:option>
                                <form:option value="Gold">Gold</form:option>
                            </c:when>
                            <c:when test="${article.model == 'iPhone XR'}">
                                <form:option value="Blue">Blue</form:option>
                                <form:option value="Coral">Coral</form:option>
                                <form:option value="Yellow">Yellow</form:option>
                                <form:option value="Red">Red</form:option>
                                <form:option value="White">White</form:option>
                                <form:option value="Black">Black</form:option>
                            </c:when>
                            <c:when test="${article.model == 'iPhone 11'}">
                                <form:option value="Green">Green</form:option>
                                <form:option value="Purple">Purple</form:option>
                                <form:option value="Yellow">Yellow</form:option>
                                <form:option value="Red">Red</form:option>
                                <form:option value="White">White</form:option>
                                <form:option value="Black">Black</form:option>
                            </c:when>
                            <c:when test="${article.model == 'iPhone 11P' || article.model == 'iPhone 11PM'}">
                                <form:option value="Silver">Silver</form:option>
                                <form:option value="Black">Black</form:option>
                                <form:option value="Gold">Gold</form:option>
                                <form:option value="Green">Green</form:option>
                            </c:when>
                            <c:when test="${article.model == 'iPhone 12'}">
                                <form:option value="Blue">Blue</form:option>
                                <form:option value="Purple">Purple</form:option>
                                <form:option value="Green">Green</form:option>
                                <form:option value="Red">Red</form:option>
                                <form:option value="White">White</form:option>
                                <form:option value="Black">Black</form:option>
                            </c:when>
                            <c:when test="${article.model == 'iPhone 12M'}">
                                <form:option value="Blue">Blue</form:option>
                                <form:option value="Purple">Purple</form:option>
                                <form:option value="Green">Green</form:option>
                                <form:option value="Red">Red</form:option>
                                <form:option value="White">White</form:option>
                                <form:option value="Black">Black</form:option>
                            </c:when>
                            <c:when test="${article.model == 'iPhone 12P' || article.model == 'iPhone 12PM'}">
                                <form:option value="Silver">Silver</form:option>
                                <form:option value="Black">Black</form:option>
                                <form:option value="Gold">Gold</form:option>
                                <form:option value="Blue">Blue</form:option>
                            </c:when>
                            <c:when test="${article.model == 'iPhone 13' || article.model == 'iPhone 13M'}">
                                <form:option value="Red">Red</form:option>
                                <form:option value="White   ">White</form:option>
                                <form:option value="Black">Black</form:option>
                                <form:option value="Blue">Blue</form:option>
                                <form:option value="Pink">Pink</form:option>
                                <form:option value="Green">Green</form:option>
                            </c:when>
                        </c:choose>
                    </form:select>
                    <thead>
                    <tr>
                        <th>Model</th>
                        <th>GB</th>
                        <th>Imei</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${phones.phones}" var="phone" varStatus="status">
                        <tr>
                            <form:hidden path="phones[${status.index}].id_article" value="${phone.id_article}"/>
                            <td><form:hidden path="phones[${status.index}].model" id="model"
                                             value="${phone.model}"/>${phone.model}</td>
                            <td><form:hidden path="phones[${status.index}].gb" value="${phone.gb}"/>${phone.gb}</td>
                            <td><form:input class="form-control" type="text" pattern="[0-9]{15}"
                                            path="phones[${status.index}].imei"
                                            value="${phone.imei}"/></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </form:form>
        </div>
    </div>
</div>


<div class="modal fade" id="dateModal" tabindex="-1" aria-labelledby="dateModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="dateModalLabel">Change date</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <input id="newDate" type="date" class="form-control" value="${order.date}"/>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" onclick="changeDate()" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="qtyModal" tabindex="-1" aria-labelledby="qtyModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="qtyModalLabel">Change qty</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="${pageContext.request.contextPath}/newQty">
            <div class="modal-body">
                    <input type="hidden" name="order_number" value="${order.number_order}">
                    <input type="hidden" name="id_article" value="${order.id_article}">
                    <input type="hidden" name="id_supplier" value="${order.id_supplier}">
                    <input type="hidden" name="date" value="${order.date}">
                    Qty to add:
                    <input name="newQty" class="form-control" />
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-primary">Save changes</button>
            </div>
            </form>
        </div>
    </div>
</div>

<script>
    function changeDate() {
        let newDate = document.getElementById("newDate").value;

        $.ajax({
            url: "${pageContext.request.contextPath}/new_order_date/${order.number_order}",
            data: {
                date: newDate
            }
        });

        $('#oDate').text(newDate);
        $('#dateModal').modal('hide');
    }
</script>

</body>
</html>
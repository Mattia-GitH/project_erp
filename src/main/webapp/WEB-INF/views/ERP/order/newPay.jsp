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
    <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet">
    <meta charset="utf-8"/>
    <title>Pay</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <div class="row" style="margin-top: 50px; alignment: center">
        <div class="col-10">
            <form:form method="post" modelAttribute="pay" action="${pageContext.request.contextPath}/save_pay">
                <table class="table table-striped">
                    <tr>
                        <th>Pay</th>
                        <th><form:input class="form-control" path="number_order" readonly="true"/></th>
                    </tr>
                    <tr>
                        <td><form:label path="payment_options">Payment Options:</form:label></td>
                        <td>
                            <form:select class="form-control" path="payment_options">
                                <form:option value="cash">cash</form:option>
                                <form:option value="bank transfer">bank transfer</form:option>
                                <form:option value="post 15gg">post 15gg</form:option>
                                <form:option value="post 30gg">post 30gg</form:option>
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td><form:label path="paid">Paid:</form:label></td>
                        <td><form:checkbox class="form-check-input" path="paid"></form:checkbox></td>
                    </tr>
                    <tr>
                        <td><button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                            Upload File
                        </button></td>
                        <td><input class="btn btn-outline-primary" type="submit"/></td>
                    </tr>
                </table>
            </form:form>
        </div>
    </div>
</div>

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Upload file</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form:form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/upload_file_modal_NewPay">
                <table class="table table-striped">
                    <tr>
                        <th colspan="2">Upload file</th>
                    </tr>
                    <tr>
                        <td>Date:</td>
                        <td><input class="form-control" name="date" value="${date}" readonly/></td>
                    </tr>
                    <tr>
                        <td>N&deg;order:</td>
                        <td><input class="form-control" name="order_number" value="${pay.number_order}" readonly/></td>
                    </tr>
                    <tr>
                        <td>File:</td>
                        <td><input type="file" name="file"/></td>
                    </tr>

                    <tr>
                        <td>Type:</td>
                        <td>
                            <select class="form-control" name="format">
                                <option value="invoice">invoice</option>
                                <option value="document">document</option>
                                <option value="image">image</option>
                            </select>
                        </td>
                    </tr>

                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <input class="btn btn-outline-primary" type="submit"/>
            </div>
            </form:form>
        </div>
    </div>
</div>

</body>
</html>
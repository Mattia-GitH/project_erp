<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Create New Article</title>
</head>
<body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<jsp:include page="../header.jsp"/>
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-10">
            <form:form method="post" modelAttribute="article" action="${pageContext.request.contextPath}/save_article">
                <table class="table table-striped" style="margin-top:50px">
                    <tr>
                        <th colspan="2">Insert Article</th>
                    </tr>
                    <tr>
                        <form:hidden path="id"/>
                        <td><form:label path="model">model:</form:label></td>
                        <td>
                            <form:select id="model" class="selectpicker form-control" path="model" required="true">
                                <form:option value=""></form:option>
                                <form:option data-giga="64,128,256"
                                             value="iPhone SE">iPhone SE</form:option>
                                <form:option data-giga="64,128,256"
                                             value="iPhone SE3">iPhone SE3</form:option>
                                <form:option data-giga="64,256"
                                             value="iPhone X">iPhone X</form:option>
                                <form:option data-giga="64,256"
                                             value="iPhone XS">iPhone XS</form:option>
                                <form:option data-giga="64,256"
                                             value="iPhone XSM">iPhone XSM</form:option>
                                <form:option data-giga="64,128,256"
                                             value="iPhone XR">iPhone XR</form:option>
                                <form:option data-giga="64,128,256"
                                             value="iPhone 11">iPhone 11</form:option>
                                <form:option data-giga="64,256"
                                             value="iPhone 11P">iPhone 11P</form:option>
                                <form:option data-giga="64,256"
                                             value="iPhone 11PM">iPhone 11PM</form:option>
                                <form:option data-giga="64,128,256"
                                             value="iPhone 12">iPhone 12</form:option>
                                <form:option data-giga="64,256"
                                             value="iPhone 12M">iPhone 12M</form:option>
                                <form:option data-giga="128,256,512"
                                             value="iPhone 12P">iPhone 12P</form:option>
                                <form:option data-giga="128,256,512"
                                             value="iPhone 12PM">iPhone 12PM</form:option>
                                <form:option data-giga="128,256,512"
                                             value="iPhone 13">iPhone 13</form:option>
                                <form:option data-giga="128,256,512"
                                             value="iPhone 13M">iPhone 13M</form:option>
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td><form:label path="gb">GB:</form:label></td>
                        <td>
                            <form:select id="giga" class="selectpicker form-control" path="gb" style="display: none;">
                                <form:option value="64">64</form:option>
                                <form:option value="128">128</form:option>
                                <form:option value="256">256</form:option>
                                <form:option value="512">512</form:option>
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td><form:label path="grade_sup">Grade Supplier:</form:label></td>
                        <td>
                            <form:select class="selectpicker form-control" path="grade_sup">
                                <form:option value="A">A</form:option>
                                <form:option value="B">B</form:option>
                                <form:option value="C">C</form:option>
                                <form:option value="D">D</form:option>
                                <form:option value="E">E</form:option>
                                <form:option value="F">F</form:option>
                                <form:option value="W">W</form:option>
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" class="text-end"><input class="btn btn-outline-success" type="submit"/></td>
                    </tr>
                </table>
            </form:form>
        </div>
    </div>
</div>


<script type="text/javascript">
    $('#giga').hide();

    $("#model").change(function () {
        var ids = ($(this).find(":selected").data('giga') + "").split(",");
        var n = null;
        $('#giga option').hide().filter(function () {
            var p = ids.indexOf($(this).val()) > -1;
            if (p && n == null) {
                n = $(this).val()
            }
            return p
        }).show();
        $('#giga').show();
        $('#giga').val(n)
    });

    $('#color').hide();

    $("#model").change(function () {
        var ids = ($(this).find(":selected").data('color') + "").split(",");
        var n = null;
        $('#color option').hide().filter(function () {
            var p = ids.indexOf($(this).val()) > -1;
            if (p && n == null) {
                n = $(this).val()
            }
            return p
        }).show();
        $('#color').show();
        $('#color').val(n)
    });
</script>
</body>
</html>
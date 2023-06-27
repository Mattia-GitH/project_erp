<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
    <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">

    <meta charset="UTF-8">
    <title>Chests</title>
</head>
<body>
<jsp:include page="../header.jsp"/>

<div class="container">
    <div class="row">
        <div class="col-2">
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#createChestModal">
                Create chest <i class="bi bi-box2"></i>
            </button>
        </div>
        <div class="col-10">
            <h1>Chests</h1>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>NUMBER</th>
                        <th>PHASE</th>
                        <th>VIEW</th>
                        <th>EDIT</th>
                        <th>DELETE</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:set var="cNumber"/>
                    <c:forEach items="${chests}" var="chest">
                        <c:if test="${cNumber != chest.number}">
                            <c:set var="cNumber" value="${chest.number}"/>
                            <tr>
                                <td class="align-middle">${chest.id}</td>
                                <td class="align-middle">${chest.number}</td>
                                <td class="align-middle">${chest.phase}</td>
                                <td class="align-middle">view</td>
                                <td class="align-middle"><a href="${pageContext.request.contextPath}/chest/${chest.number}">edit</a></td>
                                <td class="align-middle"><a href="${pageContext.request.contextPath}/chest/delete/${chest.number}">Delete</a></td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="createChestModal" tabindex="-1" aria-labelledby="createChestModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="createChestModalLabel">Create chest</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form:form modelAttribute="chestContainer" action="${pageContext.request.contextPath}/chest">
                <div class="modal-body">
                    <div class="container">
                        <div class="row">
                            <div class="col-10">
                                <form:select path="phase" required="true">
                                    <form:option value=""></form:option>
                                    <form:option value="FIXING">FIXING</form:option>
                                    <form:option value="TECHLAB">TECHLAB</form:option>
                                    <form:option value="TESTING">TESTING</form:option>
                                </form:select>
                                <table>
                                    <thead>
                                    <tr>
                                        <th>Imei</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${chestContainer.chestList}" var="chest" varStatus="status">
                                        <tr>
                                            <td><form:input path="chestList[${status.index}].imei"
                                                            onchange="checkTl('${status.index}')"/></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save changes</button>
                </div>
            </form:form>
        </div>
    </div>
</div>
<script>

    <%--    const total = [];--%>
    <%--    let list;--%>

    <%--    function checkTl(index){--%>
    <%--        let imei = document.getElementById("chestList" + index + ".imei").value;--%>

    <%--        if(imei !== ""){--%>
    <%--            $.ajax({--%>
    <%--                url: '${pageContext.request.contextPath}/checkTest/' + imei,--%>
    <%--                success: function(d){--%>
    <%--                    tlList(d);--%>
    <%--                }--%>
    <%--            });--%>
    <%--        } else {--%>


    <%--        }--%>


    <%--        function tlList(d){--%>
    <%--            const issues = d.split(",")--%>
    <%--            let print = "";--%>
    <%--            for(let i = 0; i < issues.length; i++){--%>
    <%--                print = print + issues[i] + " ";--%>
    <%--                let tlQty = {tl: issues[i], qty: 1}--%>

    <%--                list = document.getElementsByClassName("isList");--%>
    <%--                for (let i = 0; i < list.length; i++ ){--%>
    <%--                    console.log(list[i])--%>
    <%--                }--%>

    <%--                // const results = total.filter(obj => {--%>
    <%--                //     return obj.tl === tlQty.tl;--%>
    <%--                // });--%>
    <%--                //--%>
    <%--                // if (results.toString().length === 0){--%>
    <%--                //     alert("Not present");--%>
    <%--                //     total.push(tlQty);--%>
    <%--                //     console.log(total)--%>
    <%--                // } else {--%>
    <%--                //     let ind = total.indexOf(results[0])--%>
    <%--                //--%>
    <%--                //     tlQty.qty = total[ind].qty + 1;--%>
    <%--                //     delete total[ind]--%>
    <%--                //     if (tlQty.tl !== ""){--%>
    <%--                //         total.push(tlQty)--%>
    <%--                //     }--%>
    <%--                //     alert("Already present")--%>
    <%--                // }--%>
    <%--            }--%>
    <%--            document.getElementById(index).innerText = print;--%>
    <%--        }--%>
    <%--    }--%>
</script>

</body>
</html>
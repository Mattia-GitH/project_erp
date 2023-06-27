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

    <style>
        div#components li {
            float: none !important;
        }
    </style>

</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="toast-container p-3 bottom-0 end-0">
    <c:set var="ind" value="0"/>
    <c:forEach items="${msg}" var="message">
        <c:set var="ind" value="${ind + 1}"/>

        <div class="toast" role="alert" id="msg${ind}" aria-live="assertive" aria-atomic="true">
            <div class="toast-header">
                <strong class="me-auto">Error</strong>
                <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close" onclick="$('#msg${ind}').hide()"></button>
            </div>
            <div class="toast-body">
                    ${message}
            </div>
        </div>
    </c:forEach>
</div>
<div class="container">
    <div class="row">
        <div class="col-10">
            <h1>Chests</h1>
            <h4>Phase ${phase} - Number ${number} - Qty ${chests.size()}</h4>
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addModal">
                Add phones
            </button>
            <div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="addModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="addModalLabel">Add phones</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <form:form modelAttribute="chestContainer"
                                   action="${pageContext.request.contextPath}/chest/add/${number}">
                            <div class="modal-body">
                                <table>
                                    <thead>
                                    <tr>
                                        <th>Imei</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${chestContainer.chestList}" var="chest" varStatus="status">
                                        <tr>
                                            <form:hidden path="phase" value="${phase}" />
                                            <td><form:input path="chestList[${status.index}].imei"/></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <button type="submit" class="btn btn-primary">add</button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>

            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>IMEI</th>
                        <th>MODEL</th>
                        <th>ISSUES</th>
                        <th>DELETE</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${chests}" var="chest">
                        <tr>
                            <jsp:useBean id="listModel" class="java.util.ArrayList"/>
                            <c:set var="model"/>
                            <td class="align-middle">${chest.imei}</td>
                            <c:forEach items="${phones}" var="phone">
                                <c:if test="${phone.imei == chest.imei}">
                                    <td class="align-middle">
                                        <c:set var="model" value="'${fn:replace(phone.model,' ', '')}'"/>
                                        <c:set var="noUse" value="${listModel.add(model)}"/>
                                            ${phone.model}
                                    </td>
                                </c:if>
                            </c:forEach>
                            <c:forEach items="${tests}" var="test">
                                <c:if test="${test.imei == chest.imei}">
                                    <td class="align-middle">
                                        <c:if test="${test.TL0 == true}">
                                            <span class="${model}">TL0</span>
                                        </c:if>
                                        <c:if test="${test.TL1 == true}">
                                            <span class="${model}">TL1</span>
                                        </c:if>
                                        <c:if test="${test.TL2 == true}">
                                            <span class="${model}">TL2</span>
                                        </c:if>
                                        <c:if test="${test.TL2T == true}">
                                            <span class="${model}" style="color:red">TL2T</span>
                                        </c:if>
                                        <c:if test="${test.TL4 == true}">
                                            <span class="${model}">TL4</span>
                                        </c:if>
                                        <c:if test="${test.TL5 == true}">
                                            <span class="${model}">TL5</span>
                                        </c:if>
                                        <c:if test="${test.TL5A == true}">
                                            <span class="${model}">TL5A</span>
                                        </c:if>
                                        <c:if test="${test.TL5B == true}">
                                            <span class="${model}">TL5B</span>
                                        </c:if>
                                        <c:if test="${test.TL8 == true}">
                                            <span class="${model}" style="color:red">TL8</span>
                                        </c:if>
                                        <c:if test="${test.TL8P == true}">
                                            <span class="${model}">TL8P</span>
                                        </c:if>
                                        <c:if test="${test.TL9 == true}">
                                            <span class="${model}" style="color:red">TL9</span>
                                        </c:if>
                                        <c:if test="${test.TL9T == true}">
                                            <span class="${model}" style="color:red">TL9T</span>
                                        </c:if>
                                        <c:if test="${test.TL10 == true}">
                                            <span class="${model}">TL10</span>
                                        </c:if>
                                        <c:if test="${test.TL10G == true}">
                                            <span class="${model}">TL10G</span>
                                        </c:if>
                                        <c:if test="${test.TL10T == true}">
                                            <span class="${model}" style="color:red">TL10T</span>
                                        </c:if>
                                        <c:if test="${test.TL11 == true}">
                                            <span class="${model}" style="color:red">TL11</span>
                                        </c:if>
                                        <c:if test="${test.TL11G == true}">
                                            <span class="${model}">TL11G</span>
                                        </c:if>
                                        <c:if test="${test.TL12 == true}">
                                            <span class="${model}" style="color:red">TL12</span>
                                        </c:if>
                                        <c:if test="${test.TL13 == true}">
                                            <span class="${model}">TL13</span>
                                        </c:if>
                                        <c:if test="${test.TL14 == true}">
                                            <span class="${model}">TL14</span>
                                        </c:if>
                                        <c:if test="${test.TL14P == true}">
                                            <span class="${model}">TL14P</span>
                                        </c:if>
                                        <c:if test="${test.TL14A == true}">
                                            <span class="${model}" style="color:red">TL14A</span>
                                        </c:if>
                                        <c:if test="${test.TL14B == true}">
                                            <span class="${model}">TL14B</span>
                                        </c:if>
                                        <c:if test="${test.TL14T == true}">
                                            <span class="${model}" style="color:red">TL14T</span>
                                        </c:if>
                                        <c:if test="${test.TL15 == true}">
                                            <span class="${model}" style="color:red">TL15</span>
                                        </c:if>
                                        <c:if test="${test.TL16 == true}">
                                            <span class="${model}">TL16</span>
                                        </c:if>
                                        <c:if test="${test.TL17 == true}">
                                            <span class="${model}" style="color:red">TL17</span>
                                        </c:if>
                                        <c:if test="${test.TL18 == true}">
                                            <span class="${model}">TL18</span>
                                        </c:if>
                                        <c:if test="${test.TL19 == true}">
                                            <span class="${model}" style="color:red">TL19</span>
                                        </c:if>
                                        <c:if test="${test.TL19A == true}">
                                            <span class="${model}">TL19A</span>
                                        </c:if>
                                        <c:if test="${test.TL21 == true}">
                                            <span class="${model}" style="color:red">TL21</span>
                                        </c:if>
                                        <c:if test="${test.TL22 == true}">
                                            <span class="${model}">TL22</span>
                                        </c:if>
                                        <c:if test="${test.TL22T == true}">
                                            <span class="${model}" style="color:red">TL22T</span>
                                        </c:if>
                                        <c:if test="${test.TL24 == true}">
                                            <span class="${model}">TL24</span>
                                        </c:if>
                                        <c:if test="${test.TL26 == true}">
                                            <span class="${model}">TL26</span>
                                        </c:if>
                                        <c:if test="${test.TL26T == true}">
                                            <span class="${model}" style="color:red">TL26T</span>
                                        </c:if>
                                        <c:if test="${test.TL27 == true}">
                                            <span class="${model}" style="color:red">TL27</span>
                                        </c:if>
                                        <c:if test="${test.TL27T == true}">
                                            <span class="${model}" style="color:red">TL27T</span>
                                        </c:if>
                                        <c:if test="${test.TL28 == true}">
                                            <span class="${model}" style="color:red">TL28</span>
                                        </c:if>
                                        <c:if test="${test.TL28T == true}">
                                            <span class="${model}" style="color:red">TL28T</span>
                                        </c:if>
                                        <c:if test="${test.TL29 == true}">
                                            <span class="${model}" style="color:red">TL29</span>
                                        </c:if>
                                        <c:if test="${test.TL29A == true}">
                                            <span class="${model}" style="color:red">TL29A</span>
                                        </c:if>
                                        <c:if test="${test.TL29B == true}">
                                            <span class="${model}" style="color:red">TL29B</span>
                                        </c:if>
                                        <c:if test="${test.TL29C == true}">
                                            <span class="${model}" style="color:red">TL29C</span>
                                        </c:if>
                                        <c:if test="${test.TL30 == true}">
                                            <span class="${model}" style="color:red">TL30</span>
                                        </c:if>
                                        <c:if test="${test.TL32 == true}">
                                            <span class="${model}">TL32</span>
                                        </c:if>
                                        <c:if test="${test.TL36 == true}">
                                            <span class="${model}">TL36</span>
                                        </c:if>
                                        <c:if test="${test.TL36T == true}">
                                            <span class="${model}" style="color:red">TL36T</span>
                                        </c:if>
                                        <c:if test="${test.TL37 == true}">
                                            <span class="${model}" style="color:red">TL37</span>
                                        </c:if>
                                        <c:if test="${test.TL38 == true}">
                                            <span class="${model}" style="color:red">TL38</span>
                                        </c:if>
                                        <c:if test="${test.TL39 == true}">
                                            <span class="${model}" style="color:red">TL39</span>
                                        </c:if>
                                        <c:if test="${test.TL40 == true}">
                                            <span class="${model}" style="color:red">TL40</span>
                                        </c:if>
                                        <c:if test="${test.TL41 == true}">
                                            <span class="${model}" style="color:red">TL41</span>
                                        </c:if>
                                        <c:if test="${test.TL42 == true}">
                                            <span class="${model}" style="color:red">TL42</span>
                                        </c:if>
                                        <c:if test="${test.TL42A == true}">
                                            <span class="${model}" style="color:red">TL42A</span>
                                        </c:if>
                                    </td>
                                </c:if>
                            </c:forEach>
                            <td class="align-middle">
                                <a href="${pageContext.request.contextPath}/chest/deleteID/${chest.id}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col-2">
            <h1>Components</h1>
            <div id="components">

            </div>
        </div>
    </div>
</div>


<script>
    let listModel = ${listModel};
    let issue;
    let issues = [];
    let totIssues = [];
    let modelDone = [];

    for (let i = 0; i < listModel.length; i++) {
        if (!modelDone.includes(listModel[i])) {
            modelDone.push(listModel[i]);
            let ul = document.createElement("ul");
            ul.id = listModel[i];
            document.getElementById("components").append(ul)
        }
    }
    modelDone = [];

    for (let i = 0; i < listModel.length; i++) {
        issues = document.getElementsByClassName('\'' + listModel[i] + '\'')
        if (!modelDone.includes(listModel[i])) {
            modelDone.push(listModel[i]);

            for (let index = 0; index < issues.length; index++) {
                issue = {model: listModel[i], tl: issues[index].innerHTML, qty: 1}

                let results = totIssues.filter(obj => obj.model === issue.model && obj.tl === issue.tl)

                if (results.toString().length === 0) {
                    totIssues.push(issue);
                } else {
                    let ind = totIssues.indexOf(results[0])
                    issue.qty = totIssues[ind].qty + 1;
                    delete totIssues[ind]
                    totIssues.push(issue)
                }
            }
        }
    }

    for (let i = 0; i < modelDone.length; i++) {
        let results = totIssues.filter(obj => obj.model === modelDone[i])
        let h5 = document.createElement("h5")
        h5.innerHTML = modelDone[i];
        document.getElementById(modelDone[i]).prepend(h5);

        for (let x = 0; x < results.length; x++) {
            let li = document.createElement("li");
            li.innerHTML = results[x].tl + " <i class='bi bi-arrow-right'></i> " + results[x].qty;
            document.getElementById(modelDone[i]).append(li)
        }
    }

    let ind = ${ind};

    for (let i = 0; i < ind + 1; i++) {

        $("#msg" + i).show();
    }

</script>

</body>
</html>
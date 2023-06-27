<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8"/>
    <title>Edit User</title>
</head>
<body>

<sec:authentication property="name" var="username"/>
<form:form method="post" class="login-form" modelAttribute="user" action="${pageContext.request.contextPath}/change_password/${username}">
    <h1>Login</h1>
    <div class="form-input-material">
        <form:input type="text" class="form-control-material" placeholder=" " path="username" value="${username}" readonly="true" autocomplete="off"/>
        <form:label class="placeholder" path="password">password:</form:label>
    </div>
    <div class="form-input-material">
        <form:input placeholder=" "  id="password" type="password" class="form-control-material" path="password" ></form:input>
        <form:label path="password">username:</form:label>
    </div>
    <button type="submit" class="btn btn-primary btn-ghost">Login</button>
</form:form>

</body>
</html>
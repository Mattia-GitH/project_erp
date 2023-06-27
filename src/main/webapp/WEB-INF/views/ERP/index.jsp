<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/index.css">
    <meta charset="UTF-8">
    <title>Index</title>
</head>
<body>
<p class="user"></p>
<sec:authorize access="isAuthenticated()">
    <p class="username" data-item="<sec:authentication property="name"/>"><sec:authentication property="name"/></p>
</sec:authorize>

<p data-item='SENSO'>SENSO</p>
<section>
    <nav>
        <ul class="menuItems">
            <li><a href='${pageContext.request.contextPath}/' data-item='Home'>Home</a></li>
            <sec:authorize access="hasRole('ROLE_SHOP')">
                <li><a href="#" data-item='SHOP' aria-haspopup="true">SHOP</a>
                    <ul class="dropdown" aria-label="submenu">
                        <li><a href='${pageContext.request.contextPath}/make_order' data-item='Make&nbsp;Order'>Make&nbsp;Order</a>
                        </li>
                        <li><a href='${pageContext.request.contextPath}/cart_view' data-item='Cart'>Cart</a></li>
                        <li><a href='${pageContext.request.contextPath}/purchased' data-item='Orders'>Orders</a></li>
                        <li><a href='${pageContext.request.contextPath}/create_supplier'
                               data-item='Create&nbsp;Supplier'>Create&nbsp;Supplier</a></li>
                    </ul>
                </li>
                <li><a href="${pageContext.request.contextPath}/warehouseSku" data-item='Warehouse'
                       aria-haspopup="true">Warehouse</a>
                    <ul class="dropdown" aria-label="submenu">
                        <li><a href='<c:url value="/orders" />'
                               data-item='Warehouse&nbsp;Entry'>Warehouse&nbsp;Entry</a></li>
                    </ul>
                </li>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_LINE')">
                <li><a href="#" data-item='Production' aria-haspopup="true">Production</a>
                    <ul class="dropdown" aria-label="submenu">
                        <li><a href='<c:url value="/testing" />' data-item='Testing'>Testing</a></li>
                        <li><a href='<c:url value="/fixing" />' data-item='Fixing'>Fixing</a></li>
                        <li><a href='<c:url value="/packing" />' data-item='Packing'>Packing</a></li>
                    </ul>
                </li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li><a data-item='Logout' href="<c:url value="/logout" />">Logout</a></li>
                <li><a href='${pageContext.request.contextPath}/change_password' data-item='Change&nbsp;password'>Change&nbsp;password</a>
                </li>
            </sec:authorize>
            <sec:authorize access="isAnonymous()">
                <li><a data-item='Login' href="<c:url value="/login" />">Login</a></li>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <li><a class="menu" href="#" data-item='Planning' aria-haspopup="true">Planning</a>
                    <ul class="dropdown" aria-label="submenu">
                        <li><a class="menu" href='<c:url value="/planning" />' data-item='Planning'>Planning</a></li>
                        <li><a class="menu" href='<c:url value="/planned" />' data-item='Planned'>Planned</a></li>
                    </ul>
                </li>
                <li><a href='${pageContext.request.contextPath}/analytics' class="menu"
                       data-item='Analytics'>Analytics</a></li>
            </sec:authorize>
        </ul>
    </nav>
</section>
</body>
</html>
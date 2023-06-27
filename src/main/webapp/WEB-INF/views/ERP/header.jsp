<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>
    header{
        background-color: #a5c1c4;
    }

    h1{
        color: #044454  !important;
    }

    body {
        font-family: Hack, monospace;
    }

    .btn-outline-dark {
        --bs-btn-color: #212529;
        --bs-btn-border-color: #004750;
        --bs-btn-hover-color: #fff;
        --bs-btn-hover-bg: #004750;
        --bs-btn-hover-border-color: #004750;
    }

    .menu {
        text-decoration: none;
        color: #8f8f8f;
        font-size: 18px;
        font-weight: 400;
        transition: all 0.5s ease-in-out;
        position: relative;
        text-transform: uppercase;
    }
    .menu::before {
        content: attr(data-item);
        transition: 0.5s;
        color: #044454;
        position: absolute;
        top: -2px;
        bottom: 0;
        left: 0;
        right: 0;
        width: 0;
        overflow: hidden;
    }
    .menu:hover::before {
        width: 100%;
        transition: all 0.5s ease-in-out;
    }



    ul {
        list-style: none;
        margin: 0;
        padding-left: 0;
    }

    li {
        display: block;
        float: left;
        padding: 1rem;
        position: relative;
        text-decoration: none;
        transition-duration: 0.5s;
    }

    li:focus-within a {
        outline: none;
    }

    ul li ul {
        visibility: hidden;
        opacity: 0;
        min-width: 5rem;
        position: absolute;
        transition: all 0.5s ease;
        margin-top: 1rem;
        left: 0;
    }

    ul li:hover > ul,
    ul li:focus-within > ul,
    ul li ul:hover,
    ul li ul:focus {
        visibility: visible;
        opacity: 1;
        display: block;
    }

    ul li ul li {
        clear: both;
        width: 100%;
    }

    ul.dropdown li {
        margin: 0px!important;
        background-color: #A5C1C4;
    }

    div.header {
        max-height: 50px;
    }

    .dropdown {
        position: absolute;
    }
    a#helpBtn::before {
        top: 0px;
    }

    input#msg {
        height: 100px;
        width: 100%;
        border-color: transparent;
    }
    div#helpBox {
        padding: 0%;
    }
</style>
<script>
    function postmessage() {
        var msg = $('#msg').val();
        $.ajax({
            method: 'POST',
            data: {message: msg},
            url: '${pageContext.request.contextPath}/message'
        });

        $('#msg').val("");
        $('#sent').text("Sent!!!");
    }
    function clean(){
        $('#sent').text("");
    }
</script>
<header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
    <div class="col-md-1 text-start">
    </div>
    <div class="header">
        <nav>
            <ul class="menuItems">
                <li><a href='${pageContext.request.contextPath}/' class="menu" data-item='Home'>Home</a></li>
                <sec:authorize access="hasRole('ROLE_SHOP')">
                <li><a href="#"class="menu" data-item='SHOP' aria-haspopup="true">SHOP</a>
                    <ul class="dropdown" aria-label="submenu">
                        <li><a class="menu" href='${pageContext.request.contextPath}/make_order' data-item='Make&nbsp;Order'>Make&nbsp;Order</a></li>
                        <li><a class="menu" href='${pageContext.request.contextPath}/cart_view' data-item='Cart'>Cart</a></li>
                        <li><a class="menu" href='${pageContext.request.contextPath}/purchased' data-item='Orders'>Orders</a></li>
                        <li><a class="menu" href='${pageContext.request.contextPath}/create_supplier' data-item='Create&nbsp;Supplier'>Create&nbsp;Supplier</a></li>
                    </ul>
                </li>

                <li><a class="menu" href="${pageContext.request.contextPath}/warehouseSku" data-item='Warehouse' aria-haspopup="true">Warehouse</a>
                    <ul class="dropdown" aria-label="submenu">
                        <li><a class="menu" href='${pageContext.request.contextPath}/orders' data-item='Warehouse&nbsp;Entry'>Warehouse&nbsp;Entry</a></li>
                    </ul>
                </li>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_LINE')">
                <li><a class="menu" href="#" data-item='Production' aria-haspopup="true">Production</a>
                    <ul class="dropdown" aria-label="submenu">
                        <li><a class="menu" href='${pageContext.request.contextPath}/testing' data-item='Testing'>Testing</a></li>
                        <li><a class="menu" href='${pageContext.request.contextPath}/fixing' data-item='Fixing'>Fixing</a></li>
                        <li><a class="menu" href='${pageContext.request.contextPath}/packing' data-item='Packing'>Packing</a></li>
                    </ul>
                </li>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                <li><a class="menu" href="#" data-item='Planning' aria-haspopup="true">Planning</a>
                    <ul class="dropdown" aria-label="submenu">
                        <li><a class="menu" href='${pageContext.request.contextPath}/planning' data-item='Planning'>Planning</a></li>
                        <li><a class="menu" href='${pageContext.request.contextPath}/planned' data-item='Planned'>Planned</a></li>
                    </ul>
                </li>
                <li><a href='${pageContext.request.contextPath}/analytics' class="menu" data-item='Analytics'>Analytics</a></li>
                </sec:authorize>
                <a type="button" id="helpBtn" style="margin-top:16px" class="menu" data-item='Help' data-bs-toggle="modal" data-bs-target="#help">Help</a>
            </ul>
        </nav>
    </div>
    <div class="col-md-2 text-end">
    </div>

    <div class="modal fade" id="help" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Message <p id="sent"></p></h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body" id="helpBox">
                    <input name="message" id="msg" type="text">
                </div>
                <div class="modal-footer">
                    <button class="btnSend btn btn-primary" onclick="postmessage();" >Send</button>
                    <button type="button" class="btn btn-secondary" onclick="clean()" data-bs-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

</header>
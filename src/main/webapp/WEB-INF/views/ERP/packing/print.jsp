<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>
</head>
<body onload="window.print()">
<div style="font-size:20px; text-align: center">
    <img style="width: 180px" src="${pageContext.request.contextPath}/logo.png">
    <br>
    <br>
    SKU: ${info.sku}
    <br>
    <img style="width: 300px; height: 35px; object-fit: cover;" src="${pageContext.request.contextPath}/ean13/123456789123">
    <br>
    EAN: 123456789
    <br>
    <img style="width: 150px; height: 150px; object-fit: none;" src="${pageContext.request.contextPath}/qrcode/${info.imei},${info.prod_name},${info.order_number},${info.sku}">
    <br>
    IMEI: ${info.imei}
    <br>

</div>

<script>
    window.onafterprint = (event) => {
        location.replace("${pageContext.request.contextPath}/packing")
    };
</script>

</body>
</html>

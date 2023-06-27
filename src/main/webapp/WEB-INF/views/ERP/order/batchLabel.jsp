<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Batch Label</title>
</head>
<body onload="window.print()">
<div style="font-size:20px; text-align: center; font-family:verdana">
    <img style="width: 180px" src="${pageContext.request.contextPath}/logo.png">
    <br>
    <br>
    ${supplier}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;N&deg;Order: ${order_number}
    <br>
    <br>
          ${status}
    <br>
    <br>
    ${phone}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(________)
</div>
<script>
    window.onafterprint = (event) => {
        location.replace("${pageContext.request.contextPath}/orders")
    };
</script>
</body>
</html>

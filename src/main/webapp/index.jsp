<%--
  Created by IntelliJ IDEA.
  User: seals
  Date: 12/5/26
  Time: 08:09
  To change this template use File | Settings | File Templates.
--%>
<%--Bắt đầu vào project, tạo file jsp xong luôn phải mở EL lên--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--ở dòng 11, đoạn prefix anh em có thể tên tuỳ ý, nó giống như 1 cái thẻ HTML, do anh
em tự định nghĩa--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="bach" %>

<html>
<head>
    <title>Hello world</title>
</head>
<body>
<p>Xin chào đồng chí ${bien1} có số tuổi là ${age} ✈✈✈✈✈</p>
<p>${ketnoi}</p>
<%--forEach là 1 vòng lặp, trong môn này dùng để duyêt qua mảng (Array)--%>
<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>Tên khách hàng</th>
        <th>Tên bia gọi</th>
        <th>Số lượng</th>
    </tr>
    </thead>
    <tbody>
    <bach:forEach var="bien" items="${lstBeerOrder}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${bien.customerName}</td>
            <td>${bien.beerName}</td>
            <td>${bien.quantity}</td>
        </tr>
    </bach:forEach>
    </tbody>
</table>
</body>
</html>

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
<div>
    <form method="post" action="/create">
        <label>Tên khách hàng 🐕🐕🐕🐕</label>
        <input type="text" name="customerName" value="${beerOrder.customerName}"/>
        <br/>
        <label>Tên beer đặt 🍺🍺🍺🍺</label>
        <input type="text" name="beerName" value="${beerOrder.beerName}"/>
        <br/>
        <label>Số lượng cốc</label>
        <input type="number" name="quantity" value="${beerOrder.quantity}"/>
        <br/>
        <button type="submit">Đăng ký</button>
    </form>
</div>
<%--forEach là 1 vòng lặp, trong môn này dùng để duyêt qua mảng (Array)--%>
<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>Tên khách hàng</th>
        <th>Tên bia gọi</th>
        <th>Số lượng</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <bach:forEach var="bien" items="${lstBeerOrder}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${bien.customerName}</td>
            <td>${bien.beerName}</td>
            <td>${bien.quantity}</td>
            <td>
                <form action="/delete" method="post" onsubmit="return confirm('Mày có chắc chắn muốn xoá không ?')">
                        <%--Cái dòng ở dưới, tức là mỗi khi click nút xoá -> sẽ gửi kèm id cần xoá--%>
                    <input type="hidden" value="${bien.orderId}" name="idXoa"/>
                    <button type="submit">Xoá</button>
                </form>
                <form action="/detail" method="get">
                        <%--Cái dòng ở dưới, tức là mỗi khi click nút xem -> sẽ gửi kèm id cần xem--%>
                    <input type="hidden" value="${bien.orderId}" name="idXem"/>
                    <button type="submit">Xem</button>
                </form>
            </td>
        </tr>
    </bach:forEach>
    </tbody>
</table>
</body>
</html>

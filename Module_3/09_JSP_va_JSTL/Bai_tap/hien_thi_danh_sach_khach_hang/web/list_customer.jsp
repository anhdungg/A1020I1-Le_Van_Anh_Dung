<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>List Customer</title>
    <style>
        td{
            padding: 10px;
        }
    </style>
</head>
<body>
<h2 style="text-align: center">List Customer</h2>
<div style="display: flex">
    <table style="margin-left: auto; margin-right: auto">
        <tr style="border-bottom: 1px solid black">
            <th>Tên</th>
            <th>Ngày sinh</th>
            <th>Địa chỉ</th>
            <th>Ảnh</th>
        </tr>
        <c:forEach var="customer" items="${customer}">
            <tr style="border-bottom: 1px solid black">
                <td><c:out value="${customer.name}"/></td>
                <td><c:out value="${customer.dayOfBirth}"/></td>
                <td><c:out value="${customer.address}"/></td>
<%--                <td><img src="img/img-1.jpg" alt="image" style="height: 50px"/></td>--%>
<%--                <td><img src="img/img-2.jpg" alt="image" style="height: 50px"/></td>--%>
<%--                <td><img src="img/img-3.jpg" alt="image" style="height: 50px"/></td>--%>
<%--                <td><img src="img/img-4.jpg" alt="image" style="height: 50px"/></td>--%>
<%--                <td><img src="img/img-5.jpg" alt="image" style="height: 50px"/></td>--%>
                <td><img src="${customer.image}" alt="image" style="height: 50px"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

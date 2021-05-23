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
        <c:forEach var="customer" items="${customers}">
            <tr style="border-bottom: 1px solid black">
                <td><c:out value="${customer.getName()}"/></td>
                <td><c:out value="${customer.getDayOfBirth()}"/></td>
                <td><c:out value="${customer.getAddress()}"/></td>
                <td><img src="${customer.getImage()}" alt="image" style="height: 50px"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

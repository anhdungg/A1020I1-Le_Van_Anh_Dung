<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Quản lý sản phẩm</title>
    <style>
        table, td, th {
            border: 1px solid black;
        }

        table {
            border-collapse: collapse;
        }
        td, th{
            padding: 5px 10px 5px 10px;
        }
        td{
            text-align: center;
        }
    </style>
</head>
<body>
<h2 style="text-align: center">Danh sách sản phẩm</h2>
<div style="display: flex">
    <table style="margin-left: auto; margin-right: 0">
        <tr>
            <th>Id</th>
            <th>Tên</th>
            <th>Số lượng</th>
            <th>Đơn giá</th>
            <th>Mô tả</th>
            <th>Nhà sản xuất</th>
        </tr>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.getId()}</td>
                <td><a href="/product?action=view&id=${product.getId()}">${product.getName()}</a></td>
                <td>${product.getUnit()}</td>
                <td>${product.getPrice()}</td>
                <td>${product.getDescription()}</td>
                <td>${product.getProducer()}</td>
            </tr>
        </c:forEach>
    </table>
    <table style="border: 0; margin-right: auto">
        <tr style="height: 29px">
            <th rowspan="1" style="border: 0"></th>
        </tr>
        <c:forEach items="${products}" var="product">
            <tr style="height: 29px">
                <td style="border: 0; padding-bottom: 0; padding-top: 0">
                    <button style="margin: 0 5px 0 5px" onclick="location.href='/product?action=edit&id=${product.getId()}'">Sửa</button>
                    <button style="margin: 0 5px 0 5px" onclick="location.href='/product?action=delete&id=${product.getId()}'">Xoá</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div style="display: flex">
    <button style="margin: 10px 10px 0 auto" onclick="location.href='/product?action=create'">Thêm sản phẩm</button>
    <button style="margin: 10px auto 0 0" onclick="location.href='/product?action=search'">Tìm sản phẩm</button>
</div>
</body>
</html>

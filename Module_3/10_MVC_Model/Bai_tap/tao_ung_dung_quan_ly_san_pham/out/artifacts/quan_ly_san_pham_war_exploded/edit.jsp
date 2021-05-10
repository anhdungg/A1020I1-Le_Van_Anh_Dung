<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit</title>
    <style>
        .a-tag-button{
            background: #efefef;
            /*margin-left: auto;*/
            /*margin-right: 20px;*/
            border-radius: 2px;
            color: black;
            text-decoration: none;
            padding: 1px 6px;
            border: 1px solid #767776;
            font-family: Arial, serif;
            font-size: 13px;
            text-align: center;
        }
        .a-tag-button:hover{
            background: #dfdfdf;
        }
    </style>
</head>
<body>
<h1 style="text-align: center">Cập nhập thông tin sản phẩm</h1>
<p style="text-align: center">
    <c:if test='${message == "fail"}'>
        <span style="color: red;">Cập nhập sản phẩm không thành công</span>
    </c:if>
    <c:if test='${message == "success"}'>
        <span style="color: green;">Cập nhập sản phẩm thành công</span>
    </c:if>
</p>

<div style="display: flex">
    <form action="" method="post" style="margin: 0 auto 0 auto">
        <fieldset>
            <legend>Thông tin sản phẩm</legend>
                <table>
                    <tr>
                        <td>Tên: </td>
                        <td><input type="text" name="name" id="name" value="${product.getName()}"></td>
                    </tr>
                    <tr>
                        <td>Số lượng: </td>
                        <td><input type="number" name="unit" id="unit" value="${product.getUnit()}"></td>
                    </tr>
                    <tr>
                        <td>Đơn giá: </td>
                        <td><input type="number" name="price" id="price" value="${product.getPrice()}"></td>
                    </tr>
                    <tr>
                        <td>Mô tả: </td>
                        <td><input type="text" name="description" id="description" value="${product.getDescription()}"></td>
                    </tr>
                    <tr>
                        <td>Nhà sản xuất: </td>
                        <td><input type="text" name="producer" id="producer" value="${product.getProducer()}"></td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center; padding-top: 20px">
                            <a href="/product" class="a-tag-button">&#8592;Trở lại</a>
                            <input type="submit" value="Cập nhập">
                        </td>
                    </tr>
                </table>
        </fieldset>
    </form>
</div>
</body>
</html>

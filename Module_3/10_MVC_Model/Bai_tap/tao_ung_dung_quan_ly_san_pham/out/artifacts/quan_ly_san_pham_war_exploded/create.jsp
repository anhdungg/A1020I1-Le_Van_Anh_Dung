<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Create</title>
    <style>
        .a-tag-button{
            background: #efefef;
            margin-left: auto;
            margin-right: 20px;
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
<h1 style="text-align: center">Tạo sản phẩm mới</h1>
<p style="text-align: center">
    <c:if test='${message == "fail"}'>
        <span style="color: red;">Sản phẩm mới tạo không thành công</span>
    </c:if>
    <c:if test='${message == "success"}'>
        <span style="color: green;">Sản phẩm mới đã được tạo</span>
    </c:if>
</p>
<div style="display: flex">
    <form method="post"  style="margin-right: auto; margin-left: auto">
        <fieldset>
            <legend>Thông tin sản phẩm</legend>
                <table>
                    <tr>
                        <td>Tên:</td>
                        <td><input type="text" name="name" id="name"></td>
                    </tr>
                    <tr>
                        <td>Số lượng:</td>
                        <td><input type="number" name="unit" id="unit"></td>
                    </tr>
                    <tr>
                        <td>Đơn giá:</td>
                        <td><input type="number" name="price" id="price"></td>
                    </tr>
                    <tr>
                        <td>Mô tả:</td>
                        <td><input type="text" name="description" id="description"></td>
                    </tr>
                    <tr>
                        <td>Nhà sản xuất:</td>
                        <td><input type="text" name="producer" id="producer"></td>
                    </tr>
                </table>

            <div style="display: flex; margin-top: 10px">
                <a href="/product" class="a-tag-button">&#8592;Trở lại</a>
                <input style="margin-right: auto" type="submit" value="Tạo mới">
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>

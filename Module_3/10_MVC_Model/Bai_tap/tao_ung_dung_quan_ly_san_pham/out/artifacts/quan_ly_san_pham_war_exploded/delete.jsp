<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Delete</title>
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
<h1 style="text-align: center">Xoá sản phẩm</h1>
<h3 style="text-align: center; color: red">Bạn chắc chứ?</h3>
<div style="display: flex">
    <form action="" method="post" style="margin: 0 auto 0 auto">
        <fieldset>
            <legend>Thông tin sản phẩm</legend>
            <table>
                <tr>
                    <td>Tên sản phẩm:</td>
                    <td><c:out value="${product.getName()}"/></td>
                </tr>
                <tr>
                    <td>Số lượng:</td>
                    <td><c:out value="${product.getUnit()}"/></td>
                </tr>
                <tr>
                    <td>Đơn giá:</td>
                    <td><c:out value="${product.getPrice()}"/></td>
                </tr>
                <tr>
                    <td>Mô tả:</td>
                    <td><c:out value="${product.getDescription()}"/></td>
                </tr>
                <tr>
                    <td>Nhà sản xuất:</td>
                    <td><c:out value="${product.getProducer()}"/></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center; padding-top: 20px">
                        <a href="/product" class="a-tag-button">&#8592;Trở lại</a>
                        <input type="submit" value="Xoá">
                    </td>
                </tr>
            </table>
        </fieldset>
    </form>
</div>
</body>
</html>

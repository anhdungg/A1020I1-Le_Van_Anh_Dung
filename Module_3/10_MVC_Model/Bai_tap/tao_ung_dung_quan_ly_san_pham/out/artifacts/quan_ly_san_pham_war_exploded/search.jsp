<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Search</title>
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
        .a-tag-button{
            background: #efefef;
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
<h1 style="text-align: center">Tìm kiếm sản phẩm</h1>
<c:if test="${result == 'false'}">
    <div style="display: flex">
        <form action="" method="post" style="margin-right: auto; margin-left: auto">
            <div>
                <input type="text" name="action" id="action" value="search" style="display: none">
                <label for="value">Nhập tên sản phẩm: </label>
                <input type="text" name="value" id="value">
            </div>
            <div style="text-align: center; margin-top: 20px">
                <a href="/product" class="a-tag-button">&#8592;Trở lại</a>
                <input type="submit" value="Tìm">
            </div>
        </form>
    </div>
</c:if>
    <c:if test="${result == 'true'}">
        <c:if test="${status == 'false'}">
            <p style="text-align: center">Không tìm thấy kết quả cho "${value}"</p>
        </c:if>
        <c:if test="${status == 'true'}">
            <div style="display: flex">
                <table style="margin-right: auto; margin-left: auto">
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
                            <td>${product.getName()}</td>
                            <td>${product.getUnit()}</td>
                            <td>${product.getPrice()}</td>
                            <td>${product.getDescription()}</td>
                            <td>${product.getProducer()}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </c:if>
        <div style="display: flex">
            <div style="margin-left: auto; margin-right: auto; padding-top: 20px">
                    <a href="/product" class="a-tag-button">&#8592;Trở lại</a>
                    <a href="/product?action=search" class="a-tag-button">Tìm sản phẩm</a>
            </div>
        </div>
    </c:if>
</body>
</html>

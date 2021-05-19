<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>User Management Application</title>
    <style>
        .a-tag-button{
            background: #efefef;
            margin: 20px auto 0 auto;
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
<h1 style="text-align: center">User Information</h1>
<div style="display: flex">
    <table style="margin-left: auto; margin-right: auto">
        <tr>
            <td>ID:</td>
            <td><c:out value="${user.getId()}"/></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><c:out value="${user.getName()}"/></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><c:out value="${user.getEmail()}"/></td>
        </tr>
        <tr>
            <td>Country:</td>
            <td><c:out value="${user.getCountry()}"/></td>
        </tr>
    </table>
</div>
<div style="display: flex">
    <a href="/product" class="a-tag-button">&#8592;Back</a>
</div>
</body>
</html>

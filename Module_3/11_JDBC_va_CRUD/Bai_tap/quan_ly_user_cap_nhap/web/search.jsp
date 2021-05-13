<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
    <title>User Management Application</title>
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
<h1 style="text-align: center">User Management</h1>
<c:if test="${result == 'false'}">
    <div style="display: flex">
        <form action="" style="margin-right: auto; margin-left: auto">
            <div>
                <input type="text" name="action" id="action" value="search" style="display: none">
                <label for="country">Country: </label>
                <input type="text" name="country" id="country">
            </div>
            <div style="text-align: center; margin-top: 20px">
                <a href="/manage" class="a-tag-button">&#8592;Back</a>
                <input type="submit" value="Search">
            </div>
        </form>
    </div>
</c:if>
<c:if test="${result == 'true'}">
    <c:if test="${status == 'false'}">
        <p style="text-align: center">No result for "${value}"</p>
    </c:if>
    <c:if test="${status == 'true'}">
        <div style="display: flex">
            <table style="margin-right: auto; margin-left: auto">
                <tr>
                    <th>Id:</th>
                    <th>Name:</th>
                    <th>Email:</th>
                    <th>Country</th>
                </tr>
                <c:forEach items="${listUser}" var="user">
                    <tr>
                        <td>${user.getId()}</td>
                        <td>${user.getName()}</td>
                        <td>${user.getEmail()}</td>
                        <td>${user.getCountry()}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </c:if>
    <div style="display: flex">
        <div style="margin-left: auto; margin-right: auto; padding-top: 20px">
            <a href="/manage" class="a-tag-button">&#8592;Back</a>
            <a href="/product?action=search" class="a-tag-button">Search country</a>
        </div>
    </div>
</c:if>
</body>
</html>

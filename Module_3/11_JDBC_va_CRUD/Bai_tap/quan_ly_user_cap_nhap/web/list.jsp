<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
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
    </style>
</head>
<body>
<h2 style="text-align: center">User Management</h2>
<div style="display: flex">
    <table style="margin-left: auto; margin-right: auto">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${listUser}" var="user">
            <tr>
                <td>${user.getId()}</td>
                <td><a href="/manage?action=view&id=${user.getId()}">${user.getName()}</a></td>
                <td>${user.getEmail()}</td>
                <td>${user.getCountry()}</td>
                <td>
                    <button style="margin: 0 5px 0 5px" onclick="location.href='/manage?action=edit&id=${user.getId()}'">Edit</button>
                    <button style="margin: 0 5px 0 5px" onclick="location.href='/manage?action=delete&id=${user.getId()}'">Delete</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div style="display: flex">
    <button style="margin: 10px 10px 0 auto" onclick="location.href='/manage?action=create'">Create</button>
    <button style="margin: 10px 10px 0 0" onclick="location.href='/product?action=search'">Search country</button>
    <button style="margin: 10px auto 0 0" onclick="location.href='/product?action=sort'">Sort name</button>
</div>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer | List</title>
    <style>
        td, th{
            border: 1px solid black;
        }
        td{
            padding-right: 10px;
            padding-left: 10px;
        }
    </style>
</head>
<body>
<div>
    <h3>Customer</h3>
    <h4><a href="/customer">Back</a> </h4>
    <table style="border: 1px solid black">
        <tr>
            <th>ID</th>
            <td>${customer.id}</td>
        </tr>
        <tr>
            <th>Name</th>
            <td>${customer.name}</td>
        </tr>
        <tr>
            <th>Email</th>
            <td>${customer.email}</td>
        </tr>
        <tr>
            <th>Address</th>
            <td>${customer.address}</td>
        </tr>
    </table>
</div>
</body>
</html>

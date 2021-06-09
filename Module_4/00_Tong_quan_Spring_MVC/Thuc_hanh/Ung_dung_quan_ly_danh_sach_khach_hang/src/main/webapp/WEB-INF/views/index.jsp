<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <h3>Customer List</h3>
    <table style="border: 1px solid black">
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
      </tr>
      <c:forEach items="${listCustomer}" var="customer">
        <tr>
          <td>${customer.id}</td>
          <td>
          <a href="/customer/view?id=${customer.id}">${customer.name}</a>
          </td>
          <td>${customer.email}</td>
          <td>${customer.address}</td>
        </tr>
      </c:forEach>
    </table>
  </div>
  </body>
</html>

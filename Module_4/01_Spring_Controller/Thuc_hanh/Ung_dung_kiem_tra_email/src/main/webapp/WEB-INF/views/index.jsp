<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Validate Email</title>
  </head>
  <body>
  <h2 style="text-align: center">Validate Email</h2>
  <div style="display: flex">
    <form action="/validate" method="post" style="margin-left: auto; margin-right: auto">
      <label for="email">Email:</label>
      <input type="text" name="email" id="email" value="${email}">
      <c:if test="${status == 'Success'}">
        <p style="margin: 0; padding: 0; color: green">Success</p>
      </c:if>
      <c:if test="${status == 'Fail'}">
        <p style="margin: 0; padding: 0; color: red">Fail</p>
      </c:if>
      <div style="display: flex">
        <input type="submit" value="Check" style="margin: 20px auto 0 auto">
      </div>
    </form>
  </div>
  </body>
</html>

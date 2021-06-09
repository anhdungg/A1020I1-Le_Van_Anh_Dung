<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Convert the foreign currency</title>
  </head>
  <body>
  <h2 style="text-align: center">Convert the foreign currency</h2>
  <div style="display: flex">
    <form action="${pageContext.request.contextPath}/calculator" style="margin-left: auto; margin-right: auto">
      <input type="number" name="input" id="input" value="${input}">
      <label for="input">USD = </label>
      <input type="text" value="${output}" readonly>
      <label>VND</label>
      <div style="display: flex">
        <input type="submit" value="Convert" style="margin: 20px auto 0 auto">
      </div>
    </form>
  </div>
  </body>
</html>

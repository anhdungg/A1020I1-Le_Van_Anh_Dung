<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Computer</title>
  </head>
  <body>
  <h2 style="text-align: center">Calculator</h2>
  <div style="display: flex">
    <form action="${pageContext.request.contextPath}/calculator" style="margin-left: auto; margin-right: auto" id="form">
      <input type="number" name="number1" id="number1" value="${number1}">
      <input type="number" name="number2" id="number2" value="${number2}">
      <input type="hidden" name="calculation" id="calculation">
      <c:if test="${result != null}">
        <span> = ${result}</span>
      </c:if>
      <div style="margin-top: 20px">
        <input type="button" value="Addition(+)" onclick="submitForm('+')">
        <input type="button" value="Subtraction(-)" onclick="submitForm('-')">
        <input type="button" value="Multiplication(*)" onclick="submitForm('*')">
        <input type="button" value="Division(/)" onclick="submitForm('/')">
      </div>
    </form>
  </div>
  <script>
    function submitForm(str) {
      document.getElementById("calculation").value = str;
      document.getElementById("form").submit();
    }
  </script>
  </body>
</html>

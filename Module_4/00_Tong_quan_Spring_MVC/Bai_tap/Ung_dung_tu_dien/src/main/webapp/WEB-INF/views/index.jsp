<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Dictionary</title>
  </head>
  <body>
  <h2 style="text-align: center">Dictionary</h2>
  <div style="display: flex">
    <form action="${pageContext.request.contextPath}/translate" style="margin-left: auto; margin-right: auto">
      <div style="display: flex">
        <div style="margin-right: 10px">
          <label for="input">Tiếng Anh </label><br>
          <textarea name="input" id="input">${input}</textarea>
        </div>
        <div style="margin-left: 10px">
          <label>Tiếng Việt</label><br>
          <textarea><c:out value="${output}"/></textarea>
        </div>
      </div>
      <div style="display: flex">
        <input type="submit" value="Dịch" style="margin: 20px auto 0 auto">
      </div>
    </form>
  </div>
  </body>
</html>

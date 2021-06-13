<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Sandwich</title>
  </head>
  <body>
  <h2 style="text-align: center">Sandwich Condiments</h2>
  <div style="display: flex">
    <form action="${pageContext.request.contextPath}/save" style="margin-left: auto; margin-right: auto">
      <input type="checkbox" name="lettuce" id="lettuce" value="lettuce">
      <label for="lettuce">Lettuce</label>
      <input type="checkbox" name="tomato" id="tomato" value="tomato">
      <label for="tomato">Tomato</label>
      <input type="checkbox" name="mustard" id="mustard" value="mustard">
      <label for="mustard">Mustard</label>
      <input type="checkbox" name="sprouts" id="sprouts" value="sprouts">
      <label for="sprouts">Sprouts</label>
      <div style="display: flex; border-top: 2px solid #dfdfdf; margin-top: 5px">
        <input type="submit" value="Save" style="margin: 20px auto 0 auto;">
      </div>
    </form>
  </div>
  </body>
</html>

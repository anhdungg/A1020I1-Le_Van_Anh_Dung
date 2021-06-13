<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>The World Clock</title>
  </head>
  <body>
  <h2 style="text-align: center">Current Local Times Around the World</h2>
  <c:if test="${city != null && date != null}">
  <p style="text-align: center">Current time in ${city}: <strong>${date}</strong></p>
  </c:if>
  <div style="display: flex">
    <form action="${pageContext.request.contextPath}/timezone" method="get" id="location" style="margin-left: auto; margin-right: auto">
      <select name="location" onchange="document.getElementById('location').submit()" required>
        <option value="">Select a city</option>
        <option value="Asia/Ho_Chi_Minh">Ho Chi Minh</option>
        <option value="Singapore">Singapore</option>
        <option value="Asia/Hong_Kong">Asia/Hong_Kong</option>
        <option value="Asia/Tokyo">Tokyo</option>
        <option value="Asia/Seoul">Seoul</option>
        <option value="Europe/London">London</option>
        <option value="Europe/Madrid">Madrid</option>
        <option value="America/New_York">New York</option>
        <option value="Australia/Sydney">Sydney</option>
        <option value="Argentina/Buenos_Aires">Buenos Aires</option>
      </select>
    </form>
  </div>
  </body>
</html>

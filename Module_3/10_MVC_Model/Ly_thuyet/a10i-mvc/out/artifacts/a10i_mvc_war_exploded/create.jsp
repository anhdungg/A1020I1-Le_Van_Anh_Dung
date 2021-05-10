<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Create student</h2>
<p style="color: red"><c:out value="${msg}"></c:out></p>
<form action="/student" method="post">
    <div>
        Name:
        <input type="text" name="studentName" />
    </div>
    <div>
        Date of birth:
        <input type="date" name="dateOfBirth" />
    </div>
    <div>
        <input type="submit" value="Create">
    </div>
</form>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>List student JSTL</title>
</head>
<body>
    <h2>List student JSTL</h2>
    <a href="/student?actionUser=create">Create student</a>
    <table border="1">
        <tr>
            <th>No</th>
            <th>Id</th>
            <th>Name</th>
            <th>Date of birth</th>
            <th>Gender</th>
            <th>Rank</th>
            <th>Image</th>
        </tr>
<%--        for (Student student : studentListServlet) --%>
        <c:forEach var="student" items="${studentListServlet}" varStatus="loop">
            <tr>
                <td>${loop.index + 1}</td>
                <td><c:out value="${student.id}"/></td>
                <td><c:out value="${student.name}"/></td>
                <td><c:out value="${student.dateOfBirth}"/></td>
                <td>
                    <c:if test="${student.gender == 0}">
                        Female
                    </c:if>
                    <c:if test="${student.gender == 1}">
                        Male
                    </c:if>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${student.grade >= 0 && student.grade <= 4.9}">
                            Bad
                        </c:when>
                        <c:when test="${student.grade >= 5 && student.grade <= 7.9}">
                            Good
                        </c:when>
                        <c:otherwise>
                            Very good
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <img src="img/pig.jpg" height="50" width="50" />
                </td>
            </tr>
        </c:forEach>
    </table>


</body>
</html>

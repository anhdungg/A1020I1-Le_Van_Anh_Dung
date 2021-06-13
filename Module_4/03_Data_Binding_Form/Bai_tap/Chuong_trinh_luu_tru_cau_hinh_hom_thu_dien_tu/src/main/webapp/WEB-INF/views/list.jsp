<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mailbox</title>
</head>
<body>
<a href="/create">Create</a>
<table border="1" style="margin-top: 20px">
    <tr>
        <th>Language</th>
        <th>Page Size</th>
        <th>Spam Filter</th>
        <th>Signature</th>
    </tr>
    <c:forEach items="${mailboxList}" var="mailbox">
        <tr>
            <td>${mailbox.language}</td>
            <td>${mailbox.pageSize}</td>
            <td style="text-align: center"><input type="checkbox" <c:if test="${mailbox.spamFilter}">checked</c:if> onclick="return false"></td>
            <td>${mailbox.signature}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

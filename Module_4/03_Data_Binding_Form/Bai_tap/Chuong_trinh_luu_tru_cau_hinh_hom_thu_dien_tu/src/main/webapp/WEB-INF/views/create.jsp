<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
    <style>
        th{
            text-align: left;
            padding-top: 20px;
            padding-bottom: 20px;
        }
        td{
            padding-left: 30px;
            padding-top: 20px;
            padding-bottom: 20px;
        }
    </style>
</head>
<body>
<form:form action="" method="post" modelAttribute="mailbox">
    <table>
        <tr>
            <th><form:label path="language">Languages</form:label></th>
            <td>
                <form:select path="language">
                    <form:option value="English"/>
                    <form:option value="Vietnamese"/>
                    <form:option value="Japanese"/>
                    <form:option value="Chinese"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <th><form:label path="pageSize">Page Size</form:label></th>
            <td>
                Show
                <form:select path="pageSize">
                    <form:option value="5"/>
                    <form:option value="10"/>
                    <form:option value="15"/>
                    <form:option value="25"/>
                    <form:option value="50"/>
                    <form:option value="100"/>
                </form:select>
                email per page
            </td>
        </tr>
        <tr>
            <th><form:label path="spamFilter">Spams filter</form:label></th>
            <td>
                <form:checkbox path="spamFilter"/> enable spams filter
            </td>
        </tr>
        <tr>
            <th><form:label path="spamFilter">Spams filter</form:label></th>
            <td>
                <form:textarea path="signature"/>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Create"></td>
            <td>
                <a href="/"><input type="button" value="Back"></a>
            </td>
        </tr>
    </table>
    
    

</form:form>
</body>
</html>

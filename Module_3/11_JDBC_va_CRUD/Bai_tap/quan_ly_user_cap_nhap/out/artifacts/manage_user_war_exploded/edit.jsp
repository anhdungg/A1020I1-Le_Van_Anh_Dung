<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>User Management Application</title>
    <style>
        .a-tag-button{
            background: #efefef;
            /*margin-left: auto;*/
            /*margin-right: 20px;*/
            border-radius: 2px;
            color: black;
            text-decoration: none;
            padding: 1px 6px;
            border: 1px solid #767776;
            font-family: Arial, serif;
            font-size: 13px;
            text-align: center;
        }
        .a-tag-button:hover{
            background: #dfdfdf;
        }
    </style>
</head>
<body>
<h1 style="text-align: center">User Information</h1>
<p style="text-align: center">
    <c:if test='${message == "fail"}'>
        <span style="color: red;">Update fail</span>
    </c:if>
    <c:if test='${message == "success"}'>
        <span style="color: green;">Update success</span>
    </c:if>
</p>

<div style="display: flex">
    <form action="" method="post" style="margin: 0 auto 0 auto">
        <fieldset>
            <legend>User Information</legend>
            <table>
                <tr>
                    <td>Name: </td>
                    <td><input type="text" name="name" id="name" value="${user.getName()}"></td>
                </tr>
                <tr>
                    <td>Email: </td>
                    <td><input type="text" name="email" id="email" value="${user.getEmail()}"></td>
                </tr>
                <tr>
                    <td>Country: </td>
                    <td><input type="text" name="country" id="country" value="${user.getCountry()}"></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center; padding-top: 20px">
                        <a href="/manage" class="a-tag-button">&#8592;Back</a>
                        <input type="submit" value="Update">
                    </td>
                </tr>
            </table>
        </fieldset>
    </form>
</div>
</body>
</html>

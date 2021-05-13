<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>User Management Application</title>
    <style>
        .a-tag-button{
            background: #efefef;
            margin-left: auto;
            margin-right: 20px;
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
<h1 style="text-align: center">User Management</h1>
<p style="text-align: center">
    <c:if test='${message == "fail"}'>
        <span style="color: red;">Create fail</span>
    </c:if>
    <c:if test='${message == "success"}'>
        <span style="color: green;">Create success</span>
    </c:if>
</p>
<div style="display: flex">
    <form method="post"  style="margin-right: auto; margin-left: auto">
        <fieldset>
            <legend>User Information</legend>
            <table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" id="name"></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="text" name="email" id="email"></td>
                </tr>
                <tr>
                    <td>Country:</td>
                    <td><input type="text" name="country" id="country"></td>
                </tr>
            </table>

            <div style="display: flex; margin-top: 10px">
                <a href="/manage" class="a-tag-button">&#8592;Back</a>
                <input style="margin-right: auto" type="submit" value="Save">
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>

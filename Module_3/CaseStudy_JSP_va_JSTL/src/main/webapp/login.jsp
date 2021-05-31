<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Furama resort | Login</title>
    <!-- Bootstrap core Library -->
    <link rel="stylesheet" href="${contextPath}/css/bootstrap.min.css" >
    <link rel="stylesheet" href="${contextPath}/datatables/css/dataTables.bootstrap4.min.css" >
    <!-- Google font -->
    <link href="https://fonts.googleapis.com/css?family=Dancing+Script" rel="stylesheet">
    <!-- Font Awesome-->
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <style>
        <%@ include file="/css/style_login.css" %>
    </style>
</head>
<body>
    <!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-md-offset-5 col-md-4 text-center">
                <h1 class='text-white'>Furama resort</h1>
                <div class="form-login"><br>
                    <h4>Secure Login</h4>
                    <br>
                    <span style="color: red">${error}</span>
                    <form action="" method="post">
                        <input type="hidden" name="type" value="login">
                        <input type="text" name="user" id="userName" class="form-control input-sm chat-input" value="${user}" placeholder=" username"/>
                        <br><br>
                        <input type="password" name="pass" id="userPassword" class="form-control input-sm chat-input" value="${pass}" placeholder=" password"/>
                        <br>
                        <input type="checkbox" id="remember" name="remember" >
                        <label for="remember">Remember me</label>
                        <br><br>
                        <div class="wrapper">
                            <span class="group-btn">
                                <button type="submit" class="btn btn-danger btn-md">login <i class="fa fa-sign-in"></i></button>
                            </span>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <br><br><br>
        <!--footer-->
        <div class="footer text-white text-center">
            <p>© 2020 Unique Login Form. All rights reserved | Design by <a href="https://freecss.tech">Free Css</a></p>
        </div>
        <!--//footer-->
    </div>
<script src="${contextPath}/js/jquery-3.5.1.min.js"></script>
<script src="${contextPath}/js/bootstrap.min.js"></script>
</body>
</html>

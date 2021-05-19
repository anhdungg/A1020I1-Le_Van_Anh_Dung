<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer</title>
    <link rel="icon" href="img/logo.png">
    <link rel="stylesheet" href="css/bootstrap.min.css" >
    <style>
        .display-5 {
            font-size: 2.5rem;
            font-weight: 300;
            line-height: 1.2;
        }
        .navbar-nav:hover{
            background: #dfdfdf;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp" />
<div class="container-fluid">
    <div class="row">
        <jsp:include page="item.jsp" />
        <div class="col-9" style="top: 0">
            <div class="row">
                <div class="col-12 border-left" style="height: 1000px">
                    <table class="table table-striped table-dark">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">ID Type Customer</th>
                                <th scope="col">Name</th>
                                <th scope="col">Day of birth</th>
                                <th scope="col">CMND</th>
                                <th scope="col">Phone number</th>
                                <th scope="col">Email</th>
                                <th scope="col">Address</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listCustomer}" var="customer">
                                <tr>${customer.getIdCustomer()}</tr>
                                <tr>${customer.getIdTypeCustomer()}</tr>
                                <tr>${customer.getName()}</tr>
                                <tr>${customer.getDayOfBirth()}</tr>
                                <tr>${customer.getCMND()}</tr>
                                <tr>${customer.getPhoneNumber()}</tr>
                                <tr>${customer.getEmail()}</tr>
                                <tr>${customer.getAddress()}</tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="row">
                <div class="col-12 border-top border-left">
                    <p class="" style="text-align: center">Footer</p>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
    window.onscroll = function() {myFunction()};

    function myFunction() {
        let sticky = document.getElementById("divItem");
        let navbar = document.getElementById("navbar");
        // console.log("div: " + sticky.offsetTop + " navbar: " + navbar.offsetTop + " page: " + window.pageYOffset);
        let height = 510 + window.pageYOffset;
        if (height>625){
            height = 625;
        }
        sticky.style.height = height+"px";
        if (window.pageYOffset>114){
            let top = window.pageYOffset-115;
            if (top<0){
                top = 0;
            }
            sticky.style.top = top+"px";
        }else {
            sticky.style.top = "0px";
        }
    }
</script>
</body>
</html>

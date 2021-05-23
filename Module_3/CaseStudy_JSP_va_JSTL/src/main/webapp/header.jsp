<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<div class="container-fluid">
    <ul class="list-group list-group-horizontal">
        <li class="list-group-item border-0"><a href="#"><img src="${contextPath}/img/logo.png" alt="logo" style="height: 90px"></a></li>
        <li class="list-group-item border-0 mr-0 ml-auto"><h1 class="display-5 mt-3">Anh Dũng</h1></li>
    </ul>
</div>
<nav class="navbar navbar-expand-lg navbar-light bg-light p-0 pl-5 sticky-top" id="navbar">
    <div class="collapse navbar-collapse pl-5" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/"><span class="h6">Home</span></a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#"><span class="h6">Employee</span></a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="?type=customer&action=list"><span class="h6">Customer</span></a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#"><span class="h6">Service</span></a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#"><span class="h6">Contact</span></a>
            </li>
        </ul>
        <form action="" class="form-inline my-2 my-lg-0 ml-auto mr-2">
            <c:choose>
                <c:when test="${type == 'customer'}">
                    <input type="hidden" name="type" value="customer">
                </c:when>
                <c:when test="${type == 'service'}">
                    <input type="hidden" name="type" value="service">
                </c:when>
                <c:when test="${type == 'employee'}">
                    <input type="hidden" name="type" value="employee">
                </c:when>
                <c:otherwise>
                    <input type="hidden" name="type" value="all">
                </c:otherwise>
            </c:choose>
            <input type="hidden" name="action" value="search">
            <input class="form-control mr-sm-2 h-auto" style="padding: 3px" type="search" placeholder="Search" aria-label="Search" name="value">
            <button class="btn btn-outline-success my-2 my-sm-0" style="padding: 3px" type="submit">Search</button>
        </form>
    </div>
</nav>

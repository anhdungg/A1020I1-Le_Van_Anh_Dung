<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
  <head>
    <title>Furama Resort</title>
    <link rel="icon" href="img/logo.png">
    <link rel="stylesheet" href="${contextPath}/css/bootstrap.min.css" >
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
        <jsp:include page="item.jsp"/>
        <div class="col-10" style="top: 0">
          <div class="row">
            <div class="col-12" style="height: 1000px">
              <p class = "" style="text-align: center">Body</p>
            </div>
          </div>
          <div class="row">
            <div class="col-12 border-top">
              <p class="" style="text-align: center">Footer</p>
            </div>
          </div>
        </div>
      </div>
    </div>
    <script src="${contextPath}/js/jquery-3.5.1.min.js"></script>
    <script src="${contextPath}/js/bootstrap.min.js"></script>
    <script>
      window.onscroll = function() {stickyItem()};

      function stickyItem() {
        let sticky = document.getElementById("divItem");
        let navbar = document.getElementById("navbar");
        // console.log("div: " + sticky.offsetTop + " navbar: " + navbar.offsetTop + " page: " + window.pageYOffset);
        if (window.pageYOffset>209){
          let top = window.pageYOffset-210;
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

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
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
              <ol class="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
              </ol>
              <div class="carousel-inner">
                <div class="carousel-item active">
                  <img src="img/image_1.jpg" class="d-block w-100" alt="..." style="width: 1024px; height: 768px">
                </div>
                <div class="carousel-item">
                  <img src="img/image_2.jpg" class="d-block w-100" alt="..." style="width: 1024px; height: 768px">
                </div>
                <div class="carousel-item">
                  <img src="img/image_3.jpg" class="d-block w-100" alt="..." style="width: 1024px; height: 768px">
                </div>
              </div>
              <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
              </a>
              <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
              </a>
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

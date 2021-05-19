<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Furama Resort</title>
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
  <div class="container-fluid">
    <ul class="list-group list-group-horizontal">
      <li class="list-group-item border-0"><a href="#"><img src="img/logo.png" alt="logo" style="height: 90px"></a></li>
      <li class="list-group-item border-0 mr-0 ml-auto"><h1 class="display-5 mt-3">Anh Dũng</h1></li>
    </ul>
  </div>
  <nav class="navbar navbar-expand-lg navbar-light bg-light p-0 pl-5 sticky-top" id="navbar">
    <div class="collapse navbar-collapse pl-5" id="navbarSupportedContent">
      <ul class="navbar-nav ml-auto mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="#"><span class="h6">Home</span></a>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="#"><span class="h6">Employee</span></a>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="#"><span class="h6">Customer</span></a>
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
      <form class="form-inline my-2 my-lg-0 ml-auto mr-2">
        <input class="form-control mr-sm-2 h-auto" style="padding: 3px" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" style="padding: 3px" type="submit">Search</button>
      </form>
    </div>
  </nav>

  <div class="container-fluid">
    <div class="row">
      <div class="col-3 overflow-auto" id="divItem" style="height: 510px; background: #f1f0f0">
        <ul class="list-group">
          <li class="list-group-item border-0" style="background: #f1f0f0">
            <a href="#">Item One</a>
          </li>
          <li class="list-group-item border-0" style="background: #f1f0f0">
            <a href="#">Item Tow</a>
          </li>
          <li class="list-group-item border-0" style="background: #f1f0f0">
            <a href="#">Item Three</a>
          </li>
        </ul>
      </div>
      <div class="col-9" style="top: 0">
        <div class="row">
          <div class="col-12 border-left" style="height: 1000px">
            <p class = "" style="text-align: center">Body</p>
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

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Service</title>
    <link rel="icon" href="img/logo.png">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
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
        .modal-confirm {
            color: #636363;
            width: 325px;
            font-size: 14px;
        }
        .modal-confirm .modal-content {
            padding: 20px;
            border-radius: 5px;
            border: none;
        }
        .modal-confirm .modal-header {
            border-bottom: none;
            position: relative;
        }
        .modal-confirm h4 {
            text-align: center;
            font-size: 26px;
            margin: 30px 0 -15px;
        }
        .modal-confirm .form-control, .modal-confirm .btn {
            min-height: 40px;
            border-radius: 3px;
        }
        .modal-confirm .close {
            position: absolute;
            top: -5px;
            right: -5px;
        }
        .modal-confirm .modal-footer {
            border: none;
            text-align: center;
            border-radius: 5px;
            font-size: 13px;
        }
        .modal-confirm .icon-box {
            color: #fff;
            position: absolute;
            margin: 0 auto;
            left: 0;
            right: 0;
            top: -70px;
            width: 95px;
            height: 95px;
            border-radius: 50%;
            z-index: 9;
            /*background: #82ce34;*/
            padding: 15px;
            text-align: center;
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
        }
        .modal-confirm .icon-box i {
            font-size: 58px;
            position: relative;
            top: 3px;
        }
        .modal-confirm.modal-dialog {
            margin-top: 80px;
        }
        .modal-confirm .btn {
            color: #fff;
            border-radius: 4px;
            /*background: #82ce34;*/
            text-decoration: none;
            transition: all 0.4s;
            line-height: normal;
            border: none;
        }
        .modal-confirm .btn:hover, .modal-confirm .btn:focus {
            /*background: #6fb32b;*/
            /*outline: none;*/
        }
        .trigger-btn {
            display: inline-block;
            margin: 100px auto;
        }
    </style>
</head>
<body>
<c:if test="${action == 'create'}">
    <div class="modal fade" id="createModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <div>
                    <h5 class="modal-title">New service</h5>
                    <p class="m-0" style="color: red">${status}</p>
                </div>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="?type=service&action=create" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="id">ID</label>
                        <input class="form-control" type="text" name="id" id="id" value="${id}">
                        <span style="color: red">${validateId}</span>
                    </div>
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input class="form-control" type="text" name="name" id="name" value="${name}">
                        <span style="color: red">${validateName}</span>
                    </div>
                    <div class="form-group">
                        <label for="area">Area</label>
                        <input class="form-control" type="text" name="area" id="area" value="${area}">
                        <span style="color: red">${validateArea}</span>
                    </div>
                    <div class="form-group">
                        <label for="rentalCosts">Rental Costs</label>
                        <input class="form-control" type="text" name="rentalCosts" id="rentalCosts" value="${rentalCosts}">
                        <span style="color: red">${validateRentalCosts}</span>
                    </div>
                    <div class="form-group">
                        <label for="maximumNumberOfPeople">Maximum Number Of People</label>
                        <input class="form-control" type="number" name="maximumNumberOfPeople" id="maximumNumberOfPeople" value="${maximumNumberOfPeople}">
                        <span style="color: red">${validateMaximumPeople}</span>
                    </div>
                    <div class="form-group">
                        <label for="idRentalType">Rental Type</label>
                        <select name="idRentalType" id="idRentalType" class="form-control" required>
                            <option value="" id="0">Please choose</option>
                            <option value="1" id="1">Hour</option>
                            <option value="2" id="2">Day</option>
                            <option value="3" id="3">Month</option>
                            <option value="4" id="4">Year</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="idServiceType">Service Type</label>
                        <select name="idServiceType" id="idServiceType" class="form-control" onchange="selectTypeService()" required>
                            <option value="" id="5">Please choose</option>
                            <option value="1" id="6">Villa</option>
                            <option value="2" id="7">House</option>
                            <option value="3" id="8">Room</option>
                        </select>
                    </div>
                    <div id="divStandard" style="display: none">
                        <div class="form-group" style="display: block">
                            <label for="standard">Standard</label>
                            <input class="form-control" type="text" name="standard" id="standard" value="${standard}">
                            <span style="color: red">${validateStandard}</span>
                        </div>
                    </div>
                    <div id="divDescription" style="display: none">
                        <div class="form-group">
                            <label for="description">Description</label>
                            <input class="form-control" type="text" name="description" id="description" value="${description}">
                        </div>
                    </div>
                    <div id="divPoolArea" style="display: none">
                        <div class="form-group">
                            <label for="poolArea">Pool area</label>
                            <input class="form-control" type="text" name="poolArea" id="poolArea" value="${poolArea}">
                            <span style="color: red">${validatePoolArea}</span>
                        </div>
                    </div>
                    <div id="divNumberOfFloors" style="display: none">
                        <div class="form-group">
                            <label for="numberOfFloors">Number of floors</label>
                            <input class="form-control" type="number" name="numberOfFloors" id="numberOfFloors" value="${numberOfFloors}">
                            <span style="color: red">${validateNumberOfFloors}</span>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save</button>
                </div>
            </form>
        </div>
    </div>
</div>
</c:if>
<c:if test="${action == 'statusSave'}">
    <div class="modal fade" id="viewStatusSave">
        <div class="modal-dialog modal-confirm">
            <div class="modal-content">
                <div class="modal-header">
                    <div class="icon-box" style="background: #82ce34;">
                        <i class="material-icons">&#xE876;</i>
                    </div>
                    <h2 class="modal-title w-100 text-center">Success!</h2>
                </div>
                <div class="modal-body">
                    <p class="text-center">Tao moi dich vu thanh cong</p>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-success btn-block" data-dismiss="modal">OK</button>
                </div>
            </div>
        </div>
    </div>
</c:if>
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

    function selectTypeService(){
        let typeService = document.getElementById("idServiceType").value;
        switch (typeService) {
            case "1":
                document.getElementById("divStandard").style.display = "block";
                document.getElementById("divDescription").style.display = "block";
                document.getElementById("divPoolArea").style.display = "block";
                document.getElementById("divNumberOfFloors").style.display = "block";
                document.getElementById("standard").value = "";
                document.getElementById("poolArea").value = "";
                document.getElementById("numberOfFloors").value = "";
                break;
            case "2":
                document.getElementById("divStandard").style.display = "block";
                document.getElementById("divDescription").style.display = "block";
                document.getElementById("divPoolArea").style.display = "none";
                document.getElementById("divNumberOfFloors").style.display = "block";
                document.getElementById("standard").value = "";
                document.getElementById("poolArea").value = "0";
                document.getElementById("numberOfFloors").value = "";
                break;
            case "3":
                document.getElementById("divStandard").style.display = "none";
                document.getElementById("divDescription").style.display = "none";
                document.getElementById("divPoolArea").style.display = "none";
                document.getElementById("divNumberOfFloors").style.display = "none";
                document.getElementById("standard").value = "";
                document.getElementById("poolArea").value = "0";
                document.getElementById("numberOfFloors").value = "0";
                break;
            default:
                document.getElementById("divStandard").style.display = "none";
                document.getElementById("divDescription").style.display = "none";
                document.getElementById("divPoolArea").style.display = "none";
                document.getElementById("divNumberOfFloors").style.display = "none";
                document.getElementById("standard").value = "";
                document.getElementById("poolArea").value = "0";
                document.getElementById("numberOfFloors").value = "0";
        }
    }

    function select(){
        <c:if test="${idRentalType != null && idServiceType != null}">
            let id = ${idRentalType};
            let str = "";
            switch (id) {
                case 1:
                    str = "1";
                    break;
                case 2:
                    str = "2";
                    break;
                case 3:
                    str = "3";
                    break;
                case 4:
                    str = "4";
                    break;
                default:
                    str = "0";
            }
            document.getElementById(str).selected = true;
            id = ${idServiceType};
            str = "";
            switch (id) {
                case 1:
                    str = "6";
                    break;
                case 2:
                    str = "7";
                    break;
                case 3:
                    str = "8";
                    break;
                default:
                    str = "5";
            }
            document.getElementById(str).selected = true;
        </c:if>
    }

    $(window).on('load', function() {
        $('#viewStatusSave').modal('show');
        $('#createModal').modal('show');
        select();
        selectTypeService();
    });
</script>
</body>
</html>

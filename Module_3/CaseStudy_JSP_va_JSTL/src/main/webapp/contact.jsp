<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
    <head>
        <title>Contact</title>
        <link rel="icon" href="img/logo.png">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="${contextPath}/css/bootstrap.min.css" >
        <link rel="stylesheet" href="${contextPath}/datatables/css/dataTables.bootstrap4.min.css" >
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
</head>
<body>
<c:if test="${action == 'create'}">
    <div class="modal fade" id="createContact" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <div>
                        <h5 class="modal-title">Add new contact</h5>
                        <p style="color: red" class="m-0">${status}</p>
                    </div>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form action="?type=contact&action=create" method="post">
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="createIdEmployee">Employee</label>
                            <select name="idEmployee" id="createIdEmployee" class="form-control" required>
                                <option value="">Please choose employee</option>
                                <c:forEach items="${listEmployee}" var="employee">
                                    <option value="${employee.id}" id="employee${employee.id}">${employee.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="createIdCustomer">Customer</label>
                            <select name="idCustomer" id="createIdCustomer" class="form-control" required>
                                <option value="">Please choose customer</option>
                                <c:forEach items="${listCustomer}" var="customer">
                                    <option value="${customer.idCustomer}" id="customer${customer.idCustomer}">${customer.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="createIdService">Service</label>
                            <select name="idService" id="createIdService" class="form-control" onclick="calculatorTotalMoney()" required>
                                <option value="">Please choose service</option>
                                <c:forEach items="${listService}" var="service">
                                    <option value="${service.id}" id="service${service.id}">${service.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="createContactDate">Contact date</label>
                            <input class="form-control" type="date" name="contactDate" id="createContactDate" value="${contactDate}" onchange="calculatorTotalMoney()">
                            <span style="color: red">${validateContactDate}</span>
                        </div>
                        <div class="form-group">
                            <label for="createEndDate">End date</label>
                            <input class="form-control" type="date" name="endDate" id="createEndDate" value="${endDate}" onchange="calculatorTotalMoney()">
                            <span style="color: red" id="validateEndDate">${validateEndDate}</span>
                        </div>
                        <div class="form-group">
                            <label for="createDepositMoney">Deposit money</label>
                            <input class="form-control" type="number" name="depositMoney" id="createDepositMoney" value="${depositMoney}">
                            <span style="color: red">${validateDepositMoney}</span>
                        </div>
                        <div class="form-group">
                            <label for="createTotalMoney">Total money</label>
                            <input class="form-control" type="text" name="totalMoney" id="createTotalMoney" value="${totalMoney}" readonly>
                            <span style="color: red">${validateTotalMoney}</span>
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
<c:if test="${action == 'createDetail'}">
    <div class="modal fade" id="createContactDetail" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <div>
                        <h5 class="modal-title">Add new contact detail</h5>
                        <p style="color: red" class="m-0">${status}</p>
                    </div>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form action="?type=contact&action=createDetail" method="post">
                    <div class="modal-body">
                        <div class="form-group">
                                <label for="idContact">Contact</label>
                                <select name="idContact" id="idContact" class="form-control" required>
                                    <option value="">Please choose contact</option>
                                    <c:forEach items="${listContact}" var="contact">
                                        <option value="${contact.id}" id="contact${contact.id}">${contact.id}</option>
                                    </c:forEach>
                                </select>
                        </div>
                        <div class="form-group">
                                <label for="idAccompaniedService">Accompanied Service</label>
                                <select name="idAccompaniedService" id="idAccompaniedService" class="form-control" required>
                                    <option value="">Please choose accompanied service</option>
                                    <c:forEach items="${listAccompaniedService}" var="accompaniedService">
                                        <option value="${accompaniedService.id}" id="accompaniedService${accompaniedService.id}">${accompaniedService.name}</option>
                                    </c:forEach>
                                </select>
                        </div>
                        <div class="form-group">
                            <label for="amount">Amount</label>
                            <input class="form-control" type="number" name="amount" id="amount" value="${amount}">
                            <span style="color: red">${validateAmount}</span>
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
                    <p class="text-center">${status}</p>
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
                <div class="col-12">
                    <p class = "display-5" style="text-align: center">List contact</p>
                </div>
            </div>
            <div class="row">
                <div class="col-12 pl-1 pr-1">
                    <table id="tableContact" class="table table-striped" style="width: 100%">
                        <thead>
                        <tr>
                            <th scope="col">Name customer</th>
                            <th scope="col">Type customer</th>
                            <th scope="col">Name service</th>
                            <th scope="col">Type service</th>
                            <th scope="col">Contact date</th>
                            <th scope="col">End date</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listContactView}" var="contactView">
                            <tr>
                                <td>${contactView.nameCustomer}</td>
                                <td>${contactView.typeCustomer}</td>
                                <td>${contactView.nameService}</td>
                                <td>${contactView.typeService}</td>
                                <td>${contactView.contactDate}</td>
                                <td>${contactView.endDate}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${contextPath}/js/jquery-3.5.1.min.js"></script>
<script src="${contextPath}/datatables/js/jquery.dataTables.min.js"></script>
<script src="${contextPath}/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="${contextPath}/js/bootstrap.min.js"></script>
<script>
    class Service{
        constructor(id, rentalCosts) {
            this._id = id;
            this._rentalCosts = rentalCosts;
        }

        get id() {
            return this._id;
        }

        set id(value) {
            this._id = value;
        }

        get rentalCosts() {
            return this._rentalCosts;
        }

        set rentalCosts(value) {
            this._rentalCosts = value;
        }
    }
    let betweenDate = null;
    let list = [];
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
    function select(){
        <c:if test="${action == 'create' && idEmployee != null && idCustomer != null && idService != null}">
        document.getElementById("employee${idEmployee}").selected = true;
        document.getElementById("customer${idCustomer}").selected = true;
        document.getElementById("service${idService}").selected = true;
        </c:if>
        <c:if test="${action == 'createDetail' && idContact != null && idAccompaniedService != null}">
        document.getElementById("contact${idContact}").selected = true;
        document.getElementById("accompaniedService${idAccompaniedService}").selected = true;
        </c:if>
    }

    function calculatorBetweenDate(){
        <c:if test="${action == 'create' || action == 'createDetail'}">
        let contactDate = document.getElementById("createContactDate").value;
        let endDate = document.getElementById("createEndDate").value;
        if (contactDate !== "" && endDate != ""){
            let date1 = new Date(contactDate);
            let date2 = new Date(endDate);
            betweenDate = (date2.getTime() - date1.getTime()) / (1000 * 3600 * 24);
            if (betweenDate === 0){
                betweenDate = 1;
            }
            if (betweenDate < 0){
                document.getElementById("validateEndDate").innerHTML = "Ngay ket thuc phai lon hon hoac bang ngay lam hop dong";
            }else {
                document.getElementById("validateEndDate").innerHTML = "";
            }
        }
        </c:if>
    }

    function getService(){
        <c:if test="${listService != null}">
        <c:forEach items="${listService}" var="Service">
            list.push(new Service("${Service.id}", ${Service.rentalCosts}))
        </c:forEach>
        </c:if>
    }

    function calculatorTotalMoney(){
        calculatorBetweenDate();
        let idServiceInput = document.getElementById("createIdService").value;
        if (idServiceInput !== ""){
            let index=0;
            let status = false;
            for (index=0; index<list.length; index++){
                if (list[index].id ===  idServiceInput){
                    status = true;
                    break;
                }
            }
            if (status){
                if (betweenDate != null) {
                    if (betweenDate >= 0) {
                        let result = betweenDate * list[index].rentalCosts;
                        document.getElementById("createTotalMoney").value = "" + result;
                        console.log(result);
                    } else {
                        document.getElementById("createTotalMoney").value = "";
                    }
                }
            }
        }
    }

    $(document).ready(function () {
        $('#tableContact').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });

    $(window).on('load', function() {
        $('#createContact').modal('show');
        $('#viewStatusSave').modal('show');
        $('#createContactDetail').modal('show');
        select();
        calculatorBetweenDate();
        <c:if test="${listService != null}">
            getService();
        </c:if>
    });
</script>
</body>
</html>
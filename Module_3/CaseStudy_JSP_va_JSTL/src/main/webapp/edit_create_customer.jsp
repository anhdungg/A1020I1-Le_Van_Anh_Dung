<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Customer</title>
    <link rel="icon" href="img/logo.png">
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
        tr{
            text-align: center;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp" />
<div class="container-fluid">
    <div class="row">
        <jsp:include page="item.jsp"/>
        <div class="col-10">
            <div class="row">
                <div class="col-12">
                    <c:if test="${action == 'create'}">
                        <h1 class="display-5 text-center">New customer</h1>
                    </c:if>
                    <c:if test="${action == 'edit'}">
                        <h1 class="display-5 text-center">Edit customer</h1>
                    </c:if>
                    <c:if test="${action == 'search'}">
                        <c:if test="${listCustomer != null}">
                            <h1 class="display-5 text-center">Search result for "${value}"</h1>
                        </c:if>
                        <c:if test="${listCustomer == null}">
                            <h1 class="display-5 text-center">No results found for "${value}"</h1>
                        </c:if>
                    </c:if>
                    <c:if test="${action == 'delete'}">
                        <h1 class="display-5 text-center">Are you sure?</h1>
                    </c:if>
                </div>
            </div>
            <div class="row">
                <div class="col-12 pl-0 pr-1">
                    <form action="" method="post">
                        <input type="hidden" name="type" value="customer">
                        <c:if test="${action == 'create'}">
                            <input type="hidden" name="action" value="create">
                            <div class="form-row">
                                <div class="form-group col-6">
                                    <label for="createName">Name</label>
                                    <input class="form-control" type="text" name="name" id="createName">
                                </div>
                                <div class="form-group col-6">
                                    <label for="createDayOfBirth">Day of birth:</label>
                                    <input class="form-control" type="date" name="dayOfBirth" id="createDayOfBirth">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-6">
                                    <label for="createCMND">CMND</label>
                                    <input class="form-control" type="text" name="CMND" id="createCMND">
                                </div>
                                <div class="form-group col-6">
                                    <label for="createPhoneNumber">Phone number:</label>
                                    <input class="form-control" type="text" name="phoneNumber" id="createPhoneNumber">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-6">
                                    <label for="createIdTypeCustomer">Choose type customer</label>
                                    <select class="form-control" name="idTypeCustomer" id="createIdTypeCustomer" required>
                                        <option value="">--Please choose an option--</option>
                                        <option value="1">Diamond</option>
                                        <option value="2">Platinium</option>
                                        <option value="3">Gold</option>
                                        <option value="4">Silver</option>
                                        <option value="5">Member</option>
                                    </select>
                                </div>
                                <div class="form-group col-6">
                                    <label for="createEmail">Email</label>
                                    <input class="form-control" type="text" name="email" id="createEmail">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="createAddress">Address</label>
                                <input class="form-control" type="text" name="address" id="createAddress">
                            </div>
                        </c:if>
                        <c:if test="${action == 'edit' || action == 'delete'}">
                            <input type="hidden" name="action" value="edit">
                            <div class="form-row">
                                <div class="form-group col-6">
                                    <label for="id">ID</label><br>
                                    <input class="form-control" type="number" name="id" id="id" value="${customer.getIdCustomer()}" readonly>
                                </div>
                                <div class="form-group col-6">
                                    <label for="idTypeCustomer">ID type customer</label>
                                    <select class="form-control" name="idTypeCustomer" id="idTypeCustomer" required>
                                        <option value="">--Please choose an option--</option>
                                        <option value="1" id="Diamond">Diamond</option>
                                        <option value="2" id="Platinium">Platinium</option>
                                        <option value="3" id="Gold">Gold</option>
                                        <option value="4" id="Silver">Silver</option>
                                        <option value="5" id="Member">Member</option>
                                    </select>
<%--                                    <input class="form-control" type="number" name="idTypeCustomer" id="idTypeCustomer" value="${customer.getIdTypeCustomer()}">--%>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-6">
                                    <label for="name">Name</label>
                                    <input class="form-control" type="text" name="name" id="name" value="${customer.getName()}">
                                </div>
                                <div class="form-group col-6">
                                    <label for="dayOfBirth">Day of birth:</label>
                                    <input class="form-control" type="date" name="dayOfBirth" id="dayOfBirth" value="${customer.getDayOfBirth()}">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-6">
                                    <label for="CMND">CMND</label>
                                    <input class="form-control" type="text" name="CMND" id="CMND" value="${customer.getCMND()}">
                                </div>
                                <div class="form-group col-6">
                                    <label for="phoneNumber">Phone number:</label>
                                    <input class="form-control" type="text" name="phoneNumber" id="phoneNumber" value="${customer.getPhoneNumber()}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input class="form-control" type="text" name="email" id="email" value="${customer.getEmail()}">
                            </div>
                            <div class="form-group">
                                <label for="address">Address</label>
                                <input class="form-control" type="text" name="address" id="address" value="${customer.getAddress()}">
                            </div>
                        </c:if>
                        <c:if test="${action == 'search'}">
                            <c:if test="${listCustomer != null}">
                                <table id="tableCustomer" class="table table-striped" style="width: 100%">
                                    <thead>
                                    <tr>
                                        <th scope="col">ID</th>
                                        <th scope="col">Type Customer</th>
                                        <th scope="col">Name</th>
                                        <th scope="col">Day of birth</th>
                                        <th scope="col">CMND</th>
                                        <th scope="col">Phone number</th>
                                        <th scope="col">Email</th>
                                        <th scope="col">Address</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${listCustomer}" var="customer" varStatus="count">
                                        <tr onmouseover="showButton(${count.index})" onmouseout="hideButton(${count.index})">
                                            <td>${customer.getIdCustomer()}</td>
                                            <c:choose>
                                                <c:when test="${customer.getIdTypeCustomer() == 1}">
                                                    <td>Diamond</td>
                                                </c:when>
                                                <c:when test="${customer.getIdTypeCustomer() == 2}">
                                                    <td>Platinium</td>
                                                </c:when>
                                                <c:when test="${customer.getIdTypeCustomer() == 3}">
                                                    <td>Gold</td>
                                                </c:when>
                                                <c:when test="${customer.getIdTypeCustomer() == 4}">
                                                    <td>Silver</td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td>Member</td>
                                                </c:otherwise>
                                            </c:choose>
                                            <td>${customer.getName()}</td>
                                            <td>${customer.getDayOfBirth()}</td>
                                            <td>${customer.getCMND()}</td>
                                            <td>${customer.getPhoneNumber()}</td>
                                            <td>${customer.getEmail()}</td>
                                            <td class="position-relative">
                                                    ${customer.getAddress()}
                                                <div class="position-absolute" id="button${count.index}" style="right: 2%; top: 8%; display: none">
                                                    <a href="?type=customer&action=edit&id=${customer.getIdCustomer()}">
                                                        <button type="button" class="btn btn-warning p-1">Edit</button>
                                                    </a>
                                                    <a href="?type=customer&action=delete&id=${customer.getIdCustomer()}">
                                                        <button type="button" class="btn btn-danger p-1">Delete</button>
                                                    </a>
                                                </div>
                                            </td>

                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </c:if>
                        </c:if>
                        <div class="form-row">
                            <c:if test="${action == null}">
                                <a href="?type=customer&action=list" class="ml-auto mr-auto">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                </a>
                            </c:if>
                            <c:if test="${action != null}">
                                <c:choose>
                                    <c:when test="${action == 'delete'}">
                                        <a href="?type=customer&action=list" class="ml-auto mr-2">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        </a>
                                        <button type="submit" class="btn btn-danger ml-2 mr-auto">Yes</button>
                                    </c:when>
                                    <c:when test="${action == 'edit' || action == 'create'}">
                                        <a href="?type=customer&action=list" class="ml-auto mr-2">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        </a>
                                        <button type="submit" class="btn btn-primary ml-2 mr-auto">Save</button>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="?type=customer&action=list" class="ml-auto mr-auto">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        </a>
                                    </c:otherwise>
                                </c:choose>
                            </c:if>
                        </div>
                    </form>
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
    function showButton(index){
        let button = document.getElementById("button" + index);
        button.style.display = "block";
    }

    function hideButton(index){
        let button = document.getElementById("button" + index);
        button.style.display = "none";
    }
    function editSelect(){
        <c:if test="${customer.getIdTypeCustomer() != null}">
            let id = ${customer.getIdTypeCustomer()};
            let str = "";
            switch (id) {
                case 1:
                    str = "Diamond";
                    break;
                case 2:
                    str = "Platinium";
                    break;
                case 3:
                    str = "Gold";
                    break;
                case 4:
                    str = "Silver";
                    break;
                case 5:
                    str = "Member";
                    break;
            }
            document.getElementById(str).selected = true;
        </c:if>
    }
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 10
        });
    });
    $(window).on('load', function() {
    //     if($('#viewStatusSave').length){
    //         $('#viewStatusSave').modal('show');
            editSelect();
    //     }
    });
</script>
</body>
</html>

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
<!-- Modal -->
<%--<c:if test="${customer != null}">--%>
<%--    <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">--%>
<%--        <div class="modal-dialog" role="document">--%>
<%--            <div class="modal-content">--%>
<%--                <div class="modal-header">--%>
<%--                    <h5 class="modal-title" id="exampleModalLabel">Edit customer</h5>--%>
<%--                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                        <span aria-hidden="true">&times;</span>--%>
<%--                    </button>--%>
<%--                </div>--%>
<%--                <form action="?type=customer&action=edit" method="post">--%>
<%--                    <div class="modal-body">--%>
<%--                        <div class="form-row">--%>
<%--                            <div class="form-group col-6">--%>
<%--                                <label for="id">ID</label><br>--%>
<%--                                <input class="form-control" type="number" name="id" id="id" value="${customer.getIdCustomer()}" readonly>--%>
<%--                            </div>--%>
<%--                            <div class="form-group col-6">--%>
<%--                                <label for="idTypeCustomer">ID type customer</label>--%>
<%--                                <input class="form-control" type="number" name="idTypeCustomer" id="idTypeCustomer" value="${customer.getIdTypeCustomer()}">--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="form-row">--%>
<%--                            <div class="form-group col-6">--%>
<%--                                <label for="name">Name</label>--%>
<%--                                <input class="form-control" type="text" name="name" id="name" value="${customer.getName()}">--%>
<%--                            </div>--%>
<%--                            <div class="form-group col-6">--%>
<%--                                <label for="dayOfBirth">Day of birth:</label>--%>
<%--                                <input class="form-control" type="date" name="dayOfBirth" id="dayOfBirth" value="${customer.getDayOfBirth()}">--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="form-row">--%>
<%--                            <div class="form-group col-6">--%>
<%--                                <label for="CMND">CMND</label>--%>
<%--                                <input class="form-control" type="text" name="CMND" id="CMND" value="${customer.getCMND()}">--%>
<%--                            </div>--%>
<%--                            <div class="form-group col-6">--%>
<%--                                <label for="phoneNumber">Phone number:</label>--%>
<%--                                <input class="form-control" type="text" name="phoneNumber" id="phoneNumber" value="${customer.getPhoneNumber()}">--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="form-group">--%>
<%--                            <label for="email">Email</label>--%>
<%--                            <input class="form-control" type="text" name="email" id="email" value="${customer.getEmail()}">--%>
<%--                        </div>--%>
<%--                        <div class="form-group">--%>
<%--                            <label for="address">Address</label>--%>
<%--                            <input class="form-control" type="text" name="address" id="address" value="${customer.getAddress()}">--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="modal-footer">--%>
<%--                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
<%--                        <button type="submit" class="btn btn-primary">Save</button>--%>
<%--                    </div>--%>
<%--                </form>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</c:if>--%>
<%--<c:if test="${statusSave != null}">--%>
<%--    <div class="modal fade" id="viewStatusSave">--%>
<%--        <div class="modal-dialog modal-confirm">--%>
<%--            <div class="modal-content">--%>
<%--                <c:if test="${statusSave == 'success'}">--%>
<%--                    <div class="modal-header">--%>
<%--                        <div class="icon-box">--%>
<%--                            <i class="material-icons">&#xE876;</i>--%>
<%--                        </div>--%>
<%--                        <h2 class="modal-title w-100 text-center">Success!</h2>--%>
<%--                    </div>--%>
<%--                </c:if>--%>
<%--                <c:if test="${statusSave == 'fail'}">--%>
<%--                    <div class="modal-header">--%>
<%--                        <div class="icon-box" style="background: red">--%>
<%--                            <i class="material-icons">&#xE888;</i>--%>
<%--                        </div>--%>
<%--                        <h2 class="modal-title w-100 text-center">Fail!</h2>--%>
<%--                    </div>--%>
<%--                </c:if>--%>
<%--                <div class="modal-body">--%>
<%--                    <c:if test="${action == 'create'}">--%>
<%--                        <c:if test="${statusSave == 'success'}">--%>
<%--                            <p class="text-center">New customer saved.</p>--%>
<%--                        </c:if>--%>
<%--                        <c:if test="${statusSave == 'fail'}">--%>
<%--                            <p class="text-center">New customers are not saved.</p>--%>
<%--                        </c:if>--%>
<%--                    </c:if>--%>
<%--                    <c:if test="${action == 'edit'}">--%>
<%--                        <c:if test="${statusSave == 'success'}">--%>
<%--                            <p class="text-center">Successful customer editing.</p>--%>
<%--                        </c:if>--%>
<%--                        <c:if test="${statusSave == 'fail'}">--%>
<%--                            <p class="text-center">Failed customer editing.</p>--%>
<%--                        </c:if>--%>
<%--                    </c:if>--%>
<%--                    <c:if test="${action == 'delete'}">--%>
<%--                        <c:if test="${statusSave == 'success'}">--%>
<%--                            <p class="text-center">Delete customer successfully.</p>--%>
<%--                        </c:if>--%>
<%--                        <c:if test="${statusSave == 'fail'}">--%>
<%--                            <p class="text-center">Delete customer failed.</p>--%>
<%--                        </c:if>--%>
<%--                    </c:if>--%>
<%--                </div>--%>
<%--                <div class="modal-footer">--%>
<%--                    <button class="btn btn-success btn-block" data-dismiss="modal">OK</button>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</c:if>--%>
<%--<div class="modal fade" id="createModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">--%>
<%--    <div class="modal-dialog" role="document">--%>
<%--        <div class="modal-content">--%>
<%--            <div class="modal-header">--%>
<%--                <h5 class="modal-title">Add new customer</h5>--%>
<%--                <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                    <span aria-hidden="true">&times;</span>--%>
<%--                </button>--%>
<%--            </div>--%>
<%--            <form action="?type=customer&action=create" method="post">--%>
<%--                <div class="modal-body">--%>
<%--                    <div class="form-row">--%>
<%--                        <div class="form-group col-6">--%>
<%--                            <label for="createName">Name</label>--%>
<%--                            <input class="form-control" type="text" name="name" id="createName">--%>
<%--                        </div>--%>
<%--                        <div class="form-group col-6">--%>
<%--                            <label for="createDayOfBirth">Day of birth:</label>--%>
<%--                            <input class="form-control" type="date" name="dayOfBirth" id="createDayOfBirth">--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="form-row">--%>
<%--                        <div class="form-group col-6">--%>
<%--                            <label for="createCMND">CMND</label>--%>
<%--                            <input class="form-control" type="text" name="CMND" id="createCMND">--%>
<%--                        </div>--%>
<%--                        <div class="form-group col-6">--%>
<%--                            <label for="createPhoneNumber">Phone number:</label>--%>
<%--                            <input class="form-control" type="text" name="phoneNumber" id="createPhoneNumber">--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="form-row">--%>
<%--                        <div class="form-group col-6">--%>
<%--                            <label for="createIdTypeCustomer">ID type customer</label>--%>
<%--                            <input class="form-control" type="number" name="idTypeCustomer" id="createIdTypeCustomer">--%>
<%--                        </div>--%>
<%--                        <div class="form-group col-6">--%>
<%--                            <label for="createEmail">Email</label>--%>
<%--                            <input class="form-control" type="text" name="email" id="createEmail">--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <label for="createAddress">Address</label>--%>
<%--                        <input class="form-control" type="text" name="address" id="createAddress">--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="modal-footer">--%>
<%--                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
<%--                    <button type="submit" class="btn btn-primary">Save</button>--%>
<%--                </div>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<c:if test="${action == 'delete'}">
    <div class="modal fade" id="viewDelete">
        <div class="modal-dialog modal-confirm">
            <div class="modal-content">
                <div class="modal-header">
                    <h2 class="modal-title w-100 text-center">Are you sure?</h2>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">No</button>
                    <form action="" method="post" class="p-0 m-0">
                        <input type="hidden" name="id" value="${id}">
                        <button type="submit" class="btn btn-danger">Yes</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</c:if>
<jsp:include page="header.jsp" />
<div class="container-fluid">
    <div class="row">
<%--        <jsp:include page="item.jsp" />--%>
        <div class="col-12">
            <div class="list-group list-group-horizontal">
                <div class="list-group-item mr-auto ml-auto display-5 border-0">
                    List Of Customer
                </div>
                <div class="list-group-item mr-0 ml-auto p-0 border-0">
                    <a href="?type=customer&action=create">
<%--                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#createModal">New customer</button>--%>
                        <button type="button" class="btn btn-primary">New customer</button>
                    </a>
                </div>
            </div>
            <div class="row">
                <div class="col-12 pl-1 pr-1">
                    <table id="tableCustomer" class="table table-striped table-dark" style="width: 100%">
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
                                        <c:when test="${customer.getIdTypeCustomer() == 2}">
                                            <td>Gold</td>
                                        </c:when>
                                        <c:when test="${customer.getIdTypeCustomer() == 2}">
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
                </div>
            </div>
            <div class="row">
                <jsp:include page="footer.jsp"/>
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
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 10
        });
    });
    $(window).on('load', function() {
        // $('#editModal').modal('show');
        $('#viewDelete').modal('show');
    });
    // $(window).on('load', function() {
    //     $('#viewStatusSave').modal('show');
    // });
</script>
</body>
</html>

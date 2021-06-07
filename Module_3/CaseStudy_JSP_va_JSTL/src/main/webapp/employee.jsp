<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Employee</title>
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
        tr{
            text-align: center;
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
<c:if test="${action == 'edit'}">
    <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <div>
                        <h5 class="modal-title">Edit employee</h5>
                        <p class="m-0" style="color: red">${status}</p>
                    </div>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form action="?type=employee&action=edit" method="post">
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="id">ID</label><br>
                            <input class="form-control" type="number" name="id" id="id" value="${employee.id}${id}" readonly>
                        </div>
                        <div class="form-group">
                            <label for="name">Name</label>
                            <input class="form-control" type="text" name="name" id="name" value="${employee.name}${name}" required>
                            <span style="color: red">${validateName}</span>
                        </div>
                        <div class="form-group">
                            <label for="idPosition">Position</label>
                            <select class="form-control" name="idPosition" id="idPosition" required>
                                <option value="1" id="position1">Lễ tân</option>
                                <option value="2" id="position2">Phục vụ</option>
                                <option value="3" id="position3">Chuyên viên</option>
                                <option value="4" id="position4">Giám sát</option>
                                <option value="5" id="position5">Quản lý</option>
                                <option value="6" id="position6">Giám đốc</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="idEducationDegree">Education degree</label>
                            <select class="form-control" name="idEducationDegree" id="idEducationDegree" required>
                                <option value="1" id="educationDegree1">Trung cấp</option>
                                <option value="2" id="educationDegree2">Cao đẳng</option>
                                <option value="3" id="educationDegree3">Đại học</option>
                                <option value="4" id="educationDegree4">Sau đại hoc</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="idDivision">Division</label>
                            <select class="form-control" name="idDivision" id="idDivision" required>
                                <option value="1" id="division1">Sale-Marketing</option>
                                <option value="2" id="division2">Hành chính</option>
                                <option value="3" id="division3">Phục vụ</option>
                                <option value="4" id="division4">Quản lý</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="dayOfBirth">Day of birth</label>
                            <input class="form-control" type="date" name="dayOfBirth" id="dayOfBirth" value="${employee.dayOfBirth}${dayOfBirth}" required>
                            <span style="color: red">${validateDateOfBirth}</span>
                        </div>
                        <div class="form-group">
                            <label for="cmnd">CMND</label>
                            <input class="form-control" type="number" name="cmnd" id="cmnd" value="${employee.CMND}${CMND}" required>
                            <span style="color: red">${validateCMND}</span>
                        </div>
                        <div class="form-group">
                            <label for="salary">Salary</label>
                            <input class="form-control" type="text" name="salary" id="salary" value="${employee.salary}${salary}" required>
                            <span style="color: red">${validateSalary}</span>
                        </div>
                        <div class="form-group">
                            <label for="phoneNumber">Phone number</label>
                            <input class="form-control" type="text" name="phoneNumber" id="phoneNumber" value="${employee.phoneNumber}${phoneNumber}" required>
                            <span style="color: red">${validatePhoneNumber}</span>
                        </div>
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input class="form-control" type="text" name="email" id="email" value="${employee.email}${email}" required>
                            <span style="color: red">${validateEmail}</span>
                        </div>
                        <div class="form-group">
                            <label for="address">Address</label>
                            <input class="form-control" type="text" name="address" id="address" value="${employee.getAddress()}${address}" required>
                            <span style="color: red">${validateAddress}</span>
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
<c:if test="${action == 'delete'}">
    <div class="modal fade" id="deleteModal">
        <div class="modal-dialog modal-confirm">
            <div class="modal-content">
                <div class="modal-header">
                    <h2 class="modal-title w-100 text-center">Are you sure?</h2>
                </div>
                <div class="modal-body">
                    <p class="text-center">Delete employee: <span style="color: red">${name}</span></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary ml-auto mr-2" data-dismiss="modal">No</button>
                    <form action="" method="post" class="m-0 ml-2 mr-auto">
                        <input type="hidden" name="id" id="${id}">
                        <button type="submit" class="btn btn-danger">Yes</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</c:if>
<c:if test="${action == 'create'}">
<div class="modal fade" id="createModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <div>
                    <h5 class="modal-title">Edit employee</h5>
                    <p class="m-0" style="color: red">${status}</p>
                </div>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="?type=employee&action=create" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="createName">Name</label>
                        <input class="form-control" type="text" name="name" id="createName" value="${name}" required>
                        <span style="color: red">${validateName}</span>
                    </div>
                    <div class="form-group">
                        <label for="createIdPosition">Position</label>
                        <select class="form-control" name="idPosition" id="createIdPosition" required>
                            <option value="" id="position">Please choose an option</option>
                            <option value="1" id="crePosition1">Lễ tân</option>
                            <option value="2" id="crePosition2">Phục vụ</option>
                            <option value="3" id="crePosition3">Chuyên viên</option>
                            <option value="4" id="crePosition4">Giám sát</option>
                            <option value="5" id="crePosition5">Quản lý</option>
                            <option value="6" id="crePosition6">Giám đốc</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="createIdEducationDegree">Education degree</label>
                        <select class="form-control" name="idEducationDegree" id="createIdEducationDegree" required>
                            <option value="" id="creEducationDegree">Please choose an option</option>
                            <option value="1" id="creEducationDegree1">Trung cấp</option>
                            <option value="2" id="creEducationDegree2">Cao đẳng</option>
                            <option value="3" id="creEducationDegree3">Đại học</option>
                            <option value="4" id="creEducationDegree4">Sau đại hoc</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="createIdDivision">Division</label>
                        <select class="form-control" name="idDivision" id="createIdDivision" required>
                            <option value="" id="creDivision">Please choose an option</option>
                            <option value="1" id="creDivision1">Sale-Marketing</option>
                            <option value="2" id="creDivision2">Hành chính</option>
                            <option value="3" id="creDivision3">Phục vụ</option>
                            <option value="4" id="creDivision4">Quản lý</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="createDayOfBirth">Day of birth</label>
                        <input class="form-control" type="date" name="dayOfBirth" id="createDayOfBirth" value="${dayOfBirth}" required>
                        <span style="color: red">${validateDateOfBirth}</span>
                    </div>
                    <div class="form-group">
                        <label for="createCmnd">CMND</label>
                        <input class="form-control" type="number" name="cmnd" id="createCmnd" value="${CMND}" required>
                        <span style="color: red">${validateCMND}</span>
                    </div>
                    <div class="form-group">
                        <label for="createSalary">Salary</label>
                        <input class="form-control" type="number" name="salary" id="createSalary" value="${salary}" required>
                        <span style="color: red">${validateSalary}</span>
                    </div>
                    <div class="form-group">
                        <label for="createPhoneNumber">Phone number</label>
                        <input class="form-control" type="text" name="phoneNumber" id="createPhoneNumber" value="${phoneNumber}" required>
                        <span style="color: red">${validatePhoneNumber}</span>
                    </div>
                    <div class="form-group">
                        <label for="createEmail">Email</label>
                        <input class="form-control" type="text" name="email" id="createEmail" value="${email}" required>
                        <span style="color: red">${validateEmail}</span>
                    </div>
                    <div class="form-group">
                        <label for="createAddress">Address</label>
                        <input class="form-control" type="text" name="address" id="createAddress" value="${address}" required>
                        <span style="color: red">${validateAddress}</span>
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
                <c:if test="${statusSave == 'success'}">
                    <div class="modal-header">
                        <div class="icon-box" style="background: #82ce34;">
                            <i class="material-icons">&#xE876;</i>
                        </div>
                        <h2 class="modal-title w-100 text-center">Success!</h2>
                    </div>
                </c:if>
                <c:if test="${statusSave == 'fail'}">
                    <div class="modal-header">
                        <div class="icon-box" style="background: red">
                            <i class="material-icons">&#xE888;</i>
                        </div>
                        <h2 class="modal-title w-100 text-center">Fail!</h2>
                    </div>
                </c:if>
                <div class="modal-body">
                    <c:if test="${action != 'delete' && status != null}">
                        <p class="text-center">${status}</p>
                    </c:if>
                    <c:if test="${status == null}">
                        <c:if test="${statusSave == 'success'}">
                            <p class="text-center">Delete employee successfully.</p>
                        </c:if>
                        <c:if test="${statusSave == 'fail'}">
                            <p class="text-center">Delete employee failed.</p>
                        </c:if>
                    </c:if>
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
        <div class="col-12">
            <div class="list-group list-group-horizontal">
                <div class="list-group-item mr-auto ml-auto display-5 border-0">
                    <c:choose>
                        <c:when test="${action == 'search'}">
                            <c:if test="${listEmployee == null}">
                                No search results for "${value}"
                            </c:if>
                            <c:if test="${listEmployee != null}">
                                Search results for "${value}"
                            </c:if>
                        </c:when>
                        <c:otherwise>
                            List Of Employee
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="list-group-item mr-0 ml-auto mb-1 p-0 border-0">
                    <a href="?type=employee&action=create">
<%--                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#createModal">New employee</button>--%>
                        <button type="button" class="btn btn-primary">New employee</button>
                    </a>
                </div>
            </div>
            <div class="row">
                <div class="col-12 pl-1 pr-1">
                    <table id="tableEmployee" class="table table-striped" style="width: 100%">
                        <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Name</th>
                            <th scope="col">Position</th>
                            <th scope="col">Level</th>
                            <th scope="col">Department</th>
                            <th scope="col">Day of birth</th>
                            <th scope="col">CMND</th>
                            <th scope="col">Salary</th>
                            <th scope="col">Phone number</th>
                            <th scope="col">Email</th>
                            <th scope="col">Address</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listEmployee}" var="employee" varStatus="count">
                            <tr onmouseover="showButton(${count.index})" onmouseout="hideButton(${count.index})">
                                <td>${employee.id}</td>
                                <td>${employee.name}</td>
                                <c:choose>
                                    <c:when test="${employee.idPosition == 1}">
                                        <td>Lễ tân</td>
                                    </c:when>
                                    <c:when test="${employee.idPosition == 2}">
                                        <td>Phục vụ</td>
                                    </c:when>
                                    <c:when test="${employee.idPosition == 3}">
                                        <td>Chuyên viên</td>
                                    </c:when>
                                    <c:when test="${employee.idPosition == 4}">
                                        <td>Giám sát</td>
                                    </c:when>
                                    <c:when test="${employee.idPosition == 5}">
                                        <td>Quản lý</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>Giám đốc</td>
                                    </c:otherwise>
                                </c:choose>
                                <c:choose>
                                    <c:when test="${employee.idEducationDegree == 1}">
                                        <td>Trung cấp</td>
                                    </c:when>
                                    <c:when test="${employee.idEducationDegree == 2}">
                                        <td>Cao đẳng</td>
                                    </c:when>
                                    <c:when test="${employee.idEducationDegree == 3}">
                                        <td>Đại học</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>Sau đại học</td>
                                    </c:otherwise>
                                </c:choose>
                                <c:choose>
                                    <c:when test="${employee.idDivision == 1}">
                                        <td>Sale-Marketing</td>
                                    </c:when>
                                    <c:when test="${employee.idDivision == 2}">
                                        <td>Hành chính</td>
                                    </c:when>
                                    <c:when test="${employee.idDivision == 3}">
                                        <td>Phục vụ</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>Quản lý</td>
                                    </c:otherwise>
                                </c:choose>
                                <td>${employee.dayOfBirth}</td>
                                <td>${employee.CMND}</td>
                                <td>${employee.salary}</td>
                                <td>${employee.phoneNumber}</td>
                                <td>${employee.email}</td>
                                <td class="position-relative">
                                        ${employee.address}
                                    <div class="position-absolute" id="button${count.index}" style="right: 2%; top: 8%; display: none">
                                        <a href="?type=employee&action=edit&id=${employee.id}">
                                            <button type="button" class="btn btn-warning p-1">Edit</button>
                                        </a>
                                        <a href="?type=employee&action=delete&id=${employee.id}">
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
            <c:if test="${action == 'search'}">
                <div class="row">
                    <div class="col-12 d-flex">
                        <a href="?type=employee&action=list" class="mr-auto ml-auto">
                            <button type="button" class="btn btn-secondary p-1">Close</button>
                        </a>
                    </div>
                </div>
            </c:if>
            <div class="row mt-3">
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

    function editSelect(){
        <c:if test="${action == 'edit'}">
            <d:if test="${employee.idPosition != null && employee.idEducationDegree != null && employee.idDivision != null}">
                document.getElementById("position${employee.idPosition}").selected = true;
                document.getElementById("educationDegree${employee.idEducationDegree}").selected = true;
                document.getElementById("division${employee.idDivision}").selected = true;
            </d:if>
            <d:if test="${idPosition != null && idEducationDegree != null && idDivision != null}">
                document.getElementById("position${idPosition}").selected = true;
                document.getElementById("educationDegree${idEducationDegree}").selected = true;
                document.getElementById("division${idDivision}").selected = true;
            </d:if>
        </c:if>
        <c:if test="${action == 'create' && idPosition != null && idEducationDegree != null && idDivision != null}">
            document.getElementById("crePosition${idPosition}").selected = true;
            document.getElementById("creEducationDegree${idEducationDegree}").selected = true;
            document.getElementById("creDivision${idDivision}").selected = true;
        </c:if>
    }

    $(document).ready(function () {
        $('#tableEmployee').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 10
        });
    });
    $(window).on('load', function() {
        $('#viewStatusSave').modal('show');
        $('#editModal').modal('show');
        $('#deleteModal').modal('show');
        $('#createModal').modal('show');
        editSelect();
    });
</script>
</body>
</html>

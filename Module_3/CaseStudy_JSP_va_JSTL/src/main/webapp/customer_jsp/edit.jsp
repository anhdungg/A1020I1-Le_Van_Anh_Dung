<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Title</title>
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
<jsp:include page="../header.jsp" />
<div class="container-fluid">
    <div class="row">
        <jsp:include page="../item.jsp"/>
        <div class="col-10">
            <div class="row">
                <div class="col-12">
                    <h1 class="display-5 text-center">Edit customer</h1>
                    <c:if test="${status == true}">
<%--                        <p class="text-center">Successful customer editing.</p>--%>
                    </c:if>
                    <c:if test="${status == false}">
<%--                        <p class="text-center">Failed customer editing.</p>--%>
                    </c:if>
                </div>
            </div>
            <div class="row">
                <div class="col-12 pl-0 pr-1">
                    <form action="" method="post">
                        <input type="hidden" name="type" value="customer">
                        <input type="hidden" name="action" value="edit">
                        <div class="form-row">
                            <div class="form-group col-6">
                                <label for="id">ID</label><br>
                                <input class="form-control" type="number" name="id" id="id" value="${customer.getIdCustomer()}" readonly>
                            </div>
                            <div class="form-group col-6">
                                <label for="idTypeCustomer">ID type customer</label>
                                <select class="form-control" name="idTypeCustomer" id="idTypeCustomer">
                                    <option value="">--Please choose an option--</option>
                                    <option value="1" id="Diamond">Diamond</option>
                                    <option value="2" id="Platinium">Platinium</option>
                                    <option value="3" id="Gold">Gold</option>
                                    <option value="4" id="Silver">Silver</option>
                                    <option value="5" id="Member">Member</option>
                                </select>
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
                        <div class="form-row">
                            <a href="?type=customer&action=list" class="ml-auto mr-2">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            </a>
                            <button type="submit" class="btn btn-primary ml-2 mr-auto">Save</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%--<div class="modal fade" id="viewStatusSave">--%>
<%--    <div class="modal-dialog modal-confirm">--%>
<%--        <div class="modal-content">--%>
<%--            <c:if test="${statusSave == 'true'}">--%>
<%--                <div class="modal-header">--%>
<%--                    <h2 class="modal-title w-100 text-center">Success!</h2>--%>
<%--                </div>--%>
<%--            </c:if>--%>
<%--            <c:if test="${statusSave == 'false'}">--%>
<%--                <div class="modal-header">--%>
<%--                    <h2 class="modal-title w-100 text-center">Fail!</h2>--%>
<%--                </div>--%>
<%--            </c:if>--%>
<%--            <div class="modal-body">--%>
<%--                <c:if test="${statusSave == 'true'}">--%>
<%--                    <p class="text-center">Successful customer editing.</p>--%>
<%--                </c:if>--%>
<%--                <c:if test="${statusSave == 'false'}">--%>
<%--                    <p class="text-center">Failed customer editing.</p>--%>
<%--                </c:if>--%>
<%--            </div>--%>
<%--            <div class="modal-footer">--%>
<%--                <button class="btn btn-success btn-block" data-dismiss="modal">OK</button>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<script src="${contextPath}/js/jquery-3.5.1.min.js"></script>
<script src="${contextPath}/js/bootstrap.min.js"></script>
<script>
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
    $(window).on('load', function() {
<%--        <c:if test="${status != null}">--%>
            $('#viewStatusSave').modal('show');
<%--        </c:if>--%>
        editSelect();
    });
</script>
</body>
</html>

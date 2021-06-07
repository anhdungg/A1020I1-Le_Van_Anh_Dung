<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>TComplex | List</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="common/css/bootstrap.min.css" >
    <link rel="stylesheet" href="common/datatables/css/dataTables.bootstrap4.min.css" >
    <style>
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
<c:if test="${action != null}">
    <div class="modal fade" id="viewStatusSave">
        <div class="modal-dialog modal-confirm">
            <div class="modal-content">
                <c:if test="${status == true}">
                    <div class="modal-header">
                        <div class="icon-box" style="background: #82ce34;">
                            <i class="material-icons">&#xE876;</i>
                        </div>
                        <h2 class="modal-title w-100 text-center">Success!</h2>
                    </div>
                </c:if>
                <c:if test="${status == false}">
                    <div class="modal-header">
                        <div class="icon-box" style="background: red">
                            <i class="material-icons">&#xE888;</i>
                        </div>
                        <h2 class="modal-title w-100 text-center">Fail!</h2>
                    </div>
                </c:if>
                <div class="modal-body">
                    <c:if test="${action == 'delete'}">
                        <c:if test="${status == true}">
                            <p class="text-center">Xoá mặt bằng thành công</p>
                        </c:if>
                        <c:if test="${status == false}">
                            <p class="text-center">Xoá mặt bằng không thành công</p>
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

<div class="modal fade" id="deleteModal">
    <div class="modal-dialog modal-confirm">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="modal-title w-100 text-center">Are you sure?</h2>
            </div>
            <div class="modal-body">
                <p class="text-center">Bạn có muốn xoá mặt bằng có id: <span style="color: red" id="deleteNameId"></span> không?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary ml-auto mr-2" data-dismiss="modal">No</button>
                <form action="" method="post" class="m-0 ml-2 mr-auto">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" id="idDelete">
                    <button type="submit" class="btn btn-danger">Yes</button>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-12">
            <h2 class="text-center mt-2 mb-1">Danh sách mặt bằng</h2>
            <div class="d-flex">
                <a href="?action=create" class="ml-auto mr-1">
                    <button type="button" class="btn btn-primary">Tạo mới</button>
                </a>
                <a href="?action=search" class="mr-2 ml-1">
                    <button type="button" class="btn btn-primary">Tìm kiếm</button>
                </a>
            </div>
            <table id="tableMB" class="table table-striped" style="width: 100%">
                <thead>
                <tr>
                    <th scope="col">Mã MB</th>
                    <th scope="col">Diện tích</th>
                    <th scope="col">Trạng thái</th>
                    <th scope="col">Tầng</th>
                    <th scope="col">Loại văn phòng</th>
                    <th scope="col">Giá cho thuê</th>
                    <th scope="col">Ngày bắt đầu</th>
                    <th scope="col">Ngày kết thúc</th>
                    <th scope="col"></th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listMB}" var="MatBang">
                    <tr>
                        <td>${MatBang.id}</td>
                        <td>
                            <c:choose>
                                <c:when test="${MatBang.idTrangThai == 1}">
                                    Trống
                                </c:when>
                                <c:when test="${MatBang.idTrangThai == 2}">
                                    Hạ tầng
                                </c:when>
                                <c:otherwise>
                                    Đầy đủ
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>${MatBang.dienTich}</td>
                        <td>${MatBang.tang}</td>
                        <td>
                            <c:choose>
                                <c:when test="${MatBang.idLoaiVanPhong == 1}">
                                    Chia sẻ
                                </c:when>
                                <c:otherwise>
                                    Trọn gói
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>${MatBang.giaTien}</td>
                        <td>${MatBang.ngayBatDau}</td>
                        <td>${MatBang.ngayKetThuc}</td>
                        <td>
                            <button type="button" class="btn btn-danger" onclick="showModalDelete('${MatBang.id}')">Xoá</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="common/js/jquery-3.5.1.min.js"></script>
<script src="common/datatables/js/jquery.dataTables.min.js"></script>
<script src="common/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="common/js/bootstrap.min.js"></script>
<script>

    function showModalDelete(id){
        console.log(id);
        document.getElementById("deleteNameId").innerHTML = id;
        document.getElementById("idDelete").value = id;
        $('#deleteModal').modal('show');
    }
    $(document).ready(function () {
        $('#tableMB').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
    $(window).on('load', function() {
        $('#viewStatusSave').modal('show');
    });
</script>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>TComplex | Create</title>
    <link rel="stylesheet" href="common/css/bootstrap.min.css" >
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-12">
            <h2 class="text-center mt-2 mb-1">Tạo mới mặt bằng</h2>
        </div>
    </div>
    <div class="row">
        <div class="col-12 d-flex">
            <form action="?action=create" method="post" class="mr-auto ml-auto w-75">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="id">Mã MB</label><br>
                        <input class="form-control" type="text" name="id" id="id" value="${id}" required>
                        <c:if test="${id != null}">
                            <span style="color: red">Mã mặt bằng phải đúng định dạng XXX-XX-XX với X là số hoặc các ký tự alphabet viết hoa.</span>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="dienTich">Diện tích</label>
                        <input class="form-control" type="text" name="dienTich" id="dienTich" value="${dienTich}" required>
                        <c:if test="${dienTich != null}">
                            <span style="color: red">Diện tích phải > 20m2</span>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="trangThai">Trạng thái</label>
                        <select class="form-control" name="trangThai" id="trangThai" required>
                            <option value="">Chọn trạng thái</option>
                            <option value="1" id="trangThai1">Trống</option>
                            <option value="2" id="trangThai2">Hạ tầng</option>
                            <option value="3" id="trangThai3">Đầy đủ</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="tang">Tầng</label>
                        <input class="form-control" type="number" name="tang" id="tang" value="${tang}" required>
                        <c:if test="${tang != null}">
                            <span style="color: red">Có 15 tầng tất cả</span>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="loaiVanPhong">Loại văn phòng</label>
                        <select class="form-control" name="loaiVanPhong" id="loaiVanPhong" required>
                            <option value="" >Chọn loại văn phòng</option>
                            <option value="1" id="loaiVanPhong1">Chia sẻ</option>
                            <option value="2" id="loaiVanPhong2">Trọn gói</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="giaTien">Giá cho thuê</label>
                        <input class="form-control" type="text" name="giaTien" id="giaTien" value="${giaTien}" required>
                        <c:if test="${giaTien != null}">
                            <span style="color: red">Giá cho thuê phải là số dương</span>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="ngayBatDau">Ngày bắt đầu</label>
                        <input class="form-control" type="date" name="ngayBatDau" id="ngayBatDau" value="${ngayBatDau}" required>
                        <c:if test="${ngayBatDau != null}">
                            <span style="color: red">Phải đúng định dạng dd/mm/yyyy</span>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="ngayKetThuc">Ngày kêt thúc</label>
                        <input class="form-control" type="date" name="ngayKetThuc" id="ngayKetThuc" value="${ngayKetThuc}" required>
                        <c:if test="${ngayKetThuc != null}">
                            <span style="color: red">Phải đúng định dạng dd/mm/yyyy</span>
                        </c:if>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary ml-auto mr-1" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary ml-1 mr-auto">Save</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="common/js/bootstrap.min.js"></script>
</body>
</html>

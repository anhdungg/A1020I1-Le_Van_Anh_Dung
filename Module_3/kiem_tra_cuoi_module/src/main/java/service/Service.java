package service;

import model.bean.MatBang;

import java.util.List;

public interface Service {
    List<MatBang> findAll();
    List<MatBang> findTypeMB();
    List<MatBang> findNumberOfFloors();
    List<MatBang> findRentalPrice();
    List<MatBang> find();
    boolean createMB(String id, String idTrangThai, String dienTich, String tang, String idLoaiVanPhong, String giaTien,
                    String ngayBatDau, String ngayKetThuc);
    boolean deleteMB(String id);

}

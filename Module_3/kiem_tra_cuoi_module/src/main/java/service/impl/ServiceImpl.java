package service.impl;

import model.bean.MatBang;
import repository.Repository;
import repository.impl.RepositoryImpl;
import common.Validate;
import service.Service;

import java.util.List;

public class ServiceImpl implements Service {
    private Repository repository = new RepositoryImpl();
    @Override
    public List<MatBang> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<MatBang> findTypeMB() {
        return null;
    }

    @Override
    public List<MatBang> findNumberOfFloors() {
        return null;
    }

    @Override
    public List<MatBang> findRentalPrice() {
        return null;
    }

    @Override
    public List<MatBang> find() {
        return null;
    }

    @Override
    public boolean createMB(String id, String idTrangThai, String dienTich, String tang, String idLoaiVanPhong, String giaTien,
                           String ngayBatDau, String ngayKetThuc) {
        return repository.createMB(new MatBang(id, Integer.parseInt(idTrangThai), Double.parseDouble(dienTich), Integer.parseInt(tang),
                Integer.parseInt(idLoaiVanPhong), Double.parseDouble(giaTien), ngayBatDau, ngayKetThuc));
//        if (Validate.id(id) == null && Validate.validateDouble(dienTich) == null )
    }

    @Override
    public boolean deleteMB(String id) {
        return this.repository.deleteMB(id);
    }
}

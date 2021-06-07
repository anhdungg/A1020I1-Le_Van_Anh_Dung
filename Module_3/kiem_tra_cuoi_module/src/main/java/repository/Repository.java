package repository;

import model.bean.MatBang;

import java.util.List;

public interface Repository {
    List<MatBang> findAll();
    List<MatBang> findTypeMB();
    List<MatBang> findNumberOfFloors();
    List<MatBang> findRentalPrice();
    List<MatBang> find();
    boolean createMB(MatBang matBang);
    boolean deleteMB(String id);
}

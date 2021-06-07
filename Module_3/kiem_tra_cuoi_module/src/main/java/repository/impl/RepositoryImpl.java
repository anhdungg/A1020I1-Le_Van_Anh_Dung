package repository.impl;

import model.bean.MatBang;
import repository.BaseRepository;
import repository.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryImpl implements Repository {
    private BaseRepository repository = new BaseRepository();

    @Override
    public List<MatBang> findAll() {
        List<MatBang> list = new ArrayList<>();
        try {
            Statement statement = this.repository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from mat_bang");
            while (resultSet.next()){
                list.add(new MatBang(resultSet.getString("id"), resultSet.getInt("id_trang_thai"),
                        resultSet.getDouble("dien_tich"), resultSet.getInt("tang"),
                        resultSet.getInt("id_loai_van_phong"), resultSet.getDouble("gia_tien"),
                        resultSet.getString("ngay_bat_dau"), resultSet.getString("ngay_ket_thuc")));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
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
    public boolean createMB(MatBang matBang) {
        try {
            PreparedStatement preparedStatement = this.repository.getConnection().prepareStatement("" +
                    "insert into mat_bang value (?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, matBang.getId());
            preparedStatement.setInt(2, matBang.getIdTrangThai());
            preparedStatement.setDouble(3, matBang.getDienTich());
            preparedStatement.setInt(4, matBang.getTang());
            preparedStatement.setInt(5, matBang.getIdLoaiVanPhong());
            preparedStatement.setDouble(6, matBang.getGiaTien());
            preparedStatement.setString(7, matBang.getNgayBatDau());
            preparedStatement.setString(8, matBang.getNgayKetThuc());

            int result = preparedStatement.executeUpdate();

            return result>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteMB(String id) {
        try {
            PreparedStatement preparedStatement = this.repository.getConnection().prepareStatement("" +
                    "delete  from mat_bang where id = ?");
            preparedStatement.setString(1, id);
            int result = preparedStatement.executeUpdate();

            return result>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}

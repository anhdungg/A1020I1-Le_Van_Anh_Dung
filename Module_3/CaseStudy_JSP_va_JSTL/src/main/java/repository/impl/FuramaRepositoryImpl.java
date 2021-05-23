package repository.impl;

import model.bean.Customer;
import repository.BaseRepository;
import repository.FuramaRepository;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FuramaRepositoryImpl implements FuramaRepository {
    private BaseRepository repository = new BaseRepository();
    @Override
    public List<Customer> findAll() {
        List<Customer> list = new ArrayList<>();
        try {
            Statement statement = this.repository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from khach_hang");
            while (resultSet.next()){
                list.add(new Customer(resultSet.getInt("id_khach_hang"), resultSet.getInt("id_loai_khach_hang"),
                        resultSet.getString("ho_ten"), resultSet.getString("ngay_sinh"),
                        resultSet.getString("CMND"), resultSet.getString("so_dien_thoai"),
                        resultSet.getString("email"), resultSet.getString("dia_chi")));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;
        try {
            CallableStatement callableStatement = this.repository.getConnection().prepareCall("CALL find_customer_by_id(?)");
            callableStatement.setInt(1, id);

            ResultSet result = callableStatement.executeQuery();

            while (result.next()){
                customer = new Customer(result.getInt("id_khach_hang"), result.getInt("id_loai_khach_hang"),
                        result.getString("ho_ten"), result.getString("ngay_sinh"),
                        result.getString("CMND"), result.getString("so_dien_thoai"),
                        result.getString("email"), result.getString("dia_chi"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    @Override
    public boolean editCustomer(Customer customer) {
        try {
            CallableStatement callableStatement = this.repository.getConnection().prepareCall("CALL edit_customer(?, ?, ?, ?, ?, ?, ?, ?)");
            callableStatement.setInt(1, customer.getIdCustomer());
            callableStatement.setInt(2, customer.getIdTypeCustomer());
            callableStatement.setString(3, customer.getName());
            callableStatement.setString(4, customer.getDayOfBirth());
            callableStatement.setString(5, customer.getCMND());
            callableStatement.setString(6, customer.getPhoneNumber());
            callableStatement.setString(7, customer.getEmail());
            callableStatement.setString(8, customer.getAddress());

            int result = callableStatement.executeUpdate();

            return result>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean createCustomer(Customer customer) {
        try {
            CallableStatement callableStatement = this.repository.getConnection().prepareCall("CALL new_customer(?, ?, ?, ?, ?, ?, ?)");
            callableStatement.setInt(1, customer.getIdTypeCustomer());
            callableStatement.setString(2, customer.getName());
            callableStatement.setString(3, customer.getDayOfBirth());
            callableStatement.setString(4, customer.getCMND());
            callableStatement.setString(5, customer.getPhoneNumber());
            callableStatement.setString(6, customer.getEmail());
            callableStatement.setString(7, customer.getAddress());

            int result = callableStatement.executeUpdate();

            return result>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCustomer(int id) {
        try {
            CallableStatement callableStatement = this.repository.getConnection().prepareCall("CALL delete_customer(?)");
            callableStatement.setInt(1, id);

            int result = callableStatement.executeUpdate();

            return result>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    //    public static void main(String[] args) {
//        FuramaRepository furama = new FuramaRepositoryImpl();
//        System.out.println(furama.createCustomer(new Customer(1,"Nguyễn Trần Bình", "2000/09/12", "206380834", "0934472768", "tranbinhh@gmail.com", "Nghi Phú, Tp.Vinh, Nghệ An")));
//    }
}

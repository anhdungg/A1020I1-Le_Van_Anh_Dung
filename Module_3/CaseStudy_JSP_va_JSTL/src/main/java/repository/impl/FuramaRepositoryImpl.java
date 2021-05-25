package repository.impl;

import model.bean.Customer;
import model.bean.Employee;
import repository.BaseRepository;
import repository.FuramaRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuramaRepositoryImpl implements FuramaRepository {
    private BaseRepository repository = new BaseRepository();
    @Override
    public List<Customer> findAllCustomer() {
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
    public Customer findByIdCustomer(int id) {
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

    @Override
    public List<Customer> findNameCustomer(String name) {
        List<Customer> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.repository.getConnection().prepareStatement(
                    "select * from khach_hang\n" +
                            "where ho_ten like ?");
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
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
    public List<Employee> findAllEmployee() {
        List<Employee> list = new ArrayList<>();
        try {
            Statement statement = this.repository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from nhan_vien");
            while (resultSet.next()){
                list.add(new Employee(resultSet.getInt("id_nhan_vien"), resultSet.getString("ho_ten"),
                        resultSet.getInt("id_vi_tri"), resultSet.getInt("id_trinh_do"),
                        resultSet.getInt("id_bo_phan"), resultSet.getString("ngay_sinh"),
                        resultSet.getString("CMND"), resultSet.getDouble("luong"),
                        resultSet.getString("so_dien_thoai"), resultSet.getString("email"),
                        resultSet.getString("dia_chi")));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public Employee findByIdEmployee(int id) {
        Employee employee = null;
        try {
            CallableStatement callableStatement = this.repository.getConnection().prepareCall("select * from nhan_vien " +
                    "where id_nhan_vien = ?");
            callableStatement.setInt(1, id);

            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()){
                employee = new Employee(resultSet.getInt("id_nhan_vien"), resultSet.getString("ho_ten"),
                        resultSet.getInt("id_vi_tri"), resultSet.getInt("id_trinh_do"),
                        resultSet.getInt("id_bo_phan"), resultSet.getString("ngay_sinh"),
                        resultSet.getString("CMND"), resultSet.getDouble("luong"),
                        resultSet.getString("so_dien_thoai"), resultSet.getString("email"),
                        resultSet.getString("dia_chi"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employee;
    }

    @Override
    public boolean editEmployee(Employee employee) {
        try {
            PreparedStatement preparedStatement = this.repository.getConnection().prepareStatement("" +
                    "update nhan_vien set ho_ten = ?, id_vi_tri = ?, id_trinh_do = ?, id_bo_phan = ?, ngay_sinh = ?, " +
                    "CMND = ?, luong = ?, so_dien_thoai = ?, email = ?, dia_chi = ? where id_nhan_vien = ?");
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setInt(2, employee.getIdPosition());
            preparedStatement.setInt(3, employee.getIdLevel());
            preparedStatement.setInt(4, employee.getIdDepartment());
            preparedStatement.setString(5, employee.getDayOfBirth());
            preparedStatement.setString(6, employee.getCMND());
            preparedStatement.setDouble(7, employee.getSalary());
            preparedStatement.setString(8, employee.getPhoneNumber());
            preparedStatement.setString(9, employee.getEmail());
            preparedStatement.setString(10, employee.getAddress());
            preparedStatement.setInt(11, employee.getId());

            int result = preparedStatement.executeUpdate();
            return result>0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean createEmployee(Employee employee) {
        try {
            PreparedStatement preparedStatement = this.repository.getConnection().prepareStatement("" +
                    "insert into nhan_vien(ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, CMND, luong, " +
                    "so_dien_thoai, email, dia_chi) value (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setInt(2, employee.getIdPosition());
            preparedStatement.setInt(3, employee.getIdLevel());
            preparedStatement.setInt(4, employee.getIdDepartment());
            preparedStatement.setString(5, employee.getDayOfBirth());
            preparedStatement.setString(6, employee.getCMND());
            preparedStatement.setDouble(7, employee.getSalary());
            preparedStatement.setString(8, employee.getPhoneNumber());
            preparedStatement.setString(9, employee.getEmail());
            preparedStatement.setString(10, employee.getAddress());


            int result = preparedStatement.executeUpdate();
            return result>0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteEmployee(int id) {
        try {
            PreparedStatement preparedStatement = this.repository.getConnection().prepareStatement("" +
                    "delete from nhan_vien where id_nhan_vien = ?");

            preparedStatement.setInt(1, id);

            int result = preparedStatement.executeUpdate();
            return result>0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Employee> findNameEmployee(String name) {
        List<Employee> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.repository.getConnection().prepareStatement(
                    "select * from nhan_vien\n" +
                            "where ho_ten like ?");
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                list.add(new Employee(resultSet.getInt("id_nhan_vien"), resultSet.getString("ho_ten"),
                        resultSet.getInt("id_vi_tri"), resultSet.getInt("id_trinh_do"),
                        resultSet.getInt("id_bo_phan"), resultSet.getString("ngay_sinh"),
                        resultSet.getString("CMND"), resultSet.getDouble("luong"),
                        resultSet.getString("so_dien_thoai"), resultSet.getString("email"),
                        resultSet.getString("dia_chi")));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}

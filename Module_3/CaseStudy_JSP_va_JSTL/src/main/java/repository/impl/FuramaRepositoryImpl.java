package repository.impl;

import model.bean.*;
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
                list.add(new Customer(resultSet.getString("id_khach_hang"), resultSet.getInt("id_loai_khach_hang"),
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
    public Customer findByIdCustomer(String id) {
        Customer customer = null;
        try {
            CallableStatement callableStatement = this.repository.getConnection().prepareCall("CALL find_customer_by_id(?)");
            callableStatement.setString(1, id);

            ResultSet result = callableStatement.executeQuery();

            while (result.next()){
                customer = new Customer(result.getString("id_khach_hang"), result.getInt("id_loai_khach_hang"),
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
            PreparedStatement preparedStatement = this.repository.getConnection().prepareStatement("" +
                    "update khach_hang set id_loai_khach_hang = ?, ho_ten = ?, ngay_sinh = ?, CMND = ?,so_dien_thoai = ?," +
                    "email = ?, dia_chi = ? where id_khach_hang = ?;");

            preparedStatement.setInt(1, customer.getIdTypeCustomer());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getDayOfBirth());
            preparedStatement.setString(4, customer.getCMND());
            preparedStatement.setString(5, customer.getPhoneNumber());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getAddress());
            preparedStatement.setString(8, customer.getIdCustomer());

            int result = preparedStatement.executeUpdate();

            return result>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean createCustomer(Customer customer) {
        try {
            PreparedStatement preparedStatement = this.repository.getConnection().prepareStatement("" +
                    "insert into khach_hang value (?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, customer.getIdCustomer());
            preparedStatement.setInt(2, customer.getIdTypeCustomer());
            preparedStatement.setString(3, customer.getName());
            preparedStatement.setString(4, customer.getDayOfBirth());
            preparedStatement.setString(5, customer.getCMND());
            preparedStatement.setString(6, customer.getPhoneNumber());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getAddress());

            int result = preparedStatement.executeUpdate();

            return result>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCustomer(String id) {
        try {
            PreparedStatement preparedStatement = this.repository.getConnection().prepareStatement("" +
                    "delete from khach_hang where id_khach_hang = ?");
            preparedStatement.setString(1, id);

            int result = preparedStatement.executeUpdate();

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
                list.add(new Customer(resultSet.getString("id_khach_hang"), resultSet.getInt("id_loai_khach_hang"),
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

    @Override
    public List<Service> findAllService() {
        List<Service> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.repository.getConnection().prepareStatement("select * from dich_vu");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                list.add(new Service(resultSet.getString("id_dich_vu"), resultSet.getString("ten_dich_vu"),
                        resultSet.getInt("dien_tich"), resultSet.getDouble("chi_phi_thue"),
                        resultSet.getInt("so_nguoi_toi_da"), resultSet.getInt("id_kieu_thue"),
                        resultSet.getInt("id_loai_dich_vu"), resultSet.getString("tieu_chuan"),
                        resultSet.getString("mo_ta"), resultSet.getDouble("dien_tich_ho_boi"),
                        resultSet.getInt("so_tang")));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Contact> findAllContact() {
        List<Contact> list = new ArrayList<>();
        try {
            CallableStatement callableStatement = this.repository.getConnection().prepareCall("CALL find_all_contact()");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                list.add(new Contact(resultSet.getInt("id_hop_dong"), resultSet.getInt("id_nhan_vien"),
                        resultSet.getString("id_khach_hang"), resultSet.getString("id_dich_vu"),
                        resultSet.getString("ngay_lam_hop_dong"), resultSet.getString("ngay_ket_thuc"),
                        resultSet.getDouble("tien_dat_coc"), resultSet.getDouble("tong_tien")));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean createContact(Contact contact) {
        try {
            PreparedStatement preparedStatement = this.repository.getConnection().prepareStatement("" +
                    "insert into hop_dong(id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, " +
                    "tien_dat_coc, tong_tien) value(?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, contact.getIdEmployee());
            preparedStatement.setString(2, contact.getIdCustomer());
            preparedStatement.setString(3, contact.getIdService());
            preparedStatement.setString(4, contact.getContactDate());
            preparedStatement.setString(5, contact.getEndDate());
            preparedStatement.setString(6, contact.getDepositMoney()+"");
            preparedStatement.setString(7, contact.getTotalMoney()+"");

            int result = preparedStatement.executeUpdate();
            return result>0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<ContactDetail> findAllContactDetail() {
        List<ContactDetail> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.repository.getConnection().prepareStatement("select * from hop_dong_chi_tiet");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                list.add(new ContactDetail(resultSet.getInt("id_hop_dong_chi_tiet"), resultSet.getInt("id_hop_dong"),
                        resultSet.getInt("id_dich_vu_di_kem"), resultSet.getInt("so_luong")));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean createContactDetail(ContactDetail contactDetail) {
        try {
            PreparedStatement preparedStatement = this.repository.getConnection().prepareStatement("" +
                    "insert into hop_dong_chi_tiet(id_hop_dong, id_dich_vu_di_kem, so_luong) value(?, ?, ?)");
            preparedStatement.setInt(1, contactDetail.getIdContact());
            preparedStatement.setInt(2, contactDetail.getAccompanyingServices());
            preparedStatement.setInt(3, contactDetail.getAmount());

            int result = preparedStatement.executeUpdate();
            return result>0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<AccompaniedService> findAllAccompaniedService() {
        List<AccompaniedService> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.repository.getConnection().prepareStatement("select * from dich_vu_di_kem");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                list.add(new AccompaniedService(resultSet.getInt("id_dich_vu_di_kem"),
                        resultSet.getString("ten_dich_vu_di_kem"), resultSet.getInt("gia"),
                        resultSet.getInt("don_vi"), resultSet.getString("trang_thai_kha_dung")));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<RentalType> findAllRentalType() {
        List<RentalType> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.repository.getConnection().prepareStatement("select * from kieu_thue");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                list.add(new RentalType(resultSet.getInt("id_kieu_thue"), resultSet.getString("ten_kieu_thue"),
                        resultSet.getInt("gia")));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ServiceType> findAllServiceType() {
        List<ServiceType> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.repository.getConnection().prepareStatement("select * from loai_dich_vu");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                list.add(new ServiceType(resultSet.getInt("id_loai_dich_vu"), resultSet.getString("ten_loai_dich_vu")));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean createService(Service service) {
        try {
            PreparedStatement preparedStatement = this.repository.getConnection().prepareStatement("" +
                    "insert into dich_vu value (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, service.getId());
            preparedStatement.setString(2, service.getName());
            preparedStatement.setInt(3, service.getArea());
            preparedStatement.setDouble(4, service.getRentalCosts());
            preparedStatement.setInt(5, service.getMaximumNumberOfPeople());
            preparedStatement.setInt(6, service.getIdRentalType());
            preparedStatement.setInt(7, service.getIdServiceType());
            preparedStatement.setString(8, service.getStandard());
            preparedStatement.setString(9, service.getDescription());
            preparedStatement.setDouble(10, service.getPoolArea());
            preparedStatement.setInt(11, service.getNumberOfFloors());

            int result = preparedStatement.executeUpdate();
            return result>0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}

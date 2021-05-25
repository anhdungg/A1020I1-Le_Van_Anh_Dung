package service;

import model.bean.Customer;
import model.bean.Employee;

import java.util.List;

public interface FuramaService {
    List<Customer> findAllCustomer();
    Customer findByIdCustomer(int id);
    boolean editCustomer(String id, String idType, String name, String dayOfBirth, String CMND, String phoneNumber,
                         String email, String address);
    boolean createCustomer(String idType, String name, String dayOfBirth, String CMND, String phoneNumber,
                           String email, String address);
    boolean deleteCustomer(int id);
    List<Customer> findNameCustomer(String name);
    List<Employee> findAllEmployee();
    Employee findByIdEmployee(int id);
    boolean editEmployee(String id, String name, String idPosition, String idLevel, String idDepartment, String dayOfBirth,
                           String CMND, String salary, String phoneNumber, String email, String address);
    boolean createEmployee(String name, String idPosition, String idLevel, String idDepartment, String dayOfBirth, String CMND,
                           String salary, String phoneNumber, String email, String address);
    boolean deleteEmployee(int id);
    List<Employee> findNameEmployee(String name);
}

package repository;

import model.bean.Customer;
import model.bean.Employee;

import java.util.List;

public interface FuramaRepository {
    List<Customer> findAllCustomer();
    Customer findByIdCustomer(int id);
    boolean editCustomer(Customer customer);
    boolean createCustomer(Customer customer);
    boolean deleteCustomer(int id);
    List<Customer> findNameCustomer(String name);
    List<Employee> findAllEmployee();
    Employee findByIdEmployee(int id);
    boolean editEmployee(Employee employee);
    boolean createEmployee(Employee employee);
    boolean deleteEmployee(int id);
    List<Employee> findNameEmployee(String name);
}

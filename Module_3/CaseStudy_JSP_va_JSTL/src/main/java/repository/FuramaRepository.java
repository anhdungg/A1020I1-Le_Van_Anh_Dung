package repository;

import model.bean.Customer;
import model.bean.Employee;

import java.util.List;

public interface FuramaRepository {
    List<Customer> findAll();
    Customer findById(int id);
    boolean editCustomer(Customer customer);
    boolean createCustomer(Customer customer);
    boolean deleteCustomer(int id);
    List<Customer> findName(String name);
}

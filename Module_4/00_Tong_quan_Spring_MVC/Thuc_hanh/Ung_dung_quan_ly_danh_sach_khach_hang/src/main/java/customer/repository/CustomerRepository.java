package customer.repository;

import customer.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
    Customer findById(int id);
}

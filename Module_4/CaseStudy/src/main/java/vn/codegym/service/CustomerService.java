package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Customer;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);

    void deleteById(Integer id);

    Customer findById(Integer id);

    Page<Customer> findAllByNameContaining(String keyWord, Pageable pageable);

    void save(Customer customer);
}

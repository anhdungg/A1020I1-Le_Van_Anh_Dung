package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import vn.codegym.model.Customer;

import java.util.List;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);

    List<Customer> findAll();

    void deleteById(String id);

    Customer findById(String id);

    Page<Customer> findAllByNameContaining(String keyWord, Pageable pageable);

    void save(Customer customer);

    boolean existsById(String id);

    int updateById(String newId, String id);
}

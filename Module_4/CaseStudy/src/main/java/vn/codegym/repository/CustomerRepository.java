package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findAllByNameContaining(String keyWord, Pageable pageable);
}

package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Customer;
import vn.codegym.repository.CustomerRepository;
import vn.codegym.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Customer findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Page<Customer> findAllByNameContaining(String keyWord, Pageable pageable) {
        return repository.findAllByNameContaining(keyWord, pageable);
    }

    @Override
    public void save(Customer customer) {
        repository.save(customer);
    }
}

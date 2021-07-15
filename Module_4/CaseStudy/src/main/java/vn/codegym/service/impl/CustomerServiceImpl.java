package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Customer;
import vn.codegym.repository.CustomerRepository;
import vn.codegym.service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public Customer findById(String id) {
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

    @Override
    public boolean existsById(String id) {
        return repository.existsById(id);
    }

    @Override
    public int updateById(String newId, String id) {
        return repository.updateById(newId, id);
    }
}

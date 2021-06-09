package customer.service;

import customer.model.Customer;
import customer.repository.CustomerRepository;
import customer.repository.CustomerRepositoryImpl;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{
    private CustomerRepository repository = new CustomerRepositoryImpl();
    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return repository.findById(id);
    }
}

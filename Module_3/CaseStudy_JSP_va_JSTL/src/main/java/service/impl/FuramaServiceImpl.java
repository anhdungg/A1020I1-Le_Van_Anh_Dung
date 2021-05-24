package service.impl;

import model.bean.Customer;
import repository.FuramaRepository;
import repository.impl.FuramaRepositoryImpl;
import service.FuramaService;

import java.util.List;

public class FuramaServiceImpl implements FuramaService {
    private FuramaRepository repository = new FuramaRepositoryImpl();
    @Override
    public List<Customer> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return repository.findById(id);
    }

    @Override
    public boolean editCustomer(String id, String idType, String name, String dayOfBirth, String CMND, String phoneNumber,
                                String email, String address) {
        try {
            return this.repository.editCustomer(new Customer(Integer.parseInt(id), Integer.parseInt(idType), name, dayOfBirth,
                    CMND, phoneNumber, email, address));
        } catch (NumberFormatException ex){
            return false;
        }
    }

    @Override
    public boolean createCustomer(String idType, String name, String dayOfBirth, String CMND, String phoneNumber, String email, String address) {
        try {
            return this.repository.createCustomer(new Customer(Integer.parseInt(idType), name, dayOfBirth, CMND,
                    phoneNumber, email, address));
        } catch (NumberFormatException ex){
            return false;
        }
    }

    @Override
    public boolean deleteCustomer(int id) {
        return this.repository.deleteCustomer(id);
    }

    @Override
    public List<Customer> findName(String name) {
        return this.repository.findName(name);
    }
}

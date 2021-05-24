package service;

import model.bean.Customer;

import java.util.List;

public interface FuramaService {
    List<Customer> findAll();
    Customer findById(int id);
    boolean editCustomer(String id, String idType, String name, String dayOfBirth, String CMND, String phoneNumber,
                         String email, String address);
    boolean createCustomer(String idType, String name, String dayOfBirth, String CMND, String phoneNumber,
                           String email, String address);
    boolean deleteCustomer(int id);
    List<Customer> findName(String name);
}

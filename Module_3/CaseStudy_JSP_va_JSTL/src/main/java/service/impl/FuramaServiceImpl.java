package service.impl;

import model.bean.Customer;
import model.bean.Employee;
import repository.FuramaRepository;
import repository.impl.FuramaRepositoryImpl;
import service.FuramaService;

import java.util.List;

public class FuramaServiceImpl implements FuramaService {
    private FuramaRepository repository = new FuramaRepositoryImpl();
    @Override
    public List<Customer> findAllCustomer() {
        return this.repository.findAllCustomer();
    }

    @Override
    public Customer findByIdCustomer(int id) {
        return repository.findByIdCustomer(id);
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
    public List<Customer> findNameCustomer(String name) {
        return this.repository.findNameCustomer(name);
    }

    @Override
    public List<Employee> findAllEmployee() {
        return this.repository.findAllEmployee();
    }

    @Override
    public Employee findByIdEmployee(int id) {
        return this.repository.findByIdEmployee(id);
    }

    @Override
    public boolean editEmployee(String id, String name, String idPosition, String idLevel, String idDepartment, String dayOfBirth,
                                  String CMND, String salary, String phoneNumber, String email, String address) {
        return this.repository.editEmployee(new Employee(Integer.parseInt(id), name, Integer.parseInt(idPosition), Integer.parseInt(idLevel),
                Integer.parseInt(idDepartment), dayOfBirth, CMND, Double.parseDouble(salary), phoneNumber, email, address));
    }

    @Override
    public boolean createEmployee(String name, String idPosition, String idLevel, String idDepartment, String dayOfBirth,
                                  String CMND, String salary, String phoneNumber, String email, String address) {
        return this.repository.createEmployee(new Employee(name, Integer.parseInt(idPosition), Integer.parseInt(idLevel),
                Integer.parseInt(idDepartment), dayOfBirth, CMND, Double.parseDouble(salary), phoneNumber, email, address));
    }

    @Override
    public boolean deleteEmployee(int id) {
        return this.repository.deleteEmployee(id);
    }

    @Override
    public List<Employee> findNameEmployee(String name) {
        return this.repository.findNameEmployee(name);
    }
}

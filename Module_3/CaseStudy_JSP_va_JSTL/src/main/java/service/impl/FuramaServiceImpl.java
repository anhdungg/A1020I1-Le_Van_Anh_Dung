package service.impl;

import model.bean.*;
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
    public Customer findByIdCustomer(String id) {
        return repository.findByIdCustomer(id);
    }

    @Override
    public String editCustomer(String id, String idType, String name, String dayOfBirth, String CMND, String phoneNumber,
                                String email, String address) {
        try {
            if(this.repository.editCustomer(new Customer(id, Integer.parseInt(idType), name, dayOfBirth,
                    CMND, phoneNumber, email, address))){
                return "Chinh sua thong tin khach hang thanh cong";
            }else {
                return "Loi co so du lieu";
            }
        } catch (NumberFormatException ex){
            return "Exception NumberFormatException";
        }
    }

    @Override
    public String createCustomer(String id, String idType, String name, String dayOfBirth, String CMND,
                                 String phoneNumber, String email, String address) {
        try {
            if(this.repository.createCustomer(new Customer(id, Integer.parseInt(idType), name, dayOfBirth, CMND,
                    phoneNumber, email, address))){
                return "Tao moi khach hang thanh cong";
            }else {
                return "ID da ton tai";
            }
        } catch (NumberFormatException ex){
            return "Exception NumberFormatException";
        }
    }

    @Override
    public boolean deleteCustomer(String id) {
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
    public String editEmployee(String id, String name, String idPosition, String idLevel, String idDepartment, String dayOfBirth,
                                  String CMND, String salary, String phoneNumber, String email, String address) {
        try {
            if (this.repository.editEmployee(new Employee(Integer.parseInt(id), name, Integer.parseInt(idPosition), Integer.parseInt(idLevel),
                    Integer.parseInt(idDepartment), dayOfBirth, CMND, Double.parseDouble(salary), phoneNumber, email, address))){
                return "Chinh sua thong tin nhan vien thanh cong";
            }else {
                return "ID da ton tai";
            }
        }catch (NumberFormatException e){
            return "Exception NumberFormatException";
        }
    }

    @Override
    public String createEmployee(String name, String idPosition, String idLevel, String idDepartment, String dayOfBirth,
                                  String CMND, String salary, String phoneNumber, String email, String address) {
        try {
            if (this.repository.createEmployee(new Employee(name, Integer.parseInt(idPosition), Integer.parseInt(idLevel),
                    Integer.parseInt(idDepartment), dayOfBirth, CMND, Double.parseDouble(salary), phoneNumber, email, address))) {
                return "Tao moi nhan vien thanh cong";
            } else {
                return "ID da ton tai";
            }
        } catch (NumberFormatException e){
            return "Exception NumberFormatException";
        }
    }

    @Override
    public boolean deleteEmployee(int id) {
        return this.repository.deleteEmployee(id);
    }

    @Override
    public List<Employee> findNameEmployee(String name) {
        return this.repository.findNameEmployee(name);
    }

    @Override
    public List<Contact> findAllContact() {
        return this.repository.findAllContact();
    }

    @Override
    public boolean createContact(String idEmployee, String idCustomer, String idService, String contactDate,
                                 String endDate, String depositMoney, String totalMoney) {
        return this.repository.createContact(new Contact(Integer.parseInt(idEmployee), idCustomer,
                idService, contactDate, endDate, Double.parseDouble(depositMoney), Double.parseDouble(totalMoney)));
    }

    @Override
    public List<Service> findAllService() {
        return this.repository.findAllService();
    }

    @Override
    public List<ContactDetail> findAllContactDetail() {
        return this.repository.findAllContactDetail();
    }

    @Override
    public boolean createContactDetail(String idContact, String accompanyingServices, String amount) {
        return this.repository.createContactDetail(new ContactDetail(Integer.parseInt(idContact),
                Integer.parseInt(accompanyingServices), Integer.parseInt(amount)));
    }

    @Override
    public List<AccompaniedService> findAllAccompaniedService() {
        return this.repository.findAllAccompaniedService();
    }

    @Override
    public List<RentalType> findAllRentalType() {
        return this.repository.findAllRentalType();
    }

    @Override
    public List<ServiceType> findAllServiceType() {
        return this.repository.findAllServiceType();
    }

    @Override
    public String createService(String id, String name, String area, String rentalCosts, String maximumNumberOfPeople,
                                 String idRentalType, String idServiceType, String standard, String description,
                                 String poolArea, String numberOfFloors) {
        try {
            if (this.repository.createService(new Service(id, name, Integer.parseInt(area), Double.parseDouble(rentalCosts),
                    Integer.parseInt(maximumNumberOfPeople), Integer.parseInt(idRentalType), Integer.parseInt(idServiceType),
                    standard, description, Double.parseDouble(poolArea), Integer.parseInt(numberOfFloors)))){
                return "Tao moi dich vu thanh cong";
            }else {
                return "ID da ton tai";
            }
        }catch (NumberFormatException e){
            return "Exception NumberFormatException";
        }
    }
}

package service;

import model.bean.*;

import java.util.List;

public interface FuramaService {
    List<Customer> findAllCustomer();
    Customer findByIdCustomer(String id);
    String editCustomer(String id, String idType, String name, String dayOfBirth, String CMND, String phoneNumber,
                         String email, String address);
    String createCustomer(String id, String idType, String name, String dayOfBirth, String CMND, String phoneNumber,
                           String email, String address);
    boolean deleteCustomer(String id);
    List<Customer> findNameCustomer(String name);
    List<Employee> findAllEmployee();
    Employee findByIdEmployee(int id);
    String editEmployee(String id, String name, String idPosition, String idEducationDegree, String idDivision, String dayOfBirth,
                           String CMND, String salary, String phoneNumber, String email, String address);
    String createEmployee(String name, String idPosition, String idEducationDegree, String idDivision, String dayOfBirth, String CMND,
                           String salary, String phoneNumber, String email, String address);
    boolean deleteEmployee(int id);
    List<Employee> findNameEmployee(String name);
    List<Service> findAllService();
    List<Contact> findAllContact();
    boolean createContact(String idEmployee, String idCustomer, String idService, String contactDate, String endDate,
                          String depositMoney, String totalMoney);
    List<ContactDetail> findAllContactDetail();
    boolean createContactDetail(String idContact, String accompanyingServices, String amount);
    List<AccompaniedService> findAllAccompaniedService();
    List<RentalType> findAllRentalType();
    List<ServiceType> findAllServiceType();
    String createService(String id, String name, String area, String rentalCosts, String maximumNumberOfPeople, String idRentalType,
                          String idServiceType, String standard, String description, String poolArea, String numberOfFloors);

    List<ContactView> findAllContactView();
}

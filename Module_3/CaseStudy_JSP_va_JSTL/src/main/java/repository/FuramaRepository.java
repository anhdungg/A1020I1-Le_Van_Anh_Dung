package repository;

import model.bean.*;

import java.util.List;

public interface FuramaRepository {
    List<Customer> findAllCustomer();
    Customer findByIdCustomer(String id);
    boolean editCustomer(Customer customer);
    boolean createCustomer(Customer customer);
    boolean deleteCustomer(String id);
    List<Customer> findNameCustomer(String name);
    List<Employee> findAllEmployee();
    Employee findByIdEmployee(int id);
    boolean editEmployee(Employee employee);
    boolean createEmployee(Employee employee);
    boolean deleteEmployee(int id);
    List<Employee> findNameEmployee(String name);
    List<Service> findAllService();
    List<Contact> findAllContact();
    boolean createContact(Contact contact);
    List<ContactDetail> findAllContactDetail();
    boolean createContactDetail(ContactDetail contactDetail);
    List<AccompaniedService> findAllAccompaniedService();
    List<RentalType> findAllRentalType();
    List<ServiceType> findAllServiceType();
    boolean createService(Service service);

    List<ContactView> findAllContactView();
}

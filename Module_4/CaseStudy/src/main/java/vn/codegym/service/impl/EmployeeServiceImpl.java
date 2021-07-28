package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Employee;
import vn.codegym.model.EmployeeRole;
import vn.codegym.model.User;
import vn.codegym.repository.EmployeeRepository;
import vn.codegym.repository.RoleRepository;
import vn.codegym.repository.UserRepository;
import vn.codegym.service.EmployeeService;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Employee> findAllByName(String keyword, Pageable pageable) {
        return repository.findAllByName(keyword, pageable);
    }

    @Override
    public void save(EmployeeRole employeeRole) {
        if (employeeRole.getEmployee().getId() == null ){
            User user =  new User(employeeRole.getEmployee().getEmail(),
                    "$2a$10$fQt3YyA1jdYe3KK4fDU/qOuJgBvuEA98oCfO0NJj77ll96WFCcanK", employeeRole.getEmployee(), employeeRole.getRole());
//            Employee employee = new Employee(employeeRole.getEmployee(), user);
            employeeRole.getEmployee().setUser(user);
//            user.setEmployee(employee);
            userRepository.save(user);
//            repository.save(employeeRole.getEmployee());
        }else {
            Employee employee = repository.findById(employeeRole.getEmployee().getId()).orElse(null);
            if (employee != null){
                User user = userRepository.findById(employee.getUser().getUserName()).orElse(null);
                if (user != null){
                    user.setEmployee(employeeRole.getEmployee());
                    user.setRoles(employeeRole.getRole());
                    userRepository.save(user);
                    System.out.println();
                }
            }
        }

    }

    @Override
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public boolean checkAge(Date dateOfBirth) {
        Date now = new Date();
        long between = now.getTime() - dateOfBirth.getTime();
        int age = (int)(between / (1000 * 60 * 60 * 24)) / 365;

        return age > 18;
    }
}

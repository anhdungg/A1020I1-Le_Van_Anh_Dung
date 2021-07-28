package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Employee;
import vn.codegym.model.EmployeeRole;

import java.util.Date;
import java.util.List;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);

    List<Employee> findAll();

    Employee findById(Integer id);

    void deleteById(Integer id);

    Page<Employee> findAllByName(String keyword, Pageable pageable);

    void save(EmployeeRole employeeRole);

    boolean existsByEmail(String email);

    boolean checkAge(Date dateOfBirth);
}

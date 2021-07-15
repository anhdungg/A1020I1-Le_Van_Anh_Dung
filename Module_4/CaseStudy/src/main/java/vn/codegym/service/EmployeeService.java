package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Employee;

import java.util.List;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);

    List<Employee> findAll();
}

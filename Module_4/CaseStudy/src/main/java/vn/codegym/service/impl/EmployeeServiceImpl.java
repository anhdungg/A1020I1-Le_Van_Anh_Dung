package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Employee;
import vn.codegym.repository.EmployeeRepository;
import vn.codegym.service.EmployeeService;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository repository;

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
    public void save(Employee employee) {
        repository.save(employee);
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

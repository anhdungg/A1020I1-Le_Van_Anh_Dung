package vn.codegym.model;

import javax.validation.Valid;

public class EmployeeRole {
    private @Valid Employee employee;
    private Role role;

    public EmployeeRole() {
    }

    public EmployeeRole(@Valid Employee employee, Role role) {
        this.employee = employee;
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

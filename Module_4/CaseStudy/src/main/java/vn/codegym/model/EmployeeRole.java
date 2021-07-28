package vn.codegym.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class EmployeeRole {
    private @Valid Employee employee;
    @NotNull(message = "Không được để trống")
    private Set<Role> role;

    public EmployeeRole() {
    }

    public EmployeeRole(@Valid Employee employee, Set<Role> role) {
        this.employee = employee;
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }
}

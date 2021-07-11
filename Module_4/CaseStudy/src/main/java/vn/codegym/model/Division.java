package vn.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String divisionName;

    @OneToMany(mappedBy = "division")
    private Set<Employee> employees;

    public Division() {
    }

    public Division(String divisionName, Set<Employee> employees) {
        this.divisionName = divisionName;
        this.employees = employees;
    }

    public Division(Integer id, String divisionName, Set<Employee> employees) {
        this.id = id;
        this.divisionName = divisionName;
        this.employees = employees;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}

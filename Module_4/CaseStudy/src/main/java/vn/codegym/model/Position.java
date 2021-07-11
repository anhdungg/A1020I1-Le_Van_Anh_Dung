package vn.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String positionName;

    @OneToMany(mappedBy = "position")
    private Set<Employee> employees;

    public Position() {
    }

    public Position(String positionName, Set<Employee> employees) {
        this.positionName = positionName;
        this.employees = employees;
    }

    public Position(Integer id, String positionName, Set<Employee> employees) {
        this.id = id;
        this.positionName = positionName;
        this.employees = employees;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}

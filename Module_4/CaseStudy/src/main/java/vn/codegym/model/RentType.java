package vn.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private Double cost;

    @OneToMany(mappedBy = "rentType")
    private Set<Service> services;

    public RentType() {
    }

    public RentType(String name, Double cost, Set<Service> services) {
        this.name = name;
        this.cost = cost;
        this.services = services;
    }

    public RentType(Integer id, String name, Double cost, Set<Service> services) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.services = services;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }
}
